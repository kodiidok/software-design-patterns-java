package design_patterns.decorator.basic;

public class ConcreteComponent implements Component {

  @Override
  public String responsibility1() {
    return "This is responsibility 1";
  }

  @Override
  public String responsibility2() {
    return "This is responsibility 2";
  }

}
