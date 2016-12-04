package com.github.rstockbridge;

class KeypadCoordinates {
    private int x;
    private int y;

    KeypadCoordinates(int inputX, int inputY) {
        x = inputX;
        y = inputY;
    }

    void moveUpIfPossible() {
        if (y < 1) {
            y++;
        }
    }

    void moveDownIfPossible() {
        if (y > -1) {
            y--;
        }
    }

    void moveLeftIfPossible() {
        if (x > -1) {
            x--;
        }
    }

    void moveRightIfPossible() {
        if (x < 1) {
            x++;
        }
    }

    int getKeypadNumber() {
        if (x == -1 && y == 1) {
            return 1;
        } else if (x == 0 && y == 1) {
            return 2;
        } else if (x == 1 && y == 1) {
            return 3;
        } else if (x == -1 && y == 0) {
            return 4;
        } else if (x == 0 && y == 0) {
           return 5;
        } else if (x == 1 && y == 0) {
            return 6;
        } else if (x == -1 && y == -1) {
            return 7;
        } else if (x == 0 && y == -1) {
            return 8;
        } else {
            return 9;
        }
    }
}
