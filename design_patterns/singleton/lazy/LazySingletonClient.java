package design_patterns.singleton.lazy;

public class LazySingletonClient {

  private static LazySingletonClient instance;

  private LazySingletonClient() {
    // Private constructor to prevent instantiation from other classes
  }

  public static LazySingletonClient getInstance() {
    if (instance == null) {
      instance = new LazySingletonClient();
    }
    return instance;
  }

}
