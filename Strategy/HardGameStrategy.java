package Strategy;

import boggle.BoggleGame;
import boggle.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * HardGameStrategy that implements the Strategy interface.
 */
public class HardGameStrategy implements Strategy{
    /**
     * Return first 3 letters of a word
     * @param allWords All legal words on the boggle grid.
     * @return String The string we are returning to the player.
     */
    @Override
    public String RequestHint(Map<String, ArrayList<Position>> allWords) {
        ArrayList<String> all = new ArrayList<>();
        for (String word: allWords.keySet()){
            if (word.length() >= 5){
            all.add(word);
            }
        }
        Random random = new Random();
        int index = random.nextInt(all.size());
        String ele = all.get(index);
        while (BoggleGame.gameStats.getPlayerWords().contains(ele.toUpperCase())){
            index = random.nextInt(all.size());
            ele = all.get(index);
        }
        String hint = ele.substring(0, 3);
        return hint;
    }

    /**
     * Return 0 as a prefix can not be requested in the hard mode.
     * @param pre The prefix we want to check.
     * @param allWords All legal words on the boggle grid.
     * @return int The number of words containing the prefix pre.
     */
    @Override
    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords) {
        return 0;
    }

}
