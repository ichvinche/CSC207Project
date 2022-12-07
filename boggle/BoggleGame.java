package boggle;

import java.util.*;


/**
 * The BoggleGame class for the first Assignment in CSC207, Fall 2022
 */
public class BoggleGame {

    /**
     * scanner used to interact with the user via console
     */
    public Scanner scanner;
    /**
     * stores game statistics
     */
    private BoggleStats gameStats;

    BoggleGrid grid;

    int boardsize;

    boolean gamedone = false;

    boolean endround;


    Map<String,ArrayList<Position>>  allWords;




    /**
     * dice used to randomize letter assignments for a small grid
     */
    private final String[] dice_small_grid= //dice specifications, for small and large grids
            {"AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS", "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                    "DISTTY", "EEGHNW", "EEINSU", "EHRTVW", "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ"};
    /**
     * dice used to randomize letter assignments for a big grid
     */
    private final String[] dice_big_grid =
            {"AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM", "AEEGMU", "AEGMNN", "AFIRSY",
                    "BJKQXZ", "CCNSTW", "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DDHNOT", "DHHLOR",
                    "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU", "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"};

    /*
     * BoggleGame constructor
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
        this.gameStats = new BoggleStats();
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
                
                
                """);
    }


    /*
     * Gets information from the user to initialize a new Boggle game.
     * It will loop until the user indicates they are done playing.
     */
    public void addword(String word){
        if (!gamedone && !endround && !Objects.equals(word, "") && (allWords.containsKey(word.toUpperCase())) &&
                !this.gameStats.getPlayerWords().contains(word.toUpperCase())){
            this.gameStats.addWord(word.toUpperCase(), BoggleStats.Player.Human);
        }
    }
    public void endround(){
        endround = true;
        computerMove();
        gameStats.summarizeRound();
        gameStats.endRound();
        playRoundnext();
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
    /*
     * Play a round of Boggle.
     * This initializes the main objects: the board, the dictionary, the map of all
     * words on the board, and the set of words found by the user. These objects are
     * passed by reference from here to many other functions.
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

    public void playRoundnext(){
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

    /*
     * This method should return a String of letters (length 16 or 25 depending on the size of the grid).
     * There will be one letter per grid position, and they will be organized left to right,
     * top to bottom. A strategy to make this string of letters is as follows:
     * -- Assign a one of the dice to each grid position (i.e. dice_big_grid or dice_small_grid)
     * -- "Shuffle" the positions of the dice to randomize the grid positions they are assigned to
     * -- Randomly select one of the letters on the given die at each grid position to determine
     *    the letter at the given position
     *
     * @return String a String of random letters (length 16 or 25 depending on the size of the grid)
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


    /*
     * This should be a recursive function that finds all valid words on the boggle board.
     * Every word should be valid (i.e. in the boggleDict) and of length 4 or more.
     * Words that are found should be entered into the allWords HashMap.  This HashMap
     * will be consulted as we play the game.
     *
     * Note that this function will be a recursive function.  You may want to write
     * a wrapper for your recursion. Note that every legal word on the Boggle grid will correspond to
     * a list of grid positions on the board, and that the Position class can be used to represent these
     * positions. The strategy you will likely want to use when you write your recursion is as follows:
     * -- At every Position on the grid:
     * ---- add the Position of that point to a list of stored positions
     * ---- if your list of stored positions is >= 4, add the corresponding word to the allWords Map
     * ---- recursively search for valid, adjacent grid Positions to add to your list of stored positions.
     * ---- Note that a valid Position to add to your list will be one that is either horizontal, diagonal, or
     *      vertically touching the current Position
     * ---- Note also that a valid Position to add to your list will be one that, in conjunction with those
     *      Positions that precede it, form a legal PREFIX to a word in the Dictionary (this is important!)
     * ---- Use the "isPrefix" method in the Dictionary class to help you out here!!
     * ---- Positions that already exist in your list of stored positions will also be invalid.
     * ---- You'll be finished when you have checked EVERY possible list of Positions on the board, to see
     *      if they can be used to form a valid word in the dictionary.
     * ---- Food for thought: If there are N Positions on the grid, how many possible lists of positions
     *      might we need to evaluate?
     *
     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
     * @param boggleDict A dictionary of legal words
     * @param boggleGrid A boggle grid, with a letter at each position on the grid
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

    private void helperfindAllWords(int rows, int i, int j, Position curr, Map<String,ArrayList<Position>> alWords, ArrayList<Position> checker,
                                    Dictionary boggleDict, BoggleGrid boggleGrid, String str, boolean[] arr) {
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
     * Gets words from the user.  As words are input, check to see that they are valid.
     * If yes, add the word to the player's word list (in boggleStats) and increment
     * the player's score (in boggleStats).
     * End the turn once the user hits return (with no word).
     *
     * @param board The boggle board
     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
     */
    //FIX This
//    private void humanMove(BoggleGrid board, Map<String,ArrayList<Position>> allWords){
//        endround = false;
//        while(!endround) {
////            System.out.println(board);
//            if (!Objects.equals(Userword, "") && (allWords.containsKey(Userword.toUpperCase())) &&
//                    !this.gameStats.getPlayerWords().contains(Userword.toUpperCase())){
//                this.gameStats.addWord(Userword.toUpperCase(), BoggleStats.Player.Human);
//                Userword = "";
//            }
////            else if (Userword.equals("")) {
////                break;
////            }
//            //You write code here!
//            //step 1. Print the board for the user, so they can scan it for words
//            //step 2. Get a input (a word) from the user via the console
//            //step 3. Check to see if it is valid (note validity checks should be case-insensitive)
//            //step 4. If it's valid, update the player's word list and score (stored in boggleStats)
//            //step 5. Repeat step 1 - 4
//            //step 6. End when the player hits return (with no word choice).
//        }
//    }


    /*
     * Gets words from the computer.  The computer should find words that are
     * both valid and not in the player's word list.  For each word that the computer
     * finds, update the computer's word list and increment the
     * computer's score (stored in boggleStats).
     *
     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
     */
    private void computerMove(){
        Set<String> t = allWords.keySet();
        for (String i: t){
            if (!this.gameStats.getPlayerWords().contains(i.toUpperCase())){
                this.gameStats.addWord(i.toUpperCase(), BoggleStats.Player.Computer);
            }
        }
    }
    public BoggleStats getStats() {
        return this.gameStats;
    }

}
