package ChessLLD.models;

public abstract class Piece {
    public abstract Cell[] getMoves();
    public abstract Cell[] getCaptures();
    
}
