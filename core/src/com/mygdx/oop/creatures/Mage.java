package com.mygdx.oop.creatures;

public class Mage extends Healer {
    protected static int number = 0;

    /**
     * Конструктор
     *
     * @param qty Количество
     * @param x   Координата X
     * @param y   Координата Y
     */
    public Mage(int qty, int x, int y) {
        super(qty,
                x,
                y,
                ++Mage.number,
                CreaturesSkills.Mage.NAME,
                CreaturesSkills.Mage.MAX_HP,
                CreaturesSkills.Mage.ATTACK,
                CreaturesSkills.Mage.DEFENCE,
                CreaturesSkills.Mage.MIN_DAMAGE,
                CreaturesSkills.Mage.MAX_DAMAGE,
                CreaturesSkills.Mage.COST,
                CreaturesSkills.Mage.IMITIATIVE,
                CreaturesSkills.Mage.MAX_SHOOTS, CreaturesSkills.Mage.HEALING);
    }
}