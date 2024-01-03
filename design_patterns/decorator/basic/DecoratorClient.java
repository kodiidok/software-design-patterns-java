package design_patterns.decorator.basic;

interface Component {

  String responsibility1();

  String responsibility2();
}

class ConcreteComponent implements Component {

  @Override
  public String responsibility1() {
    return "This is responsibility 1";
  }

  @Override
  public String responsibility2() {
    return "This is responsibility 2";
  }

}

class Decorator implements Component {

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

class ConcreteDecoratorA extends Decorator {

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

class ConcreteDecoratorB extends Decorator {

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

public class DecoratorClient {

  public static void main(String[] args) {

    Component simpleComponent = new ConcreteComponent();
    System.out.println(simpleComponent.responsibility1());
    System.out.println(simpleComponent.responsibility2());

    Component decoratedComponent1 = new ConcreteDecoratorA(simpleComponent);
    System.out.println(decoratedComponent1.responsibility1());
    System.out.println(decoratedComponent1.responsibility2());

    Component decoratedComponent2 = new ConcreteDecoratorB(simpleComponent);
    System.out.println(decoratedComponent2.responsibility1());
    System.out.println(decoratedComponent2.responsibility2());
  }

}
