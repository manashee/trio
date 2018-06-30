package com.example.demo.trio;

public class Trio {

    public Square getA() {
        return a;
    }

    public Square getB() {
        return b;
    }

    public Square getC() {
        return c;
    }

    private final Square a;
    private final Square b;
    private final Square c;

    Trio(Square a, Square b, Square c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Trio(int ax, int ay, int bx, int by, int cx, int cy) {
        this(new Square(ax,ay), new Square(bx,by), new Square(cx,cy));
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Trio.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Trio other = (Trio) obj;
        if ((this.getA() == null) ? (other.getA() != null) : !this.getA().equals(other.getA())) {
            return false;
        }
        if ((this.getB() == null) ? (other.getB() != null) : !this.getB().equals(other.getB())) {
            return false;
        }
        if ((this.getC() == null) ? (other.getC() != null) : !this.getC().equals(other.getC())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.getA() != null ? this.getA().hashCode() : 0);
        hash = 53 * hash + (this.getB() != null ? this.getB().hashCode() : 0);
        hash = 53 * hash + (this.getC() != null ? this.getC().hashCode() : 0);
        hash = 53 * hash + this.getC().getY();
        return hash;
    }

    // triominos squares should be L shaped or rotations of it
    // if ax == bx then by should be ay + or - 1
    boolean isValid() {
        return true;
    }

    public static Trio makeL(int ax, int ay) {
        return new Trio (ax, ay, ax, ay+1, ax+1,ay+1);
    }

}
