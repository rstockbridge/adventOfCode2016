package com.github.rstockbridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IdentifyRealRooms {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rebecca/Desktop/Dropbox/documents/" +
                "coding/adventOfCode2016/day4/src/com/github/rstockbridge/input.txt"))) {

            List<String> storedInputFile = new ArrayList<>();
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                storedInputFile.add(line);
            }
            List<RoomCandidate> roomCandidates = getRoomCandidates(storedInputFile);

            System.out.format("The sum of sector IDs is %d.\n\n", calcSumSectorIDsOfRealRooms(roomCandidates));
            printDecryptedNames(roomCandidates);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calcSumSectorIDsOfRealRooms(List<RoomCandidate> roomCandidates) {
        int sectorIDSum = 0;

        for (RoomCandidate roomCandidate : roomCandidates) {
            if (roomCandidate.isRealRoom()) {
                sectorIDSum += Integer.parseInt(roomCandidate.getSectorID());
            }
        }

        return sectorIDSum;
    }

    private static void printDecryptedNames(List<RoomCandidate> roomCandidates) {
        for (RoomCandidate roomCandidate : roomCandidates) {
            System.out.println(roomCandidate.getDecryptedName());
        }
    }

    private static List<RoomCandidate> getRoomCandidates(List<String> storedInputFile) {
        List<RoomCandidate> result = new ArrayList<>();

        for (String roomData : storedInputFile) {
            RoomCandidate roomCandidate = new RoomCandidate(roomData);
            result.add(roomCandidate);
        }

        return result;
    }
}

