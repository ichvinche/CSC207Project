package Strategy;

import boggle.Position;

import java.util.ArrayList;
import java.util.Map;

public class HardGameStrategy implements Strategy{
    /**
     * Return "Can not Request Hint in Hard Mode".
     * @param allWords
     * @return String
     */
    @Override
    public String RequestHint(Map<String, ArrayList<Position>> allWords) {
        return "Can not Request Hint in Hard Mode";
    }

    /**
     * Return 0 as a prefix can not be requested in the hard mode.
     * @param pre
     * @param allWords
     * @return
     */
    @Override
    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords) {
        return 0;
    }

}
