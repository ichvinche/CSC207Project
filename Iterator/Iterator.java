package Iterator;

/**
 * Iterator interface.
 */
public interface Iterator {
    /**
     * Checks if a collection of items has a next object.
     *
     * @return True or False depending on whether the collection has a next object.
     */
    public boolean hasNext();

    /**
     * Iterating to the next time of the collection.
     *
     * @return Returns the type of Object that elements of collection subscribe to.
     */
    public Object next();
}
