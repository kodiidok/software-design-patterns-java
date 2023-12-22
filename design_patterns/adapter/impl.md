# Implementations

#### Class Adapter:

**Use Case: Integrating a Legacy System**
- **Scenario:** You have a legacy system that uses a class with an incompatible interface. You want to integrate it into a new system that expects a different interface.
- **Class Adapter Example:**

```java
// Legacy system with incompatible interface
class LegacySystem {
    void legacyRequest() {
        System.out.println("Legacy system's specific request");
    }
}

// Target interface
interface Target {
    void request();
}

// Class Adapter
class LegacyAdapter extends LegacySystem implements Target {
    @Override
    public void request() {
        legacyRequest();
    }
}

// Client code in the new system
public class NewSystemClient {
    public static void main(String[] args) {
        Target target = new LegacyAdapter();
        target.request();
    }
}
```

In this example, the `LegacyAdapter` acts as a bridge between the legacy system (with an incompatible interface) and the new system, adapting the legacy system's functionality to the expected `Target` interface.

#### Object Adapter:

**Use Case: Third-Party API Integration**
- **Scenario:** You are integrating a third-party API that has a different interface from what your application expects. You want to adapt the third-party API to fit your application's interface.
- **Object Adapter Example:**

```java
// Third-party API with different interface
class ThirdPartyAPI {
    void thirdPartyRequest() {
        System.out.println("Third-party API's specific request");
    }
}

// Target interface
interface Target {
    void request();
}

// Object Adapter
class ThirdPartyAdapter implements Target {
    private ThirdPartyAPI thirdPartyAPI;

    ThirdPartyAdapter(ThirdPartyAPI thirdPartyAPI) {
        this.thirdPartyAPI = thirdPartyAPI;
    }

    @Override
    public void request() {
        thirdPartyAPI.thirdPartyRequest();
    }
}

// Client code in the application
public class ApplicationClient {
    public static void main(String[] args) {
        ThirdPartyAPI thirdPartyAPI = new ThirdPartyAPI();
        Target target = new ThirdPartyAdapter(thirdPartyAPI);
        target.request();
    }
```

In this example, the `ThirdPartyAdapter` adapts the third-party API to the `Target` interface, allowing the client code in the application to seamlessly integrate with the third-party functionality.

These examples illustrate how Class Adapters and Object Adapters can be used in real-world scenarios to bridge interfaces and integrate components with different expectations. The choice between them depends on factors like code maintainability, control over source code, and the specific requirements of the integration.