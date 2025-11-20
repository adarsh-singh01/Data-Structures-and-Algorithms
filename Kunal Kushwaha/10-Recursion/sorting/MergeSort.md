
---

## 1. Notes: Merge Sort vs Merge Sort “In Place”

### Real-world analogy

Imagine sorting a stack of cards:

1. Split the stack into two smaller stacks.
2. Recursively sort each smaller stack.
3. Merge two sorted stacks by picking the smaller top card from either stack each time.

That’s merge sort.

---

### Core idea of Merge Sort

Merge sort uses **Divide and Conquer**:

1. **Divide** the array into two halves.
2. **Conquer** recursively: sort both halves.
3. **Combine**: merge two sorted halves into one sorted array.

Recurrence:

* `T(n) = 2T(n/2) + O(n)`
  → Solution: `T(n) = O(n log n)`.

---

### Complexity

* **Time**:

  * Every level: you merge **all n elements once** → O(n).
  * Depth: `log₂ n` levels.
  * Total: `O(n log n)`.

* **Space**:

  * Functional `mergeSort`: uses new arrays (`copyOfRange` + `mix`) → `O(n)` extra.
  * Your “in-place” version: still allocates `mix` of size `(end-start)` per merge level, but reuses original `arr` instead of new left/right arrays.
    Overall auxiliary space is still `O(n)` (not O(1)), but it **avoids allocating left/right subarrays**, which can be better in practice.

---

### mergeSort vs mergeSortInPlace

* `mergeSort(int[] arr)`:

  * **Style**: functional.
  * Returns a **new sorted array**.
  * Does not sort `arr` in-place; you must reassign: `arr = mergeSort(arr);`.

* `mergeSortInPlace(int[] arr, int start, int end)`:

  * **Style**: sorts within the same `arr`.
  * Uses indices `[start, end)` (end is exclusive).
  * Uses a temp `mix[]` only while merging a segment, then copies back into `arr`.

---

## 2. Code with useful comments

Here is your code with comments added (no behavior changed):

```java
import java.util.Arrays;

/*
Merge Sort (top-down, recursive)

High-level steps:
1. Divide the array into two parts (left half, right half).
2. Recursively sort each half.
3. Merge the two sorted halves into a single sorted array.

Key points:
- At every "level" of recursion, all n elements are involved in merging.
- Depth of recursion tree is O(log n).
=> Time complexity: O(n log n)

Functional version:
- mergeSort(arr) returns a new sorted array.
- It does NOT sort the original array in-place.

In-place-like version:
- mergeSortInPlace(arr, start, end) uses the same arr, with index ranges.
- It still uses temporary array `mix` for merging, so auxiliary space is O(n),
  but it avoids creating new left/right subarrays via copyOfRange.
*/

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        // Functional style:
        // mergeSort(arr);             // This does nothing to 'arr' because we ignore the returned sorted array.
        // arr = mergeSort(arr);       // This would correctly reassign 'arr' to the sorted array.

        // “In-place” style (using index range [start, end)):
        mergeSortInPlace(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr)); // Expect: [1, 2, 3, 4, 5]
    }

    // Functional merge sort: returns a NEW sorted array.
    static int[] mergeSort(int[] arr) {
        // Base case: an array of length 1 is already sorted.
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        // Recursively sort the left half: arr[0..mid-1]
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));

        // Recursively sort the right half: arr[mid..end-1]
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        // Merge two sorted halves into one sorted array.
        return merge(left, right);
    }

    // Merge two sorted arrays 'first' and 'second' into a single sorted array.
    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0; // pointer in first
        int j = 0; // pointer in second
        int k = 0; // pointer in mix

        // While both arrays have elements, pick the smaller one.
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from 'first', if any.
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        // Copy remaining elements from 'second', if any.
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }

    // In-place style merge sort using the same array 'arr' and index range [start, end)
    static void mergeSortInPlace(int[] arr, int start, int end) {
        // Base case: segment of length 1 is already sorted.
        if (end - start == 1) {
            return;
        }

        int mid = (start + end) / 2;

        // Sort the left half: [start, mid)
        mergeSortInPlace(arr, start, mid);

        // Sort the right half: [mid, end)
        mergeSortInPlace(arr, mid, end);

        // Merge the two sorted halves back into arr[start..end-1]
        mergeInPlace(arr, start, mid, end);
    }

    // Merge two sorted subarrays of arr:
    // left:  [start, mid)
    // right: [mid, end)
    // into a temporary array 'mix', then copy back to arr[start..end-1].
    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start; // pointer in left half
        int j = mid;   // pointer in right half
        int k = 0;     // pointer in mix

        // Merge two sorted parts into mix[]
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left half
        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements from right half
        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged result back into the original array segment
        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }
}
```

