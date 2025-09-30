
---

# Sorting Algorithms Explained in Detail

---

## 1. Selection Sort

### What is it?

Selection Sort is a simple sorting algorithm that works by repeatedly finding the smallest (or largest) element from the unsorted part of the array and swapping it with the first element of that unsorted part.

### How does it work?

* Start at the beginning of the array.
* Find the smallest element in the unsorted part.
* Swap it with the first unsorted element.
* Move the boundary of the sorted part by one to the right.
* Repeat until the whole array is sorted.

### Example:

```
Array: [64, 25, 12, 22, 11]

Step 1: Find minimum from [64, 25, 12, 22, 11] → 11
Swap 11 with 64 → [11, 25, 12, 22, 64]

Step 2: Find minimum from [25, 12, 22, 64] → 12
Swap 12 with 25 → [11, 12, 25, 22, 64]

Step 3: Find minimum from [25, 22, 64] → 22
Swap 22 with 25 → [11, 12, 22, 25, 64]

Step 4: Find minimum from [25, 64] → 25
Swap 25 with 25 → [11, 12, 22, 25, 64]

Sorted!
```

### Time Complexity:

* Best, Average, Worst: **O(n²)** because you always scan the remaining elements to find the minimum.

### Space Complexity:

* **O(1)** (in-place sorting).

---

## 2. Bubble Sort

### What is it?

Bubble Sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This "bubbling" process moves the largest unsorted element to its correct place in each iteration.

### How does it work?

* Compare each pair of adjacent elements.
* Swap them if they are in wrong order.
* Largest element moves ("bubbles") to the end after each pass.
* Repeat for remaining unsorted portion until no swaps are needed.

### Example:

```
Array: [5, 1, 4, 2, 8]

Pass 1:
Compare 5 and 1 → swap → [1, 5, 4, 2, 8]
Compare 5 and 4 → swap → [1, 4, 5, 2, 8]
Compare 5 and 2 → swap → [1, 4, 2, 5, 8]
Compare 5 and 8 → no swap → [1, 4, 2, 5, 8]

Pass 2:
Compare 1 and 4 → no swap
Compare 4 and 2 → swap → [1, 2, 4, 5, 8]
Compare 4 and 5 → no swap

Pass 3:
Compare 1 and 2 → no swap
Compare 2 and 4 → no swap

Sorted!
```

### Time Complexity:

* Worst and Average: **O(n²)**
* Best (if already sorted): **O(n)** (with optimization to stop early)

### Space Complexity:

* **O(1)**

---

## 3. Insertion Sort

### What is it?

Insertion Sort builds the sorted array one element at a time by repeatedly taking the next element and inserting it into the correct position within the sorted part.

### How does it work?

* Start with the second element.
* Compare it backward with sorted elements.
* Shift all larger sorted elements right.
* Insert the element at the right place.
* Repeat for all elements.

### Example:

```
Array: [12, 11, 13, 5, 6]

Start with [12] sorted.

Take 11:
Compare with 12 → 12 > 11, shift 12 right
Insert 11 → [11, 12]

Take 13:
Compare with 12 → 12 < 13, insert after 12 → [11, 12, 13]

Take 5:
Compare with 13 → shift 13 right
Compare with 12 → shift 12 right
Compare with 11 → shift 11 right
Insert 5 → [5, 11, 12, 13]

Take 6:
Compare with 13 → shift 13 right
Compare with 12 → shift 12 right
Compare with 11 → 11 < 6 no shift
Insert 6 → [5, 6, 11, 12, 13]

Sorted!
```

### Time Complexity:

* Worst and Average: **O(n²)**
* Best (already sorted): **O(n)**

### Space Complexity:

* **O(1)**

---

## 4. Merge Sort

### What is it?

Merge Sort is a divide-and-conquer algorithm that divides the array into halves, sorts each half recursively, and merges the sorted halves.

### How does it work?

* Divide array into two halves.
* Recursively sort both halves.
* Merge the two sorted halves.

### Example:

