import java.util.Random;
public class keyGeneration {
    private char plaintext[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char key[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public keyGeneration() {}
    public char[] getKey() {
        return this.key;
    }

    Random randomGen = new Random();
    public void assignRandomKey(){
        //creates a char array for the index's vocabulary
        char[] charList = plaintext;
        for(int i = 0; i<charList.length; i++) {
            //picks a random index in the vocabulary list
            int rand = randomGen.nextInt(charList.length);
            //System.out.println("Generating random number: " + (rand+1));
            //If a value has already been used as detectable by a blank char it will be skipped
            while(charList[rand]==' ') {
                //System.out.print((rand+1) + " is already chosen. Increase by one: " );
                rand++;
                //System.out.println(rand+1);
                //cycles the rand value back to 0 if it exceeds the length of the list
                if(rand>=charList.length) {
                    rand = 0;
                }
            }
            //once its found an appropriate value it sets it as the next value in the key
            key[i] = charList[rand];
            //System.out.println("Letter " + (rand+1) + " is now: " + key[i]);
            //marks the char as read by replacing it with a blank char
            charList[rand] = ' ';
        }
    }

    public void assignRandomKeyPrompted(){
        //creates a char array for the index's vocabulary
        char[] charList = plaintext;
        for(int i = 0; i<charList.length; i++) {
            //picks a random index in the vocabulary list
            int rand = randomGen.nextInt(charList.length);
            System.out.println("Generating random letter: " + (char)(rand+97));
            //If a value has already been used as detectable by a blank char it will be skipped
            while(charList[rand]==' ') {
                System.out.println((char)(rand+97) + " is already chosen. Choosing New Letter: ");
                rand++;
                //cycles the rand value back to 0 if it exceeds the length of the list
                if(rand>=charList.length) {
                    rand = 0;
                }
            }
            //once its found an appropriate value it sets it as the next value in the key
            key[i] = charList[rand];
            System.out.println("Letter " + key[i] + " is: " + (char)(i + 97));
            //marks the char as read by replacing it with a blank char
            charList[rand] = ' ';
        }
        System.out.println("\n");
    }
}
