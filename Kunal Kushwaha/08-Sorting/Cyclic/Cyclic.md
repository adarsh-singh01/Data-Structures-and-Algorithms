
---

# 🌀 **CYCLIC SORT — COMPLETE MASTER NOTES**

---

## **1. What is Cyclic Sort? (Concept + Intuition)**

Cyclic Sort is a **pattern-based sorting technique** used when:

* The array contains numbers in the **range 1 to n** (or sometimes `0 to n`).
* The goal is **to rearrange numbers directly to their correct indices**.
* Each number `x` belongs at index `x - 1` (for 1-indexed ranges).

---

### **Real-World Analogy:**

Imagine you have students labeled `1` to `n`, but they’re standing randomly.
Cyclic sort is like making each student move to the position that matches their roll number.

For example:

```
Input:  [3, 5, 2, 1, 4]
Output: [1, 2, 3, 4, 5]
```

Each student just goes to his own correct seat.

---

## **2. Core Algorithm Logic**

For every element `arr[i]`:

1. Compute its correct index:
   `correct = arr[i] - 1`
2. If the current number isn’t in its right place (`arr[i] != arr[correct]`):
   → **Swap** the two numbers.
3. Otherwise, move to the next index (`i++`).

---

### **Algorithm Intuition (ASCII Flow)**

```
+--------------------+
| i = 0              |
| correct = arr[i]-1 |
+--------------------+
         |
         v
If arr[i] != arr[correct]
   → swap(arr[i], arr[correct])
Else
   → i++
Repeat until i == arr.length
```

---

### **Cyclic Sort Template (1 to n)**

```java
static void cyclicSort(int[] arr) {
    int i = 0;
    while (i < arr.length) {
        int correct = arr[i] - 1;
        if (arr[i] != arr[correct]) {
            swap(arr, i, correct);
        } else {
            i++;
        }
    }
}
```

---

### **Swap Function**

```java
static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
}
```

---

### **Key Idea in Action**

```
arr = [3, 5, 2, 1, 4]
Step 1: i=0 → correct=2 → swap → [2,5,3,1,4]
Step 2: i=0 → correct=1 → swap → [5,2,3,1,4]
Step 3: i=0 → correct=4 → swap → [4,2,3,1,5]
Step 4: i=0 → correct=3 → swap → [1,2,3,4,5]
```

Now every element is in its “home position”.

---

## **3. When to Use Cyclic Sort**

✅ Best suited when:

* You have numbers **1...n** (or **0...n** variant).
* You need to detect:

  * Missing numbers
  * Duplicates
  * Set mismatch
  * Disappeared numbers
* You want to sort **in-place** without extra space.

---

## **4. Time & Space Complexity**

| Operation | Complexity                             |
| --------- | -------------------------------------- |
| **Time**  | O(n) → each element moved at most once |
| **Space** | O(1) → in-place sorting                |

**Why O(n)?**
Even though it has a while loop inside a while, each element is either swapped once or skipped.
Hence, total operations = number of elements = O(n).

---

## **5. Internal Working (ASCII Flow Example)**

```
Initial: arr = [3, 5, 2, 1, 4]

i=0 → arr[i]=3 → correct=2 → swap(arr[0], arr[2]) → [2,5,3,1,4]
i=0 → arr[i]=2 → correct=1 → swap(arr[0], arr[1]) → [5,2,3,1,4]
i=0 → arr[i]=5 → correct=4 → swap(arr[0], arr[4]) → [4,2,3,1,5]
i=0 → arr[i]=4 → correct=3 → swap(arr[0], arr[3]) → [1,2,3,4,5]
```

**Sorted** — each number now sits at its `index = value - 1`.

---

# **CYCLIC SORT APPLICATIONS**

Cyclic Sort is not just for sorting — it’s the base for solving multiple array problems efficiently in O(n) time.

---

## **A. Cyclic Sort (Basic Sorter)**

### **Problem:**

Sort an array containing numbers 1 to n in O(n) time and O(1) space.

### **Code:**

```java
int[] arr = {3, 5, 2, 1, 4};
cyclicSort(arr);
System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
```

---

## **B. Missing Number (Range 0 to n)**

### **Problem:**

Find the missing number in array of size `n` containing numbers from `0 to n`.

### **Key Idea:**

After sorting, if `arr[i] != i`, then `i` is missing.

---

**Modified Code:**

```java
while (i < arr.length) {
    if (arr[i] < arr.length && arr[i] != arr[arr[i]]) {
        swap(arr, i, arr[i]);
    } else {
        i++;
    }
}

for (int index = 0; index < arr.length; index++) {
    if (arr[index] != index) {
        return index;
    }
}
return arr.length;
```

**Example:**

```
Input: [4, 0, 2, 1, 6, 3]
Output: Missing = 5
```

---

## **C. Set Mismatch (Duplicate + Missing)**

### **Problem:**

One number is duplicated, one number is missing. Find both.

---

**Logic:**

* Perform cyclic sort.
* After sorting, if `arr[index] != index + 1`,
  → duplicate = arr[index], missing = index + 1.

