package design_patterns.factory.abstractf;

interface ProductA {
  void show();
}

interface ProductB {
  void display();
}

interface Factory {
  ProductA createProductA();
  ProductB createProductB();
}

class ConcreteProductA1 implements ProductA {
  
  public void show() {
    System.out.println("Product A1");
  }

}

class ConcreteProductA2 implements ProductA {
  
  public void show() {
    System.out.println("Product A2");
  }

}

class ConcreteProductB1 implements ProductB {

  public void display() {
    System.out.println("Product B1");
  }
  
}

class ConcreteProductB2 implements ProductB {

  public void display() {
    System.out.println("Product B2");
  }
  
}

class ConcreteFactory1 implements Factory {

  @Override
  public ProductA createProductA() {
    return new ConcreteProductA1();
  }

  @Override
  public ProductB createProductB() {
    return new ConcreteProductB1();
  }

}

class ConcreteFactory2 implements Factory {

  @Override
  public ProductA createProductA() {
    return new ConcreteProductA2();
  }

  @Override
  public ProductB createProductB() {
    return new ConcreteProductB2();
  }

}

public class AbstractFactoryClient {
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
