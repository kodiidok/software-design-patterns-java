package design_patterns.factory.factory;

interface Product {
  void show();
}

interface Creator {
  Product createProduct();
}

class ConcreteProductA implements Product {

  @Override
  public void show() {
    System.out.println("This is a product of type A");
  }
  
}

class ConcreteProductB implements Product {

  @Override
  public void show() {
    System.out.println("This is a product of type B");
  }
  
}

class ConcreteCreatorA implements Creator {
  
  @Override
  public Product createProduct() {
    return new ConcreteProductA();
  }

}

class ConcreteCreatorB implements Creator {
  
  @Override
  public Product createProduct() {
    return new ConcreteProductB();
  }

}

public class CreatorFactoryClient {
  public static void main(String[] args) {
    // Using the Factory Method to create products
    Creator creatorA = new ConcreteCreatorA();
    Product productA = creatorA.createProduct();
    productA.show();

    Creator creatorB = new ConcreteCreatorB();
    Product productB = creatorB.createProduct();
    productB.show();
  }
}