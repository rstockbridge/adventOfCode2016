package com.github.rstockbridge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IdentifyTriangles {

    public static void main(String[] args) {
        System.out.format("The number of valid triangles is %d.", getNumValidTriangles());
    }

    private static int getNumValidTriangles() {

        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/rebecca/Desktop/rebecca_java/" +
                "adventOfCode2016/day3/src/com/github/rstockbridge/input.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {

                String[] triangleSides = line.trim().split("\\s+");

                TriangleTester test = new TriangleTester(Integer.parseInt(triangleSides[0]), Integer.parseInt(triangleSides[1]),
                        Integer.parseInt(triangleSides[2]));
                if (test.isValid()) {
                    count++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}

