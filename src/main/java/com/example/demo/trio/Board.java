package com.example.demo.trio;

public class Board {


    private Trio[] triominos = null;

    private Square [] squares = null;

    private final int breadth;
    private final int height;
    private Square vacantSq;

    Board(int breadth, int height, String vacant) {
        this.breadth = breadth;
        this.height = height;

        if (null == vacant) {
            vacantSq = new Square(-1, -1);
        } else {
            vacantSq = new Square(Integer.valueOf(vacant.split(",")[0]), Integer.valueOf(vacant.split(",")[1]));
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


    public int getVacant_x() {
        return vacantSq.getX();
    }

    public int getVacant_y() {
        return vacantSq.getY();
    }

    // TODO: validate that vacant_x is < breadth and vacant_y is < height
    boolean isVacantValid() {
        if (-1 == getVacant_x() && -1 == getVacant_y())
            return true;
        else
            return (getVacant_x() < getBreadth() && getVacant_y() < getHeight());
    }

    // pure side effect function
    public Trio[] calcTriominos(int breadth, int height, Square vacant) {

        if (breadth * height < 4) {
            return new Trio[0];
        } else if (4 == breadth * height) {
            Square a = new Square(0, 0);
            Square b = new Square(1, 0);
            Square c = new Square(1, 1);

            Trio t = new Trio(a, b, c);

            Trio[] array = new Trio[1];
            array[0] = t;
            return array;
        }
        return null;
    }


    public Square [] getSquares() {
        return squares;
    }


    public Square [] getTotalUnOccupiedSquares(int breadth, int height) {
        Square [] array = {new Square(0, 0) , new Square (0,1), new Square (1,0), new Square (1,1)};
        return array;
    }

    // min 4 sqaures are required to fit in a triomino.
    public Trio[] getTriominos() {
        this.triominos = calcTriominos(getBreadth(), getHeight(), vacantSq);
        return this.triominos;
    }

}
