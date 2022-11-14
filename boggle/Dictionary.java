package boggle;

import java.util.TreeSet;

/**
 * The Dictionary class for Phase 2 of CSC207 Group Project, Fall 2022.
 */
public class Dictionary {
    /**
     * set of legal words for Boggle.
     */
    private TreeSet<String> legalWords;

    /**
     * Dictionary constructor.
     *
     * @param filename The file containing a list of all the legal words.
     */
    public Dictionary(String filename) {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks to see if a provided word belongs in the dictionary.
     *
     * @param word The word that we want to check.
     * @return boolean Indicates whether the word is in the dictionary or not.
     */
    public boolean containsWord(String word) {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks to see if a provided word is a prefix of any word in the dictionary.
     *
     * @param str The string that we want to check.
     * @return boolean Indicates whether the string is a prefix or not
     */
    public boolean isPrefix(String str) {
        throw new UnsupportedOperationException();
    }
}
