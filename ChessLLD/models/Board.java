package ChessLLD.models;

public class Board {
    Cell[][] board;

    public Board(int n) {
        board = new Cell[n][n];
        initBoard();
    }

    public void initBoard() {
        
    }
}
