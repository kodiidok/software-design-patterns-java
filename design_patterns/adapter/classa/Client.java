package design_patterns.adapter.classa;

public class Client {
  public static void main(String[] args) {
    // Creating an instance of the Adapter
    Target target = new Adapter();

    // Client interacts with the Target interface
    target.request();
  }
}