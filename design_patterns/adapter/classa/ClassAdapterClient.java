package design_patterns.adapter.classa;

interface Target {
  void request();
}

class Adapter extends Adaptee implements Target {

  @Override
  public void request() {
    specificRequest();
  }

}

class Adaptee {
  void specificRequest() {
    System.out.println("This is the special request of Adaptee");
  }
}

public class ClassAdapterClient {
  public static void main(String[] args) {
    // Creating an instance of the Adapter
    Target target = new Adapter();

    // Client interacts with the Target interface
    target.request();
  }
}