---

## 3. ASCII Execution Flow

Let’s trace both versions conceptually on `arr = [5, 4, 3, 2, 1]`.

---

### 3.1 Functional `mergeSort(arr)` (returns new array)

We call:

```java
arr = mergeSort([5,4,3,2,1]);
```

#### Recursion tree (splitting)

Think of it as a binary tree where each node is an array segment:

```
mergeSort([5,4,3,2,1])
├─ mergeSort([5,4,3])
│  ├─ mergeSort([5])
│  └─ mergeSort([4,3])
│     ├─ mergeSort([4])
│     └─ mergeSort([3])
└─ mergeSort([2,1])
   ├─ mergeSort([2])
   └─ mergeSort([1])
```

Base case: any array of length 1 is already sorted.

#### Merging bottom-up

1. Merge `[4]` and `[3]`:

   ```
   first = [4]
   second = [3]

   Compare 4 vs 3:
   -> 3 goes first: [3]
   then leftover 4: [3,4]
   result: [3,4]
   ```

2. Merge `[5]` and `[3,4]`:

   ```
   first = [5]
   second = [3,4]

   Compare 5 vs 3 -> [3]
   Compare 5 vs 4 -> [3,4]
   Leftover 5 -> [3,4,5]
   result: [3,4,5]
   ```

3. Merge `[2]` and `[1]`:

   ```
   first = [2]
   second = [1]

   Compare 2 vs 1 -> [1]
   leftover 2 -> [1,2]
   result: [1,2]
   ```

4. Final merge: `[3,4,5]` and `[1,2]`:

   ```
   first = [3,4,5]
   second = [1,2]

   Compare 3 vs 1 -> [1]
   Compare 3 vs 2 -> [1,2]
   Compare 3 vs (no more in second) -> [1,2,3,4,5]
   result: [1,2,3,4,5]
   ```

So the final result is `[1,2,3,4,5]`, returned by the top-level `mergeSort`.

Visual “merge tree”:

```
           [5,4,3,2,1]
          /           \
     [5,4,3]         [2,1]
     /     \         /   \
   [5]    [4,3]   [2]   [1]
           /  \
         [4]  [3]

Bottom-up merges:

[4] + [3]      -> [3,4]
[5] + [3,4]    -> [3,4,5]
[2] + [1]      -> [1,2]
[3,4,5] + [1,2]-> [1,2,3,4,5]
```

---

### 3.2 `mergeSortInPlace(arr, 0, 5)` (index range style)

We now track **indices** with **[start, end)** segments on the same array.

Initial call:

```java
mergeSortInPlace(arr, 0, 5);
// arr = [5,4,3,2,1]
```

#### Recursive splitting (index-based)

```
mergeSortInPlace(arr, 0, 5)
  mid = (0+5)/2 = 2

  Left:  mergeSortInPlace(arr, 0, 2)
         segment arr[0..1] = [5,4]

  Right: mergeSortInPlace(arr, 2, 5)
         segment arr[2..4] = [3,2,1]
```

Expand left `(0,2)`:

```
mergeSortInPlace(arr, 0, 2)
  mid = (0+2)/2 = 1

  Left:  mergeSortInPlace(arr, 0, 1)  -> length 1, return
         arr[0..0] = [5]

  Right: mergeSortInPlace(arr, 1, 2)  -> length 1, return
         arr[1..1] = [4]

  mergeInPlace(arr, 0, 1, 2) // merge arr[0..0] and arr[1..1]
```

**First mergeInPlace: merging [5] and [4]**

* `start=0, mid=1, end=2`
* Left:  `arr[0..0] = [5]`
* Right: `arr[1..1] = [4]`

`mix` size = `end-start` = 2.

Pointers:

* `i = 0` (left)
* `j = 1` (right)
* `k = 0` (mix)

Step by step:

1.

```
arr[i] = 5, arr[j] = 4
5 < 4? no -> mix[0] = 4
j=2, k=1
```

Now j>=end ⇒ right side exhausted.

2. Copy remaining left:

```
i=0 < mid=1
mix[1] = arr[0] = 5
i=1, k=2
```

`mix = [4, 5]`.

Copy `mix` back into `arr[0..1]`:

```
arr[0] = 4
arr[1] = 5
```

