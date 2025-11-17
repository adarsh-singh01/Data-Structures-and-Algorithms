
---

# **1. What is a Map?**

### **Real-world analogy**

Think of a **map** as a **dictionary** or **phonebook**:

* Each *word* (key) maps to one *definition* (value).
* You can quickly find the definition if you know the word.
* Each key is unique, but values can be repeated.

---

### **Definition**

In Java, a **Map** is an interface (in `java.util`) that represents a data structure for storing **key–value pairs**.

```java
Map<KeyType, ValueType> map = new HashMap<>();
```

Each **key** is unique; if you put the same key again, the value is replaced (updated).

---

### **Why Maps?**

* Fast data retrieval (`O(1)` on average).
* No need to search through arrays or lists.
* Perfect for caching, counting frequencies, lookup tables, etc.

---

# **2. What is a HashMap?**

### **Definition**

A `HashMap` is one of Java’s implementations of the `Map` interface, built using a **hash table**.

It maps a **key’s hash code** to an **index** in an **array of buckets**.

### **Key points**

* Not ordered → insertion order is *not maintained*.
* Allows one `null` key and multiple `null` values.
* Average time complexity for `get()`, `put()`, `remove()` is **O(1)**.

---

# **3. Why HashMap?**

### **Need**

If you use a normal list to search key–value pairs:

* Searching = O(n)
* Inserting = O(n)
* Deleting = O(n)

With HashMap:

* All operations are **O(1)** (average), because of hashing.

---

# **4. How HashMap Works Internally**

### **Step-by-step logic**

1. When you `put(key, value)`:

   * HashMap computes an integer **hash code** for the key using `key.hashCode()`.
   * Converts it to a **non-negative index**:
     `index = Math.abs(hashCode % table.length)`
   * Inserts `(key, value)` pair into that index (bucket).

2. When you `get(key)`:

   * Compute the same hash → find bucket.
   * Traverse the linked list (if collision) → match key via `.equals()` → return value.

3. If two keys map to the same bucket → **collision** occurs.

---

## **ASCII Visualization: Basic HashMap Flow**

```
               +-------------------+
put("Mango", "King of fruits")
               ↓
key.hashCode() → some int, e.g. 123456
index = abs(123456 % 10) = 6
               ↓
Bucket[6] → [ ("Mango", "King of fruits") ]
```

For another key with same hash:

```
Bucket[6] → [ ("Mango", "King of fruits") -> ("Apple", "Sweet fruit") ]
```

---

# **5. HashCode and Equals**

### **`hashCode()`**

* Every object in Java has a `hashCode()` method (inherited from `Object`).
* Used to calculate the index of storage.
* Must always return an **integer** (can be negative).

### **We make it positive**

```java
int hash = Math.abs(key.hashCode() % list.size());
```

### **`equals()`**

* Used to check *actual equality* between two keys stored in the same bucket.
* Ensures that two different keys with same hash don’t overwrite each other.

---

# **6. Collisions in HashMap**

### **What is a collision?**

When two different keys produce the same bucket index after hashing.

For example:

```
"Mango" -> hash = 6
"Apple" -> hash = 6
```

Both go to the same bucket.

---

### **Collision Handling Techniques**

#### **1. Chaining (Used in Java HashMap)**

Each bucket stores a **linked list (or tree in modern JDK)** of entries.

```
bucket[i] = [ ("K1", "V1") -> ("K2", "V2") -> ... ]
```

If keys hash to same index, they are appended to the list.

#### **2. Open Addressing**

Each slot holds *at most one* key–value pair.
If a slot is occupied, the algorithm searches for the next free slot (probing).

##### **Probing Strategies**

* **Linear Probing:** try `index + 1`, `index + 2`, …
* **Quadratic Probing:** `index + i^2`
* **Double Hashing:** use a second hash to jump steps.

---

# **7. Load Factor and Rehashing**

### **Load Factor (lf)**

Defines how full the hash table can get before resizing.

```
loadFactor = n / m
where,
n = number of key–value pairs
m = table size
```

Typical default in Java: `0.75f`.

When load factor exceeds this → **rehash** (resize and redistribute).

---

### **Rehashing**

When table gets crowded (load factor exceeded):

1. Create new table with **double** size.
2. Recalculate hash for each existing key.
3. Reinsert all pairs.

If we increased by 1 each time instead of doubling, inserting n elements would become O(n²).

---

### **Code: Rehashing in Custom HashMap**

```java
private void reHash() {
    ArrayList<LinkedList<Entity>> old = list;
    list = new ArrayList<>();
    size = 0;

    for (int i = 0; i < old.size() * 2; i++) {
        list.add(new LinkedList<>());
    }

    for (LinkedList<Entity> entries : old) {
        for (Entity entry : entries) {
            put(entry.key, entry.value);
        }
    }
}
```

ASCII flow:

```
Old size: 10 → Load factor = 0.5 threshold reached
→ Double size: 20
→ Re-insert all keys with new indices
```

---

# **8. Simple Uniform Hashing Assumption**

This assumption means:

> Every key is equally likely to be hashed to any of the slots.

So, expected time complexity becomes:

```
O(1 + load factor)
```

When load factor is small (≈ constant), time ≈ O(1).

