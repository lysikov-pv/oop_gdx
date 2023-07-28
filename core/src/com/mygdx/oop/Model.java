package com.mygdx.oop;

import com.mygdx.oop.creatures.*;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    public static ArrayList<Creature> army1 = new ArrayList<>();
    public static ArrayList<Creature> army2 = new ArrayList<>();
    public static ArrayList<Creature> allCreatures = new ArrayList<>();

    public Model() {
        create_armys();
    }

    public void create_armys(){
        for (int i = 1; i < 9; i++) {
            switch (new Random().nextInt(4)){
                case 0:
                    army1.add(new Mage(10, 1, i));
                    break;
                case 1:
                    army1.add(new Sharpshooter(5,1, i));
                    break;
                case 2:
                    army1.add(new Rogue(100,1, i));
                    break;
                default:
                    army1.add(new Peasant(50,1, i));
            }
        }
        for (int i = 1; i < 9; i++) {
            switch (new Random().nextInt(4)){
                case 0:
                    army2.add(new Monk(10, 10, i));
                    break;
                case 1:
                    army2.add(new Archer(10, 10, i));
                    break;
                case 2:
                    army2.add(new Pikeman(100,10, i));
                    break;
                default:
                    army2.add(new Peasant(50,10, i));
            }
        }
        allCreatures.addAll(army1);
        allCreatures.addAll(army2);
        allCreatures.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());
    }

    public int whoWin(){
        boolean win1 = true;
        for (Creature creature: army2) {
            if(!creature.action.equals(CreaturesActions.died)) { win1 = false; }
        }
        boolean win2 = true;
        for (Creature creature: army1) {
            if(!creature.action.equals(CreaturesActions.died)) { win2 = false; }
        }
        if (win1) return 1;
        if (win2) return 2;
        return 0;
    }
    public boolean step() {
        if (whoWin() == 0) {
            int i = 0;
            for (Creature creature: allCreatures) {
                if (army1.contains(creature)) {
                    creature.step(army2, army1);
                }
                else {
                    creature.step(army1, army2);
                }
            }
            Loger.printBuffer();
            return false;
        }
        else
        {
            Loger.buffer.add(String.format("Game end. %s army win!",
                    (whoWin() == 1) ? "Left" : "Right"));
            Loger.printBuffer();
            return true;
        }
    }
}