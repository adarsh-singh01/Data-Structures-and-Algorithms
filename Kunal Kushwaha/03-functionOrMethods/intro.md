
---

## 🔹 1. **Functions vs. Methods in Java**

In Java, we don’t usually use the term *function*. Instead:

> A **function defined inside a class** is called a **method**.

This is because **everything in Java must be inside a class** (except for some newer features like lambdas and record initializers). So, technically, what we call a function elsewhere (like in C or Python) becomes a **method** in Java.

### 🧠 Example:

```java
public class MyClass {
    void greet() {
        System.out.println("Hello!");
    }
}
```

Here, `greet()` is a **method**, not just a function.

---

## 🔹 2. **Method Definition Syntax**

### General form of a method:

```java
access_modifier return_type method_name(parameters) {
    // method body
    return value;  // if return_type is not void
}
```

### 🔹 Example:

```java
public int add(int a, int b) {
    return a + b;
}
```

* **access_modifier**: `public` (can also be `private`, `protected`, or default with no modifier)
* **return_type**: `int`
* **method_name**: `add`
* **parameters**: `int a`, `int b`
* **return statement**: `return a + b;`

---

## 🔹 3. **Static Context: “Anything you use in static needs to be static”**

This refers to **how Java handles static methods and variables**.

### 💡 Rule:

> A **static method** can only directly access **static members** (variables or methods).

This is because `static` means the method/variable belongs to the **class**, not any particular object.

### ❌ Error Example:

```java
public class Example {
    int number = 5;

    public static void display() {
        System.out.println(number); // ❌ Error! Non-static variable cannot be accessed
    }
}
```

### ✅ Fix:

Make the variable `static` too:

```java
static int number = 5;
```

---

## 🔹 4. **Return Statement**

When Java encounters a `return` statement in a method:

* It **immediately exits** the method.
* No code **after** the `return` line is executed.
* If the method returns a value, the `return` must provide a value of the correct type.

### 🧠 Example:

```java
public int square(int x) {
    return x * x;
    // System.out.println("This won't run"); ❌ Unreachable
}
```

---

## 🔹 5. **Scoping**

### 👉 Definition:

**Scope** refers to **where a variable is accessible** in your code.

Java has these levels of scope:

* **Class scope** (class-level fields)
* **Method scope** (variables declared inside methods)
* **Block scope** (inside loops or conditionals `{}`)

### 🧠 Example:

```java
public class ScopeDemo {
    int classVar = 10; // Class scope

    void demoMethod() {
        int methodVar = 5; // Method scope

        if (true) {
            int blockVar = 3; // Block scope
            System.out.println(blockVar); // ✅ Accessible here
        }

        // System.out.println(blockVar); ❌ Not accessible here
    }
}
```

---

## 🔹 6. **Primitives vs. Objects – Pass by Value**

Java is **always pass-by-value**.

* For **primitives**, it passes the **actual value**.
* For **objects**, it passes the **value of the reference** (not the object itself, and not a deep copy).

### 🧠 Example:

```java
void changePrimitive(int x) {
    x = 100;
}

void changeObject(MyObj obj) {
    obj.value = 100;
}
```

Calling these:

```java
int a = 5;
changePrimitive(a);
System.out.println(a); // Still 5

MyObj obj = new MyObj();
obj.value = 10;
changeObject(obj);
System.out.println(obj.value); // Now 100
```

✅ The **object reference** is copied, so changes inside the method affect the original object.
❌ But you can't reassign the object itself and expect it to reflect outside.

---

## 🔹 7. **Shadowing**

> **Shadowing** happens when a **local variable** (e.g., method or block variable) has the **same name** as an instance or class-level variable.

The **local variable hides or "shadows"** the outer variable.

### 🧠 Example:

```java
public class ShadowingDemo {
    int x = 10;

    void print() {
        int x = 5;
        System.out.println(x); // Prints 5, not 10 (local shadows class-level)
    }
}
```

To access the shadowed variable, use `this.x`:

```java
System.out.println(this.x); // prints 10
```

---

## 🔹 8. **Variable Arguments (Varargs)**

> Allows you to pass **zero or more arguments** to a method.

Syntax:

```java
void methodName(Type... name)
```

### 🧠 Example:

```java
void printNames(String... names) {
    for (String name : names) {
        System.out.println(name);
    }
}
```

Calling:

```java
printNames("Alice", "Bob", "Charlie");
```

### ⚠️ Rules:

* Varargs must be the **last** parameter in the method.
* You can only have **one varargs parameter**.

✅ Valid:

```java
void log(String level, String... messages)
```

❌ Invalid:

```java
void log(String... messages, String level) // ❌ Error
```

---

## 🔹 9. **Function Overloading**

> **Overloading** allows you to define **multiple methods with the same name** but **different parameter lists**.

### You can overload by:

* Changing the **number** of parameters
* Changing the **type** of parameters
* Or both

### 🧠 Example:

```java
void print(int a) {
    System.out.println(a);
}

void print(String s) {
    System.out.println(s);
}

void print(int a, int b) {
    System.out.println(a + b);
}
```

> ✅ Return type **alone** is **not enough** to overload a method.

---

## ✅ Summary Table

| Concept           | Explanation                             | Key Example                      |
| ----------------- | --------------------------------------- | -------------------------------- |
| **Method**        | Function inside a class                 | `void greet() {}`                |
| **Static**        | Belongs to class, not object            | `static int x;`                  |
| **Return**        | Exits method, returns value             | `return x + y;`                  |
| **Scope**         | Where a variable is accessible          | Method vs Block vs Class         |
| **Pass by Value** | Always pass by value (even for objects) | `change(x)`                      |
| **Shadowing**     | Local variable hides class variable     | `int x = 5;`                     |
| **Varargs**       | `...` allows multiple arguments         | `void print(String... names)`    |
| **Overloading**   | Same method name, different parameters  | `print(int)` and `print(String)` |

---

