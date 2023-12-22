# Implementations 

Consider a simple example where we have a `Coffee` class as our `Component`. We want to add decorators for various coffee condiments like milk (`MilkDecorator`) and sugar (`SugarDecorator`).

```java
// Component interface
interface Coffee {
    double cost();
    String description();
}

// ConcreteComponent
class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.0; // Base cost of simple coffee
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}

// ConcreteDecorator - MilkDecorator
class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5; // Additional cost for milk
    }

    @Override
    public String description() {
        return super.description() + " with Milk";
    }
}

// ConcreteDecorator - SugarDecorator
class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.2; // Additional cost for sugar
    }

    @Override
    public String description() {
        return super.description() + " with Sugar";
    }
}
```

### Usage:

```java
public class CoffeeShop {
    public static void main(String[] args) {
        // Order a simple coffee
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: $" + simpleCoffee.cost() + ", Description: " + simpleCoffee.description());

        // Add milk to the coffee
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: $" + milkCoffee.cost() + ", Description: " + milkCoffee.description());

        // Add sugar to the coffee
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: $" + sugarMilkCoffee.cost() + ", Description: " + sugarMilkCoffee.description());
    }
}
```

### Output:

```
Cost: $2.0, Description: Simple Coffee
Cost: $2.5, Description: Simple Coffee with Milk
Cost: $2.7, Description: Simple Coffee with Milk with Sugar
```

In this example, `Coffee` is the base component, and `MilkDecorator` and `SugarDecorator` are concrete decorators. They wrap instances of `Coffee` and add additional functionality (cost and description) to it.

The Decorator pattern allows you to combine these decorators in a flexible way, adding or removing responsibilities dynamically at runtime. This pattern promotes code reuse and open/closed principles, allowing you to extend the behavior of objects without modifying their code.

# Other Methods

There are different ways to implement the Decorator pattern. The implementation can vary based on programming language features and the specific requirements of the application. Below are some variations and considerations for implementing the Decorator pattern:

### 1. **Abstract Decorator Class:**
   - Create an abstract decorator class that implements the component interface.
   - Concrete decorators extend the abstract decorator class.

   ```java
   abstract class CoffeeDecorator implements Coffee {
       protected Coffee decoratedCoffee;

       CoffeeDecorator(Coffee decoratedCoffee) {
           this.decoratedCoffee = decoratedCoffee;
       }

       // Delegate methods to the decoratedCoffee
   }

   class MilkDecorator extends CoffeeDecorator { /* ... */ }
   class SugarDecorator extends CoffeeDecorator { /* ... */ }
   ```

### 2. **Interface-Based Decorator:**
   - Use interfaces instead of abstract classes for both the component and decorator.

   ```java
   interface Coffee {
       double cost();
       String description();
   }

   interface CoffeeDecorator extends Coffee { /* ... */ }

   class MilkDecorator implements CoffeeDecorator { /* ... */ }
   class SugarDecorator implements CoffeeDecorator { /* ... */ }
   ```

### 3. **Dynamic Decoration:**
   - Allow dynamic addition of decorators at runtime.
   - Decorators can be added in any order.

   ```java
   List<CoffeeDecorator> decorators = new ArrayList<>();
   decorators.add(new MilkDecorator());
   decorators.add(new SugarDecorator());

   Coffee decoratedCoffee = new SimpleCoffee();
   for (CoffeeDecorator decorator : decorators) {
       decoratedCoffee = decorator.decorate(decoratedCoffee);
   }
   ```

### 4. **Multiple Decorators:**
   - Allow a component to be decorated with multiple decorators.

   ```java
   Coffee doublyDecoratedCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
   ```

### 5. **Class-Level vs. Object-Level Decoration:**
   - Decorate either at the class level (static) or at the object level (dynamic).

   ```java
   // Class-level decoration (static)
   class MilkCoffee extends MilkDecorator { /* ... */ }

   // Object-level decoration (dynamic)
   Coffee dynamicallyDecoratedCoffee = new SimpleCoffee();
   dynamicallyDecoratedCoffee = new MilkDecorator(dynamicallyDecoratedCoffee);
   ```

### 6. **Component Composition:**
   - Allow decorators to be composed directly with components.

   ```java
   Coffee sugarMilkCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
   ```

### 7. **Stateful Decorators:**
   - Allow decorators to maintain state.

   ```java
   class ExtraShotDecorator extends CoffeeDecorator {
       private int extraShots;

       ExtraShotDecorator(Coffee decoratedCoffee, int extraShots) {
           super(decoratedCoffee);
           this.extraShots = extraShots;
       }

       @Override
       public double cost() {
           return super.cost() + 0.5 * extraShots; // Additional cost for extra shots
       }
   }
   ```

Choose the implementation approach based on the requirements of your application and the programming language features available. The key is to maintain flexibility, promote code reuse, and adhere to the open/closed principle by allowing the dynamic addition of responsibilities to objects.