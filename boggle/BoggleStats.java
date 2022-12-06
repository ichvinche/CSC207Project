package boggle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The BoggleStats class for the first Assignment in CSC207, Fall 2022
 * The BoggleStats will contain statsitics related to game play Boggle
 */
public class BoggleStats {

    /**
     * set of words the player finds in a given round
     */
    private Set<String> playerWords = new HashSet<String>();
    /**
     * set of words the computer finds in a given round
     */
    private Set<String> computerWords = new HashSet<String>();
    /**
     * the player's score for the current round
     */
    private int pScore;
    /**
     * the computer's score for the current round
     */
    private int cScore;
    /**
     * the player's total score across every round
     */
    private int pScoreTotal;
    /**
     * the computer's total score across every round
     */
    private int cScoreTotal;
    /**
     * the average number of words, per round, found by the player
     */
    private double pAverageWords;
    /**
     * the average number of words, per round, found by the computer
     */
    private double cAverageWords;
    /**
     * the current round being played
     */
    private int round;

    /**
     * enumarable types of players (human or computer)
     */
    public enum Player {
        Human("Human"),
        Computer("Computer");
        private final String player;
        Player(final String player) {
            this.player = player;
        }
    }

    /* BoggleStats constructor
     * ----------------------
     * Sets round, totals and averages to 0.
     * Initializes word lists (which are sets) for computer and human players.
     */
    public BoggleStats() {
        this.round = 0;
        this.pScoreTotal = 0;
        this.cScoreTotal = 0;
        this.cAverageWords = 0.0;
        this.pAverageWords = 0.0;
        this.cScore = 0;
        this.pScore = 0;
        this.playerWords = new HashSet<>();
        this.computerWords = new HashSet<>();
    }

    /*
     * Add a word to a given player's word list for the current round.
     * You will also want to increment the player's score, as words are added.
     *
     * @param word     The word to be added to the list
     * @param player  The player to whom the word was awarded
     */
    public void addWord(String word, Player player) {
        if (Objects.equals(player.player, "Human")){
            this.playerWords.add(word);
            this.pScore += word.length() - 3;
        }
        this.computerWords.add(word);
        this.cScore += word.length() - 3;
    }

    /*
     * End a given round.
     * This will clear out the human and computer word lists, so we can begin again.
     * The function will also update each player's total scores, average scores, and
     * reset the current scores for each player to zero.
     * Finally, increment the current round number by 1.
     */
    public void endRound() {
        this.computerWords.clear();
        this.playerWords.clear();
        this.pScoreTotal += this.pScore;
        this.cScoreTotal += this.cScore;
        this.pScore = 0;
        this.cScore = 0;
        double r = getRound();
        this.cAverageWords = this.cScoreTotal/r;
        this.pAverageWords = this.pScoreTotal/r;
        this.round += 1;
    }

    /*
     * Summarize one round of boggle.  Print out:
     * The words each player found this round.
     * Each number of words each player found this round.
     * Each player's score this round.
     */
    public void summarizeRound() {
        System.out.println("Round " + this.round + " stats:");
        System.out.println( "Player found " + this.playerWords.size() + " words:");
        Object[] Parr = getPlayerWords().toArray();
        for (Object o : Parr) {
            System.out.println(o);
        }
        System.out.println( "Player Score:" + this.pScore);
        System.out.println( "Computer found " + this.computerWords.size() + " words:" );
        Object[] Carr = this.computerWords.toArray();
        for (Object o : Carr) {
            System.out.println(o);
        }
        System.out.println( "Computer Score:" + this.cScore);
    }

    /*
     * Summarize the entire boggle game.  Print out:
     * The total number of rounds played.
     * The total score for either player.
     * The average number of words found by each player per round.
     */
    public void summarizeGame() {
        System.out.println("Total number of rounds played:" + this.round);
        System.out.println("Total score for player:" + this.pScoreTotal);
        System.out.println("Total score for computer:" + this.cScoreTotal);
        System.out.println("Average number of words found by player per round:" + this.pAverageWords);
        System.out.println("Average number of words found by computer per round:" + this.cAverageWords);
    }

    /*
     * @return Set<String> The player's word list
     */
    public Set<String> getPlayerWords() {
        return this.playerWords;
    }

    /*
     * @return int The number of rounds played
     */
    public int getRound() { return this.round; }

    /*
     * @return int The current player score
     */
    public int getScore() {
        return this.pScore;
    }

}