
---

### ✅ Java vs C++ Comparison (Line by Line)

```java
import java.util.Scanner;
```

🔁 **C++ equivalent:**

```cpp
#include <iostream>
#include <string>
```

📘 **Explanation:**

* `import java.util.Scanner;` lets you use the `Scanner` class for input.
* In C++, we use `#include <iostream>` for I/O and `#include <string>` to use `std::string`.

---

```java
public class CppCompare {
```

🔁 **C++ equivalent:**

```cpp
int main() {
```

📘 **Explanation:**

* Java requires all code to be inside a **class**, and the file should match the class name (in this case `CppCompare.java`).
* In C++, the `main()` function is the entry point — no need to wrap it in a class.

---

```java
    public static void main(String[] args) {
```

🔁 **C++ equivalent:**

```cpp
int main() {
```

📘 **Explanation:**

* `public static void main(String[] args)` is Java's standard entry point.

  * `public`: accessible everywhere
  * `static`: no need to create an object to run `main`
  * `String[] args`: array of command-line arguments
* C++ doesn't need these modifiers — `int main()` is enough.

---

```java
        Scanner scanner = new Scanner(System.in);
```

🔁 **C++ equivalent:**

```cpp
        std::string name;
```

📘 **Explanation:**

* Java needs a `Scanner` object to take user input.
* In C++, input is done using `cin`, so no need to create a special object for reading input unless using file streams.

---

```java
        System.out.print("Enter your name: ");
```

🔁 **C++ equivalent:**

```cpp
        std::cout << "Enter your name: ";
```

📘 **Explanation:**

* `System.out.print` is like `cout` — used to print to console.
* Note: `print` does **not** add a newline. Use `println` if you want a newline (like `std::endl` or `\n` in C++).

---

```java
        String name = scanner.nextLine();
```

🔁 **C++ equivalent:**

```cpp
        std::getline(std::cin, name);
```

📘 **Explanation:**

* `scanner.nextLine()` reads the full line of input — including spaces.
* In C++, we use `std::getline` to achieve the same. Using `cin >> name;` would stop at the first space.

---

```java
        System.out.println("Hello, " + name + "! Welcome to the program.");
```

🔁 **C++ equivalent:**

```cpp
        std::cout << "Hello, " << name << "! Welcome to the program." << std::endl;
```

📘 **Explanation:**

* `System.out.println` prints and moves to the next line.
* String concatenation in Java uses `+`.
* In C++, you use the insertion operator `<<`.

---

```java
        scanner.close();
```

🔁 **C++ equivalent:**

```cpp
        // No need to close std::cin
```

📘 **Explanation:**

* Java recommends closing input streams like `Scanner` to free resources.
* In C++, `cin` doesn’t need to be explicitly closed — it’s handled automatically.

---

```java
    }
}
```

🔁 **C++ equivalent:**

```cpp
    return 0;
}
```

📘 **Explanation:**

* In Java, `main` has `void` return type, so no `return` is required.
* In C++, `main` returns an `int`, and returning `0` indicates successful execution.

---

### ✅ Full C++ Equivalent of Your Java Program:

```cpp
#include <iostream>
#include <string>

int main() {
    std::string name;

    std::cout << "Enter your name: ";
    std::getline(std::cin, name);

    std::cout << "Hello, " << name << "! Welcome to the program." << std::endl;

    return 0;
}
```

---
