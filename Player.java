/**
 * Represents a Player in the game
 * This class is extended by Human and Computer classes to allow
 * for specific fields and methods, as well as extensibility
 */
public class Player {

    private final char token;
    private final String name;

    public Player(char t, String name) {
        token = t;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * This method is to be overridden by classes extending Player
     *
     * @return null
     */
    public String getUserInput() {
        return null;
    }

    public char getToken() {
        return token;
    }

}