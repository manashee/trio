package com.example.demo.trio;

import javafx.util.Pair;

public class Board {


    private Trio[] triominos = null;
    private final int breadth;
    private final int height;
    private final String vacant;
    private Pair<Integer, Integer> vacant_xy;
    // private String message;


    // TODO: validate that vacant_x is < breadth and vacant_y is < height

    Board(int breadth, int height, String vacant) {
        this.breadth = breadth;
        this.height = height;
        this.vacant = vacant;

        if (null == vacant) {
            vacant_xy = new Pair<>(-1, -1);
        } else {
            vacant_xy = new Pair<>(Integer.valueOf(vacant.split(",")[0]), Integer.valueOf(vacant.split(",")[1]));
        }
    }

    Board(int breadth, int height) {
        this(breadth, height, null);
    }

    public int getBreadth() {
        return breadth;
    }

    public int getHeight() {
        return height;
    }

    String getVacant() {
        return vacant;
    }


    public int getVacant_x() {
        return vacant_xy.getKey();
    }

    public int getVacant_y() {
        return vacant_xy.getValue();
    }

    boolean isVacantValid() {
        if (-1 == getVacant_x() && -1 == getVacant_y())
            return true;
        else
            return (getVacant_x() < getBreadth() && getVacant_y() < getHeight());
    }

    // min 4 sqaures are required to fit in a triomino.
    public Trio[] getTriominos() {
        if (getBreadth() * getHeight() < 4) {
            this.triominos = new Trio[0];
        }

        return new Trio[0];
    }

}
