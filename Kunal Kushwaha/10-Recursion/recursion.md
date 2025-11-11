# Recursion
---

## 1. What is recursion?

**Definition:** Recursion is when a function calls itself (directly or indirectly) to solve a problem by breaking it down into smaller, similar subproblems.

Recursion is appropriate when:

* A problem can be expressed in terms of smaller instances of the same problem.
* You can identify a **base case** that stops recursion.
* You accept the extra call-stack memory cost (or can optimize).

**Key mental models:**

* **Call stack model:** each call creates a frame; frames are pushed and popped as calls are made/return.
* **Recursion tree model:** visualize the whole breakdown of calls as a tree.

---

## 2. Call stack basics (what actually happens at runtime)

1. When a function calls another function (including itself), a **frame** is pushed onto the call stack with:

   * parameters, local variables, return address.
2. While the function hasn't returned, its frame stays on the stack.
3. When the function returns, its frame is popped and control returns to the caller (which continues from the return point).
4. If recursion never reaches a base case, frames keep piling up → **StackOverflowError**.

**Important consequences:**

* Local variables are *per-call*; each frame has its own copy.
* Recursive functions use extra memory equal to the depth of recursion (stack frames).

---

## 3. Base case — the guardrail

**Base case:** A condition that stops recursion and returns a direct value without further recursive calls.

If you forget or mis-specify the base case:

* Recursion might never stop → **infinite recursion** → StackOverflow.

Always ask:

* “What is the smallest instance that I know the answer for immediately?”
* “How does each recursive step make progress toward that base case?”

---

## 4. Why recursion? pros & cons

**Advantages**

* Simpler, more readable code for divide-and-conquer, tree/graph traversals, backtracking.
* Natural expression of algorithms like merge sort, quicksort, DFS on trees.

**Disadvantages**

* Extra call-stack memory (space complexity often higher than iterative).
* For naive recursion (e.g., naive Fibonacci) time complexity can be exponential due to repeated subproblems.
* In Java, tail-call optimization is not guaranteed—deep recursion can still overflow.

---

## 5. Common recursive patterns

* **Linear recursion:** each call makes one recursive call (e.g., factorial, linear search).
* **Binary recursion / tree recursion:** each call makes two (or more) recursive calls (e.g., naive Fibonacci, quicktree).
* **Tail recursion:** recursive call is the last action (theoretically optimizable).
* **Divide & conquer:** split problem, recursively solve parts, combine results (merge sort).
* **Backtracking:** recursion + undo steps (N-Queens, permutations).

---

## 6. Worked examples — code + visualization

### 6.1 Factorial (classic linear recursion)

**Definition:** `n! = n * (n-1)!`, base case `0! = 1`.

```java
public static int factorial(int n) {
    if (n == 0) return 1;        // base case
    return n * factorial(n - 1); // recursive case
}
```

**Recursion tree / call stack for `factorial(4)`**

```
factorial(4)
  └─ returns 4 * factorial(3)
       factorial(3)
         └─ returns 3 * factorial(2)
              factorial(2)
                └─ returns 2 * factorial(1)
                     factorial(1)
                       └─ returns 1 * factorial(0)
                            factorial(0) -> returns 1  (base)
                       factorial(1) -> returns 1 * 1 = 1
                factorial(2) -> returns 2 * 1 = 2
         factorial(3) -> returns 3 * 2 = 6
  factorial(4) -> returns 4 * 6 = 24
```

**Complexities:** Time O(n), Space O(n) (stack depth n).

---

### 6.2 Naive Fibonacci (binary recursion)

```java
public static int fib(int n) {
    if (n <= 1) return n;
    return fib(n-1) + fib(n-2);
}
```

**Recursion tree for `fib(4)`**

```
fib(4)
├─ fib(3)
│  ├─ fib(2)
│  │  ├─ fib(1) -> 1
│  │  └─ fib(0) -> 0
│  └─ fib(1) -> 1
└─ fib(2)
   ├─ fib(1) -> 1
   └─ fib(0) -> 0

Result: fib(4) = 3
```

**Observations**

* Many repeated subcalls (e.g., `fib(2)` computed multiple times).
* Time complexity: **exponential** O(φⁿ) roughly (φ ≈ 1.618).
* Space complexity: O(n) (stack depth equals n).

**Fix:** use **memoization** or iterative DP to avoid repeated work.

---

### 6.3 Tail recursion (factorial example)

