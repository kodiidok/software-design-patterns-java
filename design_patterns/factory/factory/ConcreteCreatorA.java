package design_patterns.factory.factory;

public class ConcreteCreatorA implements Creator {
  
  @Override
  public Product createProduct() {
    return new ConcreteProductA();
  }

}