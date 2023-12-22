package design_patterns.adapter.objecta;

public class Client {
  public static void main(String[] args) {
    // Creating an Adaptee instance
    Adaptee adaptee = new Adaptee();

    // Creating an Adapter and passing the Adaptee instance
    Target target = new Adapter(adaptee);

    // Client interacts with the Target interface
    target.request();
  }
}