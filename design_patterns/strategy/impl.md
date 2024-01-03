# Implementations

## Real-world Example: Payment Methods

### Strategy Pattern for Payment Processing

**Use Case: Handling Different Payment Methods**
- **Scenario:** You are developing a payment processing system that supports various payment methods (e.g., credit card, PayPal, cryptocurrency).
- **Strategy Pattern Example:**

```java
// Context: PaymentProcessor
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Strategy: Payment Strategy
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy 1: Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using credit card " + cardNumber);
        // Additional credit card payment logic...
    }
}

// Concrete Strategy 2: PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal with email " + email);
        // Additional PayPal payment logic...
    }
}

// Concrete Strategy 3: Cryptocurrency Payment
class CryptocurrencyPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptocurrencyPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using cryptocurrency wallet " + walletAddress);
        // Additional cryptocurrency payment logic...
    }
}

// Client Code
public class PaymentClient {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // Use Concrete Strategy 1: Credit Card Payment
        processor.setPaymentStrategy(new CreditCardPayment("1234-5678-9101-1121"));
        processor.processPayment(100);

        // Use Concrete Strategy 2: PayPal Payment
        processor.setPaymentStrategy(new PayPalPayment("example@example.com"));
        processor.processPayment(50);

        // Use Concrete Strategy 3: Cryptocurrency Payment
        processor.setPaymentStrategy(new CryptocurrencyPayment("cryptoWallet123"));
        processor.processPayment(200);
    }
}
