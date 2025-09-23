


# What is Time Complexity?

First of all, it is not the time taken by the program to execute because the time taken by the program to execute depends on various factors like processor speed, RAM, etc.  
Time complexity is the rate of increase in time taken by the program to execute with respect to the increase in input size.  
It is commonly denoted by Big Oh notation.  
e.g., `O(n)`, `O(log n)`, `O(n^2)`, etc.

---

## Example 1: Constant Time Complexity

Find the time complexity of the following code:

```cpp
for(i = 1; i <= 5; i++) {
    cout << "hello";
}
````

* Steps involved:

  1. Assigning
  2. Comparison
  3. Incrementing
  4. Printing

Since these steps are constant and do not depend on the input size, the total number of steps is 5 iterations \* 3 operations = 15 steps.
However, time complexity is generally **not expressed in terms of numbers**. We avoid constant factors, so the time complexity is **O(1)** or constant time.

---

## Example 2: Linear Time Complexity

Now consider the following code:

```cpp
for(i = 1; i <= n; i++) {
    cout << "hello";
}
```

* For every `n` iterations, it performs:

  * Incrementing
  * Comparison
  * Printing

Each of these actions happens `n` times. Therefore, the total number of steps is `3 * n`.
We say that its time complexity is **O(3n)**, which is a number multiplied by a variable.
We generally do not represent time complexity in terms of numbers, so we avoid constant factors and say that the time complexity is **O(n)** or linear time.

---

## Other Notations

Apart from **Big O notation** (Upper Bound), there are other notations like **Big Omega** and **Big Theta**:

* **Big Omega**: Represents the **best-case scenario** (Lower Bound).
* **Big Theta**: Represents the **average-case scenario**.

---

## Example 3: Quadratic Time Complexity

Now consider the following code:

```cpp
for(i = 1; i <= n; i++) {
    for(j = 1; j <= n; j++) {
        cout << "hello";
    }
}
```

Here we have nested loops. For every `n` iterations of the outer loop, the inner loop runs `n` iterations.
The total number of iterations will be `n * n = n^2`. Therefore, the time complexity will be **O(n^2)** or quadratic time.

---

## Example 4: Nested Loops with Decreasing Inner Loop

Now consider the following code:

```cpp
for(i = 0; i <= n; i++) {
    for(j = 0; j <= i; j++) {
        cout << "hello";
    }
}
```

Here we have nested loops. For every `n` iterations of the outer loop, it does `i` iterations of the inner loop.
The total number of iterations will be:
$1 + 2 + 3 + ... + n = \frac{n(n+1)}{2}$, which is **O(n^2 / 2)**.
This can be simplified to **O(n^2)**.

---

# What is Space Complexity?

Space complexity is the amount of memory space required by the program to execute with respect to the increase in input size.
It is commonly denoted by Big Oh notation.

### Formula for Space Complexity:

```
SPACE COMPLEXITY = AUXILIARY SPACE + INPUT SPACE
```

* **AUXILIARY SPACE**: The extra space or temporary space used by the algorithm.
* **INPUT SPACE**: The space used by the input.

---

## Example of Space Complexity

Consider the following simple code:

```cpp
c = a + b;
```

* **Auxiliary Space**: `c` is the auxiliary space used by the algorithm.
* **Input Space**: `a` and `b` are the input space used by the algorithm.

Since no additional space is used other than for storing `a`, `b`, and `c`, the space complexity of this code is **O(1)** or constant space.

---

## Practical Example: Interview Perspective

If you ask someone to add two numbers, they might say:
`b = a + b;` without using any third variable. This might be fine in a casual setting.

However, if you are asked this in an interview, it's not considered a good answer. The reason is that overwriting the value of `b` may not be a desirable solution in certain cases where the original value of `b` is needed for further computations. Thus, using a temporary variable is often preferred.
