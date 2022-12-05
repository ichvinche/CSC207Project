package boggle;

import java.util.*;

import Strategy.Context;
import Strategy.Strategy;
import randomiterator.*;

/**
 * The BoggleGame class for Phase 2 of CSC207 Group Project, Fall 2022.
 */
public class BoggleGame {
    /**
     * stores game statistics.
     */
    private BoggleStats gameStats;
    public Context context;

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
        gameStats = new BoggleStats();
        context = null;
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
     *
     * @param allWords
     * @param boggleDict
     * @param boggleGrid
     */
    private void findAllWords(Map<String, ArrayList<Position>> allWords, Dictionary boggleDict, BoggleGrid boggleGrid) {
        ArrayList<Position> checker = new ArrayList<Position>();
        int cols = boggleGrid.numCols();
        int rows = boggleGrid.numRows();
        boolean[] arr = new boolean[cols*rows];
        Position curr = new Position();
        String str = "";
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                curr.setRow(i);
                curr.setCol(j);
                helperFindAllWords(rows, i,j,curr,allWords,checker, boggleDict,boggleGrid,str, arr);
            }
        }
    }

    private void helperFindAllWords(int rows, int i, int j, Position curr, Map<String,ArrayList<Position>> alWords,
                                    ArrayList<Position> checker, Dictionary boggleDict, BoggleGrid boggleGrid,
                                    String str, boolean[] arr) {
        arr[i*rows+j] = true;
        str = str + boggleGrid.getCharAt(i, j);
        checker.add(curr);
        Position new_added =  new Position();
        if (boggleDict.isPrefix(str)) {
            if (boggleDict.containsWord(str) && str.length() >= 4) {
                alWords.put(str, checker);
            }
            for (int row = i - 1; row <= i + 1 && row < boggleGrid.numRows(); row++) {
                for (int col = j - 1; col <= j + 1 && col < boggleGrid.numCols(); col++) {
                    if (row >= 0 && col >= 0 && !arr[row*rows+col]){
                        new_added.setCol(col);
                        new_added.setRow(row);
                        helperFindAllWords(rows, row, col, new_added, alWords, checker,
                                boggleDict, boggleGrid, str, arr);
                    }
                }
            }
        }
        arr[i*rows+j] = false;
        checker.remove(curr);
    }

    /**
     * Get words from the human player.
     */
    private void humanMove() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets words from a computer. The computer should find words that are both valid and not in the player's word list.
     * In addition, the number of words a computer can choose depends on the difficulty and should be modelled via some
     * form of a Bernoulli distribution with a set parameter p.
     *
     * For each word that the computer finds, update the computer's word list and increment the computer's score which
     * is stored in boggleStats.
     *
     * @param allWords a mutable list of all legal words that can be found, given the boggleGrid grid letters.
     */
    private void computerMove(Map<String, ArrayList<Position>> allWords) {
        ConcreteListContainer container = new ConcreteListContainer();
        String[] words = allWords.keySet().toArray(new String[0]);

        for (RandomIterator iterator = container.iterator(words, 0, words.length - 1, 2);
             iterator.hasNext();) {
            String word = iterator.next();
            if (!gameStats.getPlayerWords().contains(word)) {
                gameStats.addWord(word, BoggleStats.Player.Computer);
            }
        }
    }

    public String RequestHint(Map<String, ArrayList<Position>> allWords) {
        Strategy strat = this.context.returnStrategy();
        return strat.RequestHint(allWords);
    }

    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords){
        Strategy strat = this.context.returnStrategy();
        return strat.CheckPrefix(pre, allWords);
    }
}