package randomiterator;

/**
 * Iterable interface.
 */
public interface ListContainer {

    /**
     * Returns an instance of the iterator class.
     *
     * @param collection The string array of items we want to iterate through.
     * @param start The index we are starting at when we iterate through the collection of objects.
     * @param end The last index of the object we are iterating.
     * @param steps The interval we are iterating the collection through.
     * @return A RandomIterator.
     */
    RandomIterator iterator(String[] collection, int start, int end, int steps);
}
