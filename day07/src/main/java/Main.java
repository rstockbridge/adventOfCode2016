import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/input.txt"))) {

            List<String> storedInputIPAddresses = new ArrayList<>();
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                storedInputIPAddresses.add(line);
            }

            System.out.format("The number of IP Address supporting TLS is %d.\n", getNumberIPsSupportingTLS(storedInputIPAddresses));
            System.out.format("The number of IP Address supporting SSL is %d.\n", getNumberIPsSupportingSSL(storedInputIPAddresses));

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

    private static boolean containsABBA(String stringSequence) {
        for (int startingLetter = 0; startingLetter < stringSequence.length() - 3; startingLetter++) {
            if (stringSequence.charAt(startingLetter) != stringSequence.charAt(startingLetter + 1) && stringSequence.charAt(startingLetter) == stringSequence.charAt(startingLetter + 3) && stringSequence.charAt(startingLetter + 1) == stringSequence.charAt(startingLetter + 2)) {
                return true;
            }
        }
        return false;
    }

    private static int getNumberIPsSupportingSSL(List<String> storedInputIPAddresses) {
        int numberIPsSupportingTLS = 0;

        for (String IPAddress : storedInputIPAddresses) {
            boolean supportsTLS = false;

            String[] stringSequences = IPAddress.split("\\[(.*?)\\]");
            List<String> ABAsInSequences = getABAsInSequence(stringSequences);

            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(IPAddress);
            while (matcher.find()) {
                for(String ABA : ABAsInSequences) {
                    String BAB = Character.toString(ABA.charAt(1)) + Character.toString(ABA.charAt(0)) + Character.toString(ABA.charAt(1));
                    if (containsBAB(matcher.group(1), BAB)) {
                        supportsTLS = true;
                    }
                }
            }

            if (supportsTLS) {
                numberIPsSupportingTLS++;
            }
        }

        return numberIPsSupportingTLS;
    }

    private static List<String> getABAsInSequence(String[] stringSequences) {
        List<String> ABAsInSequences = new ArrayList<>();
        for(String stringSequence: stringSequences) {
            for (int startingLetter = 0; startingLetter < stringSequence.length() - 2; startingLetter++) {
                if (stringSequence.charAt(startingLetter) != stringSequence.charAt(startingLetter + 1) && stringSequence.charAt(startingLetter) == stringSequence.charAt(startingLetter + 2)) {
                    ABAsInSequences.add(stringSequence.substring(startingLetter, startingLetter + 3));
                }
            }
        }

        return ABAsInSequences;
    }

    private static boolean containsBAB(String stringSequence, String BAB) {
        for (int startingLetter = 0; startingLetter < stringSequence.length() - 2; startingLetter++) {
            if (stringSequence.substring(startingLetter, startingLetter+3).equals(BAB)) {
                return true;
            }
        }
        return false;
    }
}
