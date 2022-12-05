package boggle;

/**
 * The BoggleGrid class for Phase 2 of CSC207 Group Project, Fall 2022.
 * The BoggleGrid represents the grid on which the game boggle is played.
 */
public class BoggleGrid {
    /**
     * size of the grid
     */
    private int size;

    /**
     * characters to be assigned to the grid.
     */
    private char[][] board;

    /**
     * BoggleGrid constructor.
     *
     * @param size The size of the BoggleGrid we want to initialize.
     */
    public BoggleGrid(int size) {
        this.size = size;
        board = new char[size][size];
    }

    /**
     * Assign a letter in the string of letters to each grid position.
     * Letters are assigned from left to right.
     *
     * @param letters A string of letters, one for each letter.
     */
    public void intializeBoard(String letters) {
        int bound = letters.length();
        int currIndex = 0;
        char filler = " ".charAt(0);

        for (int i = 0; i < numRows(); i++) {
            for (int j = 0; j < numCols(); j++) {
                if (currIndex >= bound) {
                    board[i][j] = filler;
                } else {
                    board[i][j] = letters.charAt(currIndex);
                }
                currIndex++;
            }
        }
    }

    /**
     * @return int The number of rows that are on the board.
     */
    public int numRows() {
        return size;
    }

    /**
     * @return int The number of columns that are on the board.
     */
    public int numCols() {
        return size;
    }

    /**
     * The specific char for a pair of (row, col).
     *
     * @param row the row value of the char.
     * @param col the col value of the char.
     * @return char the character at a given grid position.
     */
    public char getCharAt(int row, int col) {
        return board[row][col];
    }
}