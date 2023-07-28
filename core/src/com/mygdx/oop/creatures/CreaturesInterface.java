package com.mygdx.oop.creatures;

import java.util.ArrayList;

public interface CreaturesInterface {
    String getInfo();

    void step(ArrayList<Creature> enemies, ArrayList<Creature> allies);
}
