# Implementations

## Real-world Example: Building a House

### Bridge Pattern:

**Use Case: Customizing the Construction of Houses**
- **Scenario:** You are developing a system to construct various types of houses, each with different features (e.g., number of rooms, roof type, etc.). Additionally, you want to support different construction materials for the structure and the interior.
- **Bridge Pattern Example:**

```java
// Abstraction
interface House {
    void construct();
}

// Refined Abstraction 1
class StandardHouse implements House {
    private ConstructionMaterial structureMaterial;
    private ConstructionMaterial interiorMaterial;

    public StandardHouse(ConstructionMaterial structureMaterial, ConstructionMaterial interiorMaterial) {
        this.structureMaterial = structureMaterial;
        this.interiorMaterial = interiorMaterial;
    }

    @Override
    public void construct() {
        System.out.println("Constructing a Standard House with " +
                structureMaterial.getMaterial() + " structure and " +
                interiorMaterial.getMaterial() + " interior.");
    }
}

// Refined Abstraction 2
class LuxuryHouse implements House {
    private ConstructionMaterial structureMaterial;
    private ConstructionMaterial interiorMaterial;

    public LuxuryHouse(ConstructionMaterial structureMaterial, ConstructionMaterial interiorMaterial) {
        this.structureMaterial = structureMaterial;
        this.interiorMaterial = interiorMaterial;
    }

    @Override
    public void construct() {
        System.out.println("Constructing a Luxury House with " +
                structureMaterial.getMaterial() + " structure and " +
                interiorMaterial.getMaterial() + " interior.");
    }
}

// Implementor
interface ConstructionMaterial {
    String getMaterial();
}

// Concrete Implementor 1
class ConcreteMaterial implements ConstructionMaterial {
    @Override
    public String getMaterial() {
        return "Concrete";
    }
}

// Concrete Implementor 2
class WoodMaterial implements ConstructionMaterial {
    @Override
    public String getMaterial() {
        return "Wood";
    }
}

// Client Code
public class HouseClient {
    public static void main(String[] args) {
        ConstructionMaterial concrete = new ConcreteMaterial();
        ConstructionMaterial wood = new WoodMaterial();

        House standardConcreteHouse = new StandardHouse(concrete, wood);
        House luxuryWoodenHouse = new LuxuryHouse(wood, wood);

        standardConcreteHouse.construct();
        luxuryWoodenHouse.construct();
    }
}
