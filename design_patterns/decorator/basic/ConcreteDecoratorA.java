package design_patterns.decorator.basic;

public class ConcreteDecoratorA extends Decorator {

  ConcreteDecoratorA(Component component) {
    super(component);
  }

  @Override
  public String responsibility1() {
    return super.responsibility1() + " of concrete decorator A";
  }

  @Override
  public String responsibility2() {
    return super.responsibility2() + " of concrete decorator A";
  }

}
