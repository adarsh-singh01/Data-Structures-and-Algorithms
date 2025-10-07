
---

## 🧠 What is Binary Search?

**Binary Search** is a highly efficient algorithm used to find the position (index) of a **target element** in a **sorted array**.
It works by repeatedly dividing the search interval in half — hence the term "binary".

---

### ✅ **Preconditions for Binary Search:**

* The array must be **sorted** in either **ascending** or **descending** order.
* Binary Search works only on such sorted arrays.

---

## 🔍 How Does Binary Search Work?

Let’s say we have a sorted array:

```java
int[] arr = {2, 4, 6, 9, 11, 12, 14, 20, 36, 48};
int target = 14;
```

### Steps:

1. Start with two pointers:

   * `start = 0` (beginning of the array)
   * `end = arr.length - 1` (last index)

2. Find the middle index:

   ```java
   int mid = start + (end - start) / 2;
   ```

3. Compare the target with `arr[mid]`:

   * If target == `arr[mid]`, return `mid` (element found).
   * If target < `arr[mid]`, search in the **left half** (`end = mid - 1`).
   * If target > `arr[mid]`, search in the **right half** (`start = mid + 1`).

4. Repeat the process until `start > end`.

5. If not found, return `-1`.

---

## ⏱️ Time Complexity

| Case    | Time Complexity |
| ------- | --------------- |
| Best    | O(1)            |
| Average | O(log n)        |
| Worst   | O(log n)        |

* Much faster than linear search (O(n)), especially for large arrays.

---

## 🔁 Order-Agnostic Binary Search

### ❓ What is it?

A **variation of binary search** that works even when the array is sorted in **descending** order instead of ascending.

### 🧠 Why do we need it?

Sometimes, we don't know whether the array is sorted in ascending or descending order.
In that case, a regular binary search **may give wrong results**.

---

## 🧮 Algorithm for Order-Agnostic Binary Search

1. **Check array order:**

   ```java
   boolean isAsc = arr[start] < arr[end];
   ```

2. Apply binary search **with direction logic based on `isAsc`:**

   * If `isAsc` is true, proceed like normal binary search.
   * If false, reverse the comparisons:

     * If `target < arr[mid]`, go **right**
     * If `target > arr[mid]`, go **left**

---

### ✅ Java Code for Order-Agnostic Binary Search:

```java
public static int orderAgnosticBS(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    // Find whether the array is ascending or descending
    boolean isAsc = arr[start] < arr[end];

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (isAsc) {
            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if (target > arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    return -1; // Target not found
}
```

---

## ✅ Example Usage

### Ascending array:

```java
int[] arr1 = {1, 3, 5, 7, 9};
int index = orderAgnosticBS(arr1, 7);  // Output: 3
```

### Descending array:

```java
int[] arr2 = {9, 7, 5, 3, 1};
int index = orderAgnosticBS(arr2, 7);  // Output: 1
```

---

## 📌 Summary

| Feature                  | Binary Search       | Order-Agnostic Binary Search |
| ------------------------ | ------------------- | ---------------------------- |
| Requires sorted array    | Yes                 | Yes                          |
| Handles both sort orders | No (only ascending) | Yes                          |
| Time Complexity          | O(log n)            | O(log n)                     |
| Space Complexity         | O(1)                | O(1)                         |

---
