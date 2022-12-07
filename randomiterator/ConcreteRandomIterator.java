package randomiterator;

/**
 * ConcreteIterator class that implements Iterator interface.
 */
public class ConcreteRandomIterator implements RandomIterator {

    /**
     * A string array we will iterate through.
     */
    String[] collection;
    /**
     * The first index we start the iteration at.
     */
    int start;
    /**
     * The last index from the collection of items object.
     */
    int end;
    /**
     * The interval we are iterating through the collection.
     */
    int steps;

    /**
     * Constructor.
     *
     * @param sCollection The string array of item we are iterating through.
     * @param iStart The starting index of the iteration.
     * @param nSteps The interval we are iterating through.
     */
    public ConcreteRandomIterator(String[] sCollection, int iStart, int iEnd, int nSteps) {
        collection = sCollection;
        start = iStart;
        steps = nSteps;
        end = iEnd;
    }

    /**
     * Implements the hasNext() method by checking whether the collection has a next item or not.
     *
     * @return True or False depending on whether the collection has a next object.
     */
    @Override
    public boolean hasNext() {
        return start <= end;
    }

    /**
     * Iterates to the next item of the collection.
     *
     * @return Returns the value of the object we just iterated to.
     */
    @Override
    public String next() {
        if (hasNext()) {
            String object = collection[start];
            start += steps;
            return object;
        }
        return null;
    }
}
