package Strategy;
import boggle.BoggleGame;
import boggle.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * EasyGameStrategy class that implements the Strategy interface.
 */
public class EasyGameStrategy implements Strategy{

    /**
     * Return the first 3 letters of a word present on the board, serving as a hint for the player.
     * @param allWords All legal words on the boggle grid.
     * @return String The word we are giving to the user.
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
        while (BoggleGame.gameStats.getPlayerWords().contains(ele.toUpperCase())){
            index = random.nextInt(all.size());
            ele = all.get(index);
        }
        return ele;
    }

    /**
     * Return the number of words with the given prefix which are present on the board.
     * @param pre The prefix the user has inputted.
     * @param allWords All legal words on the grid.
     * @return int The number of words starting with the prefix pre.
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
