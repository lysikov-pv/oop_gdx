package com.mygdx.oop.creatures;

public class Pikeman extends Warrior {
    protected static int number = 0;

    /**
     * Конструктор
     *
     * @param qty Количество
     * @param x   Координата X
     * @param y   Координата Y
     */
    public Pikeman(int qty, int x, int y) {
        super(qty,
                x,
                y,
                ++Pikeman.number,
                CreaturesSkills.Pikeman.NAME,
                CreaturesSkills.Pikeman.MAX_HP,
                CreaturesSkills.Pikeman.ATTACK,
                CreaturesSkills.Pikeman.DEFENCE,
                CreaturesSkills.Pikeman.MIN_DAMAGE,
                CreaturesSkills.Pikeman.MAX_DAMAGE,
                CreaturesSkills.Pikeman.COST,
                CreaturesSkills.Pikeman.IMITIATIVE);
    }
}