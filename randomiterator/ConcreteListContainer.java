package randomiterator;

/**
 * ConcreteIterable class that implements Iterable interface.
 */
public class ConcreteListContainer implements ListContainer {

    /**
     * Returns an instance of the ConcreteIterator class.
     *
     * @param collection The object we want to iterate.
     * @param start The starting index of the object iteration.
     * @param end The last index of the object we are iterating through.
     * @param steps The interval we are iterating through.
     * @return A RandomIterator.
     */
    @Override
    public RandomIterator iterator(String[] collection, int start, int end, int steps) {
        return new ConcreteRandomIterator(collection, start, end, steps);
    }
}
