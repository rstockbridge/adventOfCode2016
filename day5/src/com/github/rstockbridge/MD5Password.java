package com.github.rstockbridge;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Password {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        final String doorID = "ffykfhsq";
        System.out.format("The password is %s.\n", calculatePassword(doorID));
    }


    private static String calculatePassword(String doorID) throws NoSuchAlgorithmException {
        String combinedIDAndIndex;
        String password = "";
        int currentTestIndex = 0;

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        while (password.length() < 8) {
            combinedIDAndIndex = doorID + Integer.toString(currentTestIndex);
            md5.update(StandardCharsets.UTF_8.encode(combinedIDAndIndex));
            String hash = String.format("%032x", new BigInteger(1, md5.digest()));

            if (hash.startsWith("00000")) {
                password += hash.charAt(5);
            }

            currentTestIndex++;
        }

        return password;
    }
}
