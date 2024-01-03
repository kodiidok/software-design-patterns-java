package design_patterns.adapter.classa;

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

interface Target {
  void request();
}

public class ClassAdapterClient {
  public static void main(String[] args) {
    // Creating an instance of the Adapter
    Target target = new Adapter();

    // Client interacts with the Target interface
    target.request();
  }
}