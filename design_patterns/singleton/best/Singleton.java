package design_patterns.singleton.best;

public enum Singleton {
  
  INSTANCE;

  public String sendMessage() {
    return "Hello, I'm an enum singleton!";
  }

}