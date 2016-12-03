package com.github.rstockbridge;

import static java.lang.Math.abs;

public class EasterBunnyHeadquarters {

    private static final String ALL_DIRECTIONS = "R4, R5, L5, L5, L3, R2, R1, R1, L5, R5, R2, L1, L3, L4, R3, L1, L1, R2, " +
            "R3, R3, R1, L3, L5, R3, R1, L1, R1, R2, L1, L4, L5, R4, R2, L192, R5, L2, R53, R1, L5, R73, R5, L5, R186, " +
            "L3, L2, R1, R3, L3, L3, R1, L4, L2, R3, L5, R4, R3, R1, L1, R5, R2, R1, R1, R1, R3, R2, L1, R5, R1, L5, R2, " +
            "L2, L4, R3, L1, R4, L5, R4, R3, L5, L3, R4, R2, L5, L5, R2, R3, R5, R4, R2, R1, L1, L5, L2, L3, L4, L5, L4, " +
            "L5, L1, R3, R4, R5, R3, L5, L4, L3, L1, L4, R2, R5, R5, R4, L2, L4, R3, R1, L2, R5, L5, R1, R1, L1, L5, L5, " +
            "L2, L1, R5, R2, L4, L1, R4, R3, L3, R1, R5, L1, L4, R2, L3, R5, R3, R1, L3";

    public static void main(String[] args) {
        Coordinates location = new Coordinates();
        calcFinalLocation(location);
        displayNumBlocks(location.x, location.y);
    }

    private static void calcFinalLocation(Coordinates location) {
        Orientation previous;
        Orientation next;
        Turn turn;
        int distance;

        final String[] directions = ALL_DIRECTIONS.split(", ");

        previous = Orientation.NORTH;

        for (String direction : directions) {
            turn = Turn.getTurn(direction.charAt(0));
            distance = Integer.parseInt(direction.substring(1, direction.length()));

            if (turn == Turn.RIGHT) {
                next = previous.turnRight();
            } else {
                next = previous.turnLeft();
            }

            switch (next) {
                case NORTH:
                    location.moveY(distance);
                    break;
                case SOUTH:
                    location.moveY(-distance);
                    break;
                case EAST:
                    location.moveX(distance);
                    break;
                case WEST:
                    location.moveX(-distance);
                    break;
            }

            previous = next;
        }
    }

    private static void displayNumBlocks(int xCoordinate, int yCoordinate) {
        System.out.println(abs(xCoordinate) + abs(yCoordinate));
    }

}