Tail recursion places the result accumulation in a parameter so the recursive call is the last action:

```java
public static int factTail(int n, int acc) {
    if (n == 0) return acc;
    return factTail(n - 1, acc * n); // tail call
}

// helper
public static int factorial(int n) {
    return factTail(n, 1);
}
```

**Important note (Java):** Java does *not* guarantee tail-call optimization, so tail recursion still uses stack frames in most Java runtimes. It is more useful conceptually and in languages/runtimes that optimize tail calls (e.g., some functional languages).

---

## 7. Memoization & dynamic programming (avoid recomputation)

**Memoization:** store results of subproblems so repeated calls return cached values.

Example: memoized Fibonacci

```java
public static int fibMemo(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    memo[n] = fibMemo(n-1, memo) + fibMemo(n-2, memo);
    return memo[n];
}

// call
int n = 40;
int[] memo = new int[n+1];
Arrays.fill(memo, -1);
int result = fibMemo(n, memo);
```

**Complexity:** Time O(n), Space O(n).

---

## 8. Convert recursion ↔ iteration

* Any recursion can be implemented iteratively using an explicit stack data structure (simulate call frames).
* Many recursive algorithms (factorial, Fibonacci with accumulation, binary search) are straightforward to convert to loops.
* Recursive code can be simpler/readable; iterative can be more memory-efficient (no call stack).

---

## 9. Debugging & visualizing recursion — practical tips

1. **Draw the recursion tree** on paper for small inputs (n=3,4) to see the call structure.
2. **Use a debugger** (breakpoints, step-into) to watch frames pushed/popped and variable values.
3. **Print trace statements** at entry and exit of functions:

   ```java
   void f(int n) {
       System.out.println("enter f(" + n + ")");
       ...
       System.out.println("exit f(" + n + ")");
   }
   ```

   That gives a textual stack trace order.
4. **Check base cases first** — ensure they are reached and correct.
5. **Track state changes**: avoid global mutable state; prefer passing parameters.

---

## 10. Variables, parameters, and recursion semantics

* **Parameters** and **local variables** are stored in each call frame; they are independent between calls.
* Java method arguments are **pass-by-value**:

  * For primitives: the value is copied.
  * For objects: the reference is copied (both frames may refer to the same object if passed).
* **Avoid global mutable variables** in recursion; they create subtle bugs when multiple frames mutate shared state.
* Use return values and parameters to thread state through recursion.

---

## 11. Recursion design checklist — how to approach a recursive problem

1. **Identify if it can be broken** into smaller subproblems of the same type.
2. **Define base case(s):** trivial instances you can answer directly.
3. **Define recursive case:** how to reduce the problem and combine results.
4. **Ensure progress:** each recursive call should move toward base case.
5. **Draw recursion tree / stack** for small inputs to verify flow and correctness.
6. **Consider complexity:** are subproblems overlapping? If yes, plan memoization.
7. **Decide state passing:** parameters vs return values; avoid global mutation.
8. **Edge cases:** empty input, null, extremely large input (stack risk).

---

## 12. Common recursion patterns & interview examples

* **Divide and conquer:** MergeSort, QuickSort.
* **Binary search (recursive):** split search interval.
* **Tree traversal:** pre/in/post-order using recursion (natural fit).
* **Backtracking:** generate combinations, permutations, N-queens.
* **DP via recursion + memoization:** knapsack, Fibonacci, unique paths.

---

## 13. Binary search (recursive) — explanation + code + execution flow

Binary search is a textbook recursive divide-and-conquer:

**Algorithm steps**

1. Compare target with middle element.
2. If equal → return index (base-case success).
3. If target < mid → recursively search left half.
4. Else → recursively search right half.
5. If interval empty (s > e) → return -1 (not found).

**Code (you provided):**

```java
package com.kunal.intro;

public class BS {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 55, 66, 78};
        int target = 78;
        System.out.println(search(arr, target, 0, arr.length - 1));
    }

    static int search(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (target < arr[m]) {
            return search(arr, target, s, m - 1);
        }
        return search(arr, target, m + 1, e);
    }
}
```

### Execution flow for this specific input

`arr = {1,2,3,4,55,66,78}`, `target = 78`, initial `s=0, e=6`.

We will step through calls and show call-stack frames and returns.

**Call sequence and values:**

1. `search(arr, 78, 0, 6)`

   * `m = 0 + (6-0)/2 = 3`
   * `arr[3] = 4` → 4 != 78 and 78 > 4 → recurse right half
   * Calls `search(arr, 78, 4, 6)`

