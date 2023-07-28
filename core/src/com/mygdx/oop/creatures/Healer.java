package com.mygdx.oop.creatures;

import com.mygdx.oop.Loger;

import java.util.ArrayList;

public abstract class Healer extends Shooter {
    private int healing;  // Лечение

    /**
     * Конструктор
     *
     * @param qty        Количество
     * @param x          Координата X
     * @param y          Координата Y
     * @param number     Порядковый номер
     * @param name       Название существа
     * @param maxHp      Здоровье
     * @param attack     Атака
     * @param defense    Защита
     * @param minDamage  Минимальный урон
     * @param maxDamage  Максимальный урон
     * @param cost       Стоимость
     * @param initiative Инициатива
     * @param maxShoots  Кол-во выстрелов
     * @param healing    Лечение
     */
    protected Healer(int qty, int x, int y, int number, String name, int maxHp, int attack, int defense, int minDamage, int maxDamage, int cost, int initiative, int maxShoots, int healing) {
        super(qty, x, y, number, name, maxHp, attack, defense, minDamage, maxDamage, cost, initiative, maxShoots);
        this.healing = healing;
    }

    protected Creature findMostPainful(ArrayList<Creature> creatures) {
        int maxPainful = creatures.get(0).maxHp - creatures.get(0).hp;
        int numberMostPainful = 0;
        for (int i = 0; i < creatures.size(); i++) {
            if(!creatures.get(i).action.equals(CreaturesActions.died)) {
                int painful = creatures.get(i).maxHp - creatures.get(i).hp;
                if (painful > maxPainful) {
                    maxPainful = painful;
                    numberMostPainful = i;
                }
            }
        }
        if (maxPainful != 0) {
            return creatures.get(numberMostPainful);
        }
        else {
            return null;
        }
    }

    @Override
    public void step(ArrayList<Creature> enemies, ArrayList<Creature> allies) {

        if (findMostPainful(allies) != null) {
            Creature mostPainful = findMostPainful(allies);
            int healingPoints = mostPainful.getHeal(healing * qty);
            Loger.buffer.add(getInfo() + String.format(" cured '%s #%d' on +%d HP",
                    mostPainful.name,
                    mostPainful.number,
                    healingPoints));
        }
        else {
            if (findNearest(enemies) != null) {
                Creature nearestEnemy = findNearest(enemies);
                int damage = ((maxDamage - minDamage) / 2 + minDamage) * qty;
                int qtyDies = nearestEnemy.getDamage(minDamage, maxDamage, qty, attack);
                shoots--;
                Loger.buffer.add(getInfo() + String.format(" attack '%s #%d' [Qty: %d(-%d)]; Shots left: %d(-1)",
                        nearestEnemy.name,
                        nearestEnemy.number,
                        nearestEnemy.qty + qtyDies,
                        qtyDies,
                        shoots));
            }
        }

    }
}
