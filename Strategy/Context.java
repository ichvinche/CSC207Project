package Strategy;
import java.util.*;

/**
 * The Context class for Phase 2 of the CSC207 Group Project.
 */
public class Context {
    /**
     * Stores the game Difficulty.
     */
    private Strategy difficulty;

    /**
     * The Context constructor.
     */
    public Context(Strategy strategy){
        this.difficulty = strategy;
    }

    /**
     * Return the strategy used by this context.
     */
    public Strategy returnStrategy(){
        return this.difficulty;
    }
}