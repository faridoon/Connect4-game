public class Main {
    public static void main(String[] args) {
        int n = 4;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
                if (n >= 7 || n <= 2) {
                    System.out.println(String.format("The given argument %d is not acceptable. You must pass a value that's more than 2 and less than 7. Starting game with default settings.", n));
                    n = 4;
                }
            } catch (NumberFormatException e) {
                System.out.println("Command line argument must be a number. Game started with default settings.");
            }
        }
        Game game = new Game(n);
        game.playGame();
    }
}
