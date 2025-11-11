
---

# **PATTERN PROBLEMS IN JAVA — COMPLETE DETAILED NOTES**

---

## **1. Goal of Pattern Problems**

Pattern problems are exercises in:

* Understanding **nested loops (loop within loop)**.
* Practicing **space and element relations**.
* Strengthening **row-column logic thinking**.

They are not just printing tasks — they train your **loop visualization skills** and **mathematical relation mapping**.

---

## **2. The Golden Rules (Trick to Solve Any Pattern)**

### **Rule 1 → Outer Loop = Number of Lines**

Each pattern has several *lines* (rows).
The outer loop runs exactly that many times.

```java
for (int row = 1; row <= totalRows; row++) {
    // inner loop code
}
```

---

### **Rule 2 → Inner Loop = Number of Columns**

For each row, there are certain *elements* to print.
The **inner loop** controls **how many columns (or stars/numbers/spaces)** to print in that row.

```java
for (int col = 1; col <= columnsInThisRow; col++) {
    // print the pattern element
}
```

---

### **Rule 3 → Print the Correct Element**

Inside the inner loop:

* Decide **what to print** (`*`, number, space, etc.).
* Usually based on relationship between `row` and `col`.

---

### **Rule 4 → Move to Next Line**

After inner loop ends, print a newline (`System.out.println();`).

---

### **Rule 5 → Find the Relation**

The **heart** of any pattern problem is to find:

> Relation between row number and column count.

Examples:

* If row = 3 → print 3 stars.
* If row = 4 → print 4 numbers.
* If row = i → print i spaces then 2*i - 1 stars.

---

## **3. General Template**

```java
for (int row = 1; row <= n; row++) {
    for (int col = 1; col <= someCondition; col++) {
        System.out.print("something");
    }
    System.out.println(); // move to next line
}
```

---

## **4. Detailed Example 1: Simple Star Pyramid**

```
*
**
***
****
***
**
*
```

---

### **Step-by-Step Logic**

| Step       | Description                                                         |
| ---------- | ------------------------------------------------------------------- |
| Outer loop | Controls rows (total 7 lines here)                                  |
| Inner loop | Controls number of stars in each row                                |
| Rule       | For first half → stars = row; for second half → stars = (2*n - row) |

---

### **Code**

```java
int n = 4; // height
for (int row = 1; row <= 2 * n - 1; row++) {
    int totalCols = row <= n ? row : (2 * n - row);
    for (int col = 1; col <= totalCols; col++) {
        System.out.print("*");
    }
    System.out.println();
}
```

---

### **Flow Visualization**

```
Row 1: *
Row 2: **
Row 3: ***
Row 4: ****
Row 5: ***
Row 6: **
Row 7: *
```

**ASCII Control Flow:**

```
for row = 1 to 7
│
├── compute totalCols
│   if row <= 4 → totalCols = row
│   else → totalCols = 8 - row
│
├── inner loop prints totalCols stars
└── println() → next line
```

---

## **5. Example 2: Diamond Star Pattern**

```
    *
   * *
  * * *
 * * * *
  * * *
   * *
    *
```

---

### **Logic Analysis**

| Phase          | Rows    | Spaces  | Stars |
| -------------- | ------- | ------- | ----- |
| Upper triangle | 1 → n   | n - row | row   |
| Lower triangle | n-1 → 1 | n - row | row   |

---

### **Code**

```java
int n = 4;

// Upper half
for (int row = 1; row <= n; row++) {
    for (int space = 1; space <= n - row; space++) {
        System.out.print(" ");
    }
    for (int col = 1; col <= row; col++) {
        System.out.print("* ");
    }
    System.out.println();
}

// Lower half
for (int row = n - 1; row >= 1; row--) {
    for (int space = 1; space <= n - row; space++) {
        System.out.print(" ");
    }
    for (int col = 1; col <= row; col++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

---

### **Flow Table**

| Row | Spaces | Stars |
| --- | ------ | ----- |
| 1   | 3      | 1     |
| 2   | 2      | 2     |
| 3   | 1      | 3     |
| 4   | 0      | 4     |
| 5   | 1      | 3     |
| 6   | 2      | 2     |
| 7   | 3      | 1     |

---

**ASCII Execution Flow**

```
row = 1 → print 3 spaces + 1 star
row = 2 → print 2 spaces + 2 stars
row = 3 → print 1 space  + 3 stars
row = 4 → print 0 space  + 4 stars
...
then mirror downwards
```

---

## **6. Example 3: Number Diamond Pattern**

```
    1
  2 1 2
3 2 1 2 3
  2 1 2
    1
```

---

### **Logic Breakdown**

This pattern has **two parts** — upper and lower.

| Row | Spaces | Numbers (Decreasing then Increasing) |
| --- | ------ | ------------------------------------ |
| 1   | 2      | 1                                    |
| 2   | 1      | 2 1 2                                |
| 3   | 0      | 3 2 1 2 3                            |
| 4   | 1      | 2 1 2                                |
| 5   | 2      | 1                                    |

---

### **Detailed Steps**

For upper half (`1 → n`):

1. Print spaces → `(n - row)`
2. Print decreasing numbers from `row` down to `1`.
3. Print increasing numbers from `2` up to `row`.

Then mirror the same logic in reverse for the lower half.

---

### **Code**

```java
int n = 3;