2. `search(arr, 78, 4, 6)`

   * `m = 4 + (6-4)/2 = 5`
   * `arr[5] = 66` → 66 != 78 and 78 > 66 → recurse right half
   * Calls `search(arr, 78, 6, 6)`

3. `search(arr, 78, 6, 6)`

   * `m = 6 + (6-6)/2 = 6`
   * `arr[6] = 78` → equal → return `6`

Then returns unwind:

* return `6` to caller `search(arr,78,4,6)` → returns `6`
* return `6` to original `search(arr,78,0,6)` → returns `6`
* main prints `6`.

**ASCII call-stack trace (frames top→bottom = top is most recent call):**

```
[bottom] main() calls search(arr,78,0,6)
  frame A: search(arr,78,s=0,e=6)   // m=3 arr[3]=4 -> calls right
    frame B: search(arr,78,s=4,e=6) // m=5 arr[5]=66 -> calls right
      frame C: search(arr,78,s=6,e=6) // m=6 arr[6]=78 -> found -> return 6
      frame B receives return 6 -> returns 6
    frame A receives return 6 -> returns 6
main prints 6
[stack empty]
```

**Simplified vertical layout (push then pop):**

```
push: search(0,6)       // m=3
push: search(4,6)       // m=5
push: search(6,6)       // m=6 -> found -> return 6
pop -> return to search(4,6) -> return 6
pop -> return to search(0,6) -> return 6
pop -> main receives 6 and prints
```

**Complexity**

* Time: O(log n)
* Space: O(log n) stack frames (recursive depth)
* Note: For iterative binary search, space would be O(1).

---

## 14. Execution flow diagram (ASCII) for binary search code — fuller view

```
main()
└─> search(arr,78,0,6)
     m = 3 (arr[3]=4)
     target > 4
     └─> search(arr,78,4,6)
           m = 5 (arr[5]=66)
           target > 66
           └─> search(arr,78,6,6)
                 m = 6 (arr[6]=78)
                 found -> return 6
           <- return 6
     <- return 6
main prints 6
```

---

## 15. Additional practical notes & best practices

* **Always** write and verify base case(s) first.
* For binary recursion (two recursive calls), consider whether **memoization** is needed (e.g., Fibonacci).
* **Prefer iterative implementations** when recursion depth could be large and cause StackOverflow (or convert recursion to an explicit stack).
* When writing recursive code for trees/graphs, **track visited nodes** to prevent infinite recursion (cycles).
* For heavy recursion in Java, consider increasing stack size (not a best fix) or rewrite iteratively.

---

## 16. Memory / complexity summary cheatsheet

| Example             | Time complexity   | Recursion (stack) space                    |
| ------------------- | ----------------- | ------------------------------------------ |
| Factorial (n)       | O(n)              | O(n)                                       |
| Naive Fibonacci     | O(φⁿ) exponential | O(n) depth                                 |
| Fibonacci with memo | O(n)              | O(n)                                       |
| Binary search       | O(log n)          | O(log n)                                   |
| Merge sort          | O(n log n)        | O(log n) recursion depth + O(n) merge temp |
| Tree DFS (n nodes)  | O(n)              | O(h) where h is tree height                |

---

## 17. Extra examples (snippets) — iterative equivalents & memoization

**Iterative binary search (no recursion, O(1) space):**

```java
static int binarySearchIter(int[] arr, int target) {
    int s = 0, e = arr.length - 1;
    while (s <= e) {
        int m = s + (e - s) / 2;
        if (arr[m] == target) return m;
        if (target < arr[m]) e = m - 1;
        else s = m + 1;
    }
    return -1;
}
```

**Memoized Fibonacci (compact):**

```java
static int fibMemo(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    memo[n] = fibMemo(n-1, memo) + fibMemo(n-2, memo);
    return memo[n];
}
```

---

## 18. Final checklist for writing correct recursion solutions

1. Identify the **base case(s)** clearly.
2. Decide the **recursive relation** (how to reduce problem).
3. Ensure each recursive call **progresses** toward base case.
4. Determine **what to return** and how to combine child results.
5. Decide whether **memoization** is required (overlapping subproblems).
6. Consider **stack depth** — can input cause too deep recursion?
7. Prefer parameters or returned values over global mutation.
8. Test with small values and trace the recursion tree.

---

