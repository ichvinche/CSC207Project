import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

import boggle.*;
import boggle.Dictionary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoggleTests {

    //BoggleGame  Test
    @Test
    void findAllWords_small() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BoggleGame game = new BoggleGame();
        Method method = game.getClass().getDeclaredMethod("findAllWords", Map.class, Dictionary.class, BoggleGrid.class);
        method.setAccessible(true);

        Dictionary boggleDict = new Dictionary("wordlist.txt");
        Map<String, ArrayList<Position>> allWords = new HashMap<>();
        BoggleGrid grid = new BoggleGrid(4);
        grid.initalizeBoard("RHLDNHTGIPHSNMJO");
        Object r = method.invoke(game, allWords, boggleDict, grid);

        Set<String> expected = new HashSet<>(Arrays.asList("GHOST", "HOST", "THIN"));
        assertEquals(expected, allWords.keySet());
    }

    //Dictionary Test
    @Test
    void containsWord() {
        Dictionary dict = new Dictionary("./wordlist.txt");
        assertTrue(dict.containsWord("ENZYME"));
        assertTrue(dict.isPrefix("pench"));
    }

    //BoggleGrid Test
    @Test
    void setupBoard() {
        BoggleGrid grid = new BoggleGrid(10);
        String letters = "";
        for (int i = 0; i < 10; i++) {
            letters = letters + "0123456789";
        }

        grid.initalizeBoard(letters);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(letters.charAt(i*10+j), grid.getCharAt(i, j));
            }
        }
    }

    //BoggleStats Test
    @Test
    void endRoundTest() {
        BoggleStats stats = new BoggleStats();
        stats.endRound();
        stats.endRound();
        stats.endRound();
        assertEquals(3, stats.getRound());
    }


    @Test
    void gridTest() {
        BoggleGrid grid = new BoggleGrid(4);
        String letters = "ABCDEFGHIJKLMNOP";
        grid.initalizeBoard(letters);

        for (int i = 0; i < grid.numRows(); i++) {
            for (int j = 0; j < grid.numCols(); j++) {
                System.out.printf(grid.getCharAt(i, j) + "");
            }
            System.out.println();
        }
    }

    @Test
    void positionsTest() {
        Position pos = new Position(1, 2);
        ArrayList<Position> arrayPos = new ArrayList<Position>();

        arrayPos.add(new Position(2,3));
        arrayPos.add(new Position(1,2));
        arrayPos.add(new Position(4,4));
        arrayPos.add(new Position(3,4));


        for (Position p: arrayPos) {
            System.out.println(p.getRow(0) + " " + p.getCol(0));
        }
    }
}