Now array looks like:

```
arr = [4, 5, 3, 2, 1]
```

Left half `[0..2)` is now sorted: `[4,5]`.

---

Expand right `(2,5)`:

```
mergeSortInPlace(arr, 2, 5)
  mid = (2+5)/2 = 3

  Left:  mergeSortInPlace(arr, 2, 3) -> single element [3]
  Right: mergeSortInPlace(arr, 3, 5)
```

Now right `(3,5)`:

```
mergeSortInPlace(arr, 3, 5)
  mid = (3+5)/2 = 4

  Left:  mergeSortInPlace(arr, 3, 4) -> [2]
  Right: mergeSortInPlace(arr, 4, 5) -> [1]

  mergeInPlace(arr, 3, 4, 5) // merge [2] and [1]
```

**Second mergeInPlace: merging [2] and [1]**

Before this merge, current arr is:

```
arr = [4, 5, 3, 2, 1]
           ^  ^  ^
           2  3  4 indices
```

Parameters:

* `start=3`, `mid=4`, `end=5`
* Left: `arr[3..3] = [2]`
* Right: `arr[4..4] = [1]`

Steps similar to before:

1.

```
i=3, j=4, k=0
arr[i]=2, arr[j]=1
2 < 1? no -> mix[0]=1; j=5, k=1
```

2. Right exhausted, copy left:

```
i=3 < mid=4
mix[1]=2; i=4, k=2
```

`mix=[1,2]`.

Copy back into arr[3..4]:

```
arr[3]=1
arr[4]=2
```

Now:

```
arr = [4, 5, 3, 1, 2]
```

Segment `[3..5)` sorted as `[1,2]`.

---

Now merge `(2,3)` and `(3,5)`:

```
mergeInPlace(arr, 2, 3, 5)
 left:  [3]   index 2
 right: [1,2] indices 3..4
```

Before merging:

```
arr = [4, 5, 3, 1, 2]
           ^  ^  ^
           2  3  4
```

Steps:

* `mix` size = 3
* `i=2 (3)`, `j=3 (1)`, `k=0`

1.

```
3 < 1? no -> mix[0] = 1
j=4, k=1
```

2.

```
arr[i]=3, arr[j]=2
3 < 2? no -> mix[1]=2
j=5, k=2
```

Right exhausted, copy left:

3.

```
i=2 < mid=3 -> mix[2] = 3
i=3, k=3
```

`mix=[1,2,3]`.

Copy back into arr[2..4]:

```
arr[2]=1
arr[3]=2
arr[4]=3
```

Array becomes:

```
arr = [4, 5, 1, 2, 3]
```

Now segment `[2..5)` sorted: `[1,2,3]`.

---

Final merge at top level:

`mergeInPlace(arr, 0, 2, 5)` merging:

* Left: `[4,5]` indices `[0..1]`
* Right: `[1,2,3]` indices `[2..4]`

Before:

```
arr = [4, 5, 1, 2, 3]
         ^     ^
         0..1  2..4
```

Steps:

`mix` length = 5.

1.

```
i=0 (4), j=2 (1)
4 < 1? no -> mix[0]=1; j=3, k=1
```

2.

```
i=0 (4), j=3 (2)
4 < 2? no -> mix[1]=2; j=4, k=2
```

3.

```
i=0 (4), j=4 (3)
4 < 3? no -> mix[2]=3; j=5, k=3
```

Right exhausted, copy remaining left `[4,5]`:

4.

```
i=0 < mid=2 -> mix[3]=4; i=1, k=4
```

5.

```
i=1 < mid=2 -> mix[4]=5; i=2, k=5
```

`mix = [1,2,3,4,5]`.

Copy back into arr[0..4]:

```
arr[0]=1
arr[1]=2
arr[2]=3
arr[3]=4
arr[4]=5
```

Final:

```
arr = [1, 2, 3, 4, 5]
```

---

### 3.3 Summary ASCII Tree for In-Place Sorting

```
mergeSortInPlace(arr,0,5) on [5,4,3,2,1]

Level 0:
[5,4,3,2,1]
  /       \
[5,4]    [3,2,1]

Level 1:
[5,4] -> [5] + [4]  -> merge -> [4,5]
[3,2,1] -> [3] + [2,1]
           [2,1] -> [2] + [1] -> merge -> [1,2]
         merge [3] and [1,2] -> [1,2,3]

Level 2:
merge [4,5] and [1,2,3] -> [1,2,3,4,5]
```

---
