package scissorspaperstone;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        
        // String[] choice = {"scissors", "paper", "stone"};

        Scanner scanner = new Scanner(System.in);
        SPS sps = new SPS();
        boolean win = false;
        String winner = "";

        while (!win) {
            int computerChoice = sps.generateComputerChoice();
            System.out.println("enter 1 for scissors, 2 for paper, 3 for stone");
            int playerChoice = scanner.nextInt();

            if (!(playerChoice > 0 && playerChoice < 4)) {
                System.out.println("invalid input, enter number 1 or 2 or 3 ");
                continue;
            } else {
                winner = sps.checkWinner(playerChoice, computerChoice);
                if (winner.contains("draw")) {
                    System.out.println(winner);
                } else {
                    System.out.println(winner + " wins!");
                    win = true;
                }
            }
        }
        scanner.close();
    }
}
