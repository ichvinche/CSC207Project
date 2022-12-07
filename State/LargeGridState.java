package State;

import boggle.BoggleGrid;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * This is the EndState class which implements the State interface.
 * This class represents the current state of the Boggle game after the completion of a round.
 */
public class LargeGridState implements State{
    /**
     * This is the current context for the Boggle game.
     */
    public Context context;

    /*
     * This method returns a new instance of the EndState class.
     * @return EndState a new instance of EndState.
     */
    public static LargeGridState instance(){
        return new LargeGridState();
    }

    /*
     * Changes the text size for the GUI according to user input.
     * @param size the new text size for the Boggle GUI.
     */
    public void textSize(int size){
        context.pane.getChildren().clear();
        BoggleGrid grid_check = context.game.getgrid();
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                Label Char = new Label();
                Char.setText(Character.toString(grid_check.getCharAt(row, col)));
                Char.setFont(new Font(size));
                context.pane.add(Char, col, row);
            }
        }
    }

    /*
     * Updates the current state of the game based on the current context.
     * If another round has started then update the current state.
     * Otherwise, EndState should remain the current state.
     * @param context The current context for the Boggle game.
     */
    public void Update(Context context){
        this.context = context;
    }
}
