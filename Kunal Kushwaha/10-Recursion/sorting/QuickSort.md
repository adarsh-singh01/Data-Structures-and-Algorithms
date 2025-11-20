
---

## 1. Notes: QuickSort 

### Intuition / Analogy

Imagine you’re trying to arrange students by height:

1. Pick one student as a **pivot**.
2. Ask everyone shorter than the pivot to stand on the left, and everyone taller to stand on the right.
3. Now the pivot is in a “correct zone”: everything left is ≤ pivot, everything right is ≥ pivot (not fully sorted yet).
4. Recursively repeat this process on the left group and the right group.

That’s QuickSort.

---

### Definition

**QuickSort** is a **divide-and-conquer** sorting algorithm that works by:

1. Choosing a **pivot** element.
2. **Partitioning** the array so elements smaller than pivot go to the left, larger ones to the right.
3. Recursively sorting the two partitions.

---

### Partition step (core idea)

The **partition** is the heart of QuickSort:

* After partitioning:

  * All elements `<= pivot` are on one side.
  * All elements `>= pivot` are on the other side.
* In many implementations, pivot ends up at its final sorted position.

Here, your implementation:

* Uses **middle element** as pivot:
  `pivot = nums[(low + high) / 2]`
* Uses **two pointers** `s` (start) and `e` (end) that move towards each other:

  * Move `s` forward while `nums[s] < pivot`.
  * Move `e` backward while `nums[e] > pivot`.
  * If `s <= e`, swap `nums[s]` and `nums[e]`, then `s++`, `e--`.
* After loop, `s` is the start of right partition, `e` is end of left partition.

Then you recursively sort:

* `sort(nums, low, e);`   → left segment
* `sort(nums, s, high);`  → right segment

This is a **Hoare-style partition** (not the Lomuto one you often see in textbooks).

---

### Pivot choices

You can choose pivot as:

* First element,
* Last element,
* Middle element (what your code does),
* Random element (helps avoid worst-case on many patterns).

---

### Time complexity (T(n) = T(k) + T(n-k-1) + O(n))

Let:

* n = size of current segment
* k = size of left side after partition
* n - k - 1 = size of right side

The recurrence:

```text
T(n) = T(k) + T(n - k - 1) + O(n)
```

because:

* You partition the array in O(n) time (one pass with swaps),
* Then recursively sort the left & right subarrays.

#### Worst case

If pivot is always very bad → all elements go to one side (`k = 0` or `k = n-1`):

```text
T(n) = T(n-1) + T(0) + O(n) ≈ T(n-1) + O(n) → O(n^2)
```

This happens if:

* Array is already sorted and pivot is chosen as first or last badly,
* Or you always pick a pivot that doesn’t split well.

#### Best / average case

If pivot splits array roughly in half → `k ≈ n/2`:

```text
T(n) ≈ 2T(n/2) + O(n) → O(n log n)
```

So:

* Best / expected: **O(n log n)**
* Worst: **O(n²)**

---

### Properties

1. **Not stable**
   Equal elements may change relative order due to swaps.

2. **In-place**
   Uses only O(log n) stack space (recursive calls) and constant extra for partitioning.
   No large extra arrays like MergeSort.

3. **When to use**:

   * Typically faster than merge sort for arrays in practice (cache-friendly, in-place).
   * Java `Arrays.sort()` for primitives uses a **dual-pivot quicksort** (Yaroslavskiy’s algorithm).

4. **Merge sort vs QuickSort**:

   * Merge sort: guaranteed O(n log n), stable, but needs O(n) extra space → great for linked lists.
   * QuickSort: in-place, average O(n log n), but possible O(n²) worst-case → great for arrays.

5. **Hybrid algorithms**:

   * TimSort: combination of merge sort and insertion sort (Python’s sort, Java’s sort for objects).
   * Quicksort often switches to insertion sort for very small subarrays.

---

## 2. Code with useful comments

Here is your code with comments added, behavior unchanged:

```java
import java.util.Arrays;

public class QuickSort {

    /*
     * QuickSort using Hoare-style partition with middle element as pivot.
     *
     * Idea:
     *  - Pick a pivot (here: middle element).
     *  - Reorder the array so that:
     *      all elements < pivot come before it,
     *      all elements > pivot come after it.
     *  - Then recursively sort left and right parts.
     *
     * Time complexity:
     *  - Best / Average: O(n log n)
     *  - Worst: O(n^2) (when partition is extremely unbalanced repeatedly)
     *
     * Space complexity:
     *  - O(log n) due to recursion stack (in-place partitioning).
     */

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr)); // Expect: [1, 2, 3, 4, 5]
    }

    // QuickSort on subarray nums[low..high] (inclusive)
    static void sort(int[] nums, int low, int high) {
        // Base case: segment has 0 or 1 element => already sorted
        if (low >= high) {
            return;
        }

        // s and e are scanning pointers from left and right
        int s = low;
        int e = high;

        // Middle index and pivot choice
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        // Partition: move s forward and e backward, swapping when needed
        while (s <= e) {

            // Move s right until nums[s] >= pivot
            // (elements < pivot will be on the left)
            while (nums[s] < pivot) {
                s++;
            }

            // Move e left until nums[e] <= pivot
            // (elements > pivot will be on the right)
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                // Swap elements that are on the wrong side of pivot
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;

                // Move both pointers
                s++;
                e--;
            }
        }

        // Now, 'e' is the end index of left partition,
        // and 's' is the start index of right partition.
        // Recursively sort the two partitions.
        sort(nums, low, e);
        sort(nums, s, high);
    }
}
```

---

