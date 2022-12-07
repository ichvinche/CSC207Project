package boggle;

import Strategy.*;
import randomiterator.*;
import java.util.*;

/**
 * The BoggleGame class for the Group Project Phase 2 in CSC207, Fall 2022
 */
public class BoggleGame {
    /**
     * Stores game statistics.
     */
    public static BoggleStats gameStats;
    /**
     * The boggle grid.
     */
    BoggleGrid grid;
    /**
     * The board size.
     */
    int boardsize;
    /**
     * Variable for whether the game is done.
     */
    boolean gamedone = false;
    /**
     * Variable for whether the round is done.
     */
    boolean endround;
    /**
     * The context of the boggle game.
     */
    public Context context;
    /**
     * List of all boards on the boggle grid.
     */
    Map<String,ArrayList<Position>>  allWords;
    /**
     * Variable for whether the game is on easy mode.
     */
    boolean easyMode;

    /**
     * Dice used to randomize letter assignments for a small grid.
     */
    private final String[] dice_small_grid= //dice specifications, for small and large grids
            {"AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS", "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                    "DISTTY", "EEGHNW", "EEINSU", "EHRTVW", "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ"};
    /**
     * Dice used to randomize letter assignments for a big grid.
     */
    private final String[] dice_big_grid =
            {"AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM", "AEEGMU", "AEGMNN", "AFIRSY",
                    "BJKQXZ", "CCNSTW", "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DDHNOT", "DHHLOR",
                    "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU", "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"};

    /*
     * BoggleGame constructor.
     */
    public BoggleGame(boolean size) {
        if (size) {
            boardsize = 4;
        }
        else{
            boardsize = 5;
        }
        String letters = randomizeLetters(boardsize);
        grid = new BoggleGrid(boardsize);
        grid.initalizeBoard(letters);
        gameStats = new BoggleStats();
        this.context = null;
    }

    /*
     * Provide instructions to the user, so they know how to play the game.
     */
    public String giveInstructions() {
        return ("""
                The Boggle board contains a grid of letters that are randomly placed.
                We're both going to try to find words in this grid by joining the letters.
                You can form a word by connecting adjoining letters on the grid.
                Two letters adjoin if they are next to each other horizontally,\s
                vertically, or diagonally. The words you find must be at least 4 letters long,
                 and you can't use a letter twice in any single word. Your points
                 will be based on word length: a 4-letter word is worth 1 point, 5-letter
                words earn 2 points, and so on. After you find as many words as you can,
                I will find all the remaining words.
                
                The User Interface also has certain rules to follow. Select a 4x4 or 5x5 Board.\040
                This show the board game itself where the User is required to first press Start\040
                to intialize and start the game. The User can then play the game by enter potential\040
                words in the text field and pressing submit to check their guess. They can use the\040
                hint button to get either a full word, if the game mode is set as easy, or the first
                few letters of a word, if the game mode is set as hard. Once the User has finished\040
                guessing, the User can either press the End Round Button, which will end the round,\040
                let the computer guess the remaining words, showcase the round statistics on the\040
                console and start the next round. They can also, press the Stop Button which will
                end the game and take the User back to the main menu. They can also press the New\040\040
                Game button which will start a new game for the User in the same grid selection\040
                and difficulty.\040
                When Checking the number of prefixes, using the "Prefix Words" button, if the difficulty\040
                is set to easy, the game will return the number of words containing that prefix.\040
                However, if the difficulty is set to hard, 0 will always be returned.\040
                When asking for a hint using the "hint" button, if the game's difficulty is set to easy, the game \040
                returns a word which has not yet been found by the player. If the difficulty is set to hard \040
                the game returns the first 3 letters of a word that the player has not yet found\040
                If the game difficulty is set to hard, only words of length 5 or more are accepted by the game.\040
                Have a nice session! :) <3
                
                
                
                """);
    }

    /**
     * Gets information from the user to initialize a new Boggle game.
     * It will loop until the user indicates they are done playing.
     *
     * @param word The word to be added to the player word's list.
     */
    public void addword(String word){
        if (!gamedone && !endround && !Objects.equals(word, "") && (allWords.containsKey(word.toUpperCase())) &&
                !gameStats.getPlayerWords().contains(word.toUpperCase())){
            gameStats.addWord(word.toUpperCase(), BoggleStats.Player.Human);
        }
    }

    /**
     * End the boggle round.
     */
    public void endround(){
        endround = true;
        computerMove();
        gameStats.summarizeRound();
        gameStats.endRound();
        playRoundnext();
    }

    /**
     * End the boggle game.
     */
    public void EndGame() {
        gamedone = true;
        endround = true;
        gameStats.summarizeGame();
    }

    /**
     * Play the boggle game.
     */
    public void playGame() {
        gamedone = false;
        endround = false;
    }

    /**
     * Get the score of the boggle game.
     *
     * @return int The human score of the boggle game being currently played.
     */
    public int getscore(){
        return gameStats.getScore();
    }

    /**
     * Get the BoggleGrid.
     *
     * @return BoggleGrid The BoggleGrid class attribute that is being played on.
     */
    public BoggleGrid getgrid(){
        return grid;
    }

    /*
     * Play a round of Boggle.
     * This initializes the main objects: the board, the dictionary, the map of all
     * words on the board, and the set of words found by the user. These objects are
     * passed by reference from here to many other functions.
     */
    public void playRound(){
        Dictionary boggleDict = new Dictionary("wordlist.txt");
        allWords = new HashMap<String, ArrayList<Position>>();
        findAllWords(allWords, boggleDict, grid);
    }

    /**
     * Play the next round.
     */
    public void playRoundnext(){
        String letters = randomizeLetters(boardsize);
        grid = new BoggleGrid(boardsize);
        grid.initalizeBoard(letters);
        Dictionary boggleDict = new Dictionary("wordlist.txt");
        allWords = new HashMap<String, ArrayList<Position>>();
        findAllWords(allWords, boggleDict, grid);
        endround = false;
    }

    /**
     * Returns a String of letter.
     * One letter per grid at each position organized left to right. Each of these letters will be assigned randomly.
     *
     * @param size The size of the boggle grid.
     * @return String The randomized letters for the boggle grid.
     */
    private String randomizeLetters(int size){
        StringBuilder letters = new StringBuilder();
        Random rand = new Random();
        if (size == 4) {
            String[] dice_small_grid_copy = dice_small_grid.clone();
            for (int i = 0; i < dice_small_grid_copy.length; i++) {
                int swap = rand.nextInt(dice_small_grid_copy.length);
                String to_swap = dice_small_grid_copy[swap];
                dice_small_grid_copy[swap] = dice_small_grid_copy[i];
                dice_small_grid_copy[i] = to_swap;
            }
            for (String s : dice_small_grid_copy) {
                int chosen = rand.nextInt(6);
                char added = s.charAt(chosen);
                letters.append(added);
            }
        } else {
            String[] dice_big_grid_copy = dice_big_grid.clone();
            for (int i = 0; i < dice_big_grid_copy.length; i++) {
                int swap = rand.nextInt(dice_big_grid_copy.length);
                String to_swap = dice_big_grid_copy[swap];
                dice_big_grid_copy[swap] = dice_big_grid_copy[i];
                dice_big_grid_copy[i] = to_swap;
            }
            for (String s : dice_big_grid_copy) {
                int chosen = rand.nextInt(6);
                char added = s.charAt(chosen);
                letters.append(added);
            }
        }
        return letters.toString();
    }

    /**
     * Find all the legal words for a current boggle game.
     *
     * @param allWords All the words within the boggle grid.
     * @param boggleDict The boggle dictionary containing every single legal word.
     * @param boggleGrid The boggle grid with letters at each position.
     */
    private void findAllWords(Map<String,ArrayList<Position>> allWords, Dictionary boggleDict, BoggleGrid boggleGrid) {
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
                helperfindAllWords(rows, i,j,curr,allWords,checker, boggleDict,boggleGrid,str, arr);
            }
        }
    }

    /**
     * Helper method for finAllWords().
     * Implemented recursively.
     */
    private void helperfindAllWords(int rows, int i, int j, Position curr, Map<String,ArrayList<Position>> alWords,
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
                        helperfindAllWords(rows, row, col, new_added, alWords, checker, boggleDict, boggleGrid, str
                                , arr);
                    }
                }
            }
        }
        arr[i*rows+j] = false;
        checker.remove(curr);
    }

    /*
     * Gets words from the computer.  The computer should find words that are
     * both valid and not in the player's word list.  For each word that the computer
     * finds, update the computer's word list and increment the
     * computer's score (stored in boggleStats).
     */
    private void computerMove() {
        int steps = 1;
        if (easyMode) {
            steps = 2;
        }

        ConcreteListContainer container = new ConcreteListContainer();
        String[] words = allWords.keySet().toArray(new String[0]);

        for (RandomIterator iterator = container.iterator(words, 0, words.length - 1, steps);
             iterator.hasNext();) {
            String word = iterator.next();
            if (!gameStats.getPlayerWords().contains(word)) {
                gameStats.addWord(word, BoggleStats.Player.Computer);
            }
        }
    }

    /**
     * Change the game mode computer algorithm to easy.
     */
    public void easyGameMode() {
        easyMode = true;
    }

    public BoggleStats getStats() {
        return gameStats;
    }

    /**
     * Request a hint when the user calls it.
     *
     * @param allWords All the legal board on the boggle grid.
     * @return Stirng A valid word.
     */
    public String RequestHint(Map<String, ArrayList<Position>> allWords) {
        Strategy strat = context.returnStrategy();
        return strat.RequestHint(allWords);
    }

    /**
     * Check of many words start with a certain prefix.
     *
     * @param pre The prefix we want to check.
     * @param allWords The list containing all legal boards on the boggle grid.
     * @return int The number of words on the boggle grid starting with prefix pre.
     */
    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords) {
        Strategy strat = context.returnStrategy();
        return strat.CheckPrefix(pre, allWords);
    }

}