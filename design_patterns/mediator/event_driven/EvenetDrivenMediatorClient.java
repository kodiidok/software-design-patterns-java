package design_patterns.mediator.event_driven;

import java.util.ArrayList;
import java.util.List;

// Event Dispatcher
class EventDispatcher {
    private final List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void dispatchEvent(String event, String data) {
        for (EventListener listener : listeners) {
            listener.receiveEvent(event, data);
        }
    }
}

// Colleague
abstract class Colleague implements EventListener {
    protected EventDispatcher eventDispatcher;

    public Colleague(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void sendEvent(String event, String data) {
        eventDispatcher.dispatchEvent(event, data);
    }

    public abstract void receiveEvent(String event, String data);
}

// Event Listener
interface EventListener {
    void receiveEvent(String event, String data);
}

// Concrete Colleague
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(EventDispatcher eventDispatcher) {
        super(eventDispatcher);
        eventDispatcher.addListener(this);
    }

    @Override
    public void receiveEvent(String event, String data) {
        System.out.println("Colleague 1 received event '" + event + "' with data: " + data);
    }
}

// Concrete Colleague
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(EventDispatcher eventDispatcher) {
        super(eventDispatcher);
        eventDispatcher.addListener(this);
    }

    @Override
    public void receiveEvent(String event, String data) {
        System.out.println("Colleague 2 received event '" + event + "' with data: " + data);
    }
}

// Client Code
public class EvenetDrivenMediatorClient {
    public static void main(String[] args) {
        EventDispatcher eventDispatcher = new EventDispatcher();
        ConcreteColleague1 colleague1 = new ConcreteColleague1(eventDispatcher);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(eventDispatcher);

        colleague1.sendEvent("Greetings", "Hello from Colleague 1");
        colleague2.sendEvent("Greetings", "Hi from Colleague 2");
    }
}

