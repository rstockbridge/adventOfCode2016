package com.github.rstockbridge;

import java.util.*;

class RoomCandidate {
    private String name;
    private String sectorID;
    private String checksum;
    private NavigableSet<Map.Entry<Character, Integer>> sortedCharacterEntries;

    RoomCandidate(String roomData) {
        String[] splitRoomData = roomData.split("\\[");
        splitRoomData[0] = splitRoomData[0].replace("-", "");

        name = splitRoomData[0].substring(0, splitRoomData[0].length() - 3);
        sectorID = splitRoomData[0].substring(splitRoomData[0].length() - 3, splitRoomData[0].length());
        checksum = splitRoomData[1].substring(0, splitRoomData[1].length() - 1);

        sortedCharacterEntries = new TreeSet<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return Character.compare(o1.getKey(), o2.getKey());
                } else {
                    return -Integer.compare(o1.getValue(), o2.getValue());
                }
            }
        });
    }

    String getSectorID() {
        return sectorID;
    }

    boolean isRealRoom() {
        calcSortedCharacterEntries();

        String fiveMostCommonLetters = "";
        for (int i = 0; i < 5; i++) {
            fiveMostCommonLetters += sortedCharacterEntries.pollFirst().getKey();
        }

        return checksum.equals(fiveMostCommonLetters);
    }

    private void calcSortedCharacterEntries() {

        Set<Map.Entry<Character, Integer>> characterCountMapEntries = calcCharacterCounts().entrySet();
        sortedCharacterEntries.addAll(characterCountMapEntries);
    }

    private Map<Character, Integer> calcCharacterCounts() {

        Map<Character, Integer> characterCountMap = new HashMap<>();

        for (int letter = 0; letter < name.length(); letter++) {
            char character = name.charAt(letter);
            if (characterCountMap.containsKey(character)) {
                characterCountMap.put(character, characterCountMap.get(character) + 1);
            } else {
                characterCountMap.put(character, 1);
            }
        }

        return characterCountMap;
    }
}

