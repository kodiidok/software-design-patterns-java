# Factory Pattern

The Factory Design Pattern provides an interface for creating objects but allows subclasses to alter the type of objects that will be created. There are several variations of the Factory pattern, each addressing different aspects of object creation. Here are the main methods to create the Factory Design Pattern:

**Simple Factory:**

In this method, a single factory class is responsible for creating objects based on a provided parameter. It encapsulates the object creation logic and simplifies the process for the client.

**Factory Method:**

Also known as the Virtual Constructor pattern, this method involves defining an interface for creating an object but letting subclasses alter the type of objects that will be created. It defines an interface for creating an object but leaves the choice of its type to the subclasses, creating an instance of a class.

**Abstract Factory:**

The Abstract Factory method provides an interface for creating families of related or dependent objects without specifying their concrete classes. It involves multiple factory methods, each responsible for creating a different type of object, and the factories are organized into families.

**Static Factory Method:**

This is a variant of the Factory Method pattern where the factory method is static, often located within the same class as the class it constructs. Clients call the static method to create an instance of the class, providing a more concise syntax.

**Parameterized Factory Method:**

In this approach, the factory method takes parameters that determine the type of object to be created. The parameters influence the creation logic, allowing for more dynamic and flexible object creation.

**Generic Factory:**

Some programming languages, like Java with generics, allow the creation of a generic factory that can create objects of various types. This enhances type safety and reusability.

**DI (Dependency Injection) Container:**

Dependency Injection containers can be considered a form of factory where the responsibility for creating and managing object instances is delegated to a container. The container injects dependencies into the objects, often based on configuration.

**Service Locator:**

The Service Locator pattern involves a central registry known as the "service locator" that maintains references to various services. Clients can request services from the locator, and the locator is responsible for creating and managing instances.

**Inner Factory Class:**

In some cases, a class may have an inner factory class responsible for creating instances of the outer class. This provides encapsulation and control over the instantiation process.

**Multiton Pattern:**

The Multiton pattern is a variation of the Singleton pattern where a factory is used to manage a map of named instances, each identified by a unique key. Clients request instances based on keys, and the factory creates or returns the existing instance associated with that key.