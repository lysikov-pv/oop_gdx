package com.mygdx.oop.creatures;

import com.mygdx.oop.Loger;

import java.util.ArrayList;

public abstract class Shooter extends Creature {

    protected int shoots; // Текущее кол-во выстрелов
    protected int maxShots; // Максимальное кол-во выстрелов

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
     * @param maxShots   Максимальное кол-во выстрелов
     */
    protected Shooter(int qty, int x, int y, int number, String name, int maxHp, int attack, int defense, int minDamage, int maxDamage, int cost, int initiative, int maxShots) {
        super(qty, x, y, number, name, maxHp, attack, defense, minDamage, maxDamage, cost, initiative);
        this.maxShots = maxShots;
        this.shoots = maxShots;
    }

    @Override
    public void step(ArrayList<Creature> enemies, ArrayList<Creature> allies) {
        if (hp <= 0) return;
        if (shoots <= 0) return;

        if (findNearest(enemies) != null) {
            Creature nearestEnemy = findNearest(enemies);
            int qtyDies = nearestEnemy.getDamage(minDamage, maxDamage, qty, attack);
            boolean savedShoot = false;
            for (Creature allie : allies) {
                if (allie.name.equals("Крестьянин") && allie.action.equals(CreaturesActions.waiting)) {
                    savedShoot = true;
                    allie.action = CreaturesActions.givesArrow;
                    break;
                }
            }
            Loger.buffer.add(getInfo() + String.format(" атаковал «%s #%d» [\u26C9 %d(-%d)]; У него осталось стрел: %d(-%d)",
                    nearestEnemy.name,
                    nearestEnemy.number,
                    nearestEnemy.qty + qtyDies,
                    qtyDies,
                    shoots,
                    savedShoot ? 0 : 1));

            if (savedShoot) return;
            else shoots--;
        }
    }
}
