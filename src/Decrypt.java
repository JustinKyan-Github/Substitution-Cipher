import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
public class Decrypt {
    private char plaintext[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char key[];
    //private char mostFreqChar[] = "etaoinsrhdlucmfywgpbvkxqjz".toCharArray();
    public Decrypt(char[] newKey) {
        key = newKey;
    }
    public synchronized void initialize() {
        //Declare scanner
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter a string to Decrypt " + "\nor enter 2 to Analyze text frequency (Type -1 toquit)");
        String input = in.nextLine();
        if (input.equalsIgnoreCase("2")) {
            System.out.println("\nEnter a string to "
            + "analyze text frequency (Type -1 to quit)");
            input = in.nextLine();
            if (!input.equals("-1")) {
                analyze(input);
            }
            return;
        }
        if (!input.equals("-1")) {
            System.out.println("\nDecrypted text:\n" + decrypt(input) + "\n");
        }
    }
    public String decrypt(String message) {
        char string[] = message.toLowerCase().toCharArray();
        for (int i = 0; i < string.length; i++) {
            for (int j = 0; j < plaintext.length; j++) {
                if (string[i] == key[j]) {
                    string[i] = plaintext[j];
                    break;
                }
            }
        }
        return new String(string);
    }
    public void analyze(String message) {
        DecimalFormat df = new DecimalFormat("0.00000");
        char string[] = message.toCharArray();
        int counter[] = new int[plaintext.length];
        int usedCount = 0;
        double usageRate = 0.00d;
        int uses[] = new int[plaintext.length];
        char order[] = new char[plaintext.length];
        int taken[] = new int[plaintext.length];
        for (int i = 0; i < taken.length; i++) taken[i] = -1;
            for (int i = 0; i < string.length; i++) {
                for (int j = 0; j < plaintext.length; j++) {
                    if (string[i] == plaintext[j]) {
                        counter[j]++;
                        break;
                    }
                }
            }
        for (int i = 0; i < plaintext.length; i++) {
            int storageVar = -1;
            int storageVar2 = 0;
            for (int j = 0; j < counter.length; j++) {
                boolean bool = false;
                for (int k : taken) {
                    if (k == -1) {
                        break;
                    }else if (k == j){
                        bool = true;
                        break;
                    }
                }
                if (storageVar <= counter[j] && !bool) {
                    storageVar = counter[j];
                    storageVar2 = j;
                }
            }
            taken[i] = storageVar2;
        }
        for (int i = 0; i <taken.length;i++) {
            order[i] = plaintext[taken[i]];
            uses[i] = counter[taken[i]];
        }
        for (int i : counter) usedCount = usedCount + i;
            System.out.println(usedCount + "\n"
            + Arrays.toString(uses) + "\n"
            + uses[0]/usedCount + "\n\n"
            + "[ Character Frequency of Message ] ");
        for (int i = 0; i < uses.length; i++) {
            usageRate = uses[i];
            usageRate = usageRate / usedCount;
            System.out.println(order[i] + " : "
            + df.format(usageRate));
        }
        //suggestKey(order);
    }
/* Unused Code
    public void suggestKey(char[] frequency) {
        char suggestion[] = new char[plaintext.length];
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mostFreqChar.length; i++) {
            for (int j = 0; j < plaintext.length; j++) {
                if (plaintext[j] == mostFreqChar[i]) {
                    suggestion[j] = frequency[i];
                }
            }
        }
        System.out.println("Suggested Key: " + new String(suggestion));
        System.out.println("Enter 0 if you want the suggestion as the new key?\n"
        + "If not enter any other key?");
        String input = in.nextLine();
        if (input.equals("0")) {
            key = suggestion;
            System.out.println("Key Replaced\n");
        }else {
            System.out.println("Key was not Replaced\n");
        }
    }
*/        
}
