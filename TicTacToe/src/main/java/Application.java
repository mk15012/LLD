public class Application {

    public static void main(String args[]) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        System.out.println("Game winner is: " + game.startGame());
    }

}
