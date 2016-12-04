package com.github.rstockbridge;

class KeypadCoordinates {
    private int x;
    private int y;

    KeypadCoordinates(int inputX, int inputY) {
        x = inputX;
        y = inputY;
    }

    void moveUpIfPossiblePartI() {
        if (y < 1) {
            y++;
        }
    }

    void moveDownIfPossiblePartI() {
        if (y > -1) {
            y--;
        }
    }

    void moveLeftIfPossiblePartI() {
        if (x > -1) {
            x--;
        }
    }

    void moveRightIfPossiblePartI() {
        if (x < 1) {
            x++;
        }
    }

    int getKeypadNumberPartI() {
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

    void moveUpIfPossiblePartII() {
        char location = getKeypadNumberPartII();
        if (location != '5' && location != '2' && location != '1' && location != '4' && location != '9') {
            y++;
        }
    }

    void moveDownIfPossiblePartII() {
        char location = getKeypadNumberPartII();
        if (location != '5' && location != 'A' && location != 'D' && location != 'C' && location != '9') {
            y--;
        }
    }

    void moveLeftIfPossiblePartII() {
        char location = getKeypadNumberPartII();
        if (location != '1' && location != '2' && location != '5' && location != 'A' && location != 'D') {
            x--;
        }
    }

    void moveRightIfPossiblePartII() {
        char location = getKeypadNumberPartII();
        if (location != '1' && location != '4' && location != '9' && location != 'C' && location != 'D') {
            x++;
        }
    }

    char getKeypadNumberPartII() {
        if (x == 0 && y == 2) {
            return '1';
        } else if (x == -1 && y == 1) {
            return '2';
        } else if (x == 0 && y == 1) {
            return '3';
        } else if (x == 1 && y == 1) {
            return '4';
        } else if (x == -2 && y == 0) {
            return '5';
        } else if (x == -1 && y == 0) {
            return '6';
        } else if (x == 0 && y == 0) {
            return '7';
        } else if (x == 1 && y == 0) {
            return '8';
        } else if (x == 2 && y == 0) {
            return '9';
        } else if (x == -1 && y == -1) {
            return 'A';
        } else if (x == 0 && y == -1) {
            return 'B';
        } else if (x == 1 && y == -1) {
            return 'C';
        } else {
            return 'D';
        }
    }
}
