package com.github.rstockbridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecompressFiles {

    private static String instructionREGEX = "\\((\\d+)x(\\d+)\\)";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rebecca/Desktop/rebecca_java/" +
                "adventOfCode2016/day9/src/com/github/rstockbridge/input.txt"))) {
            String fileData = bufferedReader.readLine();

            System.out.format("The length of the file after Part I decompression is %d.\n", calculateLengthUsingPartIDecompression(fileData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateLengthUsingPartIDecompression(String fileData) {
        return decompressPartI(fileData).length();
    }

    private static String decompressPartI(String fileData) {
        String decompressedFile = "";

        Pattern pattern = Pattern.compile(instructionREGEX);
        Matcher matcher = pattern.matcher(fileData);

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
}
