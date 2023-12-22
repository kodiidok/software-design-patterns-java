package design_patterns.adapter.classa;

public class Adapter extends Adaptee implements Target {

  @Override
  public void request() {
    specificRequest();
  }

}
