package design_patterns.iterator.basic;

// Iterator interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Concrete Iterator
class ConcreteIterator implements Iterator {
    private Object[] elements;
    private int position = 0;

    public ConcreteIterator(Object[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return position < elements.length;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return elements[position++];
        }
        return null;
    }
}

// Aggregate interface
interface Aggregate {
    Iterator createIterator();
}

// Concrete Aggregate
class ConcreteAggregate implements Aggregate {
    private Object[] elements;

    public ConcreteAggregate(Object[] elements) {
        this.elements = elements;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(elements);
    }
}

// Client code
public class BasicIteratorClient {
    public static void main(String[] args) {
        Object[] elements = { "Element1", "Element2", "Element3" };
        Aggregate aggregate = new ConcreteAggregate(elements);
        Iterator iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
