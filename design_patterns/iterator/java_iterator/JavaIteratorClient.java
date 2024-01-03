package design_patterns.iterator.java_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Client code
public class JavaIteratorClient {
    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        elements.add("Element1");
        elements.add("Element2");
        elements.add("Element3");

        Iterator<String> iterator = elements.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
