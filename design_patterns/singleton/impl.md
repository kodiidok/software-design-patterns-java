# implementations

### Thread-Safe Lazy Initialization Singleton:

Suppose you are implementing a logging service in a multi-threaded environment. You want to ensure that there is a single point for logging to avoid race conditions and ensure proper log sequencing.

```java
public class Logger {

    private static Logger instance;

    private Logger() {
        // private constructor to prevent instantiation
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logMessage(String message) {
        // Log the message
        System.out.println("Log: " + message);
    }
}
```

In this scenario, the `Logger` class is a thread-safe singleton that ensures there is only one instance of the logger. Threads can safely call the `logMessage` method without worrying about concurrency issues.

Usage:

```java
Logger logger = Logger.getInstance();
logger.logMessage("This is a log message.");
```

### Enum Singleton:

Consider a configuration manager where you need to store and access application settings throughout your application. The configuration manager should be a singleton to maintain a single source of truth for configuration data.

```java
public enum ConfigurationManager {

    INSTANCE;  // The single instance

    private Properties configProperties;

    ConfigurationManager() {
        // Load configuration properties
        configProperties = loadConfigProperties();
    }

    private Properties loadConfigProperties() {
        // Load properties from a configuration file or another source
        // For demonstration purposes, a simple initialization is shown
        Properties properties = new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        return properties;
    }

    public String getProperty(String key) {
        return configProperties.getProperty(key);
    }
}
```

In this example, the `ConfigurationManager` is an enum singleton that loads configuration properties during initialization. Clients can access configuration properties through the `getProperty` method.

Usage:

```java
String value = ConfigurationManager.INSTANCE.getProperty("key1");
System.out.println("Configuration value: " + value);
```

In both examples, the singleton pattern ensures that there is only one instance of the respective classes, providing global access points for logging or configuration management in a thread-safe manner.