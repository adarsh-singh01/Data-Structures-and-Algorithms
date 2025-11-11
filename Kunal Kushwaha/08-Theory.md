
---

# **STRINGS & STRINGBUILDER IN JAVA — COMPLETE DETAILED NOTES**

---

## **1. Introduction: What is a String?**

A **String** in Java is a **sequence of characters**.
Technically, it is an **object** of the class `java.lang.String`.

It is **immutable**, meaning once a String object is created, **its value cannot be changed**.

---

### **1.1 Real-world analogy**

Think of a String as a **label printed on paper**.
You can’t erase or modify it — if you want to change it, you must **print a new label**.

---

### **1.2 Example**

```java
String name = "Adarsh";
System.out.println(name);
```

* `"Adarsh"` → string literal (automatically placed in **String Pool**)
* `name` → reference variable pointing to that String object.

---

## **2. String Declaration Methods**

### **2.1 Using String Literal**

```java
String s1 = "Hello";
String s2 = "Hello";
```

Both `s1` and `s2` refer to the **same object in String Pool** (memory optimization).

### **2.2 Using new Keyword**

```java
String s3 = new String("Hello");
```

Creates a **new object in the heap** (outside the pool) even if the same string exists in the pool.

---

### **2.3 ASCII Visualization**

```
String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");
```

Memory Diagram:

```
String Pool:
   "Hello" ← s1, s2

Heap Memory:
   new "Hello" ← s3
```

---

## **3. String Pool (Interning Mechanism)**

* Java maintains a special memory area called **String Constant Pool (SCP)**.
* If a string literal already exists in the pool, new references reuse it.
* This saves memory and improves performance.

**Key Point:**
If you use `new`, you bypass the pool and create a new object.

---

### **3.1 Example**

```java
String a = "Java";
String b = "Java";
String c = new String("Java");

System.out.println(a == b); // true (same object in pool)
System.out.println(a == c); // false (different object)
```

---

## **4. String Equality: `==` vs `.equals()`**

| Operator    | Compares                   | Example           | Result |
| ----------- | -------------------------- | ----------------- | ------ |
| `==`        | Reference (memory address) | `"a" == "a"`      | true   |
| `.equals()` | Value (contents)           | `"a".equals("a")` | true   |

**Example:**

```java
String s1 = "Adarsh";
String s2 = new String("Adarsh");

System.out.println(s1 == s2);       // false
System.out.println(s1.equals(s2));  // true
```

---

## **5. Printing Methods in Java**

Java’s **PrintStream class (java.io)** provides:

* `print()`
* `println()`
* `printf()`

---

### **5.1 `print()`**

Prints without adding a newline.

```java
System.out.print("Hello");
System.out.print("World");
// Output: HelloWorld
```

---

### **5.2 `println()`**

Prints and moves to next line.

```java
System.out.println("Hello");
System.out.println("World");
// Output:
// Hello
// World
```

---

### **5.3 `printf()` (Formatted Output)**

Used for **formatted output** (like `printf` in C/C++).

**Example:**

```java
System.out.printf("My score is %.2f and age is %d", 95.567, 20);
```

**Output:**

```
My score is 95.57 and age is 20
```

---

#### **Format Specifiers**

| Specifier | Meaning          | Example        | Output   |
| --------- | ---------------- | -------------- | -------- |
| `%d`      | Integer          | `%d` → 10      | 10       |
| `%f`      | Floating point   | `%f` → 1.23456 | 1.234560 |
| `%.2f`    | 2 decimal places | `%.2f` → 1.23  | 1.23     |
| `%s`      | String           | `%s` → "Hello" | Hello    |
| `%c`      | Character        | `%c` → 'A'     | A        |
| `%b`      | Boolean          | `%b` → true    | true     |

---

## **6. `toString()` and `Arrays.toString()`**

### **6.1 `toString()`**

* Defined in `Object` class.
* Returns a **string representation** of an object.

**Default:**
If not overridden, it prints:

```
ClassName@HexadecimalHashCode
```

**Example:**

