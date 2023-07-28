package com.mygdx.oop.creatures;

public enum CreaturesSkills {
    Archer("Archer", 10, 6, 3, 2, 3, 100, 9, 12, 0),
    Mage("Mage", 25, 11, 8, 7, 9, 350, 8, 24, 4),
    Monk("Monk", 30, 12, 7, 10, 12, 400, 7, 12, 2),
    Peasant("Peasant", 1, 1, 1, 1, 1, 10, 1, 0, 0),
    Pikeman("Pikeman", 10, 4, 5, 1, 3, 60, 4, 0, 0),
    Sharpshooter("Sharpshooter", 15, 12, 10, 8, 10, 400, 10, 32, 0),
    Rogue("Rogue", 4, 6, 1, 1, 2, 100, 10, 0, 0),

    ;

    public final String NAME; // Название существа
    public final int MAX_HP; // Максимальное здоровье
    public final int ATTACK;  // Атака
    public final int DEFENCE; // Защита
    public final int MIN_DAMAGE; // Минимальный урон
    public final int MAX_DAMAGE; // Максимальный урон
    public final int COST; // Стоимость
    public final int MAX_SHOOTS; // Кол-во выстрелов
    public final int HEALING; // Лечение
    public final int IMITIATIVE; // Инициатива

    CreaturesSkills(String name, int maxHp, int attack, int defense, int minDamage, int maxDamage, int cost, int initiative, int maxShoots, int healing) {
        this.NAME = name;
        this.MAX_HP = maxHp;
        this.ATTACK = attack;
        this.DEFENCE = defense;
        this.MIN_DAMAGE = minDamage;
        this.MAX_DAMAGE = maxDamage;
        this.COST = cost;
        this.IMITIATIVE = initiative;
        this.MAX_SHOOTS = maxShoots;
        this.HEALING = healing;
    }
}