```
Array: [38, 27, 43, 3, 9, 82, 10]

Divide into [38, 27, 43, 3] and [9, 82, 10]

Sort left:
Divide into [38, 27] and [43, 3]
Sort [38, 27]:
Divide into [38] and [27]
Merge [27, 38]
Sort [43, 3]:
Divide into [43] and [3]
Merge [3, 43]
Merge [27, 38] and [3, 43] → [3, 27, 38, 43]

Sort right:
Divide into [9, 82] and [10]
Sort [9, 82]:
Divide into [9] and [82]
Merge [9, 82]
Merge [9, 82] and [10] → [9, 10, 82]

Merge [3, 27, 38, 43] and [9, 10, 82]
Final: [3, 9, 10, 27, 38, 43, 82]
```

### Time Complexity:

* Always **O(n log n)** due to splitting and merging.

### Space Complexity:

* **O(n)** additional space for merging.

---

## 5. Recursive Bubble Sort

### What is it?

Recursive Bubble Sort applies the bubble sort logic but uses recursion instead of loops.

### How does it work?

* Compare and swap adjacent elements as usual.
* After one pass, the largest element is at the end.
* Recursively call the function on the rest of the array (excluding the last sorted element).
* Base case when the array size is 1.

### Intuition:

Same idea as iterative Bubble Sort but written recursively.

---

## 6. Recursive Insertion Sort

### What is it?

Recursive Insertion Sort sorts the array recursively by:

* Sorting first n-1 elements.
* Inserting nth element at correct position.

### How does it work?

* Base case: array of size 1 is sorted.
* Recursively sort first n-1 elements.
* Insert nth element into sorted array.

### Intuition:

Same as iterative insertion sort, but the recursion takes care of sorting smaller subarrays.

---

## 7. Quick Sort

### What is it?

Quick Sort is a divide-and-conquer algorithm that picks a pivot and partitions the array such that:

* Elements less than pivot are on the left.
* Elements greater than pivot are on the right.
  Then recursively sorts the left and right parts.

### How does it work?

* Pick a pivot (commonly last element).
* Partition the array around the pivot.
* Recursively apply Quick Sort on left and right partitions.

### Example:

```
Array: [64, 25, 12, 22, 11]

Pick pivot = 11  
→ Left: []  
→ Right: [64, 25, 12, 22]  
→ Result: [11 + sort(right)]

Sort [64, 25, 12, 22]  
→ Pivot = 22  
→ Left: [12]  
→ Right: [64, 25]  
→ Result: [12 + 22 + sort(right)]

Sort [64, 25]  
→ Pivot = 25  
→ Left: []  
→ Right: [64]  
→ Result: [25, 64]

Final combined:  
[11, 12, 22, 25, 64]

```

### Time Complexity:

* Average: **O(n log n)**
* Worst (sorted or reverse sorted input with bad pivot): **O(n²)**

### Space Complexity:

* **O(log n)** on average for recursive stack (in-place sorting).

---

# Summary Table

| Algorithm                | Time Complexity (Best) | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity | Stable? |
| ------------------------ | ---------------------- | ------------------------- | ----------------------- | ---------------- | ------- |
| Selection Sort           | O(n²)                  | O(n²)                     | O(n²)                   | O(1)             | No      |
| Bubble Sort              | O(n)                   | O(n²)                     | O(n²)                   | O(1)             | Yes     |
| Insertion Sort           | O(n)                   | O(n²)                     | O(n²)                   | O(1)             | Yes     |
| Merge Sort               | O(n log n)             | O(n log n)                | O(n log n)              | O(n)             | Yes     |
| Recursive Bubble Sort    | Same as Bubble Sort    | Same as Bubble Sort       | Same as Bubble Sort     | O(n) recursion   | Yes     |
| Recursive Insertion Sort | Same as Insertion Sort | Same as Insertion Sort    | Same as Insertion Sort  | O(n) recursion   | Yes     |
| Quick Sort               | O(n log n)             | O(n log n)                | O(n²)                   | O(log n)         | No      |

---
