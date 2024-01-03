package design_patterns.bridge.objectb;

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
class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    void operation() {
        System.out.println("Abstraction operation");
        implementor.operationImpl();
    }
}

// Client code
public class ObjectBridgeClient {
    public static void main(String[] args) {
        Implementor implementorA = new ConcreteImplementorA();
        Implementor implementorB = new ConcreteImplementorB();

        Abstraction abstractionA = new Abstraction(implementorA);
        Abstraction abstractionB = new Abstraction(implementorB);

        abstractionA.operation();
        abstractionB.operation();
    }
}
