package boggle;

import Strategy.Context;
import Strategy.Strategy;

import java.util.*;
import randomiterator.*;

/**
 * The BoggleGame class for the first Assignment in CSC207, Fall 2022
 */
public class BoggleGame {

    /**
<<<<<<< HEAD
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

    /*
     * scanner used to interact with the user via console
     */
    public Scanner scanner;
    /**
     * stores game statistics
     */
    public static BoggleStats gameStats;

    BoggleGrid grid;

    int boardsize;

    boolean gamedone = false;

    boolean endround;

    boolean easyMode;

    public Context context;


    Map<String,ArrayList<Position>>  allWords;

    /**
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

    /**
     * dice used to randomize letter assignments for a small grid
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
     * Provide instructions to the user, so they know how to play the game.
     * @return
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
     * @param word
     */
    public void addword(String word){
        if (!gamedone && !endround && !Objects.equals(word, "") && (allWords.containsKey(word.toUpperCase())) &&
                !gameStats.getPlayerWords().contains(word.toUpperCase())){
            gameStats.addWord(word.toUpperCase(), BoggleStats.Player.Human);
        }
    }

    public void endround(){
        endround = true;
        computerMove();
        gameStats.summarizeRound();
        gameStats.endRound();
        playRoundNext();
    }

    public void EndGame() {
        gamedone = true;
        endround = true;
        gameStats.summarizeGame();
    }

    public void playGame(){
        gamedone = false;
        endround = false;
//        int boardSize;
//        while(true){
//
//            System.out.println("Enter 1 to play on a big (5x5) grid; 2 to play on a small (4x4) one:");
//            String choiceGrid = scanner.nextLine();
//
//            //get grid size preference
//            if(choiceGrid == "") break; //end game if user inputs nothing
//            while(!choiceGrid.equals("1") && !choiceGrid.equals("2")){
//                System.out.println("Please try again.");
//                System.out.println("Enter 1 to play on a big (5x5) grid; 2 to play on a small (4x4) one:");
//                choiceGrid = scanner.nextLine();
//            }
//
//            if(choiceGrid.equals("1")) boardSize = 5;
//            else boardSize = 4;

        //get letter choice preference
//            System.out.println("Enter 1 to randomly assign letters to the grid; 2 to provide your own.");
//            String choiceLetters = scanner.nextLine();
//
//            if(choiceLetters == "") break; //end game if user inputs nothing
//            while(!choiceLetters.equals("1") && !choiceLetters.equals("2")){
//                System.out.println("Please try again.");
//                System.out.println("Enter 1 to randomly assign letters to the grid; 2 to provide your own.");
//                choiceLetters = scanner.nextLine();
//            }
//
//            if(choiceLetters.equals("1")){
//        playRound();
//        while(!gamedone){
//            playRoundnext();
//            this.gameStats.summarizeRound();
//            this.gameStats.endRound();

        //round is over! So, store the statistics, and end the round.
//            this.gameStats.summarizeRound();
//            this.gameStats.endRound();
//
//            //Shall we repeat?
//            System.out.println("Play again? Type 'Y' or 'N'");
//            String choiceRepeat = scanner.nextLine().toUpperCase();

//            if(choiceRepeat == "") break; //end game if user inputs nothing
//            while(!choiceRepeat.equals("Y") && !choiceRepeat.equals("N")){
//                System.out.println("Please try again.");
//                System.out.println("Play again? Type 'Y' or 'N'");
//                choiceRepeat = scanner.nextLine().toUpperCase();
//            }

//            if(choiceRepeat == "" || choiceRepeat.equals("N")) break; //end game if user inputs nothing

    }

    //we are done with the game! So, summarize all the play that has transpired and exit.
//        this.gameStats.summarizeGame();
//        System.out.println("Thanks for playing!");


    public int getscore(){
        return this.gameStats.getScore();
    }
    public BoggleGrid getgrid(){
        return grid;
    }

    /**
     *
     */
    public void playRound(){
        //step 1. initialize the grid
        //step 2. initialize the dictionary of legal words
        Dictionary boggleDict = new Dictionary("wordlist.txt"); //you may have to change the path to the wordlist, depending on where you place it.
        //step 3. find all legal words on the board, given the dictionary and grid arrangement.
        allWords = new HashMap<String, ArrayList<Position>>();
        findAllWords(allWords, boggleDict, grid);
        //step 4. allow the user to try to find some words on the grid
//        humanMove(grid, allWords);
        //step 5. allow the computer to identify remaining words
//        computerMove(allWords);
    }

    public void playRoundNext(){
        //step 1. initialize the grid
        String letters = randomizeLetters(boardsize);
        grid = new BoggleGrid(boardsize);
        grid.initalizeBoard(letters);
        //step 2. initialize the dictionary of legal words
        Dictionary boggleDict = new Dictionary("wordlist.txt"); //you may have to change the path to the wordlist, depending on where you place it.
        //step 3. find all legal words on the board, given the dictionary and grid arrangement.
        allWords = new HashMap<String, ArrayList<Position>>();
        findAllWords(allWords, boggleDict, grid);
        endround = false;
        //step 4. allow the user to try to find some words on the grid
//        humanMove(grid, allWords);
        //step 5. allow the computer to identify remaining words
//        computerMove(allWords);
    }

    /**
     *
     * @param size
     * @return
     */
    /*private String randomizeLetters(int size){
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
    }*/

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
     * <p>
     * For each word that the computer finds, update the computer's word list and increment the computer's score which
     * is stored in boggleStats.
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

    public void easyGameMode() {
        easyMode = true;
    }

    public BoggleStats getStats() {
        return gameStats;
    }

    public String RequestHint(Map<String, ArrayList<Position>> allWords) {
        Strategy strat = context.returnStrategy();
        return strat.RequestHint(allWords);
    }

    public int CheckPrefix(String pre, Map<String, ArrayList<Position>> allWords) {
        Strategy strat = context.returnStrategy();
        return strat.CheckPrefix(pre, allWords);
    }
}