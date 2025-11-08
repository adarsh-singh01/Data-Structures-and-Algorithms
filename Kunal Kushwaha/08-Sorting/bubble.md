
---

# **BUBBLE SORT — Detailed Notes**

---

## **1. Why Bubble Sort? (Intuition + Real-World Analogy)**

### **Analogy**

Imagine you have a row of **soap bubbles of different sizes** in water.
If you repeatedly compare adjacent bubbles and swap them so that the bigger one “floats” to the top after each pass, eventually all the biggest bubbles rise in order.

That’s **Bubble Sort** — the heaviest (largest) elements “bubble up” to their correct position after each pass.

---

### **Why Learn Bubble Sort**

* **Foundation for understanding sorting mechanics:** It introduces the idea of *pairwise comparison* and *iteration over passes*.
* **Helps visualize optimization concepts:** Early stopping (when array already sorted).
* **Used in education:** Great for understanding *time complexity*, *stability*, and *in-place sorting*.
* **Not used in production:** Inefficient for large datasets, but conceptually simple.

---

## **2. Definition**

**Bubble Sort** is a simple comparison-based algorithm where adjacent elements are compared and swapped if they are in the wrong order.
After each full pass through the array, the largest unsorted element "bubbles up" to its correct position.

---

### **Process Description**

1. Start from the beginning of the array.
2. Compare each pair of adjacent elements (`arr[i]` and `arr[i+1]`).
3. If `arr[i] > arr[i+1]`, swap them.
4. After first pass, the **largest element is at the end**.
5. Repeat the process for remaining elements (ignoring the last sorted one).
6. Stop when no swaps are needed (array is sorted).

---

## **3. Other Names of Bubble Sort**

| Name              | Meaning                                                  |
| ----------------- | -------------------------------------------------------- |
| **Sinking Sort**  | Because smaller elements “sink” to the bottom each pass. |
| **Exchange Sort** | Because it repeatedly *exchanges* adjacent elements.     |

---

## **4. Example with Step-by-Step Execution**

### **Input**

```
arr = [5, 3, 1, 4, 2]
```

---

### **Pass 1**

Compare and swap adjacent elements:

```
[5, 3, 1, 4, 2]
 ↑  ↑
Compare (5 > 3) → swap → [3, 5, 1, 4, 2]

[3, 5, 1, 4, 2]
    ↑  ↑
Compare (5 > 1) → swap → [3, 1, 5, 4, 2]

[3, 1, 5, 4, 2]
       ↑  ↑
Compare (5 > 4) → swap → [3, 1, 4, 5, 2]

[3, 1, 4, 5, 2]
          ↑  ↑
Compare (5 > 2) → swap → [3, 1, 4, 2, 5]
```

→ Largest element `5` bubbled to end.

---

### **Pass 2**

Now last element is sorted; only check till `n-2`.

```
[3, 1, 4, 2, |5|]
 ↑  ↑
Swap 3>1 → [1, 3, 4, 2, 5]

[1, 3, 4, 2, 5]
      ↑  ↑
Swap 4>2 → [1, 3, 2, 4, 5]
```

→ Second largest element `4` in correct position.

---

### **Pass 3**

```
[1, 3, 2, |4, 5|]
 ↑  ↑
No swap (1<3)
      ↑  ↑
Swap 3>2 → [1, 2, 3, 4, 5]
```

→ Now sorted!

---

### **Pass 4**

No swaps → stop early (optimization).

---

### **Final Sorted Array**

```
[1, 2, 3, 4, 5]
```

---

## **5. ASCII Flow Diagram of Control**

```
Outer loop → pass = 1 to n-1
    |
    v
+--------------------------------+
| Inner loop → i = 0 to n-pass-1 |
|   Compare arr[i], arr[i+1]     |
|   if arr[i] > arr[i+1]: swap   |
+--------------------------------+
          ↓
   If no swaps in this pass
   → Array already sorted → break
```

---

## **6. Java Implementation**

```java
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        bubbleSort(arr);
        for (int n : arr) System.out.print(n + " ");
    }

    static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, stop early
            if (!swapped) break;
        }
    }
}
```

---

## **7. Time and Space Complexity**

| Case             | Description             | Time Complexity             |
| ---------------- | ----------------------- | --------------------------- |
| **Best Case**    | Array already sorted    | **O(n)** (1 pass, no swaps) |
| **Average Case** | Random order            | **O(n²)**                   |
| **Worst Case**   | Array sorted in reverse | **O(n²)**                   |

**Space Complexity:** O(1) — In-place algorithm (no extra array used).

---

## **8. Stability in Sorting Algorithms**

### **Definition: Stable Sort**

A sorting algorithm is **stable** if two elements with the same key (value) appear in the **same relative order** before and after sorting.

Example:

```
Input:
[(A, 2), (B, 1), (C, 2)]

Stable Sort Output:
[(B, 1), (A, 2), (C, 2)]
→ A comes before C (same value 2, same order as input)
```

### **Unstable Sort Example**

```
Unstable Sort Output:
[(B, 1), (C, 2), (A, 2)]
→ C and A swapped (relative order lost)
```

---

### **Bubble Sort Stability**

✅ **Stable**, because it only swaps adjacent elements **if** the left one is strictly greater (`>`).
If equal (`==`), order remains unchanged.

---

## **9. Stable vs Unstable Sorting Algorithms**

| Algorithm          | Stable | Unstable |
| ------------------ | ------ | -------- |
| **Bubble Sort**    | ✅      |          |
| **Insertion Sort** | ✅      |          |
| **Merge Sort**     | ✅      |          |
| **Counting Sort**  | ✅      |          |
| **Radix Sort**     | ✅      |          |
| **Selection Sort** |        | ❌        |
| **Quick Sort**     |        | ❌        |
| **Heap Sort**      |        | ❌        |

---

## **10. Summary Table**

| Feature                             | Description                                               |
| ----------------------------------- | --------------------------------------------------------- |
| **Name**                            | Bubble Sort (a.k.a Sinking Sort / Exchange Sort)          |
| **Idea**                            | Repeatedly swap adjacent elements if they’re out of order |
| **Data Movement**                   | Heavy element “bubbles up” per pass                       |
| **Complexity (Best/Average/Worst)** | O(n) / O(n²) / O(n²)                                      |
| **Space Complexity**                | O(1)                                                      |
| **In-place**                        | Yes                                                       |
| **Stable**                          | Yes                                                       |
| **Practical Usage**                 | Teaching / Visualization, not used in real systems        |

---

## **11. Detailed Control Flow (ASCII Visualization)**

```
Outer Loop (Pass)
│
├──> Inner Loop (Compare Adjacent)
│      ├── If arr[j] > arr[j+1] → Swap
│      ├── Continue until last unsorted index
│      └── Largest element placed at end
│
├── Next Pass (ignore last sorted part)
│      └── Repeat until no swaps
│
└── Done → Array fully sorted
```

---

### **Intuitive Visualization**

```
Initial: [5, 3, 1, 4, 2]
Pass 1:  [3, 1, 4, 2, 5]
Pass 2:  [1, 3, 2, 4, 5]
Pass 3:  [1, 2, 3, 4, 5]
Sorted:  [1, 2, 3, 4, 5]
```

---

### **In Short**

> Bubble Sort repeatedly swaps adjacent elements if they’re in the wrong order.
> Each pass ensures one element reaches its final position,
> making it simple, stable, and educational — but inefficient for large data.

---
