package Iterator;

/**
 * ConcreteIterable class that implements Iterable interface.
 */
public class ConcreteIterable implements Iterable {

    /**
     * Returns an instance of the ConcreteIterator class.
     *
     * @param collection The object we want to iterate.
     * @param start The starting index of the object iteration.
     * @param end The last index of the object we are iterating through.
     * @param steps The interval we are iterating through.
     * @return A ConcreteIterator.
     */
    @Override
    public Iterator iterator(String[] collection, int start, int end, int steps) {
        return new ConcreteIterator(collection, start, end, steps);
    }
}
