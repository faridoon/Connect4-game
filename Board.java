import java.util.Random;

public class Board {
    private final char[][] gameBoard;
    private final int winningNumber;
    private boolean checkWin;
    private final Random rand;

    public Board(int winningNumber) {
        this.winningNumber = winningNumber;
        rand = new Random();
        checkWin = false;
        gameBoard = new char[6][7];
        printBoard();
        System.out.println(winningNumber + " tokens should be placed in a row vertically, horizontally or diagonally in order to win.");
    }

    /**
     * Simply displays the game's board
     */
    public void printBoard() {
        System.out.println("\n―――――――――――――――――");
        for (int x = 0; x < gameBoard.length; x++) {
            System.out.print("| ");
            for (int y = 0; y < gameBoard[x].length; y++) {
                if (gameBoard[x][y] == '\0') {
                    System.out.print("o ");
                } else {
                    System.out.print(gameBoard[x][y] + " ");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("  1 2 3 4 5 6 7");
        System.out.println("―――――――――――――――――\n");
    }

    /**
     * Places a token on the board for a human player
     *
     * @param i position from user
     * @param t player's token
     */
    public void placeToken(int i, char t) {
        if (i > 0 && i <= gameBoard.length + 1) {
            for (int x = gameBoard.length - 1; x >= -1; x--) {
                //go over the column in reverse order and place token where slot is empty
                if (x < 0) {
                    System.out.println(String.format("No more empty slots available in column #%d. You lost your turn!", i));
                    return;
                }
                //since array elements start with index 0, we need to decrement i (the column specified by user)
                if (gameBoard[x][i - 1] == '\0') {
                    gameBoard[x][i - 1] = t;
                    return;
                }
            }
        } else {
            System.out.println("Please enter a valid number that's between 1 and 7. You lost your turn!");
        }
    }

    /**
     * Places a random token for computer players
     *
     * @param t Player's token
     *
     * @return Position at which token was placed
     */
    public int placeRandomToken(char t) {
        int minimum = 1;
        int maximum = 7;
        int randomNum;
        randomNum = minimum + rand.nextInt((maximum - minimum) + 1);

        if (randomNum > 0 && randomNum <= gameBoard.length + 1) {
            for (int x = gameBoard.length - 1; x >= -1; x--) {
                //go over the column in reverse order and place token where slot is empty
                if (x < 0) {
                    System.out.println(String.format("No more empty slots available in column #%d. You lost your turn!", randomNum));
                    return randomNum;
                }
                //since array elements start with index 0, we need to decrement i (the column specified by user)
                if (gameBoard[x][randomNum - 1] == '\0') {
                    gameBoard[x][randomNum - 1] = t;
                    return randomNum;
                }
            }
            return randomNum;
        } else {
            System.out.println("Please enter a valid number that's between 1 and 7. You lost your turn!");
        }
        return randomNum;
    }

    /**
     * Checks whether the game is playable; if all slots are full, then game cannot be played
     *
     * @return true or false
     */
    public boolean canPlay() {
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[x].length; y++) {
                if (gameBoard[x][y] == '\0') {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if player (human or computer) has won the game
     *
     * @param playerToken
     *
     * @return true or false
     */
    public boolean playerWon(char playerToken) {
        int count = 0;
        //check horizontal
        for (int row = gameBoard.length - 1; row >= 0; row--) {
            count = 0;
            for (int col = 0; col < gameBoard[row].length; col++) {
                if (gameBoard[row][col] == playerToken) {
                    count++;
                    if (count == winningNumber) {
                        checkWin = true;
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        //check vertical
        for (int col = 0; col < gameBoard[0].length; col++) {
            count = 0;
            for (int row = 0; row < gameBoard.length; row++) {
                if (gameBoard[row][col] == playerToken) {
                    count++;
                    if (count == winningNumber) {
                        checkWin = true;
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        //check diagnoal

        for (int n = -gameBoard.length; n <= gameBoard.length; n++) {
            count = 0;
            for (int i = 0; i < gameBoard.length; i++) {
                if ((i - n >= 0) && (i - n < gameBoard.length)) {
                    if (gameBoard[i][i - n] == playerToken) {
                        count++;
                        if (count == winningNumber) {
                            checkWin = true;
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
        return false;
    }


    public boolean checkWin() {
        return checkWin;
    }

}
