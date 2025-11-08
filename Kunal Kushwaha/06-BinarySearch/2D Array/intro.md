
---

# **Searching in a Sorted 2D Array — Detailed Notes**

---

## **Case 1: Matrix Sorted Row-wise and Column-wise**

### **Problem Statement**

You are given a 2D matrix (sorted in ascending order **both row-wise and column-wise**), and you need to check whether a target element exists in it.

Each row and each column is sorted in ascending order.

Example:

```
1   4   7   11
2   5   8   12
3   6   9   16
10 13  14   17
```

---

### **Key Idea**

Start the search from the **top-right corner** of the matrix.

Why top-right?

* From this position, you can easily decide whether to move **down** or **left**:

  * Moving **down** → elements increase (since columns are sorted)
  * Moving **left** → elements decrease (since rows are sorted)

---

### **Algorithm Logic**

1. Let `r = 0` (start row), `c = cols - 1` (last column).
2. While `r < rows` and `c >= 0`:

   * Let `element = matrix[r][c]`
   * Compare:

     1. **If `element == target`:**
        → Found, return `true`
     2. **If `element < target`:**
        → Move **down** (`r++`) to next row, since all elements below are larger.
     3. **If `element > target`:**
        → Move **left** (`c--`) to previous column, since all elements right of this are even larger.
3. If loop ends, element not found → return `false`.

---

### **Example Execution**

Matrix:

```
1  3  5  7
2  4  6  8
9 10 11 12
```

Target = 10

Start from **top-right corner**: (r=0, c=3) → element = 7
→ 7 < 10 → move **down**
(r=1, c=3) → element = 8
→ 8 < 10 → move **down**
(r=2, c=3) → element = 12
→ 12 > 10 → move **left**
(r=2, c=2) → element = 11
→ 11 > 10 → move **left**
(r=2, c=1) → element = 10 → **Found**

---

### **Pseudocode**

```java
boolean searchMatrix(int[][] matrix, int target) {
    int r = 0;
    int c = matrix[0].length - 1;
    while (r < matrix.length && c >= 0) {
        int element = matrix[r][c];
        if (element == target) return true;
        else if (element < target) r++;
        else c--;
    }
    return false;
}
```

---

### **Time and Space Complexity**

| Operation | Complexity                                                                 |
| --------- | -------------------------------------------------------------------------- |
| Time      | **O(n + m)** (worst case — at most one full row + one full column scanned) |
| Space     | **O(1)**                                                                   |

---

### **ASCII Flow**

```
Start at top-right (1,3)
↓ if smaller
← if larger

     c0  c1  c2  c3
r0 → [1   3   5   7]
r1 → [2   4   6   8]
r2 → [9  10  11  12]
```

Path for target = 10:
(0,3) → (1,3) → (2,3) → (2,2) → (2,1)

---

## **Case 2: Matrix Fully Sorted (Purely Sorted Flattened Matrix)**

### **Example Matrix**

```
1   2   3   4
5   6   7   8
9  10  11  12
```

Here, the entire matrix behaves like a single sorted list if flattened row-wise.

---

### **Approach 1: Binary Search in Each Row**

If each row is sorted but independent:

1. Perform binary search in each row.
2. Stop if found, else move to the next row.

Pseudocode:

```java
boolean searchMatrix(int[][] matrix, int target) {
    for (int[] row : matrix) {
        if (binarySearch(row, target)) return true;
    }
    return false;
}
```

This gives **O(n log m)** time complexity.

---

### **Approach 2: Treat 2D Matrix as 1D Array (Optimized Binary Search)**

We can flatten the matrix conceptually into a single sorted array.

For `matrix[row][col]`, its 1D index is:

```
index = row * cols + col
```

and vice versa:

```
row = index / cols
col = index % cols
```

---

### **Algorithm**

1. Let `low = 0`, `high = rows * cols - 1`
2. While `low <= high`:

   * `mid = (low + high) / 2`
   * Map `mid` back to 2D coordinates:

     * `r = mid / cols`
     * `c = mid % cols`
   * Compare `matrix[r][c]` with target:

     * if equal → found
     * if smaller → `low = mid + 1`
     * if greater → `high = mid - 1`

---

### **Example**

```
Matrix:
1  2  3  4
5  6  7  8
9 10 11 12
Target = 11
```

Flattened (conceptually):

```
index: 0  1  2  3  4  5  6  7  8  9  10  11
value: 1  2  3  4  5  6  7  8  9 10  11  12
```

Binary search just like a 1D array.

---

### **Pseudocode**

```java
boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int low = 0, high = rows * cols - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        int r = mid / cols;
        int c = mid % cols;

        if (matrix[r][c] == target) return true;
        else if (matrix[r][c] < target) low = mid + 1;
        else high = mid - 1;
    }
    return false;
}
```

---

### **Time & Space Complexity**

| Operation | Complexity        |
| --------- | ----------------- |
| Time      | **O(log(n × m))** |
| Space     | **O(1)**          |

---

### **Approach 3: Binary Search + Partitioning (For Advanced Scenarios)**

If matrix is sorted **both row-wise and column-wise**, but not fully flattened, you can divide the matrix into **4 submatrices (quarters)** and discard impossible ones recursively.

When only **2 rows remain**, consider the **4 halves** of the remaining submatrix.

```
Mid divides the matrix:

+----------+----------+
|          |          |
|   Q1     |   Q2     |
|          |          |
+----------+----------+
|          |          |
|   Q3     |   Q4     |
|          |          |
+----------+----------+
```

Based on the mid-element comparison, decide which quadrants to keep or eliminate.

This divide-and-conquer method (used in "Search in 2D Matrix II" — LeetCode 240) yields average **O(n + m)** or better.

---

# **Summary Table**

| Matrix Type                | Strategy                  | Starting Point     | Movement      | Time        | Space |
| -------------------------- | ------------------------- | ------------------ | ------------- | ----------- | ----- |
| Row-wise & Col-wise Sorted | Staircase search          | Top-right          | Down or Left  | O(n + m)    | O(1)  |
| Fully Sorted (Row-major)   | Binary search (flattened) | Middle (mid index) | Divide halves | O(log(n×m)) | O(1)  |
| Only Row-wise Sorted       | Binary search each row    | Start of each row  | Left/Right    | O(n log m)  | O(1)  |

---

# **ASCII Flow Summary**

### **Case 1: Staircase Search**

```
r=0, c=cols-1
↓  if target > element
←  if target < element
✔  if target == element
```

### **Case 2: Flattened Binary Search**

```
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
             ↑
         mid element
→ Compare and adjust low/high
```

### **Case 3: Divide & Conquer (2 Rows Remaining)**

```
[  1   3   5   7 ]
[  9  11  13  15 ]

Split into halves and compare with mid points
```

---

### **Interview Takeaways**

1. Always identify **matrix sorting pattern** first — row-wise only, row+column-wise, or fully flattened.
2. For row+column sorted → Staircase Search (**O(n+m)**).
3. For fully sorted → Flattened Binary Search (**O(log n×m)**).
4. For custom sorting or non-uniform structure → Divide & Conquer approach.
5. Understand index mapping for flattening and how `mid / cols` and `mid % cols` work.

---

