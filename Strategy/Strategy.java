package Strategy;

import boggle.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface Strategy {

    /**
     * Request a hint.
     *
     * @param allWords All legal words on the boggle grid.
     * @return String The string we are returning to the player.
     */
    public String RequestHint(Map<String, ArrayList<Position>> allWords);

    /**
     * Check the number of words that start with a given prefix.
     *
     * @param pre The prefix we are using to check.
     * @param allWords All legal words on the grid.
     * @return int The number of words on the grid that start with pre.
     */
    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords);
}
