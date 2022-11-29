package State;

/**
 * This is the State Interface.
 * Classes StartState, EndState, and PauseState will implement this interface.
 */
public interface State {
    /*
     * Changes the text size for the GUI according to user input.
     * @param size the new text size for the Boggle GUI.
     */
    void textSize(int size);
    /*
     * Changes the Colour theme of the Boggle GUI according to user input.
     */
    void changeColour();
    /*
     * Updates the current state of the game based on the current context.
     * @param context The current context for the Boggle game.
     */
    void Update(Context context);
}
