# Implementations

### 1. **Simple Factory: Logging System**

Imagine you are building a logging system where you have different types of loggers (e.g., FileLogger, ConsoleLogger). A simple factory can be used to create instances of these loggers based on the desired log type.

```java
// Simple Factory
public class LoggerFactory {
    public static Logger createLogger(String logType) {
        switch (logType) {
            case "file":
                return new FileLogger();
            case "console":
                return new ConsoleLogger();
            default:
                throw new IllegalArgumentException("Invalid log type: " + logType);
        }
    }
}
```

### 2. **Factory Method: Document Editors**

Consider a document editing application where you have multiple types of documents (e.g., TextDocument, SpreadsheetDocument). A factory method can be used to create document instances based on the user's choice.

```java
// Factory Method
interface Document {
    void open();
    void save();
}

class TextDocument implements Document {
    // Implementation for TextDocument
}

class SpreadsheetDocument implements Document {
    // Implementation for SpreadsheetDocument
}

abstract class DocumentEditor {
    public abstract Document createDocument();

    public void openAndSaveDocument() {
        Document document = createDocument();
        document.open();
        document.save();
    }
}

class TextDocumentEditor extends DocumentEditor {
    @Override
    public Document createDocument() {
        return new TextDocument();
    }
}

class SpreadsheetDocumentEditor extends DocumentEditor {
    @Override
    public Document createDocument() {
        return new SpreadsheetDocument();
    }
}
```

### 3. **Abstract Factory: GUI Framework**

In a graphical user interface (GUI) framework, you might need to create different types of GUI components (e.g., buttons, windows) for different platforms (e.g., Windows, macOS). An abstract factory can help create families of related components.

```java
// Abstract Factory
interface Button {
    void click();
}

interface Window {
    void render();
}

// Concrete Products
class WindowsButton implements Button {
    // Implementation for WindowsButton
}

class MacOSButton implements Button {
    // Implementation for MacOSButton
}

class WindowsWindow implements Window {
    // Implementation for WindowsWindow
}

class MacOSWindow implements Window {
    // Implementation for MacOSWindow
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Window createWindow();
}

// Concrete Factories
class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Window createWindow() {
        return new WindowsWindow();
    }
}

class MacOSGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Window createWindow() {
        return new MacOSWindow();
    }
}
```