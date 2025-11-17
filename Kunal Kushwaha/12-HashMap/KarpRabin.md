
---

# **1. Real-World Analogy**

Imagine you want to find the word **“Adarsh”** inside a long book.

Instead of reading every window of 6 letters and comparing the string character by character (O(n · m)),
you can assign a **numeric fingerprint (hash)** to the substring and compare fingerprints instead.

Just like checking the *barcode* of items instead of reading entire descriptions.

---

# **2. What is Karp–Rabin? (Simple Definition)**

Karp–Rabin is a **string searching algorithm** that uses **hashing** to find a pattern inside a text.

It avoids comparing strings character-by-character for every index.

It computes:

1. The **hash of the pattern**.
2. A **rolling hash** for every substring of the text of the same length.
3. When hashes match → possible match (verify by comparing strings).

---

# **3. Why Karp–Rabin? (Usefulness)**

### ✓ Useful when:

* You must search **multiple patterns** in a text.
* You must search **same pattern many times** across different texts.
* You want better average performance than naive O(n·m).

### ✓ Efficiency:

* Hashing a sliding window allows update in **O(1)** instead of recomputing full hash.

### ✓ Hashing reduces comparisons drastically.

---

# **4. How Karp–Rabin Works (Technical Breakdown)**

Let:

```
text = "shivamadarshprince"
pattern = "adarsh"
```

Length = 6

### **Step-by-step:**

1. Compute **hash(pattern)**.
2. Compute **hash(text[0..5])** (first window).
3. If hashes match → verify full strings.
4. Slide window by 1 character each time:

   * Remove oldChar
   * Add newChar
   * Update hash in O(1) using rolling hash formula.
5. Repeat until text end.

---

# **5. Hash Function Used**

Given PRIME = 101

Hash of string `"adar"`:

```
hash = 'a'*101^0 + 'd'*101^1 + 'a'*101^2 + 'r'*101^3
```

This is called **Polynomial Rolling Hash**.

Every character contributes based on its positional power.

---

# **6. Why Rolling Hash? (Efficiency Insight)**

Without rolling hash, each substring hashing costs O(m) → total O(n·m).

Rolling hash helps compute next hash in **constant time**.

---

# **7. Rolling Hash Formula**

For previous hash H of substring:

```
old substring: text[i .... i+m-1]
new substring: text[i+1 .... i+m]
```

Given:

```
H = t[i]*P^0 + t[i+1]*P^1 + ... + t[i+m-1]*P^(m-1)
```

To roll:

1. Remove t[i]
2. Divide by P
3. Add t[i+m] * P^(m-1)

Your code does exactly that.

---

# **8. Collision & Variants**

### **What is a collision?**

Two different strings produce the same hash value.

Example:
Hash("adarsh") == Hash("xyzabc") → extremely rare but possible.

When a collision occurs:

* Hash compares equal,
* But actual strings do not.

---

## **Two variants of Rabin–Karp**

### **1. Monte Carlo**

* **Fast**, but risk of **false positive** due to hash collision.
* If hash matches → assume pattern exists.
* DOES NOT verify with string comparison.
* May return wrong index if collision.

### **2. Las Vegas**

* More reliable.
* If hash matches → verify substring using `.equals()`.
* Zero false positives.
* Worst-case time increases (if many collisions).

### **Your implementation is Las Vegas**

(because it does `substring.equals(pattern)` after hash match).

---

# **9. Time Complexity**

Let:

* n = text length
* m = pattern length

### **Average Case (Assuming Random Hashing):**

```
O(n + m)
≈ Amortized Linear Time
```

Why?
Only constant-time hash updates + rare full comparisons.

### **Worst Case:**

When many collisions occur:

```
O(n * m)  (quadratic)
```

Example edge case:

* All characters same: "aaaaaaaaaaaaaa..."
* Bad hash function.

But with a good prime & polynomial hash, practically linear.

---

# **10. Important Concepts**

### **LSH (Las Vegas Safe Hashing)**

Hash match → verify → correct result guaranteed.

### **Amortized Linear Time**

Even if some windows require full comparison,
average for large text remains O(n).

