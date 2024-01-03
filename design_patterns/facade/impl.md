# Implementations

## Real-world Example: Building a House

### Facade Pattern:

**Use Case: Simplifying the Construction Process**
- **Scenario:** You are developing a system to construct various types of houses, each with different features (e.g., number of rooms, roof type, etc.). The construction process involves coordinating multiple subsystems (e.g., foundation, structure, interior), and you want to provide a simplified interface for clients to construct houses without dealing with the complexities of each subsystem.
- **Facade Pattern Example:**

```java
// Subsystem 1: Foundation
class Foundation {
    public void buildFoundation() {
        System.out.println("Building foundation.");
    }
}

// Subsystem 2: Structure
class Structure {
    public void buildStructure() {
        System.out.println("Constructing structure.");
    }
}

// Subsystem 3: Interior
class Interior {
    public void designInterior() {
        System.out.println("Designing interior.");
    }
}

// Facade
class HouseFacade {
    private Foundation foundation;
    private Structure structure;
    private Interior interior;

    public HouseFacade() {
        this.foundation = new Foundation();
        this.structure = new Structure();
        this.interior = new Interior();
    }

    public void constructHouse() {
        System.out.println("Starting house construction...");
        foundation.buildFoundation();
        structure.buildStructure();
        interior.designInterior();
        System.out.println("House construction completed.");
    }
}

// Client Code
public class HouseClient {
    public static void main(String[] args) {
        HouseFacade houseFacade = new HouseFacade();
        houseFacade.constructHouse();
    }
}
