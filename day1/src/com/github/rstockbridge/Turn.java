package com.github.rstockbridge;

public enum Turn {
    RIGHT,
    LEFT;

    static Turn getTurn(char direction) {
        if (direction == 'R') {
            return RIGHT;
        } else if (direction == 'L') {
            return LEFT;
        } else throw new IllegalArgumentException("All directions must be either left or right.");
    }
}


