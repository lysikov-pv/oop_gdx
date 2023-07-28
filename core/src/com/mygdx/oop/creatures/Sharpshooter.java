package com.mygdx.oop.creatures;

public class Sharpshooter extends Shooter {
    protected static int number = 0;
    /**
     * Конструктор
     * @param qty Количество
     * @param x   Координата X
     * @param y   Координата Y
     */
    public Sharpshooter(int qty, int x, int y) {
        super(qty,
                x,
                y,
                ++Sharpshooter.number,
                CreaturesSkills.Sharpshooter.NAME,
                CreaturesSkills.Sharpshooter.MAX_HP,
                CreaturesSkills.Sharpshooter.ATTACK,
                CreaturesSkills.Sharpshooter.DEFENCE,
                CreaturesSkills.Sharpshooter.MIN_DAMAGE,
                CreaturesSkills.Sharpshooter.MAX_DAMAGE,
                CreaturesSkills.Sharpshooter.COST,
                CreaturesSkills.Sharpshooter.IMITIATIVE,
                CreaturesSkills.Sharpshooter.MAX_SHOOTS);
    }
}
