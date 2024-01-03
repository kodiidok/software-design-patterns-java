package design_patterns.strategy.base;

// Strategy interface
interface Strategy {
    void execute();
}

// Concrete strategy 1
class ConcreteStrategy1 implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing ConcreteStrategy1");
    }
}

// Concrete strategy 2
class ConcreteStrategy2 implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing ConcreteStrategy2");
    }
}

// Context class
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performOperation() {
        strategy.execute();
    }
}

// Client code
public class BaseStrategyClient {
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

