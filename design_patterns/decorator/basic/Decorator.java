package design_patterns.decorator.basic;

abstract class Decorator implements Component {

  protected Component decoratedComponent;

  Decorator(Component component) {
    this.decoratedComponent = component;
  }

  @Override
  public String responsibility1() {
    return decoratedComponent.responsibility1();
  }

  @Override
  public String responsibility2() {
    return decoratedComponent.responsibility2();
  }

}
