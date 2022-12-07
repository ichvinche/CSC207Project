package State;

import boggle.BoggleGrid;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * This is the PauseState class which implements the State interface.
 * This class represents the current state of the Boggle game in the middle of a round.
 */
public class SmallGridState implements State{
    /**
     * This is the current stateContext for the Boggle game.
     */
    public StateContext stateContext;

    /*
     * This method returns a new instance of the PauseState class.
     * @return PauseState a new instance of PauseState.
     */
    public static SmallGridState instance(){
        return new SmallGridState();
    }

    /*
     * Changes the text size for the GUI according to user input.
     * @param size the new text size for the Boggle GUI.
     */
    public void textSize(int size) {
        stateContext.pane.getChildren().clear();
        BoggleGrid grid_check = stateContext.game.getgrid();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Label Char = new Label();
                Char.setText(Character.toString(grid_check.getCharAt(row, col)));
                Char.setFont(new Font(size));
                stateContext.pane.add(Char, col, row);
            }
        }
    }

    /*
     * Updates the current state of the game based on the current stateContext.
     * If a round has ended then update the current state.
     * Otherwise, PauseState should remain the current state.
     * @param stateContext The current stateContext for the Boggle game.
     */
    public void Update(StateContext stateContext){
        this.stateContext = stateContext;
    }
}
