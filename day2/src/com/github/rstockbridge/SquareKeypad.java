package com.github.rstockbridge;

public class SquareKeypad extends Keypad {

    public SquareKeypad(int initialX, int initialY) {
        super(initialX, initialY);
    }

    public String getCurrentKey() {
        if (currentCoordinate.getX() == -1 && currentCoordinate.getY() == 1) {
            return "1";
        } else if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == 1) {
            return "2";
        } else if (currentCoordinate.getX() == 1 && currentCoordinate.getY() == 1) {
            return "3";
        } else if (currentCoordinate.getX() == -1 && currentCoordinate.getY() == 0) {
            return "4";
        } else if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == 0) {
            return "5";
        } else if (currentCoordinate.getX() == 1 && currentCoordinate.getY() == 0) {
            return "6";
        } else if (currentCoordinate.getX() == -1 && currentCoordinate.getY() == -1) {
            return "7";
        } else if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == -1) {
            return "8";
        } else {
            return "9";
        }
    }

    void moveUpIfPossible() {
        if (currentCoordinate.getY() < 1) {
            currentCoordinate = new KeypadCoordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
        }
    }

    void moveDownIfPossible() {
        if (currentCoordinate.getY() > -1) {
            currentCoordinate = new KeypadCoordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
        }
    }

    void moveLeftIfPossible() {
        if (currentCoordinate.getX() > -1) {
            currentCoordinate = new KeypadCoordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
        }
    }

    void moveRightIfPossible() {
        if (currentCoordinate.getX() < 1) {
            currentCoordinate = new KeypadCoordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
        }
    }
}
