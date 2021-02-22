public class Game {
    private final Board board;
    private final int winningNumber;

    public Game(int n) {
        winningNumber = n;
        board = new Board(winningNumber);
    }

    public void playGame() {
        Player human = new Human('y', "You");
        Player computer1 = new Computer('r', "Computer 1");
        Player computer2 = new Computer('b', "Computer 2");

        Player currentPlayer = human;
        int i = 0;

        while (board.canPlay() && !board.checkWin()) {
            if (currentPlayer.getName().equals("You")) {
                System.out.println("It's your turn. Enter a number between 1 and 7:");
                try {
                    i = Integer.parseInt((currentPlayer.getUserInput()));
                } catch (Exception NumberFormatException) {
                    System.out.println("You didn't enter a valid number. You lost your turn! Boo!");
                }
                board.placeToken(i, currentPlayer.getToken());
            } else {
                System.out.println(currentPlayer.getName() + " entered " + board.placeRandomToken(currentPlayer.getToken()));
            }
            if (board.playerWon(currentPlayer.getToken())) {
                System.out.println("***** " + currentPlayer.getName() + " won! *****");
                board.printBoard();
                System.out.println("End of Game. Goodbye!");
                return;
            }

            if (currentPlayer.equals(human)) {
                currentPlayer = computer1;
            } else if (currentPlayer.equals(computer1)) {
                currentPlayer = computer2;
            } else {
                currentPlayer = human;
            }
            board.printBoard();
        }
    }
}
