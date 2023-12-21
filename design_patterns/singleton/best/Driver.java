package design_patterns.singleton.best;

public class Driver {
  
  public static void main(String[] args) {
    Singleton singleton = Singleton.INSTANCE;
    System.out.println(singleton.sendMessage());
  }

}
