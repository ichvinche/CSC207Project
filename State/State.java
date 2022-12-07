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
     * Updates the current state of the game based on the current stateContext.
     * @param stateContext The current stateContext for the Boggle game.
     */
    void Update(StateContext stateContext);

}
