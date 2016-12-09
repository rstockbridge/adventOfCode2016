package com.github.rstockbridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IdentifyRealRooms {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rebecca/Desktop/rebecca_java/" +
                "adventOfCode2016/day4/src/com/github/rstockbridge/input.txt"))) {

            ArrayList<String> storedInputFile = new ArrayList<>();
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                storedInputFile.add(line);
            }

            System.out.format("The sum of sector IDs is %d.\n", calcSumSectorIDsOfRealRooms(storedInputFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calcSumSectorIDsOfRealRooms(ArrayList<String> storedInputFile) {
        int sectorIDSum = 0;

        for (String roomData : storedInputFile) {

            RoomCandidate roomCandidate = new RoomCandidate(roomData);

            if (roomCandidate.isRealRoom()) {
                sectorIDSum += Integer.parseInt(roomCandidate.getSectorID());
            }
        }

        return sectorIDSum;
    }
}

