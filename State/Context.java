package State;

/**
 * This is the Context class for the state design pattern.
 */
public class Context {
    /**
     * This is the current state of the Boggle game.
     */
    private State state;
    /*
     * Class constructor.
     */
    public Context(){
        this.state = StartState.instance();
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