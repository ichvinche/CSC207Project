package Strategy;

import boggle.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface Strategy {
    public String RequestHint(Map<String, ArrayList<Position>> allWords);
    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords);
}
