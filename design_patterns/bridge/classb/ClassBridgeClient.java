package design_patterns.bridge.classb;

// Implementor interface
interface Implementor {
    void operationImpl();
}

// Concrete Implementor A
class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("Concrete Implementor A operation");
    }
}

// Concrete Implementor B
class ConcreteImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("Concrete Implementor B operation");
    }
}

// Abstraction class
abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    abstract void operation();
}

// Refined Abstraction A
class RefinedAbstractionA extends Abstraction {
    public RefinedAbstractionA(Implementor implementor) {
        super(implementor);
    }

    @Override
    void operation() {
        System.out.println("Refined Abstraction A operation");
        implementor.operationImpl();
    }
}

// Refined Abstraction B
class RefinedAbstractionB extends Abstraction {
    public RefinedAbstractionB(Implementor implementor) {
        super(implementor);
    }

    @Override
    void operation() {
        System.out.println("Refined Abstraction B operation");
        implementor.operationImpl();
    }
}

// Client code
public class ClassBridgeClient {
    public static void main(String[] args) {
        Implementor implementorA = new ConcreteImplementorA();
        Implementor implementorB = new ConcreteImplementorB();

        Abstraction abstractionA = new RefinedAbstractionA(implementorA);
        Abstraction abstractionB = new RefinedAbstractionB(implementorB);

        abstractionA.operation();
        abstractionB.operation();
    }
}
