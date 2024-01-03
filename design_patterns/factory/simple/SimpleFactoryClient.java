package design_patterns.factory.simple;

interface Product {
  void show();
}

class Factory {

  public static Product createProduct(String productType) {
    switch (productType) {
      case "A":
        return new ConcreteProductA();
      case "B":
        return new ConcreteProductB();
      default:
        throw new IllegalArgumentException("Invalid product type: " + productType);
    }
  }

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

public class SimpleFactoryClient {
  public static void main(String[] args) {
    Product productA = Factory.createProduct("A");
    productA.show();

    Product productB = Factory.createProduct("B");
    productB.show();
  }
}
