# Implementations

## Real-world Example: Building a House

### Iterator Pattern:

**Use Case: Managing Rooms in a House**
- **Scenario:** You are developing a system to manage the rooms in a house during construction. The system should allow iterating over the rooms to perform various operations or inspections.
- **Iterator Pattern Example:**

```java
// Aggregate
interface House {
    RoomIterator createIterator();
}

// Concrete Aggregate
class StandardHouse implements House {
    private Room[] rooms;

    public StandardHouse() {
        rooms = new Room[3];
        rooms[0] = new Room("Living Room");
        rooms[1] = new Room("Bedroom");
        rooms[2] = new Room("Kitchen");
    }

    @Override
    public RoomIterator createIterator() {
        return new StandardHouseIterator(rooms);
    }
}

// Iterator
interface RoomIterator {
    boolean hasNext();
    Room next();
}

// Concrete Iterator
class StandardHouseIterator implements RoomIterator {
    private Room[] rooms;
    private int index;

    public StandardHouseIterator(Room[] rooms) {
        this.rooms = rooms;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < rooms.length && rooms[index] != null;
    }

    @Override
    public Room next() {
        return rooms[index++];
    }
}

// Element
class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Client Code
public class HouseClient {
    public static void main(String[] args) {
        House standardHouse = new StandardHouse();
        RoomIterator iterator = standardHouse.createIterator();

        System.out.println("Rooms in the Standard House:");

        while (iterator.hasNext()) {
            Room room = iterator.next();
            System.out.println(room.getName());
        }
    }
}
