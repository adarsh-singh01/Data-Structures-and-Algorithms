
# 📚 **Mastering Arrays, Memory, and ArrayList in Java — A Comprehensive Guide**

---

This document is a detailed breakdown of **arrays**, **memory management**, and **ArrayLists** in Java. It is designed for **long-term recall**, so you can come back any time and refresh your understanding even after months or years.

---

## 🔷 Section 1: Arrays in Java

---

### ✅ 1.1 What is an Array?

An **array** is a **data structure** that stores **multiple values of the same data type** under a single variable name. It provides **indexed access**, meaning each element can be accessed using its index.

📌 **Key Points:**

* Indexing starts at **0**.
* Arrays are **fixed in size** once created.
* They are **objects** in Java and live in **heap memory**.
* Arrays are **mutable** (you can change their contents).

---

### 🧠 1.2 Syntax of Array Declaration and Initialization

```java
datatype[] arrayName = new datatype[size];
```

Or in shorthand:

```java
int[] numbers = {1, 2, 3, 4, 5};  // Initialization with values
```

---

### 📦 1.3 Memory Model: Stack vs Heap

```java
int[] rollnos;             // Declaration only — rollnos is a reference (stored in stack)
rollnos = new int[5];      // Object creation — array is stored in heap
```

🧠 Think of it like this:

* The **reference** (`rollnos`) is stored in the **stack**.
* The **actual array object** (`new int[5]`) is created in the **heap**.

---

### 💡 1.4 Default Values in Arrays

When you create an array using `new`, each element is automatically initialized with a **default value** depending on the data type:

| Data Type              | Default Value               |
| ---------------------- | --------------------------- |
| `int`, `byte`, `short` | `0`                         |
| `float`, `double`      | `0.0`                       |
| `boolean`              | `false`                     |
| `char`                 | `'\u0000'` (null character) |
| `Object`, `String`     | `null`                      |

🧪 Example:

```java
int[] nums = new int[3];  // [0, 0, 0]
String[] names = new String[2];  // [null, null]
```

---

## 🔷 Section 2: Memory and Object Management

---

### 🧠 2.1 What is Dynamic Memory Allocation?

**Dynamic memory allocation** means memory is allocated **at runtime**, not at compile-time.

In Java:

* Arrays and objects are created at runtime using the `new` keyword.
* Memory is managed in the **heap**, not manually controlled like in C/C++.

### ⚖️ Comparison with C++:

* **C++**: Arrays are **contiguously allocated** in memory.
* **Java**: Memory layout is **managed by the JVM**, so the layout may not be strictly contiguous, especially for multi-dimensional arrays.

---

### 🛠️ 2.2 The `new` Keyword

In Java, the `new` keyword is used to:

* Create **new objects**
* Create **arrays**
* Allocate **heap memory**

```java
int[] data = new int[10];       // Array
Student s = new Student();      // Object
```

---

### 🚫 2.3 What is `null`?

`null` is a **literal** that represents **"no reference"** or an **empty object reference**.

* You can assign `null` to any **reference type**.
* You **cannot assign `null` to primitive types**.

```java
String name = null;     // Valid
int age = null;         // ❌ Invalid (primitives can’t be null)
```

---

### 🧠 2.4 Stack vs Heap Memory

| Memory Area | Stores What                               | Lifespan                |
| ----------- | ----------------------------------------- | ----------------------- |
| **Stack**   | Method calls, local variables, primitives | Short (per method call) |
| **Heap**    | Arrays, objects, classes                  | Long (managed by GC)    |

* Primitives: Stored in **stack**
* Arrays & Objects: Stored in **heap**, reference stored in **stack**

---

### 🧳 2.5 `String[] args` in `main()`

```java
public static void main(String[] args)
```

* `args` is a **String array** that receives **command-line arguments** when the program runs.
* It allows users to input parameters like:

```bash
java MyProgram arg1 arg2 arg3
```

---

## 🔷 Section 3: Working with Arrays

---

### 🔁 3.1 Using `for-each` Loop

