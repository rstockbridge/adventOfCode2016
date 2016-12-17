package com.github.rstockbridge;

class PixelScreen {

    private int numberOfRows;
    private int numberOfColumns;
    private boolean pixels[][];

    PixelScreen(int inputNumRows, int inputNumColumns) {
        numberOfRows = inputNumRows;
        numberOfColumns = inputNumColumns;
        pixels = new boolean[numberOfRows][numberOfColumns];
    }

    void turnOnRectangle(int numberOfRows, int numberOfColumns) {
        for (int column = 0; column < numberOfColumns; column++) {
            for (int row = 0; row < numberOfRows; row++) {
                pixels[row][column] = true;
            }
        }
    }

    void rotateColumn(int column, int amount) {
        for(int i = 0; i < amount; i++) {
            boolean storedBottomPixel = pixels[numberOfRows - 1][column];
            for (int row = numberOfRows - 1; row > 0; row--) {
                pixels[row][column] = pixels[row - 1][column];
            }
            pixels[0][column] = storedBottomPixel;
        }
    }

    void rotateRow(int row, int amount) {
        for(int i = 0; i < amount; i++) {
            boolean storedRightPixel = pixels[row][numberOfColumns - 1];
            for (int column = numberOfColumns - 1; column > 0; column--) {
                pixels[row][column] = pixels[row][column - 1];
            }
            pixels[row][0] = storedRightPixel;
        }
    }

    void print() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (pixels[row][column]) {
                    System.out.format("%c", '#');
                } else {
                    System.out.format("%c", '.');
                }
            }
            System.out.println();
        }
    }

    int countNumberOfLitPixels() {
        int result = 0;

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (pixels[row][column]) {
                    result++;
                }
            }
        }

        return result;
    }


}
