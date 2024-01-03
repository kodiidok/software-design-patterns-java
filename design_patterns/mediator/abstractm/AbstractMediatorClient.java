package design_patterns.mediator.abstractm;

// Abstract Mediator
interface Mediator {
    void sendMessage(Colleague colleague, String message);
}

// Concrete Mediator
class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public ConcreteMediator() {
        this.colleague1 = new ConcreteColleague1(this);
        this.colleague2 = new ConcreteColleague2(this);
    }

    @Override
    public void sendMessage(Colleague colleague, String message) {
        if (colleague == colleague1) {
            colleague2.receiveMessage(message);
        } else if (colleague == colleague2) {
            colleague1.receiveMessage(message);
        }
    }

    public ConcreteColleague1 getColleague1() {
        return colleague1;
    }

    public ConcreteColleague2 getColleague2() {
        return colleague2;
    }
}

// Colleague Interface
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(this, message);
    }

    public abstract void receiveMessage(String message);
}

// Concrete Colleague
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague 1 received: " + message);
    }
}

// Concrete Colleague
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague 2 received: " + message);
    }
}

// Client Code
public class AbstractMediatorClient {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague1 colleague1 = mediator.getColleague1();
        ConcreteColleague2 colleague2 = mediator.getColleague2();

        colleague1.sendMessage("Hello from Colleague 1");
        colleague2.sendMessage("Hi from Colleague 2");
    }
}

