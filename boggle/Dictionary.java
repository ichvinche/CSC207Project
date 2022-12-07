package boggle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
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
        String line = "";
        int wordcount = 0;
        this.legalWords = new TreeSet<String>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null)
            {
                if (line.strip().length() > 0) {
                    legalWords.add(line.strip());
                    wordcount++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Initialized " + wordcount + " words in the Dictionary.");
    }

    /**
     * Checks to see if a provided word belongs in the dictionary.
     *
     * @param word The word that we want to check.
     * @return boolean Indicates whether the word is in the dictionary or not.
     */
    public boolean containsWord(String word) {
        String lowerCaseWord = word.toLowerCase();
        for (String s: this.legalWords) {
            if (Objects.equals(s, lowerCaseWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if a provided word is a prefix of any word in the dictionary.
     *
     * @param str The string that we want to check.
     * @return boolean Indicates whether the string is a prefix or not
     */
    public boolean isPrefix(String str) {
        String lowerCaseString = str.toLowerCase();
        for (String s: this.legalWords) {
            if (s.startsWith(lowerCaseString)) {
                return true;
            }
        }
        return false;
    }
}
