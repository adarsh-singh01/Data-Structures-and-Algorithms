
---

# **SELECTION SORT — Detailed Notes**

---

## **1. Real-World Analogy (Intuition)**

Imagine you are sorting a deck of cards placed face up on a table.

* You look through **all the cards** to find the **smallest one**.
* You **pick it up** and **place it at the beginning**.
* Then, from the remaining unsorted cards, you again find the smallest and place it next.
* You repeat this until all cards are in order.

That’s **Selection Sort**.

You "select" the minimum element and place it in its correct position during each pass.

---

## **2. Definition**

**Selection Sort** is a comparison-based algorithm that divides the array into two parts:

1. **Sorted portion** (at the beginning)
2. **Unsorted portion** (the rest)

At each step, it:

* Finds the **minimum element** from the unsorted portion
* Swaps it with the **first unsorted element**

---

## **3. Step-by-Step Working**

### **Example:**

```
arr = [5, 3, 1, 4, 2]
```

---

### **Pass 1**

Find the smallest element from index 0 → 4

```
Current min = 5  
Compare (5, 3) → min = 3  
Compare (3, 1) → min = 1  
Compare (1, 4) → min = 1  
Compare (1, 2) → min = 1
```

Swap smallest (1) with first element (5):

```
[1, 3, 5, 4, 2]
↑  sorted ↑
```

---

### **Pass 2**

Now find smallest from index 1 → 4

```
Current min = 3
Compare (3, 5) → min = 3  
Compare (3, 4) → min = 3  
Compare (3, 2) → min = 2
```

Swap (2, 3):

```
[1, 2, 5, 4, 3]
```

---

### **Pass 3**

Find smallest from index 2 → 4

```
Current min = 5
Compare (5, 4) → min = 4
Compare (4, 3) → min = 3
```

Swap (3, 5):

```
[1, 2, 3, 4, 5]
```

---

### **Pass 4**

Find smallest from index 3 → 4

```
Compare (4, 5) → min = 4
No swap needed
```

Array sorted.

---

### **Final Output:**

```
[1, 2, 3, 4, 5]
```

---

## **4. Control Flow (ASCII Diagram)**

```
Outer Loop (i = 0 → n-1)
│
├──> Assume minIndex = i
│     │
│     ├── Inner Loop (j = i+1 → n-1)
│     │       if arr[j] < arr[minIndex]
│     │            → update minIndex = j
│     │
│     └── After inner loop → swap arr[i] and arr[minIndex]
│
└── Repeat until array sorted
```

---

## **5. Java Implementation**

```java
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        selectionSort(arr);
        for (int n : arr) System.out.print(n + " ");
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            // find the smallest element in unsorted array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap the found minimum element with the first unsorted one
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
```

---

## **6. Example Execution Flow (ASCII)**

Let’s trace `arr = [5, 3, 1, 4, 2]`.

```
Initial:
[5, 3, 1, 4, 2]
 ↑
 i=0, minIndex=0

Find minimum from j=1→4:
minIndex=2 (value=1)
Swap arr[0], arr[2] → [1, 3, 5, 4, 2]
```

```
Pass 2:
[1, 3, 5, 4, 2]
     ↑
    i=1, minIndex=4 (value=2)
Swap arr[1], arr[4] → [1, 2, 5, 4, 3]
```

```
Pass 3:
[1, 2, 5, 4, 3]
        ↑
       i=2, minIndex=4 (value=3)
Swap arr[2], arr[4] → [1, 2, 3, 4, 5]
```

```
Pass 4:
[1, 2, 3, 4, 5]
           ↑
No swap needed
```

---

## **7. Time and Space Complexity**

| Case             | Description    | Time Complexity                      |
| ---------------- | -------------- | ------------------------------------ |
| **Best Case**    | Already sorted | **O(n²)** (still scans all elements) |
| **Average Case** | Random order   | **O(n²)**                            |
| **Worst Case**   | Reverse sorted | **O(n²)**                            |

**Space Complexity:** O(1) (in-place)

---

## **8. Characteristics**

| Property             | Description                                         |
| -------------------- | --------------------------------------------------- |
| **Algorithm Type**   | Comparison-based                                    |
| **Sorting In-place** | Yes                                                 |
| **Stable**           | ❌ **Unstable** (can change order of equal elements) |
| **Recursive**        | No                                                  |
| **Adaptive**         | No (doesn’t reduce work if partially sorted)        |
| **Use Case**         | Small datasets, educational purposes                |

---

## **9. Why is Selection Sort Unstable?**

**Unstable means** the relative order of equal elements may change after sorting.

### Example:

```
[(A, 2), (B, 2), (C, 1)]
```

Step 1: Find min (C, 1) → Swap with first element (A, 2):

```
[(C, 1), (B, 2), (A, 2)]
```

→ The order of `(A, 2)` and `(B, 2)` **is now reversed**.

Hence, **Selection Sort is Unstable.**

---

## **10. Stable vs Unstable Recap**

| Term         | Meaning                         | Example                  |
| ------------ | ------------------------------- | ------------------------ |
| **Stable**   | Equal elements maintain order   | Bubble, Insertion, Merge |
| **Unstable** | Equal elements may change order | Selection, Quick, Heap   |

---

## **11. Comparison: Bubble vs Selection Sort**

| Feature                    | **Bubble Sort**                        | **Selection Sort**              |
| -------------------------- | -------------------------------------- | ------------------------------- |
| **Working principle**      | Repeated swapping of adjacent elements | Finds minimum each pass         |
| **Pass behavior**          | Large elements bubble up each pass     | Small elements get placed first |
| **Swaps per pass**         | Many (depends on condition)            | At most 1                       |
| **Best Case Complexity**   | O(n) (if optimized)                    | O(n²)                           |
| **Worst Case Complexity**  | O(n²)                                  | O(n²)                           |
| **Stable?**                | Yes                                    | No                              |
| **Adaptive?**              | Yes (early stop possible)              | No                              |
| **Ease of implementation** | Very simple                            | Slightly more logic             |
| **Practical use**          | Visualization, educational             | Simple selection tasks          |

---

## **12. Detailed Control Flow Diagram**

```
for i = 0 to n-2:
   |
   +--> minIndex = i
   |      |
   |      +--> for j = i+1 to n-1:
   |               if arr[j] < arr[minIndex]:
   |                   minIndex = j
   |
   +--> swap arr[i] with arr[minIndex]
   |
   +--> next iteration (sorted portion grows)
```

---

## **13. Visual Flow (Conceptual)**

```
Initial: [5, 3, 1, 4, 2]
         |     |           find smallest
         ↓     ↓
After 1: [1, 3, 5, 4, 2]
After 2: [1, 2, 5, 4, 3]
After 3: [1, 2, 3, 4, 5]
Sorted : [1, 2, 3, 4, 5]
```

---

## **14. Conceptual Summary**

| Concept         | Description                                         |
| --------------- | --------------------------------------------------- |
| **Idea**        | Select smallest each pass, place in sorted position |
| **Moves**       | One swap per pass (less write operations)           |
| **Performance** | Consistently O(n²)                                  |
| **In-place**    | Yes                                                 |
| **Stable**      | No                                                  |
| **Useful for**  | Small arrays, educational demos, selection problems |

---

### **Intuition Recap**

> Bubble Sort — “largest bubbles up”
> Selection Sort — “smallest gets selected”

Both use nested loops and O(n²) time,
but Bubble Sort swaps frequently while Selection Sort minimizes swaps.

---