This loop is used to iterate over arrays without manually using an index.

```java
int[] arr = {10, 20, 30};
for (int num : arr) {
    System.out.print(num + " ");
}
```

💬 *"For each element `num` in `arr`, do something..."*

---

### 🖨️ 3.2 Printing Arrays

❌ `System.out.println(arr);` → prints something like `[I@6d06d69c` (reference)

✅ Best way to print arrays:

```java
import java.util.Arrays;
System.out.println(Arrays.toString(arr));  // Prints [1, 2, 3]
```

For 2D arrays:

```java
System.out.println(Arrays.deepToString(arr));
```

---

### 🔄 3.3 Mutability of Arrays

Arrays in Java are **mutable**, meaning their contents can be changed after creation.

```java
int[] data = {1, 2, 3};
data[0] = 100;  // Now array is [100, 2, 3]
```

### 🚫 Strings Are Immutable

Strings are objects in Java but **immutable**:

* Changing a string actually creates a **new object**.

```java
String s = "hello";
s = s.toUpperCase();  // Creates new string "HELLO"
```

---

## 🔷 Section 4: 2D and Multi-Dimensional Arrays

---

### 🧮 4.1 What is a 2D Array?

A **2D array** is an **array of arrays**. It's commonly used to represent matrices or grids.

```java
int[][] matrix = new int[3][4];  // 3 rows, 4 columns
```

---

### ⚠️ 4.2 Why Column Size is Optional?

You can create a **jagged array** where each row has a different number of columns:

```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];
jagged[1] = new int[4];
jagged[2] = new int[1];
```

Each row is an independent array.

---

### 🧠 4.3 Internal Representation

Java stores 2D arrays as **arrays of array references**.

* `arr.length` → number of rows
* `arr[i].length` → number of columns in row `i`

---

### 🔁 4.4 Looping Through 2D Arrays

```java
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
    }
}
```

---

## 🔷 Section 5: ArrayList — Dynamic Arrays in Java

---

### ✅ 5.1 What is an ArrayList?

An **ArrayList** is a part of the **Java Collections Framework**.

* Similar to arrays, but **resizable**
* Stores **objects** only (not primitives)
* Offers powerful **methods**: `add()`, `remove()`, `get()`, `set()`, `contains()`

### ⚠️ Note:

To store primitives like `int`, use wrapper classes (`Integer`, `Double`, etc.)

---

### 🛠️ 5.2 Syntax & Usage

```java
import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
System.out.println(list.get(1));  // Output: 20
```

---

### ⏱️ 5.3 Time Complexity

| Operation                               | Time Complexity      |
| --------------------------------------- | -------------------- |
| `add(element)` (end)                    | **O(1)** (amortized) |
| `get(index)`                            | **O(1)**             |
| `add(index, element)` / `remove(index)` | **O(n)**             |
| `contains(element)`                     | **O(n)**             |

So, **ArrayList is not always O(1)** — especially if you insert/remove from the middle.

---

### 🧮 5.4 Multi-Dimensional ArrayLists

Just like 2D arrays, you can create a list of lists:

```java
ArrayList<ArrayList<Integer>> list = new ArrayList<>();

// Add 3 rows
for (int i = 0; i < 3; i++) {
    list.add(new ArrayList<>());
}

// Add values
list.get(0).add(10);
list.get(1).add(20);
list.get(2).add(30);

```

📌 Note: Each inner list is independent — you can make it jagged.

---

## 🧾 Quick Recap / Cheatsheet

| Concept | Summary |
|--------|---------|
| Arrays | Fixed size, homogeneous, mutable |
| `new` keyword | Allocates memory in heap |
| `null` | Used to indicate no object |
| Stack | Method variables, function calls |
| Heap | All objects, arrays |
| `String[] args` | Holds command-line arguments |
| 2D Arrays | Array of arrays, supports jagged structures |
| ArrayList | Dynamic array for objects only, supports methods |
| Mutability | Arrays: ✅, Strings: ❌ |

---



