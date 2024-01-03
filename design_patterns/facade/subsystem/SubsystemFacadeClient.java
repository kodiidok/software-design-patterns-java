package design_patterns.facade.subsystem;

// Subsystem A
class SubsystemA {
    public void operationA() {
        System.out.println("Subsystem A operation");
    }
}

// Subsystem B
class SubsystemB {
    public void operationB() {
        System.out.println("Subsystem B operation");
    }
}

// Facade
class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;

    public Facade(SubsystemA subsystemA, SubsystemB subsystemB) {
        this.subsystemA = subsystemA;
        this.subsystemB = subsystemB;
    }

    public void operation() {
        System.out.println("Facade operation");
        subsystemA.operationA();
        subsystemB.operationB();
    }
}

// Client code
public class SubsystemFacadeClient {
    public static void main(String[] args) {
        SubsystemA subsystemA = new SubsystemA();
        SubsystemB subsystemB = new SubsystemB();
        Facade facade = new Facade(subsystemA, subsystemB);
        facade.operation();
    }
}

