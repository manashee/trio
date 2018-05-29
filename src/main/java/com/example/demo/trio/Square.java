package com.example.demo.trio;

import javafx.util.Pair;

public class Square {


    private Pair<Integer, Integer> xy;

    public Square(int x, int y) {

        this.xy = new Pair<>(x, y);

    }

    public int getX() {
        return xy.getKey();
    }

    public int getY() {
        return xy.getValue();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Square.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Square other = (Square) obj;

        return this.getX() == other.getX() && this.getY() == other.getY();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.getX();
        hash = hash + this.getY();
        return hash;
    }
}
