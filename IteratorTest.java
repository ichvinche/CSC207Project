import randomiterator.*;

public class IteratorTest {
    public static void main(String[] args) {
        ConcreteListContainer container = new ConcreteListContainer();
        String[] items = {"hello", "world", "nice", "good", "well"};

        for (RandomIterator iterator = container.iterator(items, 0, items.length - 1, 2); iterator.hasNext();) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}
