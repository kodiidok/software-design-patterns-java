package design_patterns.decorator.basic;

public class Driver {

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
