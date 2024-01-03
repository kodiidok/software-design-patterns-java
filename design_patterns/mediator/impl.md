# implementations

In a chat application, multiple users (colleagues) want to communicate with each other without having direct references to each other. A mediator facilitates communication between users, ensuring loose coupling and easy scalability.

## Simple Interface Approach

```java
// Mediator Interface
interface ChatMediator {
    void sendMessage(User user, String message);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {
    @Override
    public void sendMessage(User user, String message) {
        System.out.println(user.getName() + " sends message: " + message);
    }
}

// Colleague (User) Interface
class User {
    private String name;
    private ChatMediator chatMediator;

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chatMediator.sendMessage(this, message);
    }
}

// Client Code
public class ChatApplication {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatRoom();

        User user1 = new User("Alice", chatMediator);
        User user2 = new User("Bob", chatMediator);
        User user3 = new User("Charlie", chatMediator);

        chatMediator.sendMessage(user1, "Hello, everyone!");

        user2.sendMessage("Hi, Alice!");
        user3.sendMessage("Hey, Bob!");
    }
}
```

## Abstract Mediator Approach

```java
// Abstract Mediator
interface ChatMediator {
    void sendMessage(User user, String message);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {
    private User colleague1;
    private User colleague2;
    private User colleague3;

    public void setColleagues(User colleague1, User colleague2, User colleague3) {
        this.colleague1 = colleague1;
        this.colleague2 = colleague2;
        this.colleague3 = colleague3;
    }

    @Override
    public void sendMessage(User user, String message) {
        if (user == colleague1) {
            colleague2.receiveMessage(message);
            colleague3.receiveMessage(message);
        } else if (user == colleague2) {
            colleague1.receiveMessage(message);
            colleague3.receiveMessage(message);
        } else if (user == colleague3) {
            colleague1.receiveMessage(message);
            colleague2.receiveMessage(message);
        }
    }
}

// Colleague (User) Interface
class User {
    private String name;
    private ChatMediator chatMediator;

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chatMediator.sendMessage(this, message);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Client Code
public class ChatApplication {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatRoom();

        User user1 = new User("Alice", chatMediator);
        User user2 = new User("Bob", chatMediator);
        User user3 = new User("Charlie", chatMediator);

        ((ChatRoom) chatMediator).setColleagues(user1, user2, user3);

        user1.sendMessage("Hello, everyone!");

        user2.sendMessage("Hi, Alice!");
        user3.sendMessage("Hey, Bob!");
    }
}

```
