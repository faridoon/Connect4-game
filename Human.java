/**
 * Represents a human player in the game; it extends the Player class
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Human extends Player {

    private final BufferedReader in;

    public Human(char t, String name) {
        super(t, name);
        in = new BufferedReader(new InputStreamReader(System.in));

    }

    /**
     * Take input from user via the command line/terminal
     * This overrides the parent class' method for human-specific functionality
     *
     * @return user-inputted string e.g. 5
     */
    @Override
    public String getUserInput() {
        String s;
        try {
            s = in.readLine();
            return s;
        } catch (IOException e) {
            System.out.println("There was an error capturing your input. Please try again. ");
        }
        return null;

    }
}

