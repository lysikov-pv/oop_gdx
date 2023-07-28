package com.mygdx.oop.creatures;

public class Monk extends Healer {
    protected static int number = 0;

    /**
     * Конструктор
     *
     * @param qty Количество
     * @param x   Координата X
     * @param y   Координата Y
     */
    public Monk(int qty, int x, int y) {
        super(qty,
                x,
                y,
                ++Monk.number,
                CreaturesSkills.Monk.NAME,
                CreaturesSkills.Monk.MAX_HP,
                CreaturesSkills.Monk.ATTACK,
                CreaturesSkills.Monk.DEFENCE,
                CreaturesSkills.Monk.MIN_DAMAGE,
                CreaturesSkills.Monk.MAX_DAMAGE,
                CreaturesSkills.Monk.COST,
                CreaturesSkills.Monk.IMITIATIVE,
                CreaturesSkills.Monk.MAX_SHOOTS, CreaturesSkills.Monk.HEALING);
    }
}
