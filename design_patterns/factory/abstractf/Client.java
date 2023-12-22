package design_patterns.factory.abstractf;

public class Client {
  public static void main(String[] args) {
    // Creating products using Abstract Factory
    Factory factory1 = new ConcreteFactory1();
    ProductA productA1 = factory1.createProductA();
    ProductB productB1 = factory1.createProductB();

    Factory factory2 = new ConcreteFactory2();
    ProductA productA2 = factory2.createProductA();
    ProductB productB2 = factory2.createProductB();

    // Displaying products
    productA1.show();
    productB1.display();
    productA2.show();
    productB2.display();
  }
}
