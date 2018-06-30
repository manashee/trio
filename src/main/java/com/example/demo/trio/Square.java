package com.example.demo.trio;

import javafx.util.Pair;

public class Square {

    private Pair<Integer, Integer> xy;

    public Square(int x, int y) {

        this.xy = new Pair<>(x, y);

    }

    public int getX() {
        return xy.getKey().intValue();
    }

    public int getY() {
        return xy.getValue().intValue();
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


    public boolean onEast( Square other ) {
        if ( other.getX() -1 == this.getX() && this.onSameRank(other) )
            return true;
        else
            return false;
    }


    public boolean onWest( Square other ) {

        if (other.getX() + 1 == this.getX() && this.onSameRank(other))
            return true;
        else
            return false;
    }


    public boolean onNorth( Square other ) {

        if (other.getY() + 1 == this.getX() && this.onSameFile(other))
            return true;
        else
            return false;
    }

    public boolean onSouth( Square other ) {

        if (other.getY() - 1 == this.getX() && this.onSameFile(other))
            return true;
        else
            return false;
    }

    public boolean onSameRank( Square other ) {
        if ( other.getY() == this.getY()  )
            return true;
        else
            return false;
    }

    public boolean onSameFile( Square other ) {
        if ( other.getX() == this.getX()  )
            return true;
        else
            return false;
    }
}
