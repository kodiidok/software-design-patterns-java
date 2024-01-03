package design_patterns.singleton.eager;

public class EagerSingletonClient {

  private static final EagerSingletonClient instance = new EagerSingletonClient();

  private EagerSingletonClient() {
    // Private constructor to prevent instantiation from other classes
  }

  public static EagerSingletonClient getInstance() {
    return instance;
  }

}
