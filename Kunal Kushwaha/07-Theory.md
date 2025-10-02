
### 1. **Every file that ends with `.java` is a class itself?**

* **No, not exactly.**
* A `.java` file **contains one or more classes** (or interfaces, enums).
* **If a class is declared `public`**, then the **file name must match that public class name exactly**.
* Example:

  * `HelloWorld.java` must contain:

    ```java
    public class HelloWorld {
        // code
    }
    ```
* You can have multiple **non-public** classes in one `.java` file, but that is uncommon.

---

### 2. **PascalCase variables are classes (convention)**

* The **naming convention** in Java:

  * **Classes and interfaces:** use **PascalCase** (each word capitalized, no underscores).

    * Example: `Scanner`, `SumOfTwo`, `ArrayList`
  * **Variables and methods:** use **camelCase** (first word lowercase, following words capitalized).

    * Example: `inputScanner`, `num1`, `calculateSum()`
  * **Constants:** all uppercase with underscores (`MAX_SIZE`).

---

### 3. **Main class is public**

* The **main class** that contains the `main` method is usually declared as `public`.
* This is so the **Java Virtual Machine (JVM)** can access and run the class.
* If your main class is not public, JVM **cannot start your program** from it.

---

### 4. **Access Modifiers**

* Java uses **access modifiers** to control visibility of classes, methods, and variables:

  * `public`: accessible from **anywhere**.
  * `protected`: accessible within the same package and subclasses.
  * (default) *no modifier*: accessible **only inside the same package**.
  * `private`: accessible **only within the same class**.

---

### 5. **Main is the entry point of a Java program**

* The JVM looks for the `main` method to start execution:

  ```java
  public static void main(String[] args)
  ```
* Without this exact signature, JVM throws an error — program won’t run.

---

### 6. **Some conventions in Java**

| Concept               | Convention                         |
| --------------------- | ---------------------------------- |
| Class names           | PascalCase (e.g., `MyClass`)       |
| Method/variable names | camelCase (e.g., `calculateSum`)   |
| Constants             | ALL_CAPS_WITH_UNDERSCORES          |
| Package names         | all lowercase (e.g., `com.adarsh`) |

---

### 7. **What is `public static void main`**

* **public**: method accessible from anywhere (JVM).
* **static**: method can be called without creating an instance of the class.
* **void**: method returns no value.
* **main**: method name recognized by JVM as starting point.
* **String[] args**: array of command-line arguments (strings).

---

### 8. **How does the computer know what `javac`, `python` is?**

* When you type commands like `javac` or `python` in a terminal, the system looks in folders listed in the **PATH environment variable**.
* If `javac.exe` or `python.exe` is found in any PATH folder, it executes that program.
* If not found, it says "command not found."

---

### 9. **What are PATH variables?**

* **PATH** is an environment variable listing directories where executable files are located.
* When a command is run, the OS searches those directories in order.
* Adding Java's `bin` directory to PATH allows `javac` and `java` commands to work from anywhere.

---

### 10. **What’s `package com.adarsh`?**

* `package` defines a **namespace** and folder structure.
* Example: `package com.adarsh;` means your `.java` file is inside a folder structure `com/adarsh/`.
* It helps:

  * Organize code.
  * Avoid naming conflicts.
  * Control visibility (with access modifiers).

---

### 11. **What’s `System.out.println()`?**

* `System` is a final class in `java.lang`.
* `out` is a static variable of type `PrintStream`, initialized by JVM.
* `System.out.println()` prints to **standard output (console)**.
* `out` is **not null** by default — it’s set up to print to your terminal.
* You can also use `print()`, `printf()` methods.

---

### 12. **What’s `System.in`?**

* `System.in` is an `InputStream` connected to the keyboard (standard input).
* By itself, it only reads raw bytes.
* Scanner wraps `System.in` to make it easier to read typed input, e.g.:

  * `nextInt()`: reads an integer.
  * `next()`: reads next token (word).
  * `nextLine()`: reads the entire line as a string.

---

### 13. **What’s Scanner?**

* `Scanner` is a **public class** from `java.util` package.
* It provides convenient methods to parse primitive types and strings from input streams.
* You can use it because it's **public and imported**.

---

### 14. **Every class in Java extends Object class?**

* Yes! If you don't explicitly extend another class, your class **implicitly extends** `java.lang.Object`.
* `Object` is the root superclass of all classes.
* It provides fundamental methods like:

  * `toString()`
  * `equals()`
  * `hashCode()`
  * `getClass()`

---

### 15. **What’s primitive (datatype that can't be broken)?**

* Primitive types store **actual values**.
* They **aren’t objects** and cannot be decomposed into smaller parts.
* Primitive types: `int`, `float`, `double`, `byte`, `short`, `long`, `char`, `boolean`.
* They have fixed size and default values.

---

### 16. **Why add `f` and `L` in float and long?**

* By default:

  * Decimal literals like `3.14` are `double`.
  * Integer literals like `100` are `int`.
* To specify literal types explicitly:

  * `3.14f` means a `float` literal.
  * `10000000000L` means a `long` literal.
* This prevents type mismatch errors.

---

### 17. **Wrapper classes?**

* Wrapper classes **wrap primitive types as objects**.
* Useful because Java’s collections work with objects, not primitives.
* Examples:

  * `int` → `Integer`
  * `double` → `Double`
  * `boolean` → `Boolean`
* Wrappers provide utility methods and support null values.

---

### 18. **What’s cast and floating point error?**

* **Casting** converts one data type into another.
* **Implicit casting**: automatic when converting smaller to bigger types (widening).
* **Explicit casting**: programmer must specify, e.g. `(int) 3.9`.
* **Floating point error**: decimal numbers are approximated in binary, leading to tiny precision errors.

Example:

```java
System.out.println(0.1 + 0.2); // prints 0.30000000000000004
```

---

### 19. **Rules of typecasting**

| Conversion         | Cast Required? | Example                              |
| ------------------ | -------------- | ------------------------------------ |
| smaller → bigger   | No             | `int` to `long`                      |
| bigger → smaller   | Yes            | `(byte) intValue`                    |
| incompatible types | Usually no     | e.g. `int` to `String` needs parsing |

---

### 20. **What’s narrowing conversion?**

* Converting **larger data type to smaller data type**.
* Potentially **loses data** or **causes overflow**.
* Must be explicit.

Example:

```java
int a = 257;
byte b = (byte) a;  // b becomes 1 because 257 % 256 = 1 (overflow)
```

---

### 21. **Type promotion**

* Smaller types are **promoted to bigger types** during expressions.
* Example:

```java
byte b = 10;
int i = b + 20;  // b promoted to int
```

---

### 22. **Does Java work on Unicode?**

* Yes, Java uses **Unicode** to represent characters.
* The `char` type is 16 bits, capable of representing most Unicode characters.
* You can use any language’s characters in strings or chars.

Example:

```java
char ch = 'अ';
System.out.println(ch);  // prints Devanagari character
```

---

