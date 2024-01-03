package design_patterns.adapter.objecta;

class Adapter implements Target {

  private Adaptee adaptee;

  Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void request() {
    adaptee.specificRequest();
  }
  
}

class Adaptee {
  void specificRequest() {
    System.out.println("This is the special request of Adaptee");
  }
}

interface Target {
  void request();
}

public class ObjectAdapterClient {
  public static void main(String[] args) {
    // Creating an Adaptee instance
    Adaptee adaptee = new Adaptee();

    // Creating an Adapter and passing the Adaptee instance
    Target target = new Adapter(adaptee);

    // Client interacts with the Target interface
    target.request();
  }
}