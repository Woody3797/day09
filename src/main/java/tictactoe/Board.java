package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    
    private String[] board = {"1","2","3","4","5","6","7","8","9"};
    private boolean win;
    private String player1 = "X";
    private String player2 = "O";

    public Board(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public boolean isWin() {
        return win;
    }


    public void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " | ");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " | ");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " | ");
        System.out.println("|---|---|---|");
    }

    public String checkWinner(String[] board) {
        int i = 0;
        String line = "";
        String winner = "";
        while (i < 8) {
            switch (i) {
                case 0: line = board[0] + board[1] + board[2];
                    break;
                case 1: line = board[3] + board[4] + board[5];
                    break;
                case 2: line = board[6] + board[7] + board[8];
                    break;
                case 3: line = board[0] + board[3] + board[6];
                    break;
                case 4: line = board[1] + board[4] + board[7];
                    break;
                case 5: line = board[2] + board[5] + board[8];
                    break;
                case 6: line = board[0] + board[4] + board[8];
                    break;
                case 7: line = board[2] + board[4] + board[6];
                    break;
            }
            i++;

            if (line.equalsIgnoreCase("XXX")) {
                winner = "X";
                i = 9;
            } else if (line.equalsIgnoreCase("OOO")) {
                winner = "O";
                i = 9;
            } else {
                for (int j = 0; j < 9; j++) {
                    if (Arrays.asList(board).contains(String.valueOf(j + 1))) {
                        break;
                    } else if (j == 8) {
                        winner = "draw";
                    }
                }
            }
        }
        return winner;
    }

    public void updateBoard(String player, String[] board) {
        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();
        int turn = 1;

        if (turn % 2 == 1) {
            player = player1;
            board[Integer.parseInt(playerInput)] = player1;
        } else {
            player = player2;
            board[Integer.parseInt(playerInput)] = player2;
        }


    }
}
