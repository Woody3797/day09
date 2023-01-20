package tictactoe;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String[] tttBoard = new String[9];

        // player X and O
        String player = "X";
        String winner = "";

        // populating the tic-tac-toe board with 1 to 9
        for (int i = 0; i < 9; i++) {
            tttBoard[i] = String.valueOf(i + 1);
        }

        TicTacToe ttt = new TicTacToe();

        Scanner scanner = new Scanner(System.in);
        while (winner == "") {
            System.out.println("Tic-Tac-Toe game");
            System.out.println("----------------");
            System.out.println(player + " will play now...");
    
            // print out the initial tic-tac-toe board
            ttt.printBoard(tttBoard);
    

            // play tic-tac-toe logic here...
            Integer input;

            System.out.print("(Player " + player + ") Enter your position: ");
            input = scanner.nextInt();

            // only accept keyboard input 1 to 9
            if ((input > 0) && (input < 10)) {

            } else {
                System.out.println("Invalid input: Only number 1 to 9 is allowed.");
                continue;
            }

            // assign 'X' or 'O' to position if its number
            if ((tttBoard[input - 1]).equals(String.valueOf(input))) {
                tttBoard[input - 1] = player;

                // switch to another player's turn
                if (player.equalsIgnoreCase("X")) {
                    player = "O";
                } else {
                    player = "X";
                }
            } else {
                System.out.println("Position already taken up. Please enter another position number");
            }

            ttt.printBoard(tttBoard);
            winner = ttt.checkWinner(tttBoard);

            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("Its a " + winner);
            } else {
                System.out.println("The winner of this game is " + winner);
            }
        }

        scanner.close();

    }
}
