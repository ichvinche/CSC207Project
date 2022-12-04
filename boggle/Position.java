package boggle;

/**
 * Position class for Phase 2 of CSC207 Group Project, Fall 2022.
 */
public class Position {
    /**
     * the row value of the position.
     */
    private int row;

    /**
     * the column value of the position.
     */
    private int col;

    /**
     * Position constructor.
     *
     * @param row The row value of the position.
     * @param col The col value of the position.
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Set the row value.
     *
     * @param row the int value of the row we want to set.
     */
    public void setRow(int row) { this.row = row; }

    /**
     * Set the column value.
     *
     * @param col the int value of the column we want to set.
     */
    public void setCol(int col) { this.col = col; }

    /**
     * Get the row for a current position.
     *
     * @return int the row value of the position.
     */
    public int getRow() { return this.row; }

    /**
     * Get the col for a current position.
     *
     * @return int the column value of the position.
     */
    public int getCol() { return this.col; }
}
