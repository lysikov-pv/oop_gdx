package com.mygdx.oop;

import java.util.LinkedList;

public class Loger {
    public static LinkedList<String> buffer = new LinkedList<>();
    public static void printBuffer() {
        while (!buffer.isEmpty()) {
            System.out.println(buffer.pollFirst());
        }
    }
}