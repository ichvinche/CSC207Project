package randomiterator;

/**
 * Iterator interface.
 */
public interface RandomIterator {
    /**
     * @return True or False depending on whether the collection has a next object.
     */
    boolean hasNext();

    /**
     * @return Returns the type of Object that elements of collection subscribe to; i.e. String.
     */
    String next();
}
