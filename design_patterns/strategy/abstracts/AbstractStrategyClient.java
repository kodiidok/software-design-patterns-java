package design_patterns.strategy.abstracts;

// Abstract strategy class
abstract class AbstractStrategy {
    abstract void execute();
}

// Concrete strategy 1
class ConcreteStrategy1 extends AbstractStrategy {
    @Override
    void execute() {
        System.out.println("Executing ConcreteStrategy1");
    }
}

// Concrete strategy 2
class ConcreteStrategy2 extends AbstractStrategy {
    @Override
    void execute() {
        System.out.println("Executing ConcreteStrategy2");
    }
}

// Context class
class Context {
    private AbstractStrategy strategy;

    public void setStrategy(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public void performOperation() {
        strategy.execute();
    }
}

// Client code
public class AbstractStrategyClient {
    public static void main(String[] args) {
        // Create context
        Context context = new Context();

        // Use ConcreteStrategy1
        context.setStrategy(new ConcreteStrategy1());
        context.performOperation();

        // Use ConcreteStrategy2
        context.setStrategy(new ConcreteStrategy2());
        context.performOperation();
    }
}

