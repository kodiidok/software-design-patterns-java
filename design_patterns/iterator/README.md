# Iterator Pattern

The Iterator design pattern is a behavioral pattern that provides a way to access elements of a collection sequentially without exposing its underlying representation. It involves defining an interface for creating iterators and implementing it in concrete classes.

**Iterator:**
- The Iterator interface declares methods for traversing elements in a collection.
- It typically includes methods like `hasNext` to check for the next element and `next` to retrieve the next element.

**Concrete Iterator:**
- The Concrete Iterator implements the Iterator interface.
- It keeps track of the current position in the collection and provides methods to traverse elements.

**Aggregate:**
- The Aggregate interface declares a method to create an Iterator.
- It represents the collection of elements.

**Concrete Aggregate:**
- The Concrete Aggregate implements the Aggregate interface.
- It provides a method to create a Concrete Iterator for the collection.

### Usage:

**Client Code:**
- The client interacts with the Iterator to traverse elements without exposing the underlying collection details.
- The client can use different iterators for the same collection.

### When to Use the Iterator Pattern:

- When you want to provide a consistent way to traverse different types of collections.
- When you want to decouple the client code from the internal structure of the collection.
- When you need to support multiple traversals of a collection.

### Benefits:

- Simplifies the client code by providing a common interface for traversing collections.
- Decouples the client from the details of the collection's implementation.
- Supports multiple types of iterators for the same collection.

### Considerations:

- Be cautious about the performance impact, especially for large collections.
- Ensure that the collection maintains consistency during traversal.

The Iterator pattern is particularly useful when dealing with various types of collections, providing a standard way to traverse elements without exposing the complexities of the underlying structure.
