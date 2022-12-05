package boggle;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * The BoggleStats class for Phase 2 of CSC207 Group Project, Fall 2022.
 * This class will contain all the related statistics related to when a player plays the game.
 */
public class BoggleStats {
    /**
     * set of words the player finds in a given round.
     */
    private Set<String> playerWords = new HashSet<String>();

    /**
     * set of words the computer finds in a given round.
     */
    private Set<String> computerWords = new HashSet<String>();

    /**
     * the player's score for the current round.
     */
    private int pScore;

    /**
     * the computer's score for the current round.
     */
    private int cScore;

    /**
     * the player's total score across every round.
     */
    private int pScoreTotal;

    /**
     * the computer's total score across every round.
     */
    private int cScoreTotal;

    /**
     * the average number of words, per round, found by the player.
     */
    private double pAverageWords;

    /**
     * the average number of words, per round, found by the computer.
     */
    private double cAverageWords;

    /**
     * the current round being played.
     */
    private int round;

    /**
     * enumarable types of players which are either human or computer.
     */
    public enum Player {
        Human("Human"),
        Computer("Computer");
        private final String player;

        Player(final String player) {
            this.player = player;
        }
    }

    /**
     * BoggleStats constructor.
     */
    public BoggleStats() {
        round = 0;
        pScore = 0;
        cScore = 0;
        pScoreTotal = 0;
        cScoreTotal = 0;
        pAverageWords = 0;
        cAverageWords = 0;
        playerWords = new HashSet<String>();
        computerWords = new HashSet<String>();
    }

    /**
     * Add a word found a by a given player to their words list for the current round.
     * Increment the player's score as the words are added to the list.
     *
     * @param word The word the player has guessed which is to be added to the list.
     * @param player The player type who guessed the word and whose score will be changed.
     */
    public void addWord(String word, Player player) {
        if (Objects.equals(player.player, "Human")) {
            playerWords.add(word.toUpperCase());
            pScore += word.length() + 4 - 1;
        } else if (Objects.equals(player.player, "Computer")) {
            computerWords.add(word);
            cScore += word.length() - 4 + 1;
        }
    }

    /**
     * End the current round.
     * Should clear the words list of the human and computer. Additionally, the function will update the scores of the
     * human or computer accordingly.
     *
     * Lastly, the round counter should be incremented by 1.
     */
    public void endRound() {
        playerWords.clear();
        computerWords.clear();
        pScoreTotal += pScore;
        cScoreTotal += cScore;
        pScore = 0;
        cScore = 0;
        round++;
    }

    /**
     *
     *
     * @return int The words list for the human player.
     */
    public Set<String> getPlayerWords() {
        return playerWords;
    }

    /**
     * The current round of the game.
     *
     * @return int The total number of rounds played.
     */
    public int getRound() {
        return round;
    }

    /**
     * The score of the player.
     *
     * @return int The score of the human player.
     */
    public int getScore() {
        return pScore;
    }
}