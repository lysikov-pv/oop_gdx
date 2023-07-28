package com.mygdx.oop.creatures;

public class Position {
    public int x; // 1..15
    public int y; // 1..11

    public double getDistance(Position nextPosition) {
        int dx = nextPosition.x - x;
        int dy = nextPosition.y - y;
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position other) {
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
}
