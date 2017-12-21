import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static int inputDataNumberOfColumns = -1;

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rebecca/Desktop/Dropbox/documents/work/coding/AdventOfCode2016/day06/src/main/java/input.txt"))) {

            List<String> storedTransposedInputFile = getTransposedInputData(bufferedReader);

            String errorCorrectedMessageUsingMostFrequentCharacter = "";
            String errorCorrectedMessageUsingLeastFrequentCharacter = "";

            for (int column = 0; column < inputDataNumberOfColumns; column++) {
                List<Map.Entry<Character, Integer>> sortedCharacterMapEntries = getSortedCharacterMapEntries(storedTransposedInputFile, column);
                errorCorrectedMessageUsingMostFrequentCharacter += getMostFrequentCharacterInColumn(sortedCharacterMapEntries);
                errorCorrectedMessageUsingLeastFrequentCharacter += getLeastFrequentCharacterInColumn(sortedCharacterMapEntries);
            }

            System.out.format("The error corrected message using the most frequent character is %s.\n",
                    errorCorrectedMessageUsingMostFrequentCharacter);
            System.out.format("The error corrected message using the least frequent character is %s.\n",
                    errorCorrectedMessageUsingLeastFrequentCharacter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getTransposedInputData(BufferedReader bufferedReader) throws IOException {
        List<String> storedTransposedInputFile = new ArrayList<>();

        for (String line; (line = bufferedReader.readLine()) != null; ) {
            if (inputDataNumberOfColumns == -1) {
                inputDataNumberOfColumns = line.length();
                for (int column = 0; column < inputDataNumberOfColumns; column++) {
                    storedTransposedInputFile.add(column, "");
                }
            }
            for (int column = 0; column < inputDataNumberOfColumns; column++) {
                storedTransposedInputFile.set(column, storedTransposedInputFile.get(column) + line.charAt(column));
            }
        }

        return storedTransposedInputFile;
    }

    private static char getMostFrequentCharacterInColumn(List<Map.Entry<Character, Integer>> sortedCharacterMapEntries) {
        return sortedCharacterMapEntries.get(sortedCharacterMapEntries.size() - 1).getKey();
    }

    private static char getLeastFrequentCharacterInColumn(List<Map.Entry<Character, Integer>> sortedCharacterMapEntries) {
        return sortedCharacterMapEntries.get(0).getKey();

    }

    private static List<Map.Entry<Character, Integer>> getSortedCharacterMapEntries(List<String> storedTransposedInputFile, int column) {
        List<Map.Entry<Character, Integer>> sortedCharacterMapEntries = new ArrayList<>(calculateCharacterCountMap(
                storedTransposedInputFile, column).entrySet());
        Collections.sort(sortedCharacterMapEntries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        return sortedCharacterMapEntries;
    }


    private static Map<Character, Integer> calculateCharacterCountMap(List<String> storedTransposedInputFile, int column) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (int characterPosition = 0; characterPosition < storedTransposedInputFile.get(column).length(); characterPosition++) {
            char key = storedTransposedInputFile.get(column).charAt(characterPosition);
            if (!characterCountMap.containsKey(key)) {
                characterCountMap.put(key, 1);
            } else {
                characterCountMap.put(key, characterCountMap.get(key) + 1);
            }
        }

        return characterCountMap;
    }
}
