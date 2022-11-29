package State;

/**
 * This is the EndState class which implements the State interface.
 * This class represents the current state of the Boggle game after the completion of a round.
 */
public class EndState {
    /**
     * This is the current context for the Boggle game.
     */
    private Context context;

    /*
     * This method returns a new instance of the EndState class.
     * @return EndState a new instance of EndState.
     */
    public static EndState instance(){
        return new EndState();
    }

    /*
     * Changes the text size for the GUI according to user input.
     * @param size the new text size for the Boggle GUI.
     */
    public void textSize(int size){
        // If text size is too large or small, System.out.println("Text size outside of boundaries.")
        // else set text size of GUI to @param size.
    }

    /*
     * Changes the Colour theme of the Boggle GUI according to user input.
     */
    public void changeColour(){
        // Get a user input
        // If user input is invalid, System.out.println("Input is invalid")
        // else change colour theme based on user input.
    }

    /*
     * Updates the current state of the game based on the current context.
     * If another round has started then update the current state.
     * Otherwise, EndState should remain the current state.
     * @param context The current context for the Boggle game.
     */
    public void Update(Context context){
    }
}
