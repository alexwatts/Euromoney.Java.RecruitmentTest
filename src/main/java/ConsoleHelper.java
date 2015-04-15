import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * ConsoleHelper.java
 */
public class ConsoleHelper {

    public static boolean askYesOrNoQuestion() throws IOException {

        System.out.println("Please type Y for Yes or N for No. Then Type Enter");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String yesOrNo = null;

        try {
            yesOrNo = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read redefined dictionary");
            System.exit(1);
        }

        if (yesOrNo.equals("Y")) {
            return true;
        } else if (yesOrNo.equals("N")) {
            return false;
        } else {
            askYesOrNoQuestion();
        }

        throw new RuntimeException("An unexpected code path was reached.");

    }

    public static List<String> getRedefinedDictionary() throws IOException {
        System.out.println("To redefine the dictionary enter the words separated by spaces and then hit return.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String redefinedDictionary = null;

        try {
            redefinedDictionary = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read redefined dictionary");
            System.exit(1);
        }

        System.out.println("Dictionary was redefined.");
        System.out.println("\nThe Dictionary Words are " + redefinedDictionary + "\n");

        return Arrays.asList(redefinedDictionary.split(" "));

    }

}
