package design_patterns.singleton.best;

enum Singleton {
  
  INSTANCE;

  public String sendMessage() {
    return "Hello, I'm an enum singleton!";
  }

}

public class BestSingletonClient {
  
  public static void main(String[] args) {
    Singleton singleton = Singleton.INSTANCE;
    System.out.println(singleton.sendMessage());
  }

}
