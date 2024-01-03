package design_patterns.iterator.iterable;

import java.util.Iterator;

// Iterable interface
interface MyIterable<T> {
    MyIterator<T> iterator();
}

// Iterator interface
interface MyIterator<T> {
    boolean hasNext();
    T next();
}

// Concrete Iterator
class MyConcreteIterator<T> implements MyIterator<T> {
    private T[] elements;
    private int position = 0;

    public MyConcreteIterator(T[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return position < elements.length;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return elements[position++];
        }
        return null;
    }
}

// Concrete Aggregate
class MyConcreteAggregate<T> implements MyIterable<T> {
    private T[] elements;

    public MyConcreteAggregate(T[] elements) {
        this.elements = elements;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyConcreteIterator<>(elements);
    }
}

// Client code
public class IterableIteratorClient {
    public static void main(String[] args) {
        String[] elements = { "Element1", "Element2", "Element3" };
        MyIterable<String> myAggregate = new MyConcreteAggregate<>(elements);
        MyIterator<String> myIterator = myAggregate.iterator();

        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
    }
}
