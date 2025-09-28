
---

## ✅ What Is Hashing?

Hashing is a technique to **map data to a fixed-size table (usually an array)** using a function called a **hash function**.

Hashing is commonly used in:

* Hash tables (`unordered_map`, `unordered_set`)
* Databases (indexing)
* Caches
* Password storage

---

## 🔢 1. **Hashing Using Division Method**

This is one of the simplest hash functions:

```
h(key) = key % table_size;
```

* You divide the key by the table size and take the remainder.
* `table_size` is usually a **prime number** to reduce collisions.

### Example:

```cpp
key = 32
table_size = 10
h(32) = 32 % 10 = 2
```

So we store `32` at index `2`.

---

## 🧮 2. **Folding Method**

This method works well for large numeric keys:

* **Break** the key into equal parts (usually in digits)
* **Add** those parts together
* Apply modulo if needed

### Example:

```cpp
Key = 123456 → break into 123 + 456 = 579
Then h(123456) = 579 % table_size
```

This helps distribute digits more evenly.

---

## 🔲 3. **Mid-Square Method**

* **Square** the key
* **Extract** middle digits (e.g., 2 or 3 digits from the center)
* Apply modulo if needed

### Example:

```cpp
key = 123
key^2 = 15129
middle = 512 (from 15129)
h(123) = 512 % table_size
```

Works well if the keys are uniformly distributed.

---

## 🚫 4. **What Is Collision?**

> A **collision** occurs when **two keys hash to the same index** in the hash table.

Example:

```cpp
key1 = 32 → h(32) = 2
key2 = 42 → h(42) = 2  // collision!
```

Both keys map to index 2.

---

## 🔁 5. **Collision Resolution Techniques**

### a) **Linear Probing (Open Addressing)**

* If a collision occurs, try the **next slot** in the array (i.e., `index + 1`), then `index + 2`, and so on until a free slot is found.

### b) **Linear Chaining (Separate Chaining)**

* Instead of storing one value per index, store a **linked list** or **vector** of elements.
* All keys that hash to the same index are stored in that list.

```cpp
h(42) = 2
Table[2] = [32, 42]
```

### ⚠️ Trade-offs:

* **Chaining** is easier to implement and handles load better.
* **Probing** requires careful handling of deletion and rehashing.

---

## ❓ 6. Why Are Collisions **Rare** in `unordered_map`?

Because:

* C++’s `unordered_map` uses a **well-designed hash function** (internally using `std::hash`).
* It automatically resizes (rehashes) when the **load factor** becomes too high.
* It uses **buckets** and **chaining** internally to handle collisions efficiently.

So, unless you're inserting **huge amounts of data** or using **custom types with poor hash functions**, collisions are infrequent.

---

## ✅ Summary Table

| Concept               | Description                                                               |
| --------------------- | ------------------------------------------------------------------------- |
| **Division Method**   | `h(key) = key % table_size`                                               |
| **Folding Method**    | Break key into parts, sum parts                                           |
| **Mid-Square Method** | Square the key, take middle digits                                        |
| **Collision**         | Two keys hash to the same index                                           |
| **Linear Probing**    | Go to next available slot in the array                                    |
| **Chaining**          | Store a list (vector/linked list) at each index                           |
| **unordered_map**     | Uses `std::hash`, handles collisions with chaining, resizes automatically |

---
