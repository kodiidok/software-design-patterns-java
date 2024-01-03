# Implementations

## Real-world Example: Building a House

### Class-Based Builder:

**Use Case: Constructing Different Types of Houses**
- **Scenario:** You are developing a system to construct various types of houses, each with different features (e.g., number of rooms, roof type, etc.).
- **Class-Based Builder Example:**

```java
// Product: House
class House {
    private int rooms;
    private String roofType;
    // Other attributes...

    // Constructor and getter methods...
}

// Abstract Builder
interface HouseBuilder {
    void buildRooms(int rooms);
    void buildRoofType(String roofType);
    // Other building methods...
    House getResult();
}

// Concrete Builder for Standard House
class StandardHouseBuilder implements HouseBuilder {
    private House house = new House();

    @Override
    public void buildRooms(int rooms) {
        house.setRooms(rooms);
    }

    @Override
    public void buildRoofType(String roofType) {
        house.setRoofType(roofType);
    }

    @Override
    public House getResult() {
        return house;
    }
}

// Director
class HouseConstructionDirector {
    public void construct(HouseBuilder builder) {
        builder.buildRooms(3);
        builder.buildRoofType("Gabled");
        // Other construction steps...
    }
}

// Client Code
public class HouseClient {
    public static void main(String[] args) {
        HouseBuilder builder = new StandardHouseBuilder();
        HouseConstructionDirector director = new HouseConstructionDirector();

        director.construct(builder);

        House standardHouse = builder.getResult();
        // Use the constructed house...
    }
}
