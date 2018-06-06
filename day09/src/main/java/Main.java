import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern PATTERN = Pattern.compile("\\((\\d+)x(\\d+)\\)");

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/input.txt"))) {
            String fileData = bufferedReader.readLine();

            System.out.format("The length of the file after Part I decompression is %d.\n", calculateLengthUsingPartIDecompression(fileData));
            System.out.format("The length of the file after Part II decompression is %d.\n", calculateLengthUsingPartIIDecompression(fileData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateLengthUsingPartIDecompression(String fileData) {
        return decompressPartI(fileData).length();
    }

    private static String decompressPartI(String fileData) {
        String decompressedFile = "";
        Matcher matcher = PATTERN.matcher(fileData);

        while (matcher.find()) {
            int startingPositionOfInstruction = matcher.start();
            int lengthOfInstruction = matcher.group(0).length();
            int lengthOfSequenceToRepeat = Integer.parseInt(matcher.group(1));
            int numberOfTimesToRepeat = Integer.parseInt(matcher.group(2));

            decompressedFile += fileData.substring(0, startingPositionOfInstruction);
            fileData = fileData.substring(startingPositionOfInstruction + lengthOfInstruction);

            for (int repeatIndex = 0; repeatIndex < numberOfTimesToRepeat; repeatIndex++) {
                decompressedFile += fileData.substring(0, lengthOfSequenceToRepeat);
            }

            fileData = fileData.substring(lengthOfSequenceToRepeat);
            matcher.reset(fileData);
        }

        decompressedFile += fileData;

        return decompressedFile;
    }

    private static long calculateLengthUsingPartIIDecompression(String fileData) {
        return calculateLength(fileData);
    }

    private static long calculateLength(String string) {
        Matcher matcher = PATTERN.matcher(string);

        if (!matcher.find()) {
            return string.length();
        } else {
            int startingPositionOfInstruction = matcher.start();
            int endingPositionOfInstruction = startingPositionOfInstruction + matcher.group(0).length();
            int lengthOfSequenceToRepeat = Integer.parseInt(matcher.group(1));
            int numberOfTimesToRepeat = Integer.parseInt(matcher.group(2));

            return startingPositionOfInstruction // length of sequence before instruction
                    + numberOfTimesToRepeat * calculateLengthUsingPartIIDecompression(string.substring(endingPositionOfInstruction, endingPositionOfInstruction + lengthOfSequenceToRepeat)) // number of times to repeat * length of sequence to be repeated
                    + calculateLengthUsingPartIIDecompression(string.substring(endingPositionOfInstruction + lengthOfSequenceToRepeat)); // length of remaining sequence
        }
    }
}
