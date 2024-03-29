package State;
import javafx.scene.text.Font;

/**
 * This is the StartState class which implements the State interface.
 * This class represents the current state of the Boggle game before the first round begins.
 */
public class StartState implements State {
    /**
     * This is the current stateContext for the Boggle game.
     */
    public StateContext stateContext;

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
        stateContext.gui.SettingsButton.setFont(new Font(size));
        stateContext.gui.helpButton.setFont(new Font(size));
        stateContext.gui.size4Button.setFont(new Font(size));
        stateContext.gui.size5Button.setFont(new Font(size));
    }

    /*
     * Updates the current state of the game based on the current stateContext.
     * If the first round has started then update the current state.
     * Otherwise, StartState should remain the current state.
     * @param stateContext The current stateContext for the Boggle game.
     */
    public void Update(StateContext stateContext){
        this.stateContext = stateContext;
    }
}