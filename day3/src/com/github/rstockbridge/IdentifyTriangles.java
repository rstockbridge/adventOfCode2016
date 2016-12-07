package com.github.rstockbridge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IdentifyTriangles {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rebecca/Desktop/rebecca_java/" +
                "adventOfCode2016/day3/src/com/github/rstockbridge/input.txt"))) {

            ArrayList<String> storedInputFile = new ArrayList<>();
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                storedInputFile.add(line);
            }

            System.out.format("The number of valid triangles in Part I is %d.\n", getNumValidTrianglesPartI(storedInputFile));
            System.out.format("The number of valid triangles in Part II is %d.\n", getNumValidTrianglesPartII(storedInputFile));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getNumValidTrianglesPartI(ArrayList<String> storedInputFile) {
        int count = 0;

        for (String line : storedInputFile) {

            String[] triangleSides = line.trim().split("\\s+");

            TriangleTester test = new TriangleTester(Integer.parseInt(triangleSides[0]), Integer.parseInt(triangleSides[1]),
                    Integer.parseInt(triangleSides[2]));
            if (test.isValid()) {
                count++;
            }
        }

        return count;
    }

    private static int getNumValidTrianglesPartII(ArrayList<String> storedInputFile) {
        int count = 0;
        int lineNumber = 0;

        String[] triangleSide1Triplet = new String[3];
        String[] triangleSide2Triplet = new String[3];
        String[] triangleSide3Triplet = new String[3];

        for (String line : storedInputFile) {
            if (lineNumber % 3 == 0) {
                triangleSide1Triplet = line.trim().split("\\s+");
            } else if (lineNumber % 3 == 1) {
                triangleSide2Triplet = line.trim().split("\\s+");
            } else {
                triangleSide3Triplet = line.trim().split("\\s+");
            }

            if (lineNumber % 3 == 2) {
                for (int triangleTesterCount = 0; triangleTesterCount < 3; triangleTesterCount++) {
                    TriangleTester test = new TriangleTester(Integer.parseInt(triangleSide1Triplet[triangleTesterCount]),
                            Integer.parseInt(triangleSide2Triplet[triangleTesterCount]),
                            Integer.parseInt(triangleSide3Triplet[triangleTesterCount]));
                    if (test.isValid()) {
                        count++;
                    }
                }
            }

            lineNumber++;
        }

        return count;
    }
}