---

# **9. Hash Functions**

### **Purpose**

A **hash function** maps any key → integer index in table range `[0, m-1]`.

---

### **Common Hash Function Methods**

#### (a) Division Method

```
H(k) = k % m
```

Choose `m` as a **prime number** not close to a power of 2 to minimize clustering.

---

#### (b) Multiplication Method

```
H(k) = floor( m * ( (A * k) % 1 ) )
```

where `0 < A < 1`, often `A = (√5 - 1)/2`.

This avoids dependence on patterns in `k`.

---

#### (c) Universal Hashing

A family of random hash functions chosen to minimize collisions in worst case.

---

# **10. Shrinking**

Some hash maps (like `LinkedHashMap`) shrink (reduce table size) when many elements are removed to save memory.

In custom implementations (like your code), you can add this manually.

---

# **11. Open Addressing vs. Chaining**

| Feature      | **Chaining**                        | **Open Addressing**           |
| ------------ | ----------------------------------- | ----------------------------- |
| Storage      | Linked list (or BST) in each bucket | Single array only             |
| Collisions   | Stored in same bucket               | Next free slot                |
| Deletion     | Easier                              | Complex (requires re-probing) |
| Load Factor  | Can exceed 1                        | Must be < 1                   |
| Used in Java | ✅ HashMap uses chaining             | ❌ Not in HashMap              |

---

# **12. When to Use Which**

* **Chaining** → easier, flexible, good when memory is plenty.
* **Open Addressing** → compact memory, faster lookup if low load factor.

---

# **13. Custom HashMap (your code)**

### **Structure**

```java
ArrayList<LinkedList<Entity>> list;
```

Each bucket → LinkedList of `Entity` (key–value pair).

### **Main methods**

1. `put(K key, V value)` – Insert/update key–value.
2. `get(K key)` – Retrieve value.
3. `remove(K key)` – Delete entry.
4. `reHash()` – Resize & redistribute when load factor > threshold.
5. `toString()` – Print all key–value pairs.

---

### **Code Walkthrough (Step-by-Step)**

#### **Put Operation**

```java
int hash = Math.abs(key.hashCode() % list.size());
LinkedList<Entity> entities = list.get(hash);
```

1. Compute hash index.
2. Traverse linked list → if key exists → update value.
3. If new key:

   * Check load factor → maybe rehash.
   * Add new Entity to list.

ASCII flow:

```
"Apple" → hash=3
list[3] : [ ("Mango", "King of fruits") ]
Add → [ ("Mango", ...)->("Apple", "Sweet red fruit") ]
```

---

#### **Rehash Operation**

When `size/list.size() > loadFactor (0.5)`:

* Double array size.
* Reinsert all existing key–value pairs.

---

#### **Get Operation**

```java
int hash = Math.abs(key.hashCode() % list.size());
for(Entity e : list.get(hash))
  if(e.key.equals(key)) return e.value;
```

→ Find bucket, check each node for equality.

---

#### **Remove Operation**

Find and remove the entity from linked list.

---

# **14. Complexity Analysis**

| Operation  | Average     | Worst (if all keys collide) |
| ---------- | ----------- | --------------------------- |
| `put()`    | O(1)        | O(n)                        |
| `get()`    | O(1)        | O(n)                        |
| `remove()` | O(1)        | O(n)                        |
| `rehash()` | O(n) (rare) | O(n)                        |

Amortized time for n inserts is **O(n)**.

---

# **15. Built-in HashMap Behavior**

### **Default values**

| Parameter        | Default                 |
| ---------------- | ----------------------- |
| Initial capacity | 16                      |
| Load factor      | 0.75                    |
| Resizing policy  | Double size on overflow |

From JDK 8 onwards:

* If bucket size > 8 → linked list is converted to a balanced tree (O(log n) worst case).

---

# **16. Interview Patterns**

| Concept               | Common Question                        |
| --------------------- | -------------------------------------- |
| Collision handling    | Explain chaining vs open addressing    |
| Hash function         | Design good hash function for strings  |
| Load factor           | Why not increase by 1? Why double?     |
| Custom implementation | Implement HashMap from scratch         |
| HashMap resizing      | When and how does Java HashMap resize? |
| Key equality          | Why override hashCode and equals?      |
| Performance           | Why O(1) average? Why O(n) worst?      |

---

# **17. Time & Space Complexity Summary**

| Operation | Average | Worst | Space             |
| --------- | ------- | ----- | ----------------- |
| Put       | O(1)    | O(n)  | O(n)              |
| Get       | O(1)    | O(n)  | O(n)              |
| Remove    | O(1)    | O(n)  | O(n)              |
| Rehash    | O(n)    | O(n)  | O(2n) temporarily |

---

# **18. Key Takeaways**

✅ HashMap = Hash Table + LinkedList (chaining).
✅ Uses `hashCode()` + `equals()` for indexing and equality.
✅ Load factor decides when to rehash.
✅ Collision handled by chaining.
✅ Expected complexity = O(1 + α) (α = load factor).
✅ Rehashing doubles table → prevents quadratic time.
✅ Java’s `HashMap` is **not ordered**, use `LinkedHashMap` or `TreeMap` for ordering.

---

