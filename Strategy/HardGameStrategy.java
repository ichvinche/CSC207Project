package Strategy;

import boggle.BoggleGame;
import boggle.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class HardGameStrategy implements Strategy{
    /**
     * Return first 3 letters of a word
     * @param allWords
     * @return String
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
     * @param pre
     * @param allWords
     * @return
     */
    @Override
    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords) {
        return 0;
    }

}
