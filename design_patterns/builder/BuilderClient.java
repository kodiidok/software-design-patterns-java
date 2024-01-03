package design_patterns.builder;

// Product class represents the complex object being constructed
class Product {
    // Attributes of the product
    private String part1;
    private String part2;
    
    // Getter methods for parts
    public String getPart1() {
        return part1;
    }
    
    public String getPart2() {
        return part2;
    }

    public void setPart1(String value) {
        this.part1 = value;
    }

    public void setPart2(String value) {
        this.part2 = value;
    }
}

// Abstract builder interface declares the methods to construct the product
interface Builder {
    void buildPart1();
    void buildPart2();
    Product getResult();
}

// Concrete builder 1
class ConcreteBuilder1 implements Builder {
    private Product product = new Product();
    
    @Override
    public void buildPart1() {
        // Implement construction of part1 for ConcreteBuilder1
        product.setPart1("Part1 for ConcreteBuilder1");
    }
    
    @Override
    public void buildPart2() {
        // Implement construction of part2 for ConcreteBuilder1
        product.setPart2("Part2 for ConcreteBuilder1");
    }
    
    @Override
    public Product getResult() {
        return product;
    }
}

// Concrete builder 2
class ConcreteBuilder2 implements Builder {
    private Product product = new Product();
    
    @Override
    public void buildPart1() {
        // Implement construction of part1 for ConcreteBuilder2
        product.setPart1("Part1 for ConcreteBuilder2");
    }
    
    @Override
    public void buildPart2() {
        // Implement construction of part2 for ConcreteBuilder2
        product.setPart2("Part2 for ConcreteBuilder2");
    }
    
    @Override
    public Product getResult() {
        return product;
    }
}

// Director class orchestrates the construction process
class Director {
    public void construct(Builder builder) {
        builder.buildPart1();
        builder.buildPart2();
    }
}


public class BuilderClient {
    public static void main(String[] args) {
        // Create director
        Director director = new Director();
        
        // Create concrete builder 1
        Builder builder1 = new ConcreteBuilder1();
        // Construct product using builder 1
        director.construct(builder1);
        // Retrieve the product
        Product product1 = builder1.getResult();
        // Use the product
        System.out.println("Product 1 - Part 1: " + product1.getPart1());
        System.out.println("Product 1 - Part 2: " + product1.getPart2());
        
        // Create concrete builder 2
        Builder builder2 = new ConcreteBuilder2();
        // Construct product using builder 2
        director.construct(builder2);
        // Retrieve the product
        Product product2 = builder2.getResult();
        // Use the product
        System.out.println("Product 2 - Part 1: " + product2.getPart1());
        System.out.println("Product 2 - Part 2: " + product2.getPart2());
    }
}
