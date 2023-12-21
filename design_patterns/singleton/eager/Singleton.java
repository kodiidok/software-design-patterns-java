package design_patterns.singleton.eager;

public class Singleton {

  private static final Singleton instance = new Singleton();

  private Singleton() {
    // Private constructor to prevent instantiation from other classes
  }

  public static Singleton getInstance() {
    return instance;
  }

}
