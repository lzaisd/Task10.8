package ru.vsu.cs.sidorovaei.logics;

public class Line {
    public int a;
    public int b;


    public Line(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA () {
        return a;
    }
    public int getB () {
        return b;
    }
    public void setA (int anotherA) {
        this.a = anotherA;
    }
    public void setB (int anotherB) {
        this.b = anotherB;
    }
}