```java
Object obj = new Object();
System.out.println(obj.toString());
// Output: java.lang.Object@2f92e0f4
```

---

### **6.2 `Arrays.toString()`**

Converts an **array** into a readable String.

```java
int[] arr = {1, 2, 3, 4};
System.out.println(Arrays.toString(arr));
```

Output:

```
[1, 2, 3, 4]
```

Without it, printing an array directly gives a hashcode:

```
[I@232204a1
```

---

## **7. The “+” Operator and Overloading**

In Java, the `+` operator is **overloaded** for String concatenation.

**Example:**

```java
String s = "Hello" + " World";
System.out.println(s); // Hello World
```

Internally, the compiler converts this to:

```java
String s = new StringBuilder().append("Hello").append(" World").toString();
```

---

### **7.1 C++ Comparison**

In C++, `+` can be **user-defined** via **operator overloading**.
But in Java, operator overloading is **not allowed** — only `+` is specially defined for Strings.

---

## **8. String Concatenation & Performance**

**Strings are immutable**, so every concatenation creates a **new object**.

**Example:**

```java
String s = "a";
s = s + "b";  // creates new object
s = s + "c";  // creates yet another object
```

For large operations, this is inefficient (creates many intermediate objects).

---

### **8.1 ASCII Diagram**

```
"a" → new "ab" → new "abc"
```

Each step = new object, old one becomes eligible for garbage collection.

---

## **9. StringBuilder — Mutable Strings**

To avoid multiple new object creations, Java provides:

* `StringBuilder` (non-synchronized, faster)
* `StringBuffer` (synchronized, thread-safe)

---

### **9.1 StringBuilder Example**

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
sb.append("!");
System.out.println(sb); // Hello World!
```

* Changes occur **in the same object** (no new objects).
* Much faster for repeated concatenations.

---

### **9.2 Common Methods**

| Method               | Description        | Example              | Output     |
| -------------------- | ------------------ | -------------------- | ---------- |
| `append()`           | Add text           | sb.append("Java")    | HelloJava  |
| `insert()`           | Insert text        | sb.insert(5, "X")    | HelloXJava |
| `delete(start, end)` | Remove range       | sb.delete(5, 6)      | HelloJava  |
| `reverse()`          | Reverse the string | sb.reverse()         | avaJolleH  |
| `setCharAt(i, ch)`   | Change a character | sb.setCharAt(0, 'M') | MelloJava  |
| `length()`           | Returns length     | sb.length()          | 9          |

---

### **9.3 String vs StringBuilder vs StringBuffer**

| Property        | String                 | StringBuilder          | StringBuffer           |
| --------------- | ---------------------- | ---------------------- | ---------------------- |
| **Mutability**  | Immutable              | Mutable                | Mutable                |
| **Thread-safe** | No                     | No                     | Yes                    |
| **Performance** | Slow for many changes  | Fast                   | Slower (sync overhead) |
| **Use Case**    | Small or constant text | Frequent modifications | Multi-threaded env     |

---

## **10. Palindrome Check using StringBuilder**

```java
String str = "madam";
StringBuilder sb = new StringBuilder(str);
if (str.equals(sb.reverse().toString())) {
    System.out.println("Palindrome");
} else {
    System.out.println("Not Palindrome");
}
```

Output:

```
Palindrome
```

---

## **11. Important Methods in String**

| Method               | Description                     | Example                           | Output    |
| -------------------- | ------------------------------- | --------------------------------- | --------- |
| `length()`           | Returns string length           | `"Java".length()`                 | 4         |
| `charAt(i)`          | Get character at index          | `"Java".charAt(2)`                | v         |
| `substring(a, b)`    | Extract substring               | `"Java".substring(1,3)`           | av        |
| `indexOf("a")`       | First occurrence                | `"Java".indexOf("a")`             | 1         |
| `lastIndexOf("a")`   | Last occurrence                 | `"Java".lastIndexOf("a")`         | 3         |
| `toLowerCase()`      | Converts to lowercase           | `"JAVA".toLowerCase()`            | java      |
| `toUpperCase()`      | Converts to uppercase           | `"java".toUpperCase()`            | JAVA      |
| `trim()`             | Removes leading/trailing spaces | `"  hi ".trim()`                  | hi        |
| `replace("a","x")`   | Replace char                    | `"Java".replace("a","x")`         | Jxvx      |
| `split(" ")`         | Splits into array               | `"A B C".split(" ")`              | [A, B, C] |
| `contains("va")`     | Checks substring                | `"Java".contains("va")`           | true      |
| `startsWith("Ja")`   | Prefix check                    | `"Java".startsWith("Ja")`         | true      |
| `endsWith("va")`     | Suffix check                    | `"Java".endsWith("va")`           | true      |
| `equalsIgnoreCase()` | Compare ignoring case           | `"java".equalsIgnoreCase("JAVA")` | true      |

---

## **12. Internal Working of String Class**

* Internally uses a **char[] value** array (in older Java) or **byte[]** (in newer Java versions).
* When you modify a string, it creates a **new array** and assigns the new value.
* **Immutable** → thread-safe, reliable as map keys.

---

### **12.1 ASCII Diagram**

```
String name = "Java";
┌─────────────────────┐
│ Reference → "Java"  │
│ Internal char[] = {'J','a','v','a'} │
└─────────────────────┘
```

Any change (like `name += "Code"`) creates a **new char[]**.

---

## **13. PrintStream Class (Underlying Print System)**

`System.out` is a **PrintStream** object.

### **Flow**

```
System → class
  .out → static PrintStream object
     .println() → method to print text
