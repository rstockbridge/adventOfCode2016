import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Main {

    private static final String ALL_DIRECTIONS = "R4, R5, L5, L5, L3, R2, R1, R1, L5, R5, R2, L1, L3, L4, R3, L1, L1, R2, " +
            "R3, R3, R1, L3, L5, R3, R1, L1, R1, R2, L1, L4, L5, R4, R2, L192, R5, L2, R53, R1, L5, R73, R5, L5, R186, " +
            "L3, L2, R1, R3, L3, L3, R1, L4, L2, R3, L5, R4, R3, R1, L1, R5, R2, R1, R1, R1, R3, R2, L1, R5, R1, L5, R2, " +
            "L2, L4, R3, L1, R4, L5, R4, R3, L5, L3, R4, R2, L5, L5, R2, R3, R5, R4, R2, R1, L1, L5, L2, L3, L4, L5, L4, " +
            "L5, L1, R3, R4, R5, R3, L5, L4, L3, L1, L4, R2, R5, R5, R4, L2, L4, R3, R1, L2, R5, L5, R1, R1, L1, L5, L5, " +
            "L2, L1, R5, R2, L4, L1, R4, R3, L3, R1, R5, L1, L4, R2, L3, R5, R3, R1, L3";

    public static void main(String[] args) {
        Coordinates locationPartI = calcFinalLocationPartI();
        displayNumBlocks(locationPartI.x, locationPartI.y);

        Coordinates locationPartII = calcRepeatedLocationPartII();
        if (locationPartII != null) {
            displayNumBlocks(locationPartII.x, locationPartII.y);
        } else {
            System.out.println("No locations are visited twice.");
        }
    }

    private static Coordinates calcFinalLocationPartI() {
        Coordinates location = new Coordinates(0, 0);
        Orientation previous = Orientation.NORTH;
        Orientation next;
        Turn turn;
        int distance;

        final String[] directions = ALL_DIRECTIONS.split(", ");

        for (String direction : directions) {
            turn = Turn.getTurn(direction.charAt(0));
            distance = Integer.parseInt(direction.substring(1, direction.length()));

            if (turn == Turn.RIGHT) {
                next = previous.turnRight();
            } else {
                next = previous.turnLeft();
            }

            location = getUpdatedLocation(location, next, distance);
            previous = next;
        }
        return location;
    }

    private static Coordinates calcRepeatedLocationPartII() {
        Coordinates location = new Coordinates(0, 0);
        Orientation previous = Orientation.NORTH;
        Orientation next;
        Turn turn;
        int distance;

        final String[] directions = ALL_DIRECTIONS.split(", ");

        List<Coordinates> placesVisited = new ArrayList<Coordinates>();
        placesVisited.add(new Coordinates(0, 0));

        for (String direction : directions) {
            turn = Turn.getTurn(direction.charAt(0));
            distance = Integer.parseInt(direction.substring(1, direction.length()));

            if (turn == Turn.RIGHT) {
                next = previous.turnRight();
            } else {
                next = previous.turnLeft();
            }

            for (int step = 0; step < distance; step++) {
                location = getUpdatedLocation(location, next, 1);

                if (placesVisited.contains(location)) {
                    return location;
                } else {
                    placesVisited.add(location);
                }
            }

            previous = next;
        }
        return null;
    }

    private static Coordinates getUpdatedLocation(Coordinates location, Orientation orientation, int distance) {
        switch (orientation) {
            case NORTH:
                return new Coordinates(location.x, location.y + distance);
            case SOUTH:
                return new Coordinates(location.x, location.y - distance);
            case EAST:
                return new Coordinates(location.x + distance, location.y);
            case WEST:
                return new Coordinates(location.x - distance, location.y);
        }
        throw new IllegalStateException("This branch should never be executed.");
    }

    private static void displayNumBlocks(int xCoordinate, int yCoordinate) {
        System.out.format("Easter Bunny Headquarters is %d blocks away.\n", abs(xCoordinate) + abs(yCoordinate));
    }


}
