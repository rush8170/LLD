package Models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Game {
    Board board;
    Dice dice;
    int numOfLadders;
    int numOfSnakes;
    List<Snake> snakes;
    List<Ladder> ladders;
    Queue<Player> players;
    Random random;

    public Game(int size, int numOfLadders, int numOfSnakes) {
        this.random = new Random(12344);
        this.board = new Board(size, 1, size);
        this.dice = new Dice(1,6,-1);
        this.numOfLadders = numOfLadders;
        this.numOfSnakes = numOfSnakes;
        snakes = new ArrayList<Snake>();
        ladders = new ArrayList<Ladder>();
        players = new ArrayDeque<Player>();
        this.initBoard();
    }

    private void initBoard() {
        // One thing missing is what is the snake and ladder have same start and end (infinite loop)
        HashSet<Snake> uniqueSnakes = new HashSet<Snake>();
        for(int i=0;i<numOfSnakes;i++) {
            while(true) {
                int randStart = random.nextInt(board.startPosition, board.size);
                int randEnd = random.nextInt(board.startPosition, board.size);
                if(randStart!=randEnd) {
                    int temp = Math.max(randStart, randEnd);
                    randStart = Math.min(randStart, randEnd);
                    randEnd = temp;
                    Snake currSnake = new Snake(randStart, randEnd);
                    if(!uniqueSnakes.contains(currSnake)) {
                        uniqueSnakes.add(currSnake);
                        snakes.add(currSnake);
                        break;
                    }
                }
            }
        }

        HashSet<Ladder> uniqueLadders = new HashSet<Ladder>();
        for(int i=0;i<numOfLadders;i++) {
            while(true) {
                int randStart = random.nextInt(board.startPosition, board.size);
                int randEnd = random.nextInt(board.startPosition, board.size);
                if(randStart!=randEnd) {
                    int temp = Math.max(randStart, randEnd);
                    randStart = Math.min(randStart, randEnd);
                    randEnd = temp;
                    Ladder currLadder = new Ladder(randStart, randEnd);
                    if(!uniqueLadders.contains(currLadder)) {
                        uniqueLadders.add(currLadder);
                        ladders.add(currLadder);
                        break;
                    }
                }
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void playGame () throws Exception{
        while(true) {
            Player currPlayer = players.poll();
            System.out.println("Player " + currPlayer.name + "'s turn");
            
            int diceRoll = dice.roll();
            System.out.println("Dice roll resulted in : " + diceRoll);
            int currPosition = currPlayer.position;
            int newPosition = diceRoll + currPosition;
            if(newPosition > board.endPosition) {
                players.offer(currPlayer);
            }
            else if(newPosition == board.endPosition) {
                System.out.println("Player " + (currPlayer.name) + " won!");
                currPlayer.hasWon = true;
                break;
            }
            else {
                currPlayer.position = getPositionAfterSnakeOrLadder(newPosition);
                players.offer(currPlayer);
            }

            System.out.println("Player " + currPlayer.name + " is at position " + currPlayer.position);

            if(players.size()<2) {
                break;
            }
        }
    }

    private int getPositionAfterSnakeOrLadder(int index) {
        for(Snake snake: snakes) {
            if(snake.head == index) {
                System.out.println("You were bitten by a snake!");
                return snake.tail;
            }
        }
        for(Ladder ladder: ladders) {
            if(ladder.start == index) {
                System.out.println("You rose the ranks with the ladder!");
                return ladder.end;
            }
        }
        return index;
    }
    
}