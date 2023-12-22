package design_patterns.factory.simple;

public class Factory {

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