```

**PrintStream methods:**

* `print()`
* `println()`
* `printf()`
* `format()`

---

## **14. String Performance Summary**

| Operation              | String                              | StringBuilder            |
| ---------------------- | ----------------------------------- | ------------------------ |
| **Append repeatedly**  | Slow (creates new object each time) | Fast (modifies in place) |
| **Memory efficiency**  | Poor for large concatenations       | Excellent                |
| **Thread-safe**        | Yes (immutable)                     | No                       |
| **Suitable for loops** | ❌                                   | ✅                        |

---

### **Performance Example**

```java
String s = "";
for (int i = 0; i < 10000; i++) {
    s += i; // creates many objects
}

StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append(i); // modifies one object
}
```

→ **StringBuilder** is ~100x faster.

---

## **15. Summary Diagram (String vs StringBuilder)**

```
String:
   "A" → "AB" → "ABC" → new object each time
StringBuilder:
   [A] → append(B) → append(C) → same object modified
```

---

## **16. Interview Quick Recap**

| Topic                     | Key Idea                            |
| ------------------------- | ----------------------------------- |
| **String Literal vs new** | Literal in pool, `new` in heap      |
| **String Pool**           | Reuses immutable objects            |
| **== vs equals()**        | Reference vs value                  |
| **Immutability**          | New object each modification        |
| **StringBuilder**         | Mutable, faster                     |
| **printf**                | Formatted output using specifiers   |
| **toString()**            | Converts object → String            |
| **Arrays.toString()**     | Readable array print                |
| **String Performance**    | Use StringBuilder in loops          |
| **Palindrome Check**      | Reverse and compare                 |
| **PrintStream**           | Responsible for System.out printing |

---

## **17. Mini Control Flow (ASCII Summary)**

```
+-----------------------------+
| String creation: "Adarsh"   |
+-----------------------------+
         ↓
  Stored in String Pool
         ↓
  Reference variable → object
         ↓
   Any modification?
         ↓
     YES → new object
     NO  → same reference
```

---

## **18. Important Interview Questions**

1. Why are Strings immutable in Java?

   * For security, thread safety, and performance (used in String Pool, HashMap keys, etc.)

2. Difference between `==` and `.equals()`?

3. What is String interning?

4. Why is StringBuilder preferred in loops?

5. Difference between `StringBuilder` and `StringBuffer`?

6. What does `System.out` actually represent?

7. Why does `System.out.println(array)` print hashcode?

8. How to reverse or check palindrome efficiently?

---

