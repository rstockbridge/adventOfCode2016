import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Main {

    private static final char placeholderPasswordEntry = '&';

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        final String doorID = "ffykfhsq";
        System.out.format("The Part I password is %s.\n", calculatePasswordPartI(doorID));
        System.out.format("The Part II password is %s.\n", calculatePasswordPartII(doorID));
    }


    private static String calculatePasswordPartI(String doorID) throws NoSuchAlgorithmException {
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

    private static String calculatePasswordPartII(String doorID) throws NoSuchAlgorithmException {
        String combinedIDAndIndex;

        char[] password = new char[8];
        Arrays.fill(password, placeholderPasswordEntry);

        int currentTestIndex = 0;
        int successCount = 0;

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        while (successCount < 8) {
            combinedIDAndIndex = doorID + Integer.toString(currentTestIndex);
            md5.update(StandardCharsets.UTF_8.encode(combinedIDAndIndex));
            String hash = String.format("%032x", new BigInteger(1, md5.digest()));

            if (hash.startsWith("00000")) {
                int entryPositionCandidate = Character.getNumericValue(hash.charAt(5));

                if ((entryPositionCandidate >= 0) && (entryPositionCandidate < 8) && (password[entryPositionCandidate] == placeholderPasswordEntry)) {
                    password[entryPositionCandidate] = hash.charAt(6);
                    successCount++;
                }
            }

            currentTestIndex++;
        }

        return new String(password);
    }
}
