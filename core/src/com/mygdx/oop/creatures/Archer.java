package com.mygdx.oop.creatures;

public class Archer extends Shooter {
    protected static int number = 0;

    /**
     * Конструктор
     *
     * @param qty Количество
     * @param x   Координата X
     * @param y   Координата Y
     */
    public Archer(int qty, int x, int y) {
        super(qty,
                x,
                y,
                ++Archer.number,
                CreaturesSkills.Archer.NAME,
                CreaturesSkills.Archer.MAX_HP,
                CreaturesSkills.Archer.ATTACK,
                CreaturesSkills.Archer.DEFENCE,
                CreaturesSkills.Archer.MIN_DAMAGE,
                CreaturesSkills.Archer.MAX_DAMAGE,
                CreaturesSkills.Archer.COST,
                CreaturesSkills.Archer.IMITIATIVE,
                CreaturesSkills.Archer.MAX_SHOOTS);
    }
}
