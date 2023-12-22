package design_patterns.factory.factory;

public class Client {
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