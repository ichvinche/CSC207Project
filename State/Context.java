package State;
import boggle.BoggleGame;
import boggle.GUI;
import javafx.scene.layout.GridPane;

/**
 * This is the Context class for the state design pattern.
 */
public class Context {
    /**
     * This is the current state of the Boggle game.
     */
    public State state;
    public GUI gui;
    public BoggleGame game;
    public GridPane pane;
    /*
     * Class constructor.
     */
    public Context(GUI gui, BoggleGame game, GridPane pane){
        this.state = StartState.instance();
        this.gui = gui;
        this.game = game;
        this.pane = pane;
    }
    /*
     * This Function gets the current state of the game as a State object.
     * @return State the current state of the Boggle game.
     */
    public State getState(){
        return this.state;
    }

    /*
     * Sets the current state given a State object.
     * @param state the new state of the Boggle game.
     */
    public void setState(State state){
        this.state = state;
    }

    /*
     * Changes the current state of the game. The next state is dependent on the current state.
     */
    public void changeState(){
        state.Update(this);
    }
}