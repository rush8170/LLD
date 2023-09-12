package SnakesAndLaddersLLD.Models;

public class Board {
    // Assuming the board to be of dimension size*size
    int size;
    int startPosition;
    int endPosition;
    
    public Board(int size, int startPosition, int endPosition) {
        this.size = size;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

}
