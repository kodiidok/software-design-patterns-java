package design_patterns.factory.simple;

public class Client {
  public static void main(String[] args) {
    Product productA = Factory.createProduct("A");
    productA.show();

    Product productB = Factory.createProduct("B");
    productB.show();
  }
}
