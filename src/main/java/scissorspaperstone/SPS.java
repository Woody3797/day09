package scissorspaperstone;

import java.util.Random;

public class SPS {
    
    public Integer generateComputerChoice() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public String checkWinner(Integer playerChoice, Integer computerChoice) {
        playerChoice = playerChoice - 1;
        String winner = "";
        if (playerChoice == computerChoice) {
            return "";
        }

        switch (playerChoice) {
            case 0: 
                if (computerChoice == 1) {
                    winner = "player";
                } else {
                    winner = "computer";
                }
                break;
            case 1:
                if (computerChoice == 2) {
                    winner = "player";
                } else {
                    winner = "computer";
                }
                break;
            case 2:
                if (computerChoice == 0) {
                    winner = "player";
                } else {
                    winner = "computer";
                }
                break;
        }
        return winner;
    }
}
