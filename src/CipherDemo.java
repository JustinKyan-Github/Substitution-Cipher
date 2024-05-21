import java.util.Scanner;
public class CipherDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        System.out.println("Welcome to the Substitution Cipher Demo.\n\n"
            + "In this program you are able "
            + "to either encrypt,\ndecrypt, or analyze the"
            + "letter frequency\nof a message that you want to enter.\n");
        keyGeneration c = new keyGeneration();
        Encrypt e;
        Decrypt d;
        System.out.println("Press Enter to start.");
        in.nextLine();
        System.out.println("Do you want to see your key being generated?\n"
            + "(Type yes for prompts during generation)");
        input = in.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            c.assignRandomKeyPrompted();
        }else {
            c.assignRandomKey();
        }
        System.out.println("Do you want to see your generated key?\n"
            + "(Type yes for key)");
        input = in.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.println("Current key is: " + new String(c.getKey()) +"\n");
        }
        e = new Encrypt(c.getKey());
        d = new Decrypt(c.getKey());
        do {
        System.out.println("Do you want to Encrypt, Decrypt, "
            + "or Analyze text frequencies?\n"
            + "(Type encrypt, decrypt, or analyze. Press any key to quit)");
        input = in.nextLine();
        if (input.equalsIgnoreCase("encrypt")) {
            e.initialize();
        }
        else if(input.equalsIgnoreCase("decrypt") || input.equalsIgnoreCase("analyze")) {
            d.initialize();
        }
        }while(input.equalsIgnoreCase("encrypt") || input.equalsIgnoreCase("decrypt")|| input.equalsIgnoreCase("analyze"));
    }
}