**Code:**

```java
while (i < arr.length) {
    int correct = arr[i] - 1;
    if (arr[i] != arr[correct]) swap(arr, i, correct);
    else i++;
}

for (int index = 0; index < arr.length; index++) {
    if (arr[index] != index + 1)
        return new int[]{arr[index], index + 1};
}
```

**Example:**

```
Input: [1, 2, 2, 4]
Output: Duplicate = 2, Missing = 3
```

---

## **D. Find All Disappeared Numbers**

### **Problem:**

Given an array of numbers from `1...n` with duplicates,
find all numbers that don’t appear.

---

**Logic:**
After cyclic sort, if `nums[i] != i + 1`, then `(i + 1)` is missing.

**Code:**

```java
while (i < nums.length) {
    int correct = nums[i] - 1;
    if (nums[i] != nums[correct]) swap(nums, i, correct);
    else i++;
}

List<Integer> ans = new ArrayList<>();
for (int index = 0; index < nums.length; index++) {
    if (nums[index] != index + 1)
        ans.add(index + 1);
}
```

**Example:**

```
Input: [4,3,2,7,8,2,3,1]
Output: [5,6]
```

---

## **E. Find All Duplicates**

### **Problem:**

Find all elements that appear twice.

---

**Logic:**
After sorting, if `nums[i] != i + 1`, then `nums[i]` is a duplicate.

**Code:**

```java
while (i < nums.length) {
    int correct = nums[i] - 1;
    if (nums[i] != nums[correct]) swap(nums, i, correct);
    else i++;
}

List<Integer> ans = new ArrayList<>();
for (int index = 0; index < nums.length; index++) {
    if (nums[index] != index + 1 && !ans.contains(nums[index]))
        ans.add(nums[index]);
}
```

**Example:**

```
Input: [4,3,2,7,8,2,3,1]
Output: [2,3]
```

---

## **F. Find Single Duplicate (One repeating element)**

### **Problem:**

Find the single repeating number in array of `1...n` numbers.

**Logic:**
Return when duplicate found during swap check.

**Code:**

```java
while (i < arr.length) {
    if (arr[i] != i + 1) {
        int correct = arr[i] - 1;
        if (arr[i] != arr[correct]) swap(arr, i, correct);
        else return arr[i];
    } else i++;
}
return -1;
```

**Example:**

```
Input: [1,3,4,2,2]
Output: Duplicate = 2
```

---

# **6. Internal Visualization (Step-by-Step)**

Example: `arr = [3, 5, 2, 1, 4]`

```
Initial:  [3,5,2,1,4]
i=0 → correct=2 → swap(0,2)
→ [2,5,3,1,4]
i=0 → correct=1 → swap(0,1)
→ [5,2,3,1,4]
i=0 → correct=4 → swap(0,4)
→ [4,2,3,1,5]
i=0 → correct=3 → swap(0,3)
→ [1,2,3,4,5]
i++ → Done
```

---

# **7. Control Flow Summary (ASCII)**

```
┌────────────────────────────────────────────┐
│  Start with i = 0                         │
└────────────────────────────────────────────┘
           │
           ▼
   correct = arr[i] - 1
           │
           ▼
   if arr[i] != arr[correct]:
        swap(arr[i], arr[correct])
   else:
        i++
           │
           ▼
Repeat until i == arr.length
```

---

# **8. Quick Revision Table**

| Problem             | Check Condition                      | Output               |
| ------------------- | ------------------------------------ | -------------------- |
| Missing Number      | `arr[i] != i`                        | return i             |
| Set Mismatch        | `arr[i] != i + 1`                    | [duplicate, missing] |
| All Missing Numbers | `arr[i] != i + 1`                    | collect i+1          |
| All Duplicates      | `arr[i] != i + 1`                    | collect arr[i]       |
| Single Duplicate    | `arr[i] == arr[correct]` during swap | return arr[i]        |

---

# **9. Complexity & Advantages**

| Property             | Description                                     |
| -------------------- | ----------------------------------------------- |
| **Time Complexity**  | O(n)                                            |
| **Space Complexity** | O(1)                                            |
| **Stable?**          | Not necessarily (depends on swapping)           |
| **In-place?**        | Yes                                             |
| **Works for?**       | Arrays where value ↔ index mapping is possible  |
| **Common Uses**      | Missing/duplicate detection without extra space |

---

# **10. Key Takeaways**

✅ Every number belongs to an index.
✅ Swap until each number reaches its home.
✅ Perfect for “1 to n” or “0 to n” range problems.
✅ Turns sorting + searching problems into **O(n)** solutions.

---

# **11. Mnemonic Summary (for quick recall)**

**Cyclic Sort = “Seat Each Element Where It Belongs”**

| Step   | Action                           |
| ------ | -------------------------------- |
| Step 1 | Compute correct = arr[i] - 1     |
| Step 2 | If not in place, swap            |
| Step 3 | Else, move ahead                 |
| Step 4 | After loop, each arr[i] == i + 1 |
| Step 5 | Any mismatch → anomaly detected  |

---
