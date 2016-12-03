package com.github.rstockbridge;

public enum Orientation {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public Orientation turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            default:
                throw new IllegalArgumentException("This branch should never be executed.");
        }
    }

    public Orientation turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalArgumentException("This branch should never be executed.");
        }
    }
}