## 3. ASCII Execution Flow on `[5,4,3,2,1]`

We call:

```java
sort(nums = [5,4,3,2,1], low = 0, high = 4)
```

### 3.1 First call: `sort([5,4,3,2,1], 0, 4)`

Initial:

```
nums = [5, 4, 3, 2, 1]
low  = 0, high = 4
s = 0, e = 4
m = 0 + (4-0)/2 = 2
pivot = nums[2] = 3
```

#### Partition loop

While `s <= e`:

---

**Iteration 1:**

`s = 0`, `e = 4`, `pivot = 3`

1. Move `s` right while `nums[s] < pivot`:

* nums[0] = 5 < 3? NO → stop, `s` stays 0.

2. Move `e` left while `nums[e] > pivot`:

* nums[4] = 1 > 3? NO → stop, `e` stays 4.

3. `s <= e`? → `0 <= 4` yes → swap `nums[0]` and `nums[4]`:

Before:

```
[5, 4, 3, 2, 1]
 ^           ^
 s=0         e=4
```

After swap:

```
[1, 4, 3, 2, 5]
 ^           ^
 s           e
```

Then:

* `s++` → s = 1
* `e--` → e = 3

---

**Iteration 2:**

`s = 1`, `e = 3`, pivot = 3

1. Move `s`:

* nums[1] = 4 < 3? NO → stop at s = 1.

2. Move `e`:

* nums[3] = 2 > 3? NO → stop at e = 3.

3. `s <= e`? → `1 <= 3` yes → swap `nums[1]` and `nums[3]`:

Before:

```
[1, 4, 3, 2, 5]
    ^     ^
    s=1   e=3
```

After swap:

```
[1, 2, 3, 4, 5]
    ^     ^
    s     e
```

Then:

* `s++` → s = 2
* `e--` → e = 2

---

**Iteration 3:**

`s = 2`, `e = 2`, pivot = 3

1. Move `s`:

* nums[2] = 3 < 3? NO → s stays 2.

2. Move `e`:

* nums[2] = 3 > 3? NO → e stays 2.

3. `s <= e`? → `2 <= 2` yes → swap `nums[2]` with itself (no change).

Array remains:

```
[1, 2, 3, 4, 5]
       ^
       s,e
```

Then:

* `s++` → 3
* `e--` → 1

---

**Loop ends** when `s <= e` is false ⇒ `3 <= 1`? no.

Now we have:

* `nums = [1,2,3,4,5]`
* `e = 1` → left partition end
* `s = 3` → right partition start

So we call:

```java
sort(nums, low = 0, high = e = 1);  // left side
sort(nums, low = s = 3, high = 4);  // right side
```

---

### 3.2 Left recursion: `sort([1,2,3,4,5], 0, 1)`

Segment = `[1,2]`

Setup:

```
s = 0, e = 1
m = 0 + (1-0)/2 = 0
pivot = nums[0] = 1
```

#### Partition on [1,2]:

**Iteration 1:**

`s=0,e=1,pivot=1`

1. Move `s`:

* nums[0] = 1 < 1? NO → s=0.

2. Move `e`:

* nums[1] = 2 > 1? YES → e=0.
* Now nums[0] = 1 > 1? NO -> stop.

3. `s <= e`? → `0 <= 0` yes → swap 0 with 0 (no change).
   Then `s=1,e=-1`.

Loop ends (1 <= -1? no).

Now:

* left recursive: `sort(nums, 0, e = -1)` → base case (low>=high) returns.
* right recursive: `sort(nums, s = 1, 1)` → base case (low>=high) returns.

Left partition sorted.

Array still:

```
[1, 2, 3, 4, 5]
```

---

### 3.3 Right recursion: `sort([1,2,3,4,5], 3, 4)`

Segment = `[4,5]`

Setup:

```
s=3, e=4
m = 3 + (4-3)/2 = 3
pivot = nums[3] = 4
```

#### Partition on [4,5]:

**Iteration 1:**

`s=3, e=4, pivot=4`

1. Move `s`:

* nums[3] = 4 < 4? NO → s=3.

2. Move `e`:

* nums[4] = 5 > 4? YES -> e=3
* nums[3] = 4 > 4? NO -> stop.

3. `s <= e`? → `3 <= 3` yes → swap 3 with 3 (no change).

Then:

* `s=4`, `e=2`.

Loop ends.

Recursive calls:

```java
sort(nums, 3, e = 2);  // base case (3>=2) return
sort(nums, s = 4, 4);  // base case (4>=4) return
```

No changes; segment already sorted.

---

### 3.4 Final Result

At the end of all recursion, the array is:

```
[1, 2, 3, 4, 5]
```

The recursion tree (high-level):

```
sort(0,4) on [5,4,3,2,1]
  pivot = 3
  -> [1,2,3,4,5] after partition
  left: sort(0,1) on [1,2]
  right: sort(3,4) on [4,5]
    both are trivially sorted after partition
```

---

## 4. Quick revision table for QuickSort (for interviews)

| Aspect           | Summary                                        |
| ---------------- | ---------------------------------------------- |
| Paradigm         | Divide and Conquer                             |
| Idea             | Partition around a pivot, then sort subarrays  |
| Pivot choices    | First, last, middle, random                    |
| Partition style  | Hoare (two pointers) / Lomuto (single pointer) |
| Time (avg/best)  | O(n log n)                                     |
| Time (worst)     | O(n²)                                          |
| Space            | O(log n) (recursion stack)                     |
| Stable?          | No                                             |
| In-place?        | Yes                                            |
| Java arrays sort | Dual-pivot quicksort for primitives            |

---

