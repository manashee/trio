package com.example.demo.trio;

import javafx.util.Pair;

public class Board {


    private final int breadth;
    private final int height;
    private final String vacant;
    private Pair<Integer, Integer> vacant_xy;
    private String message;


    // TODO: validate that vacant_x is < breadth and vacant_y is < height

    Board(int breadth, int height, String vacant) {
        this.breadth = breadth;
        this.height = height;
        this.vacant = vacant;

        vacant_xy = new Pair<>(Integer.valueOf(vacant.split(",")[0]), Integer.valueOf(vacant.split(",")[1]));

        this.message = String.format("breadth = %1$s, height = %2$s, vacant = %3$s", breadth, height, vacant);
    }




    int getBreadth() {
        return breadth;
    }

    int getHeight() {
        return height;
    }

    String getVacant() {
        return vacant;
    }


    public String getMessage() {
        return message;
    }

    int getVacant_x() {
        return vacant_xy.getKey();
    }

    int getVacant_y() {
        return vacant_xy.getValue();
    }

    boolean isVacantValid() {
        return getVacant_x() < getBreadth() && getVacant_y() < getHeight();
    }

}
