package design_patterns.mediator.simple;

// Mediator Interface
interface Mediator {
    void sendMessage(Colleague colleague, String message);
}

// Concrete Mediator
class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleagues(ConcreteColleague1 colleague1, ConcreteColleague2 colleague2) {
        this.colleague1 = colleague1;
        this.colleague2 = colleague2;
    }

    @Override
    public void sendMessage(Colleague colleague, String message) {
        if (colleague == colleague1) {
            colleague2.receiveMessage(message);
        } else if (colleague == colleague2) {
            colleague1.receiveMessage(message);
        }
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
public class SimpleMediatorClient {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleagues(colleague1, colleague2);

        colleague1.sendMessage("Hello from Colleague 1");
        colleague2.sendMessage("Hi from Colleague 2");
    }
}
