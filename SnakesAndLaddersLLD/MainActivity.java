package SnakesAndLaddersLLD;
import SnakesAndLaddersLLD.Models.Game;
import SnakesAndLaddersLLD.Models.Player;

public class MainActivity {
    public static void main(String[] args) {
        System.out.println("Starting the game!");
        Game snlGame = new Game(30, 5, 7);
        Player p1 = new Player("Pikachu");
        Player p2 = new Player("Squirtle");
        Player p3 = new Player("Togepi");
        snlGame.addPlayer(p1);
        snlGame.addPlayer(p2);
        snlGame.addPlayer(p3);
        try {
            snlGame.playGame();
        }
        catch(Exception e) {
            System.out.println("Some issue");
        }
    }
}