### **Prime Modulus / Base**

Avoids hash clustering; spreads values uniformly.

---

# **11. ASCII Execution Flow**

Example text `“adarshxyz”`, pattern: `"adarsh"`.

```
text:    a d a r s h x y z
index:   0 1 2 3 4 5 6 7 8
window: [0.........5]

pattern hash = H(p)
text hash    = H(text[0..5])

Compare hash:
| H(p) == H(text[0..5])? YES |
→ Compare strings to avoid collision
→ Match at index 0

Slide Window:

oldChar = 'a'
newChar = 'x'

newHash = updateHash(...)
```

---

# **12. FULL EXPLANATION OF YOUR CODE**

---

## **Class and Hash Base**

```java
private final int PRIME = 101;
```

Using `101` as base for polynomial hashing.

---

## **1. calculateHash()**

```java
private double calculateHash(String str) {
    double hash = 0;
    for (int i = 0; i < str.length(); i++) {
        hash += str.charAt(i) * Math.pow(PRIME, i);
    }
    return hash;
}
```

### Explanation:

* Computes polynomial hash:
  `hash = Σ char[i] * PRIME^i`
* Position matters
* Characters earlier contribute less weight
* Result is `double` (not ideal, but enough for teaching)

---

## **2. updateHash()**

```java
private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
    double newHash = (prevHash - oldChar) / PRIME;
    newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
    return newHash;
}
```

### Explanation (Rolling Hash):

Old substring: `"abcde"`
New substring: `"bcdef"`

Step-by-step:

1. **Remove oldChar contribution**

   ```
   prevHash - oldChar*PRIME^0
   ```

2. **Divide by PRIME**
   This shifts powers:

   ```
   'b'*P^1 becomes 'b'*P^0 etc.
   ```

3. **Add newChar at highest place**:

   ```
   newChar * P^(m-1)
   ```

This makes each update O(1).

---

## **3. search()**

```java
public void search(String text, String pattern) {
```

### Steps:

1. Compute initial hashes:

```java
double patternHash = calculateHash(pattern);
double textHash = calculateHash(text.substring(0, patternLength));
```

2. Slide window across text:

```java
for(int i=0; i<= text.length() - patternLength; i++) {
```

3. When hashes match:

```java
if(textHash == patternHash) {
    if(text.substring(i, i+patternLength).equals(pattern)) {
        System.out.println("Pattern found at index " + i);
    }
}
```

Las Vegas verification.

4. Compute next rolling hash:

```java
textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
```

---

# **13. Example Dry Run** (Important for interview)

Let:
text = `abcxabcdabcdabcy`
pattern = `abcd`

Pattern length = 4

### Initial hashing window:

```
text[0..3] = "abcx"
H("abcd") = X
H("abcx") = Y
→ no match
```

Slide forward:

```
window: "bcxa"
window: "cxab"
window: "xabc"
window: "abcd"  ← match
Verify → true
```

Continue scanning.

---

# **14. When to Use Karp–Rabin (Interview)**

Use when:

* Searching *many patterns* in one text.
* Searching *same pattern* across many documents.
* Need near-linear performance in practice.
* Hashing is cheap.

Avoid when:

* Pattern length is tiny → naive is faster.
* Need worst-case guarantees → use KMP or Z-algorithm.

---

# **15. Comparison with Other Algorithms**

| Algorithm             | Best for                         | Time               |
| --------------------- | -------------------------------- | ------------------ |
| **Naive**             | Quick coding                     | O(n·m)             |
| **KMP**               | Worst-case guarantees            | O(n + m)           |
| **Rabin–Karp**        | Multiple patterns / average fast | Amortized O(n + m) |
| **Z Algorithm**       | Preprocessing pattern+text       | O(n + m)           |
| **Suffix Array/Tree** | Heavy preprocessing              | O(n) build         |

---

# **16. Summary Points (Revision Sheet)**

* Hash-based string matching.
* Polynomial rolling hash.
* Amortized linear; worst-case quadratic.
* Las Vegas version verifies matches.
* Monte Carlo version accepts hash-only match.
* Best when searching multiple patterns.

---

