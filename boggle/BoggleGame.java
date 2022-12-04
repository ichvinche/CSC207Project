package boggle;

import java.util.*;

/**
 * The BoggleGame class for Phase 2 of CSC207 Group Project, Fall 2022.
 */
public class BoggleGame {
    /**
     * stores game statistics.
     */
    private BoggleStats gameStats;

    /**
     * dice used to randomize letter assignments for a small grid.
     */
    private final String[] dice_small_grid =
            {"AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS", "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                    "DISTTY", "EEGHNW", "EEINSU", "EHRTVW", "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ"};

    /**
     * dice used to randomize letter assignments for a big grid.
     */
    private final String[] dice_big_grid =
            {"AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM", "AEEGMU", "AEGMNN", "AFIRSY",
                    "BJKQXZ", "CCNSTW", "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DDHNOT", "DHHLOR",
                    "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU", "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"};

    /**
     * BoggleGame constructor.
     */
    public BoggleGame() {
        throw new UnsupportedOperationException();
    }

    /**
     * Return a string of letters from a list of words given the board size that needs to be displayed onto the screen
     * for the human to see and play.
     *
     * There is one letter per grid position and they are organized from left to right.
     *
     * @param size The size of the boggle grid the human wants to play at.
     * @return String A string of random letters that depends on the size of the boggle grid.
     */
    private String randomizeLetters(int size) {
        StringBuilder boggleLetters = new StringBuilder();
        Random rand = new Random();
        if (size == 4) {
            List<String> copyDice = new ArrayList<String>(List.of(dice_small_grid.clone()));
            Collections.shuffle(copyDice);
            for (String s: copyDice) {
                int randomInt = rand.nextInt(s.length() - 1);
                boggleLetters.append(s.charAt(randomInt));
            }
            return boggleLetters.toString();
        } else if (size == 5) {
            List<String> copyDice = new ArrayList<String>(List.of(dice_big_grid.clone()));
            Collections.shuffle(copyDice);
            for (String s: copyDice) {
                int randomInt = rand.nextInt(s.length() - 1);
                boggleLetters.append(s.charAt(randomInt));
            }
            return boggleLetters.toString();
        } else {
            return null;
        }
    }

    /**
     * Recursive function that finds all the words given a boggle grid of some size.
     * Every word should be valid; i.e. should be part of the boggle dictionary.
     *
     * Words that are found (through recursion) are to be added into the allWords HashMap.
     */
    private void findAllWords(Map<String, ArrayList<Position>> allWords, Dictionary boggleDict, BoggleGrid boggleGrid) {
        throw new UnsupportedOperationException();
    }
}
