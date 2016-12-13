package com.github.rstockbridge;

import java.util.*;

class RoomCandidate {
    private final String nameWithoutDashes;
    private final String nameWithSpaces;
    private final String decryptedName;
    private final String sectorID;
    private final String checksum;

    RoomCandidate(String roomData) {
        String[] splitRoomData = roomData.split("\\[");

        sectorID = splitRoomData[0].substring(splitRoomData[0].length() - 3, splitRoomData[0].length());
        nameWithoutDashes = splitRoomData[0].substring(0, splitRoomData[0].length() - 3).replace("-", "");
        nameWithSpaces = splitRoomData[0].substring(0, splitRoomData[0].length() - 3).replace("-", " ");
        checksum = splitRoomData[1].substring(0, splitRoomData[1].length() - 1);
        decryptedName = calculateDecryptedName();
    }

    String getDecryptedName() {
        return decryptedName;
    }

    String getSectorID() {
        return sectorID;
    }

    boolean isRealRoom() {
        String fiveMostCommonLetters = "";
        for (int i = 0; i < 5; i++) {
            fiveMostCommonLetters += getSortedCharacterEntries().get(0).getKey();
        }

        return checksum.equals(fiveMostCommonLetters);
    }

    private List<Map.Entry<Character, Integer>> getSortedCharacterEntries() {
        List<Map.Entry<Character, Integer>> sortedCharacterMapEntries = new ArrayList<>(calculateCharacterCountMap().entrySet());

        Collections.sort(sortedCharacterMapEntries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return Character.compare(o1.getKey(), o2.getKey());
                } else {
                    return -Integer.compare(o1.getValue(), o2.getValue());
                }
            }
        });

        return sortedCharacterMapEntries;
    }

    private Map<Character, Integer> calculateCharacterCountMap() {
        Map<Character, Integer> characterCountMap = new HashMap<>();

        for (int letter = 0; letter < nameWithoutDashes.length(); letter++) {
            char character = nameWithoutDashes.charAt(letter);
            if (characterCountMap.containsKey(character)) {
                characterCountMap.put(character, characterCountMap.get(character) + 1);
            } else {
                characterCountMap.put(character, 1);
            }
        }

        return characterCountMap;
    }

    private String calculateDecryptedName() {
        String result = "";

        for (int letter = 0; letter < nameWithSpaces.length(); letter++) {
            if (nameWithSpaces.charAt(letter) == ' ') {
                result += " ";
            } else {
                result += (char) (((int) nameWithSpaces.charAt(letter) - (int) 'a' + Integer.parseInt(sectorID)) % 26 + (int) 'a');
            }
        }

        return result;
    }
}

