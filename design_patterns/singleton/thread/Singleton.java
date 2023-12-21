package design_patterns.singleton.thread;

public class Singleton {

  private static volatile Singleton instance;

  private Singleton() {
    // Private constructor to prevent instantiation from other classes
  }

  public static Singleton getInstance() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }

}