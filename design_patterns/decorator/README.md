# Decorator Pattern

The Decorator design pattern is a structural pattern that allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class. It is one of the Gang of Four design patterns and is used to extend the functionalities of classes in a flexible and reusable way.

**Component**:

Defines the interface for objects that can have responsibilities added to them.

**ConcreteComponent**:

Implements the Component interface and defines a concrete object to which additional responsibilities can be attached.

**Decorator**:

Maintains a reference to a Component object and defines an interface that conforms to Component's interface.
Implements the core behavior of the Component, but also delegates additional responsibilities to concrete decorators.

**ConcreteDecorator**:

Adds new responsibilities to the component.
Extends the behavior of the Component by wrapping it with additional functionality.