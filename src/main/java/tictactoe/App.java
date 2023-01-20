package tictactoe;

public class App {
    
    public static void main(String[] args) {
        
        Board board = new Board("p1", "p2");

        board.printBoard();
        System.out.println("tic tac toe game. player X will play first");
    }
}
