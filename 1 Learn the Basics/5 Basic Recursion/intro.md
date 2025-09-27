
##  **What is a Recursive Function?**

A **recursive function** is a function that **calls itself** in order to solve a smaller instance of the same problem.

It must have:

1. **Base case** – to stop the recursion
2. **Recursive case** – where the function calls itself with a smaller input

---

###  Example: Factorial (n!)

```cpp
int factorial(int n) {
    if (n == 0) return 1;           // Base case: factorial(0) = 1
    return n * factorial(n - 1);    // Recursive call
}
```

---

##  **What is the Base Condition?**

The **base condition** is the point at which the recursion stops. It prevents **infinite recursion** and hence **stack overflow**.

### Example:

```cpp
// Without base condition (bad!)
void print(int n) {
    std::cout << n << std::endl;
    print(n - 1);  // No stopping condition => infinite loop
}
```

 This will cause a **stack overflow** because the function keeps calling itself forever.

 Correct version with a base condition:

```cpp
void print(int n) {
    if (n == 0) return;           // Base condition
    std::cout << n << std::endl;
    print(n - 1);                 // Recursive call
}
```

---

##  What is Stack Overflow?

###  Definition:

A **stack overflow** occurs when too many function calls are pushed onto the **call stack**, exhausting the allocated memory.

###  The Call Stack:

When a function is called, it’s pushed onto the stack. When it returns, it’s popped off.

In recursion, each recursive call adds a new **stack frame** to the memory. If the recursion is too deep (like no base case), the stack keeps growing until the memory runs out → **stack overflow**.

###  Example:

```cpp
void infiniteRec() {
    infiniteRec(); // No base case, keeps calling itself
}
```

**Result:** Program crashes with a **stack overflow error**.

---

##  What is Stack Space?

* **Stack space** is a region of memory where function call information is stored:

  * Parameters
  * Local variables
  * Return addresses

Each recursive call uses up a portion of the **stack memory**.

If recursion is too deep (e.g., factorial(10^6)), you may run out of stack space.

---

##  What is a Recursion Tree?

A **recursion tree** is a visual representation of how a recursive function breaks a problem into smaller subproblems.

---

###  Example: Fibonacci

```cpp
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

The recursion tree for `fib(4)`:

```
             fib(4)
            /      \
        fib(3)     fib(2)
       /     \     /    \
   fib(2)  fib(1) fib(1) fib(0)
   /    \
fib(1) fib(0)
```

* Nodes = function calls
* Leaf nodes = base cases
* Notice how some calls repeat (this is why we use **memoization** in dynamic programming).

---

##  What is Segmentation Fault?

A **segmentation fault** (often abbreviated as **segfault**) occurs when a program tries to access memory that it doesn't have permission to use.

### Common Causes:

* Dereferencing `NULL` or uninitialized pointers
* Writing outside array bounds
* Stack overflow (often causes segmentation fault)

### Example:

```cpp
void recurse(int n) {
    int arr[100000]; // Very large local array
    recurse(n + 1);
}
```

 This will likely cause a **segmentation fault** due to **stack overflow**.

---

##  Recap: Key Concepts

| Term                   | Meaning                                                                |
| ---------------------- | ---------------------------------------------------------------------- |
| **Recursive Function** | A function that calls itself                                           |
| **Base Case**          | Condition to stop recursion                                            |
| **Stack Space**        | Memory used to store function calls                                    |
| **Stack Overflow**     | Too many recursive calls → memory exhaustion                           |
| **Recursion Tree**     | Visual structure showing how recursion unfolds                         |
| **Segmentation Fault** | Accessing invalid memory (e.g., due to stack overflow or bad pointers) |

---

##  Tips for Writing Recursive Functions

1. Always define a **base case**.
2. Ensure each recursive call **moves toward the base case**.
3. Be aware of **stack depth** limits (especially for large inputs).
4. Consider **iterative solutions** or **tail recursion** if needed.


## Difference Btw Parameterized and Functional Recursion


| Feature                 | Parameterized                  | Functional                         |
| ----------------------- | ------------------------------ | ---------------------------------- |
| Shape of tree           | Straight down (tail recursion) | Downward → then combines on return |
| Passes result as param? | ✅ Yes                          | ❌ No (uses return values)          |
| Combines results later? | ❌ No                           | ✅ Yes (adds during return)         |
| Base case returns       | Nothing / prints directly      | Returns 0                          |
| Example usage           | `sumParameterized(3, 0)`       | `sumFunctional(3)`                 |

---
