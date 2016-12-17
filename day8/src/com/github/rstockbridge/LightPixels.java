package com.github.rstockbridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LightPixels {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rebecca/Desktop/rebecca_java/" +
                "adventOfCode2016/day8/src/com/github/rstockbridge/input.txt"))) {

            List<String> storedInstructions = new ArrayList<>();
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                storedInstructions.add(line);
            }

            PixelScreen screen = new PixelScreen(6, 50);

            for (String instruction : storedInstructions) {
                if (instruction.contains("rect")) {
                    String[] instructionData = instruction.substring(5).split("x");
                    screen.turnOnRectangle(Integer.parseInt(instructionData[1]), Integer.parseInt(instructionData[0]));
                } else if (instruction.contains("rotate column")) {
                    String[] instructionData = instruction.substring(16).split(" by ");
                    screen.rotateColumn(Integer.parseInt(instructionData[0]), Integer.parseInt(instructionData[1]));
                } else {
                    String[] instructionData = instruction.substring(13).split(" by ");
                    screen.rotateRow(Integer.parseInt(instructionData[0]), Integer.parseInt(instructionData[1]));
                }
            }

            System.out.format("The number of lit pixels is %d.\n\n", screen.countNumberOfLitPixels());
            screen.print();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

