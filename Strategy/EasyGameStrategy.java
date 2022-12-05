package Strategy;

import boggle.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;


public class EasyGameStrategy implements Strategy{

    /**
     * Return the first 3 letters of a word present on the board, serving as a hint for the player.
     * @param allWords
     * @return
     */
    @Override
    public String RequestHint(Map<String, ArrayList<Position>> allWords) {
        ArrayList<String> all = new ArrayList<>();
        for (String word: allWords.keySet()){
            all.add(word);
        }
        Random random = new Random();
        int index = random.nextInt(all.size());
        String ele = all.get(index);
        String hint = ele.substring(0, 3);
        return hint;
    }

    /**
     * Return the number of words with the given prefix which are present on the board
     * @param pre
     * @param allWords
     * @return int
     */
    @Override
    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords) {
        int total = 0;
        for (String word: allWords.keySet()){
            if (word.toLowerCase().startsWith(pre.toLowerCase())){
                total++;
            }
        }
        return total;
    }

}
