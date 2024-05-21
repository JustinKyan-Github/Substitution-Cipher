import java.util.Scanner;
public class Encrypt {
    private char plaintext[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char key[];
    public Encrypt(char keyGen[]){
        key = keyGen;
    }
/**
* Initializes the encryption process by prompting the user to enter a string
* to encrypt. If the user enters "-1", the function will return without
* performing any encryption. Otherwise, it will encrypt the input string
* using the key provided during object creation and print the encrypted
* result to the console.
*/
    public void initialize() {
        // Create a Scanner object to read user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter a string to encrypt
        System.out.println("Enter a string to encrypt (type -1 to quit): ");

        // Read the user input as a string
        String input = in.nextLine();

        // Check if the user entered "-1" to quit the program
        if (input.equals("-1")) {
            return;
        } else {
            // If the user entered a string, encrypt it and print the result
            System.out.println("\nEncrypted text:\n" + encrypt(input) + "\n");
        }
    }

/**
* Encrypts a given message using a substitution cipher defined by the key.
* 
* @param message The message to be encrypted.
* @return The encrypted message.
*/
     private String encrypt(String message) {
        // Convert the message to lowercase and convert it into a character array
        char[] string = message.toLowerCase().toCharArray();
        
        // Iterate over each character in the message
        for (int i = 0; i < string.length; i++) {
            // Iterate over each character in the plaintext
            for (int j = 0; j < plaintext.length; j++) {
                // If the character is found in the plaintext, replace it with the corresponding character from the key
                if (string[i] == plaintext[j]) {
                    string[i] = key[j];
                    // Exit the inner loop since the character has been found and replaced
                    break;
                }
            }
        }
        // Return the encrypted message as a string
        return new String(string);
    } 

}
