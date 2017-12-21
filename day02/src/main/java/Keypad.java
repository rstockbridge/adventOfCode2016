public abstract class Keypad {
    KeypadCoordinate currentCoordinate;

    Keypad(int initialX, int initialY) {
        currentCoordinate = new KeypadCoordinate(initialX, initialY);
    }

    public abstract String getCurrentKey();

    abstract void moveUpIfPossible();

    abstract void moveDownIfPossible();

    abstract void moveLeftIfPossible();

    abstract void moveRightIfPossible();
}
