package Models;

public class Player {
    String name;
    @Getter
    int position;
    boolean hasWon;

    private Player(String name, int position, boolean hasWon) {
        this.name = name;
        this.position = position;
        this.hasWon = hasWon;
    }

    public Player(String name) {
        this(name, 0, false);
    }
}
