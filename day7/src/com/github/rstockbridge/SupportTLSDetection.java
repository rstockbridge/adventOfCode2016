package com.github.rstockbridge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupportTLSDetection {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rebecca/Desktop/rebecca_java/" +
                "adventOfCode2016/day7/src/com/github/rstockbridge/input.txt"))) {

            List<String> storedInputIPAddresses = new ArrayList<>();
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                storedInputIPAddresses.add(line);
            }

            System.out.println(getNumberIPsSupportingTLS(storedInputIPAddresses));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getNumberIPsSupportingTLS(List<String> storedInputIPAddresses) {
        int numberIPsSupportingTLS = 0;

        for (String IPAddress : storedInputIPAddresses) {
            boolean supportsTLS = false;

            String[] stringSequences = IPAddress.split("\\[(.*?)\\]");
            for (String stringSequence : stringSequences) {
                if (containsABBA(stringSequence)) {
                    supportsTLS = true;
                }
            }

            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(IPAddress);
            while (matcher.find()) {
                if (containsABBA(matcher.group(1))) {
                    supportsTLS = false;
                }
            }

            if (supportsTLS) {
                numberIPsSupportingTLS++;
            }
        }

        return numberIPsSupportingTLS;
    }

    private static boolean containsABBA(String sequence) {
        for (int startingLetter = 0; startingLetter < sequence.length() - 3; startingLetter++) {
            if (sequence.charAt(startingLetter) != sequence.charAt(startingLetter + 1) && sequence.charAt(startingLetter) == sequence.charAt(startingLetter + 3) && sequence.charAt(startingLetter + 1) == sequence.charAt(startingLetter + 2)) {
                return true;
            }
        }
        return false;
    }
}
