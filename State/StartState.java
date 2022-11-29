package State;

/**
 * This is the StartState class which implements the State interface.
 * This class represents the current state of the Boggle game before the first round begins.
 */
public class StartState implements State {
    /**
     * This is the current context for the Boggle game.
     */
    private Context context;

    /*
     * This method returns a new instance of the StartState class.
     * @return StartState a new instance of StartState.
     */
    public static StartState instance(){
        return new StartState();
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
     * Changes the Colour theme of the Boggle GUI according to user input from a selection of different colour themes.
     */
    public void changeColour(){
        // Get a user input
        // If user input is invalid, System.out.println("Input is invalid")
        // else change colour theme based on user input.
    }

    /*
     * Updates the current state of the game based on the current context.
     * If the first round has started then update the current state.
     * Otherwise, StartState should remain the current state.
     * @param context The current context for the Boggle game.
     */
    public void Update(Context context){
    }

}