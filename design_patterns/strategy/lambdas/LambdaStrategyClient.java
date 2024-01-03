package design_patterns.strategy.lambdas;

// Functional interface for the strategy
@FunctionalInterface
interface Strategy {
    void execute();
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
public class LambdaStrategyClient {
    public static void main(String[] args) {
        // Create context
        Context context = new Context();

        // Use Lambda for ConcreteStrategy1
        context.setStrategy(() -> System.out.println("Executing ConcreteStrategy1"));
        context.performOperation();

        // Use Lambda for ConcreteStrategy2
        context.setStrategy(() -> System.out.println("Executing ConcreteStrategy2"));
        context.performOperation();
    }
}
