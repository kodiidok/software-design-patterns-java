package design_patterns.factory.factory;

public class ConcreteCreatorB implements Creator {
  
  @Override
  public Product createProduct() {
    return new ConcreteProductB();
  }

}
