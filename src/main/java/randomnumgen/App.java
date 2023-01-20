package randomnumgen;

import java.util.Random;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        Integer guess = rand.nextInt(100);

        int myGuess = 0;
        Scanner input = new Scanner(System.in);

        while (myGuess != guess) {
            myGuess = input.nextInt();

            if (myGuess < guess) {
                System.out.println("too low!");
            } else if (myGuess > guess) {
                System.out.println("too high!");
            } else {
                System.out.println("just nice!");
            }
        }
        input.close();
    }
}
