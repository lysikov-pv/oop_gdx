package com.mygdx.oop.creatures;

import java.util.ArrayList;

public class Peasant extends Creature {
    protected static int number = 0;

    /**
     * Конструктор
     *
     * @param qty Количество
     * @param x   Координата X
     * @param y   Координата Y
     */
    public Peasant(int qty, int x, int y) {
        super(qty,
                x,
                y,
                ++Peasant.number,
                CreaturesSkills.Peasant.NAME,
                CreaturesSkills.Peasant.MAX_HP,
                CreaturesSkills.Peasant.ATTACK,
                CreaturesSkills.Peasant.DEFENCE,
                CreaturesSkills.Peasant.MIN_DAMAGE,
                CreaturesSkills.Peasant.MAX_DAMAGE,
                CreaturesSkills.Peasant.COST,
                CreaturesSkills.Peasant.IMITIATIVE);
    }

    @Override
    public void step(ArrayList<Creature> enemies, ArrayList<Creature> allies) {
//        super.step(enemies, allies);
        if (hp <= 0) return;
        action = CreaturesActions.waiting;
    }
}