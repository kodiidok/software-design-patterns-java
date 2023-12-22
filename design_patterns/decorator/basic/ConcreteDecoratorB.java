package design_patterns.decorator.basic;

public class ConcreteDecoratorB extends Decorator {

  ConcreteDecoratorB(Component component) {
    super(component);
  }

  @Override
  public String responsibility1() {
    return super.responsibility1() + " of concrete decorator B";
  }

  @Override
  public String responsibility2() {
    return super.responsibility2() + " of concrete decorator B";
  }

}
