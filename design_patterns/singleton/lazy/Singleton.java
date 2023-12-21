package design_patterns.singleton.lazy;

public class Singleton {

  private static Singleton instance;

  private Singleton() {
    // Private constructor to prevent instantiation from other classes
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

}
