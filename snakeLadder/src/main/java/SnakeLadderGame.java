import lombok.Data;
import model.Board;
import model.Cell;
import model.Dice;
import model.Player;

import java.util.Deque;
import java.util.LinkedList;

@Data
public class SnakeLadderGame {

    private Board board;
    private Dice dice;
    private Deque<Player> players;
    private Player winner;

    public SnakeLadderGame() {
        initializeGame();
    }

    private void initializeGame() {
        this.board = new Board(10, 4, 5);
        this.dice = new Dice(1);
        this.players = new LinkedList<>();
        addPlayers();
        this.winner = null;
    }

    private void addPlayers() {

        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);

        players.add(player1);
        players.add(player2);
    }

    public void startGame() {

        while (winner == null) {
            Player playerTurn = players.removeFirst();
            players.addLast(playerTurn);

            System.out.println("Player " + playerTurn.getId() + " current position is " + playerTurn.getCurrentPosition());
            int diceValue = dice.roll();

            int newPosition = playerTurn.getCurrentPosition() + diceValue;
            newPosition = checkJump(newPosition);
            playerTurn.setCurrentPosition(newPosition);

            System.out.println("Player " + playerTurn.getId() + " new position is " + playerTurn.getCurrentPosition());
            if (newPosition > board.getSize() * board.getSize() - 1) {
                winner = playerTurn;
            }
        }

        System.out.println("Winner is " + winner.getId());
    }

    private int checkJump(int newPosition) {

        if (newPosition >= board.getSize() * board.getSize() - 1) {
            return newPosition;
        }

        Cell cell = board.getCells()[newPosition / board.getSize()][newPosition % board.getSize()];
        if (cell.getJump() != null && cell.getJump().getStart() == newPosition) {
            String jumpBy = cell.getJump().getStart() > cell.getJump().getEnd() ? "SNAKE" : "LADDER";
            System.out.println("Found jump through " + jumpBy);
            return cell.getJump().getEnd();
        }

        return newPosition;
    }

}
