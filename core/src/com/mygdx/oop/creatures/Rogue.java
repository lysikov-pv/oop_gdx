package com.mygdx.oop.creatures;

public class Rogue extends Warrior {
    protected static int number = 0;

    /**
     * Конструктор
     *
     * @param qty Количество
     * @param x   Координата X
     * @param y   Координата Y
     */
    public Rogue(int qty, int x, int y) {
        super(qty,
                x,
                y,
                ++Rogue.number,
                CreaturesSkills.Rogue.NAME,
                CreaturesSkills.Rogue.MAX_HP,
                CreaturesSkills.Rogue.ATTACK,
                CreaturesSkills.Rogue.DEFENCE,
                CreaturesSkills.Rogue.MIN_DAMAGE,
                CreaturesSkills.Rogue.MAX_DAMAGE,
                CreaturesSkills.Rogue.COST,
                CreaturesSkills.Rogue.IMITIATIVE);
    }
}