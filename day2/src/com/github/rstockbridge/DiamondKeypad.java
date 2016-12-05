package com.github.rstockbridge;

public class DiamondKeypad extends Keypad {

    public DiamondKeypad(int initialX, int initialY) {
        super(initialX, initialY);
    }

    public String getCurrentKey() {
        if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == 2) {
            return "1";
        } else if (currentCoordinate.getX() == -1 && currentCoordinate.getY() == 1) {
            return "2";
        } else if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == 1) {
            return "3";
        } else if (currentCoordinate.getX() == 1 && currentCoordinate.getY() == 1) {
            return "4";
        } else if (currentCoordinate.getX() == -2 && currentCoordinate.getY() == 0) {
            return "5";
        } else if (currentCoordinate.getX() == -1 && currentCoordinate.getY() == 0) {
            return "6";
        } else if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == 0) {
            return "7";
        } else if (currentCoordinate.getX() == 1 && currentCoordinate.getY() == 0) {
            return "8";
        } else if (currentCoordinate.getX() == 2 && currentCoordinate.getY() == 0) {
            return "9";
        } else if (currentCoordinate.getX() == -1 && currentCoordinate.getY() == -1) {
            return "A";
        } else if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == -1) {
            return "B";
        } else if (currentCoordinate.getX() == 1 && currentCoordinate.getY() == -1) {
            return "C";
        } else {
            return "D";
        }
    }

    void moveUpIfPossible() {
        String key = getCurrentKey();
        if (!key.equals("5") && !key.equals("2") && !key.equals("1") && !key.equals("4") && !key.equals("9")) {
            currentCoordinate = new KeypadCoordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
        }
    }

    void moveDownIfPossible() {
        String key = getCurrentKey();
        if (!key.equals("5") && !key.equals("A") && !key.equals("D") && !key.equals("C") && !key.equals("9")) {
            currentCoordinate = new KeypadCoordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
        }
    }

    void moveLeftIfPossible() {
        String key = getCurrentKey();
        if (!key.equals("1") && !key.equals("2") && !key.equals("5") && !key.equals("A") && !key.equals("D")) {
            currentCoordinate = new KeypadCoordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
        }
    }

    void moveRightIfPossible() {
        String key = getCurrentKey();
        if (!key.equals("1") && !key.equals("4") && !key.equals("9") && !key.equals("C") && !key.equals("D")) {
            currentCoordinate = new KeypadCoordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
        }
    }
}
