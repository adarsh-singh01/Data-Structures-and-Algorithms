
## 🔰 1. **Class**

### 💡 Concept:

A **class** is a blueprint for creating objects. It defines **attributes (fields)** and **methods** that describe the behavior and state of an object.

### 📌 Java Example:

```java
public class Car {
    // Attributes (Fields)
    String brand;
    int speed;

    // Method
    void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h");
    }
}
```

---

## 🔰 2. **Object**

### 💡 Concept:

An **object** is an instance of a class. It represents a real-world entity with **state** (fields) and **behavior** (methods).

### 📌 Java Example:

```java
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(); // Object creation
        car1.brand = "Toyota";
        car1.speed = 120;
        car1.drive(); // Output: Toyota is driving at 120 km/h
    }
}
```

---

## 🔰 3. **Attributes / Fields**

### 💡 Concept:

These are **variables** defined in a class to hold the **state** of an object.

```java
public class Car {
    String brand;   // attribute / field
    int speed;      // attribute / field
}
```

---

## 🔰 4. **Constructor**

### 💡 Concept:

A **constructor** is a special method used to **initialize objects**. It has the same name as the class and no return type.

### 📌 Java Example:

```java
public class Car {
    String brand;
    int speed;

    // Constructor
    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void display() {
        System.out.println(brand + " - " + speed + " km/h");
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car("Honda", 100); // calls constructor
        car.display();
    }
}
```

---

## 🔰 5. **Method / Function**

### 💡 Concept:

* **Method**: A block of code that performs an action.
* In Java, all **functions are methods** (since they must belong to a class).

```java
public class Calculator {
    // Method
    int add(int a, int b) {
        return a + b;
    }
}
```

---

## 🔰 6. **this Keyword**

### 💡 Concept:

Refers to the **current object** inside a method or constructor. Used to differentiate between **class fields** and **method parameters**.

```java
public class Person {
    String name;

    // Constructor with 'this'
    Person(String name) {
        this.name = name;  // 'this.name' is the class field, 'name' is parameter
    }

    void printName() {
        System.out.println("Name: " + this.name);
    }
}
```

---

## 🔰 7. **Encapsulation**

### 💡 Concept:

Encapsulation is the **bundling of data (fields) and methods** into a single unit (class), and **restricting access** using access modifiers (`private`, `public`, etc.).

* Fields are **private**
* Access through **public getters and setters**

### 📌 Java Example:

```java
public class Account {
    private double balance;  // encapsulated field

    // Getter
    public double getBalance() {
        return balance;
    }

    // Setter with validation
    public void setBalance(double amount) {
        if (amount > 0) {
            balance = amount;
        }
    }
}
```

---

## 🔰 8. **Abstraction**

### 💡 Concept:

**Hiding internal implementation** and showing only necessary features. Achieved using:

* **Abstract Classes**
* **Interfaces**

### 📌 Using Abstract Class:

```java
abstract class Animal {
    abstract void makeSound(); // abstract method
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}
```

---

## 🔰 9. **Inheritance**

### 💡 Concept:

Inheritance allows one class to **inherit properties and behavior** (fields and methods) from another class using the `extends` keyword.

### 📌 Java Example:

```java
class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();  // inherited method
        d.bark();
    }
}
```

---

## 🔰 10. **Polymorphism**

### 💡 Concept:

Polymorphism means **"many forms"**. In Java:

* **Compile-time Polymorphism** → Method Overloading
* **Runtime Polymorphism** → Method Overriding

---

### ✅ Compile-Time Polymorphism (Method Overloading)

```java
class MathOperations {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

---

### ✅ Runtime Polymorphism (Method Overriding)

```java
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}
```

---

## 🔰 11. **Interface**

### 💡 Concept:

An **interface** is a contract that defines **abstract methods** (implicitly `public abstract`) that implementing classes must define.

### 📌 Java Example:

```java
interface Vehicle {
    void drive();  // implicitly public and abstract
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Bike is driving");
    }
}
```

---

## ✅ Summary Table

| Concept       | Keyword/Usage             | Description              |
| ------------- | ------------------------- | ------------------------ |
| Class         | `class`                   | Blueprint for objects    |
| Object        | `new`                     | Instance of class        |
| Attribute     | Field                     | Variable inside class    |
| Method        | `void`, return type       | Function in class        |
| Constructor   | Same as class name        | Initializes object       |
| this          | `this`                    | Refers to current object |
| Encapsulation | `private` + getter/setter | Hides data               |
| Abstraction   | `abstract` / `interface`  | Hides implementation     |
| Inheritance   | `extends`                 | Reuse of code            |
| Polymorphism  | Overloading / Overriding  | Many forms               |
| Interface     | `interface`, `implements` | Contract for behavior    |

---