// Upper half
for (int row = 1; row <= n; row++) {
    for (int s = 1; s <= n - row; s++) System.out.print("  ");
    for (int col = row; col >= 1; col--) System.out.print(col + " ");
    for (int col = 2; col <= row; col++) System.out.print(col + " ");
    System.out.println();
}

// Lower half
for (int row = n - 1; row >= 1; row--) {
    for (int s = 1; s <= n - row; s++) System.out.print("  ");
    for (int col = row; col >= 1; col--) System.out.print(col + " ");
    for (int col = 2; col <= row; col++) System.out.print(col + " ");
    System.out.println();
}
```

---

### **Flow Visualization**

```
Row 1 → "    1"
Row 2 → "  2 1 2"
Row 3 → "3 2 1 2 3"
Row 4 → "  2 1 2"
Row 5 → "    1"
```

---

**ASCII Control Flow Summary**

```
for each row
│
├── print (n - row) spaces
├── print decreasing numbers from row to 1
├── print increasing numbers from 2 to row
└── newline
```

---

## **7. Example 4: Advanced Number Box Pattern**

```
4444444
4333334
4322234
4321234
4322234
4333334
4444444
```

---

### **Logic Behind It**

This is a **square matrix** of size `2*n - 1` (here n=4 → size=7).

Each cell’s value depends on **how far it is from the edges**.

---

### **Formula:**

For any position `(i, j)`:

```
value = n - min(min(i, j), min(size-1 - i, size-1 - j))
```

Where `i` and `j` are **0-based indices**.

---

### **Code**

```java
int n = 4;
int size = 2 * n - 1;

for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
        int minDist = Math.min(Math.min(i, j), Math.min(size - 1 - i, size - 1 - j));
        System.out.print(n - minDist);
    }
    System.out.println();
}
```

---

### **Visualization**

Outer layer → 4
Next layer → 3
Then 2
Then 1 (center)

```
Layer view:
4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4
```

---

**ASCII Flow**

```
for each cell (i,j)
│
├── compute distance from top (i)
├── compute distance from left (j)
├── compute distance from bottom (size-1-i)
├── compute distance from right (size-1-j)
│
└── min distance → subtract from n
```

---

## **8. Common Observations**

| Pattern Type        | Relation                             | Example |
| ------------------- | ------------------------------------ | ------- |
| Increasing Triangle | Col = Row                            | `*`     |
| Decreasing Triangle | Col = n - Row + 1                    | `*`     |
| Pyramid             | Spaces = n - Row, Stars = 2*Row - 1  | `*`     |
| Diamond             | Combine pyramid + inverted pyramid   | `*`     |
| Number Pyramid      | Print decreasing + increasing values | Numbers |
| Square Matrix       | Based on distance from edges         | Numbers |

---

## **9. Common Pitfalls**

1. Forgetting to print newline (`System.out.println()`).
2. Using wrong loop boundaries (`<=` vs `<`).
3. Mixing row/col logic (spaces vs stars).
4. Forgetting to reset space counters.
5. Confusing 1-based and 0-based indexing.

---

## **10. Control Flow Template (Universal)**

```
for row = 1 → totalRows
│
├── print spaces (if any)
│
├── print symbols/numbers
│
└── println() to move to next line
```

---

## **11. Practice Strategy**

Start with **simple triangles**, then **centered pyramids**, then **numeric diamonds**, finally **layered boxes**.

Progression:

1. Simple right triangle
2. Inverted triangle
3. Full pyramid
4. Diamond
5. Number diamond
6. Hollow patterns
7. Concentric squares (like last pattern)

---

## **12. Summary Table**

| Pattern           | Formula for columns                | Formula for spaces | Notes    |   |             |
| ----------------- | ---------------------------------- | ------------------ | -------- | - | ----------- |
| Right triangle    | `col <= row`                       | none               | basic    |   |             |
| Inverted triangle | `col <= n - row + 1`               | none               | basic    |   |             |
| Pyramid           | `col <= 2*row - 1`                 | `n - row`          | centered |   |             |
| Diamond           | combine pyramid + inverted pyramid | `                  | n - row  | ` | symmetrical |
| Number diamond    | decrease then increase             | `n - row`          | complex  |   |             |
| Square box        | based on edge distance             | none               | advanced |   |             |

---

## **13. Final Control Flow (ASCII)**

```
+-------------------------------------------+
| OUTER LOOP → Controls Rows (1..N)         |
|   INNER LOOP #1 → Controls Spaces         |
|   INNER LOOP #2 → Controls Characters     |
|   print newline after each row            |
+-------------------------------------------+
```

---

## **14. Key Takeaways**

✅ Always start by identifying:

* How many rows?
* How many elements per row?
* What’s the pattern of change (increase/decrease)?

✅ Try to express columns/spaces/stars as **functions of row**.

✅ Break complex patterns into:

* Upper and lower halves
* Left and right sides
* Layers

✅ Dry-run small values (like n=3) to visualize behavior.

---

