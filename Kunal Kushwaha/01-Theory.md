
## 🧭 1. **Procedural Programming (Imperative Subset)**

### 🔍 Definition:

Procedural programming is a **sub-paradigm of imperative programming**. It structures programs as a series of **procedures (functions or routines)** that operate on data.

* Code is executed **sequentially**, with **control flow** (loops, conditionals, jumps) directing execution.
* It emphasizes **procedure calls**, **state change**, and **mutable data**.
* Data and behavior are **separate**.

### 🧠 Key Characteristics:

* Emphasis on **step-by-step** instructions.
* Heavy use of **variables**, **loops**, and **function calls**.
* Global state is often used and **side effects** are common.
* **Modularity** is encouraged via procedures but **no object encapsulation**.

### 🔧 Example in C:

```c
#include <stdio.h>

int add(int a, int b) {
    return a + b;
}

int main() {
    int sum = add(5, 3);
    printf("Sum is %d\n", sum);
    return 0;
}
```

### ⚠️ Downsides:

* Poor data encapsulation.
* Harder to manage as complexity increases.

---

## 🔁 2. **Functional Programming (FP)**

### 🔍 Definition:

Functional programming is a **declarative paradigm** where computation is treated as the **evaluation of mathematical functions** and avoids changing-state and mutable data.

### 🧠 Core Principles:

* **Pure functions**: Same inputs always produce the same outputs, no side effects.
* **Immutability**: Data structures are immutable.
* **First-class functions**: Functions can be passed as arguments, returned, or assigned.
* **Higher-order functions**: Functions that take other functions as arguments or return them.
* **Recursion** instead of iteration.

### 🔧 Example in Haskell:

```haskell
add :: Int -> Int -> Int
add x y = x + y

main = print (add 3 4)
```

### ✅ Pros:

* Easier reasoning about code (no side effects).
* Better for concurrency and parallelism.

### ⚠️ Challenges:

* Performance overhead due to immutability.
* More abstract, may be harder to learn initially.

---

## 🧱 3. **Object-Oriented Programming (OOP)**

### 🔍 Definition:

OOP organizes software design around **objects**, which are **instances of classes**. Each object contains both **state** (attributes) and **behavior** (methods).

### 🧠 Core Concepts:

* **Encapsulation**: Bundling of data and methods operating on that data.
* **Abstraction**: Hiding internal implementation details.
* **Inheritance**: Deriving new classes from existing ones.
* **Polymorphism**: Treating objects of different classes through a common interface.

### 🔧 Example in Java:

```java
class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    void speak() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.speak();  // Output: Dog barks (polymorphism)
    }
}
```

### ✅ Strengths:

* Better at modeling real-world systems.
* Reusability through inheritance and composition.

### ⚠️ Criticisms:

* Inheritance can lead to tight coupling and fragile hierarchies.
* Overhead of managing state and object lifecycle.

---

## 🔢 4. **Static Typing**

### 🔍 Definition:

Static typing means **type checking is done at compile time**. The compiler enforces that variables are only used in ways consistent with their declared types.

### 🧠 Key Features:

* Variables have **fixed types**.
* Type errors are caught early.
* Usually includes **type inference** (like in TypeScript, Rust, or Haskell).
* Often supports **generics/templates** for type-safe abstraction.

### 🔧 Example in TypeScript:

```typescript
function add(a: number, b: number): number {
    return a + b;
}
add(1, "2"); // Error at compile time
```

### ✅ Benefits:

* Better **IDE support** (autocompletion, refactoring).
* Fewer runtime errors.
* Encourages thoughtful API design.

### ⚠️ Trade-offs:

* Slower development for quick scripts.
* Verbosity unless supported by type inference.

---

## 🔄 5. **Dynamic Typing**

### 🔍 Definition:

Dynamic typing performs type checking **at runtime**. Variables are bound to types only when the program is executed.

### 🧠 Key Features:

* Variables can change types at runtime.
* Type flexibility (duck typing: “if it quacks like a duck...”).
* Errors related to types occur only when code is run.

### 🔧 Example in Python:

```python
x = 10        # x is int
x = "hello"   # x is now str — no error
```

### ✅ Benefits:

* Very flexible and concise.
* Good for rapid prototyping and scripting.

### ⚠️ Risks:

* Type-related bugs surface at runtime.
* Harder to refactor large codebases safely.

---

## 🧬 Summary Table

| Concept         | Category    | Description                                   | Pros                                         | Cons                                      | Example Languages           |
| --------------- | ----------- | --------------------------------------------- | -------------------------------------------- | ----------------------------------------- | --------------------------- |
| Procedural      | Paradigm    | Functions and step-by-step instructions.      | Simple, efficient, predictable.              | Global state, limited abstraction.        | C, Pascal, BASIC            |
| Functional      | Paradigm    | Pure functions, immutability, recursion.      | Predictable, testable, concurrency-friendly. | Performance overhead, abstract syntax.    | Haskell, Elixir, Scala, F#  |
| Object-Oriented | Paradigm    | Classes, objects, inheritance, encapsulation. | Good for modeling real-world systems.        | Can lead to complex class hierarchies.    | Java, C++, Python, Ruby     |
| Static Typing   | Type System | Type-checked at compile time.                 | Early error detection, performance.          | Verbose, less flexible.                   | Java, C++, Rust, TypeScript |
| Dynamic Typing  | Type System | Type-checked at runtime.                      | Concise, flexible.                           | More runtime bugs, less safe refactoring. | Python, Ruby, JavaScript    |

---

## 🧩 Bonus: Languages Supporting Multiple Paradigms

Many modern languages are **multi-paradigm**:

* **Python**: Procedural, Object-Oriented, and some Functional features.
* **JavaScript**: Functional and Object-Oriented.
* **Rust**: Procedural, Functional, with strong static typing.
* **Scala**: Functional + Object-Oriented + Statically typed.

---
