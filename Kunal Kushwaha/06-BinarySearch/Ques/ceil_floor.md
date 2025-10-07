
---

### 🔍 You're asking:

> Why do we return `arr[start]` as the ceiling?
> Shouldn't we consider `end` too?
> Because after the loop, shouldn't the target lie between `start` and `end`?

---

### 📘 **Short Answer:**

We return `arr[start]` as the ceiling because:

> **`start` always ends up at the smallest number greater than the target** (i.e., the ceiling).

In contrast, **`end` ends up at the last number smaller than the target** (i.e., the floor).

---

### 🔁 What happens in the loop?

Let’s walk through what `start` and `end` represent:

* When `target < arr[mid]`:
  → We do `end = mid - 1`
  → Because mid and everything after it are **≥ target**, and we want to search the left side for potentially smaller valid ceilings.

* When `target > arr[mid]`:
  → We do `start = mid + 1`
  → Because mid and everything before it are **< target**, and we want a greater value.

So we're always **shrinking the search space** until:

```java
start > end
```

At this point:

* `start` is pointing at the **smallest number ≥ target** → ✅ **Ceiling**
* `end` is pointing at the **largest number < target** → ✅ **Floor**

---

### 📌 Visual Example:

```java
arr = {2, 3, 5, 9, 14, 16, 18};
target = 17
```

Final positions:

```
start = 6 (arr[6] = 18 ✅ ceiling)
end = 5 (arr[5] = 16 ✅ floor)
```

---

### ✅ Summary:

| Pointer | What it points to (after loop) | Use Case    |
| ------- | ------------------------------ | ----------- |
| `start` | Smallest element ≥ target      | **Ceiling** |
| `end`   | Largest element ≤ target       | **Floor**   |

So:

* For **ceil** → `return arr[start]`
* For **floor** → `return arr[end]`

As long as you're checking boundaries (`start < arr.length`, `end >= 0`), this logic is solid.

---
