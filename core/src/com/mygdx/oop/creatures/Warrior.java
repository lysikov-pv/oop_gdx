package com.mygdx.oop.creatures;

import com.mygdx.oop.Loger;

import java.util.ArrayList;

public abstract class Warrior extends Creature {

    /**
     * Конструктор
     *
     * @param qty        Количество
     * @param x          Координата Х
     * @param y          Координата Y
     * @param number     Порядковый номер
     * @param name       Название существа
     * @param maxHp      Максимальное здоровье
     * @param attack     Атака
     * @param defense    Защита
     * @param minDamage  Минимальный урон
     * @param maxDamage  Максимальный урон
     * @param cost       Стоимость
     * @param initiative Инициатива
     */
    protected Warrior(int qty, int x, int y, int number, String name, int maxHp, int attack, int defense, int minDamage, int maxDamage, int cost, int initiative) {
        super(qty, x, y, number, name, maxHp, attack, defense, minDamage, maxDamage, cost, initiative);

    }
    public void goTo(Position target){
        int x = getPosition().x;
        int y = getPosition().y;
        int dy = y - target.y;
        Position top    = new Position(x, (dy > 0) ? y + 1 : y - 1);
        Position bottom = new Position(x, (dy > 0) ? y - 1 : y + 1);
        Position left   = new Position(x - 1, y);
        Position right  = new Position(x + 1, y);
        boolean topFree    = true;
        boolean bottomFree = true;
        boolean leftFree   = true;
        boolean rightFree  = true;

        if (top.y > 10)   topFree    = false;
        if (bottom.y < 1) bottomFree = false;
        if (left.x < 1)   leftFree   = false;
        if (right.x > 10) rightFree  = false;

//        for (Creature creature: allCreatures) {
//            if(creature.getPosition().equals(top))    topFree    = false;
//            if(creature.getPosition().equals(bottom)) bottomFree = false;
//            if(creature.getPosition().equals(left))   leftFree   = false;
//            if(creature.getPosition().equals(right))  rightFree  = false;
//        }

        double[] distances = {top.getDistance(target),
                bottom.getDistance(target),
                left.getDistance(target),
                right.getDistance(target)};
        boolean[] positionFree = {topFree, bottomFree, leftFree, rightFree};

        double minDistance = -1;
        int newPositionIndex = -1;
        for (int i = 0; i < distances.length; i++) {
            if ((minDistance == -1 || minDistance > distances[i]) && positionFree[i]) {
                minDistance = distances[i];
                newPositionIndex = i;
            }
        }
        if (newPositionIndex == 0) {
            position.x = top.x;
            position.y = top.y;
        }
        else if (newPositionIndex == 1) {
            position.x = bottom.x;
            position.y = bottom.y;
        }
        else if (newPositionIndex == 2) {
            position.x = left.x;
            position.y = left.y;
        }
        else if (newPositionIndex == 3) {
            position.x = right.x;
            position.y = right.y;
        }
    }

    protected boolean canAttack(Creature creature){
        return (Math.abs(getPosition().x - creature.getPosition().x) <= 1)
                && (Math.abs(getPosition().y - creature.getPosition().y) <= 1);
    }

    @Override
    public void step(ArrayList<Creature> enemies, ArrayList<Creature> allies) {
        if (hp <= 0) return;

        if (findNearest(enemies) != null) {
            Creature nearestEnemy = findNearest(enemies);
            if (canAttack(nearestEnemy)) {
                int qtyDies = nearestEnemy.getDamage(minDamage, maxDamage, qty, attack);
                Loger.buffer.add(getInfo() + String.format(" атаковал «%s #%d» [\u26C9 %d(-%d)]",
                        nearestEnemy.name,
                        nearestEnemy.number,
                        nearestEnemy.qty + qtyDies,
                        qtyDies));
            } else {
                goTo(nearestEnemy.getPosition());
                Loger.buffer.add(getInfo() + String.format(" идет к «%s #%d»",
                        nearestEnemy.name,
                        nearestEnemy.number));
            }
        }
    }
}
