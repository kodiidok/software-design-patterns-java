package design_patterns.adapter.objecta;

public class Adapter implements Target {

  private Adaptee adaptee;

  Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void request() {
    adaptee.specificRequest();
  }
  
}
