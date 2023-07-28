package com.mygdx.oop.creatures;

import com.mygdx.oop.Loger;

import java.util.ArrayList;
import java.util.Random;

public abstract class Creature implements CreaturesInterface {
    protected int number; // Порядковый номер
    protected String name; // Название существа
    protected int qty; // Количество
    protected int hp; // Текущее здоровье
    protected int maxHp; // Максимальное здоровье
    protected int attack;  // Атака
    protected int defense; // Защита
    protected int minDamage; // Минимальный урон
    protected int maxDamage; // Максимальный урон
    protected int cost; // Стоимость
    protected int initiative; // Инициатива

    protected Position position; // Координаты
    public CreaturesActions action; // Действие


    /**
     * Конструктор существа
     *
     * @param qty        Количество
     * @param x          Координата X
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
    protected Creature(int qty, int x, int y, int number, String name, int maxHp, int attack, int defense, int minDamage, int maxDamage, int cost, int initiative) {
        this.name = name;
        this.number = number;
        this.qty = qty;
        position = new Position(x, y);
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.cost = cost;
        this.initiative = initiative;
        action = CreaturesActions.waiting;
    }

    public String getName() {
        return name;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getHp() {
        return hp;
    }

    public Position getPosition() {
        return position;
    }

    public String toString() {
        return String.format("«%s #%d» [\u26C9 %d]",
                name, number, qty);
    }

    public String toChar() {
        return name.substring(0, 2) + ((number > 10) ? number % 10 : number);
    }

    public String getInfo() {
        return String.format("«%s #%d» [\u26C9 %d]",
                name, number, qty);
    }

    public void step(ArrayList<Creature> enemies, ArrayList<Creature> allies) {
        Creature nearestEnemy = findNearest(enemies);
        Loger.buffer.add(getInfo() + String.format(" -> Ближайшее существо: %s #%d; Растояние: %d",
                nearestEnemy.name,
                nearestEnemy.number,
                (int)Math.ceil(position.getDistance(nearestEnemy.position))));
    }

    private int sign(int x) {
        if (x > 0) return 1;
        if (x < 0) return -1;
        return 0;
    }

    public int getDamage(int enemieMinDamage, int enemieMaxDamage, int enemieQty, int enemieAttack) {
        // Формула расчета повреждения с handbookhmm.ru/1-damage
        Random random = new Random();
        int i = enemieAttack - defense;
        int damage = (int) Math.round(
                random.nextInt(enemieMinDamage, enemieMaxDamage + 1)
                * enemieQty
                * (1.0 + 0.1 * Math.pow(sign(i), Math.abs(i))));
        int qtyDamage = damage / maxHp;
        if (qtyDamage < qty) {
            qty -= qtyDamage;
            hp -= damage - qtyDamage * maxHp;
        }
        else {
            die();
        }
        return qtyDamage;
    }

    public int getHeal(int healing) {
        int damage = maxHp - hp;
        int healingPoints = Math.min(damage, healing);
        hp += healingPoints;
        return healingPoints;
    }

    public void die() {
        qty = 0;
        hp = 0;
        action = CreaturesActions.died;
    }

    protected Creature findNearest(ArrayList<Creature> creatures) {
        double minDistance = -1;
        int numberNearest = -1;
        for (int i = 0; i < creatures.size(); i++) {
            if(!creatures.get(i).action.equals(CreaturesActions.died)) {
                double distance = position.getDistance(creatures.get(i).position);
                if (minDistance == -1 || distance < minDistance) {
                    minDistance = distance;
                    numberNearest = i;
                }
            }
        }
        if (numberNearest != -1) {
            return creatures.get(numberNearest);
        }
        else {
            return null;
        }
    }
}