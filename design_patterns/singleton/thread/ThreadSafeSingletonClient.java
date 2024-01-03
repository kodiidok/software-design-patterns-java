package design_patterns.singleton.thread;

public class ThreadSafeSingletonClient {

  private static volatile ThreadSafeSingletonClient instance;

  private ThreadSafeSingletonClient() {
    // Private constructor to prevent instantiation from other classes
  }

  public static ThreadSafeSingletonClient getInstance() {
    if (instance == null) {
      synchronized (ThreadSafeSingletonClient.class) {
        if (instance == null) {
          instance = new ThreadSafeSingletonClient();
        }
      }
    }
    return instance;
  }

}