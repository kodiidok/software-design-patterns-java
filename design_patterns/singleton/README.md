# Singleton Pattern
[ Creational Design Patterns ]

**Single Instance**

The Singleton pattern ensures that a class has only one instance, and it provides a mechanism to access that instance from any point in the application.

**Global Access**

The Singleton instance is typically accessible globally, allowing any part of the application to use it without the need to create multiple instances.

**Lazy Initialization**

The Singleton instance is often lazily initialized, meaning that it is created when it is first requested rather than at the time of class loading.

**Private Constructor**

The Singleton class usually has a private constructor to prevent external instantiation of the class. The only way to obtain an instance is through a static method.

**Thread Safety**

Implementations may include mechanisms to ensure thread safety, especially in multi-threaded environments, to prevent the creation of multiple instances concurrently.