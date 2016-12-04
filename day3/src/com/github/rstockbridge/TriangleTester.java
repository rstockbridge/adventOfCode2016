package com.github.rstockbridge;

public class TriangleTester {
    private int side1;
    private int side2;
    private int side3;

    public TriangleTester(int inputSide1, int inputSide2, int inputSide3) {
        side1 = inputSide1;
        side2 = inputSide2;
        side3 = inputSide3;
    }

    boolean isValid() {
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }
}
