

---

# Bitwise Operations — Deep, interview-ready notes (with complete Java code)

---

## 1) Real-world analogy

Imagine each binary digit (bit) as a tiny light switch in a row of lamps.

* Turning a lamp **on** = bit `1`.
* Turning a lamp **off** = bit `0`.

Bitwise operators are tools that let you flip, combine or inspect these switches extremely quickly — like wiring panels that let you toggle many switches at once, or compare two panels lamp-by-lamp.

This explains why bitwise operations are used for low-level efficiency, flags, masks, and clever algorithmic tricks.

---

## 2) What is a bitwise operator? (definition)

A **bitwise operator** applies logical or shift operations to the binary representations of integers, operating on each bit (0/1) individually: AND (`&`), OR (`|`), XOR (`^`), NOT/Complement (`~`), left shift (`<<`), right shift (`>>`), and unsigned right shift (`>>>` in Java).

---

## 3) Why bitwise operations are useful (real-world reasons)

* **Speed**: bitwise ops are CPU-level, O(1) and extremely fast.
* **Memory efficiency**: use bits to represent multiple boolean flags in single integers.
* **Elegant tricks**: parity, power-of-two checks, extracting low/high bits, toggling, masks.
* **Common interview patterns**: XOR-based single-unique-element, bit counting, bit DP, subset enumeration.

---

## 4) Technical breakdown — operators and important identities

### a) AND (`&`)

* Operation: `a & b`: bitwise AND — bit is 1 if both bits are 1.
* Use: mask bits (keep some bits, zero others).
* Example: `x & 1` yields LSB (0 if even, 1 if odd).

### b) OR (`|`)

* `a | b`: bitwise OR — bit is 1 if any operand bit is 1.
* Use: set bits via mask: `x | mask`.

### c) XOR (`^`)

* `a ^ b`: bitwise XOR — bit is 1 if bits differ.
* Identities:

  * `a ^ 0 = a`
  * `a ^ a = 0`
  * `a ^ 1` flips the bit (on single-bit).
* Useful: cancel pairs (XOR of all array elements = unique one when others appear twice).

### d) NOT / Complement (`~`)

* `~a`: bitwise complement flips every bit.
* Two’s complement negative: `-a == ~a + 1`.

### e) Left shift (`<<`)

* `a << b` shifts bits left by `b` places (fills with 0), numeric effect: `a * 2^b` (if no overflow).
* Example: `x << 1` doubles `x` (in integer arithmetic modulo word-size).

### f) Right shift (`>>`, `>>>`)

* `a >> b`: arithmetic right shift — preserve sign bit (for signed types).
* `a >>> b`: logical right shift — fill with zeros (Java only; unsigned).
* Numeric effect for positive `a`: `a >> b` ≈ `a / 2^b` (floor).

---

## 5) Important bitwise observations / identities (handy in problems)

* `a & 1` → LSB (0 for even, 1 for odd).
* `n & (n - 1)` clears the lowest set bit; if result is 0 and n>0 then n was a power of two.
* `n & -n` gives the rightmost set bit mask.
* XOR of all numbers where every number appears twice except one → yields the unique number.
* `a ^ a = 0`, `a ^ 0 = a`.
* Two’s complement negative: `-x = (~x) + 1`.

---

## 6) Binary basics & ranges

* Base conversions: divide by base, take remainders to convert decimal→base; multiply-add for base→decimal.
* 1 byte = 8 bits. With `n` bits signed (two’s complement) range: `[-2^{n-1}, 2^{n-1}-1]`.
* MSB = most significant bit (leftmost), LSB = least significant bit (rightmost).
* Example 8-bit signed: `-128 .. 127`.

---

## 7) Complete solved code questions (Java) — each function has explanation, code, example, complexity

I'll provide a `BitwiseUtils` class with static methods for the common tasks you listed and small usage demos. Each method includes time/space complexity.

```java
// BitwiseUtils.java
import java.util.*;

public class BitwiseUtils {

    // 1) Check even/odd using bitwise
    // - Use a & 1: O(1)
    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    // 2) Find unique element when every other element appears twice (XOR trick)
    // - XOR all numbers -> returns unique one. O(n) time, O(1) space
    public static int findUniqueWithXor(int[] arr) {
        int xr = 0;
        for (int v : arr) xr ^= v;
        return xr;
    }

    // 3) Highest set bit (most significant set bit) as mask (returns mask, e.g., for 13 returns 8)
    // Approach: propagate highest bit and then (x+1)>>1. Works for x>0.
    // O(1) arithmetic on fixed-size ints (loop unrolled), but O(log W) bit ops where W is word size.
    public static int highestBitMask(int x) {
        if (x == 0) return 0;
        // propagate highest set bit to all lower bits:
        x |= (x >> 1);
        x |= (x >> 2);
        x |= (x >> 4);
        x |= (x >> 8);
        x |= (x >> 16);
        // now x is like 0b11111... up to originally highest bit
        return (x + 1) >>> 1; // mask with only top bit set
    }

    // 4) Set the i-th bit (0-based index)
    // returns new number with bit i set to 1.
    public static int setIthBit(int n, int i) {
        return n | (1 << i);
    }

    // 5) Reset (clear) the i-th bit (0-based)
    public static int clearIthBit(int n, int i) {
        return n & ~(1 << i);
    }

    // 6) Toggle the ith bit (flip)
    public static int toggleIthBit(int n, int i) {
        return n ^ (1 << i);
    }

    // 7) Position (mask) of rightmost set bit: n & (-n)
    // returns mask with only rightmost set bit. For n=0 -> returns 0.
    public static int rightmostSetBitMask(int n) {
        return n == 0 ? 0 : (n & -n);
    }

    // 8) Two's complement negative demonstration (returns -n)
    // Java already does two's complement; show formula -n == ~n + 1
    public static int negativeViaTwosComplement(int n) {
        return (~n) + 1;
    }

    // 9) Count set bits (Brian Kernighan): O(k) where k is number of set bits
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    // 10) XOR of numbers from 0 to n (inclusive) — pattern repeats every 4
    // returns xor(0..n)
    public static int xorFrom0ToN(int n) {
        switch (n & 3) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0; // case 3
        }
    }

    // 11) XOR of numbers in [a, b] (inclusive)
    public static int xorRangeAB(int a, int b) {
        return xorFrom0ToN(b) ^ xorFrom0ToN(a - 1);
    }

    // 12) Flip and invert image (LeetCode style): given binary matrix, flip horizontally then invert bits.
    // Time O(m*n), Space O(1) extra
    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = A[i].length - 1;
            while (l <= r) {
                // swap and invert in place
                int left = A[i][l];
                int right = A[i][r];
                // invert while swapping
                A[i][l] = 1 ^ right;
                A[i][r] = 1 ^ left;
                l++; r--;
            }
        }
        return A;
    }

    // 13) Power test: check if n is power of two: n > 0 && (n & (n-1)) == 0
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ( (n & (n - 1)) == 0 );
    }

    // 14) Fast exponentiation a^b (binary exponentiation) for integers (use long)
    // O(log b)
    public static long fastPow(long a, long b) {
        long res = 1;
        long base = a;
        while (b > 0) {
            if ((b & 1) == 1) res = res * base;
            base = base * base;
            b >>= 1;
        }
        return res;
    }

    // 15) Number of digits of n in base b (n > 0)
    // digits = floor(log_b(n)) + 1 ; implement safely using loops or Math.log
    public static int digitsInBase(long n, int b) {
        if (n <= 0) return 0;
        return (int)(Math.floor(Math.log(n) / Math.log(b))) + 1;
    }

    // 16) Nth magic number (common problem): sum of powers of 5 using binary digits of n
    // Definition: nth magic number = sum_{i=0..} ( (n >> i) & 1 ) * 5^{i+1}
    // Example: n=3 (binary 11) => 5 + 25 = 30 (depends on exact problem variant). We'll implement standard version:
    public static int nthMagicNumber(int n) {
        int power = 5;
        int ans = 0;
        while (n > 0) {
            if ((n & 1) == 1) ans += power;
            power *= 5;
            n >>= 1;
        }
        return ans;
    }

    // 17) Find position/index (0-based) of rightmost set bit (returns -1 if none)
    public static int indexOfRightmostSetBit(int n) {
        if (n == 0) return -1;
        int mask = n & -n;
        return Integer.numberOfTrailingZeros(mask); // built-in
    }

    // 18) XOR of array when numbers have +/− pairs and one number without complement:
    // If array has x and -x for all except one, XOR of all elements won't directly give answer because negative's bits differ.
    // But if the problem was "numbers appear in pairs (same) except one", XOR works. If positives & negatives, you'd sum or use a map.
    // Provide the XOR-solution for classic case:
    public static int findSingleInPairs(int[] arr) {
        return findUniqueWithXor(arr);
    }

    // small demo
    public static void main(String[] args) {
        System.out.println("isOdd(7): " + isOdd(7));
        System.out.println("unique xor: " + findUniqueWithXor(new int[]{2,3,2,4,4}));
        System.out.println("highestBitMask(13): " + highestBitMask(13));
        System.out.println("set 2nd bit of 5: " + setIthBit(5,2)); // 5(101) set bit2 -> 101|100=101 -> actually unchanged
        System.out.println("clear 0th bit of 5: " + clearIthBit(5,0)); // 5->101 -> becomes 100 = 4
        System.out.println("rightmostSetBitMask(12): " + rightmostSetBitMask(12)); // 12(1100) -> 0100=4
        System.out.println("negativeViaTwosComplement(5): " + negativeViaTwosComplement(5));
        System.out.println("countSetBits(29): " + countSetBits(29)); // 29 = 11101 -> 4
        System.out.println("xorFrom0ToN(7): " + xorFrom0ToN(7));
        System.out.println("xorRangeAB(3,9): " + xorRangeAB(3,9));
        System.out.println("isPowerOfTwo(16): " + isPowerOfTwo(16));
        System.out.println("fastPow(2,10): " + fastPow(2,10));
        System.out.println("digitsInBase(255,16): " + digitsInBase(255,16));
        System.out.println("nthMagicNumber(6): " + nthMagicNumber(6));
        System.out.println("indexOfRightmostSetBit(40): " + indexOfRightmostSetBit(40)); // 40=101000 -> trailing zeros=3
    }
}
```

---

### Explanations & corrections for some of your original lines

* **“Answer is n & (1 << (n-1))”** — that line looked wrong: to check if the k-th bit (0-based) is set, do `n & (1 << k)`. To test highest bit, you find the index via `floor(log2(n))` or use the propagate trick shown above.

* **Set ith bit**: `n | (1 << i)` (i zero-based).
  Example: set bit 2 of `5 (101)` → `(1<<2)=100` → `101 | 100 = 101` (already set). If it had been `1 (001)`, set bit2 → `101 = 5`.

* **Reset ith bit**: `n & ~(1 << i)`.

* **Rightmost set bit mask**: `n & -n` works because two’s complement negative flips and adds one, isolating LSB.

* **Negative in binary**: two’s complement: invert bits and add 1. For example for 4-bit range, +3 = `0011`, negative -3 = `(~0011)+1 = 1100+1 = 1101` (which is -3 in signed two’s complement). Java uses 32-bit two’s complement for `int`.

---

## 8) Visual/ASCII explanations (key flows)

### a) XOR pair trick (find unique)

```
arr = [5, 3, 5, 2, 3]
xor = 0
xor ^= 5 -> 5
xor ^= 3 -> 6
xor ^= 5 -> 3
xor ^= 2 -> 1
xor ^= 3 -> 2  <-- unique element
```

Because `x^x=0` pairs cancel.

### b) Clear rightmost set bit: n & (n-1)

```
n = 12 (1100)
n-1 = 11 (1011)
n & (n-1) = 1000 (8) -> cleared lowest set bit
```

### c) Rightmost set bit mask: n & (-n)

```
n = 12 (1100)
two's complement -n = (~1100)+1 = 0011 + 1 = 0100 (4)
n & (-n) = 1100 & 0100 = 0100 => mask 4
```

### d) Highest bit mask: propagation method

```
x = 13 -> 0000 0000 0000 1101
x |= x>>1  -> 0000..1111
x |= x>>2  -> still 0000..1111
(x+1) >>> 1 -> 0000..1000  => 8
```

---

## 9) Interview patterns & where to apply these tricks

* **Parity / odd-even**: `n & 1`.
* **Single unique element**: XOR of all elements.
* **Power of two**: `n > 0 && (n & (n - 1)) == 0`.
* **Remove rightmost set bit**: while `n > 0` do `n &= (n - 1)` to enumerate set bits.
* **Count set bits**: Brian Kernighan algorithm.
* **Find rightmost set bit index**: `Integer.numberOfTrailingZeros(n)` or `n & -n` then `ctz`.
* **Masks for flags**: use `(1 << k)` & combine with `|` and `& ~`.
* **Fast multiplications/divisions by 2^k**: `<<` and `>>` (careful with negative numbers and sign).
* **Fast exponentiation**: use binary exponentiation (bitwise iterate `b`).

---

## 10) Complexity summary (per function)

* `isOdd` — O(1) time, O(1) space.
* `findUniqueWithXor` — O(n) time, O(1) space.
* `highestBitMask` — O(1) (constant number of word operations), O(1) space.
* `set/clear/toggle ith bit` — O(1).
* `rightmostSetBitMask` — O(1).
* `negativeViaTwosComplement` — O(1).
* `countSetBits` (Brian Kernighan) — O(k) where k = number of set bits (≤ word size), so O(1) practically for 32-bit ints; O(log n) in terms of n’s bit-length.
* `xorFrom0ToN` — O(1).
* `xorRangeAB` — O(1).
* `flipAndInvertImage` — O(m * n), O(1) extra.
* `isPowerOfTwo` — O(1).
* `fastPow` — O(log b) time.
* `digitsInBase` — O(1) using logs (or O(log_b n) by loop).
* `nthMagicNumber` — O(log n) (number of bits in n).
* `indexOfRightmostSetBit` — O(1) using builtin.

---

## 11) Common pitfalls & corrections

* **Be explicit about indexing**: `i`-th bit — clarify 0-based vs 1-based. I used 0-based throughout.
* **Watch signed shifts**: `>>` keeps sign bit; `>>>` fills with zeros.
* **Overflow**: `<<` can overflow the integer word-size; bitwise math is modulo word-size.
* **Negative numbers**: `n & (n-1)` works for signed ints as it manipulates two’s complement bits; but be cautious when reasoning about sign.

---

## 12) Quick reference cheat-sheet (copyable)

* Check odd: `(n & 1) == 1`
* Set bit i: `n | (1 << i)`
* Clear bit i: `n & ~(1 << i)`
* Toggle bit i: `n ^ (1 << i)`
* Check bit i: `(n >> i) & 1`
* Rightmost set bit mask: `n & -n`
* Clear rightmost set bit: `n & (n - 1)`
* Power of 2 check: `n > 0 && (n & (n - 1)) == 0`
* Count bits: Brian Kernighan
* Highest set bit mask: use propagation trick (see code)
* XOR range: `xor(0..b) ^ xor(0..a-1)`

---


# Walkthrough of `BitwiseUtils` methods — binary traces & ASCII diagrams

> Note: Java `int` is 32-bit two’s-complement. For readability I show compact bit-views (8 or 16 bits) unless sign behavior matters — and I call out when full 32-bit behavior or sign-extension is relevant.

---

## 1) `isOdd(int n)` — Check if number is odd

**Purpose:** Return `true` if `n` is odd, else `false`.

**Input:** `n = 7`

**Operation:** `(n & 1) == 1`

**Binary trace (8-bit view):**

```
n = 7  ->  0000 0111
1      ->  0000 0001
n & 1  ->  0000 0001  = 1  => odd
```

**ASCII explanation:**

```
00000111  (7)
&00000001  (1)
-------- 
00000001  => 1 -> true (odd)
```

**Why this works:** The least significant bit (LSB) indicates parity. If LSB = 1 → odd.

**Edge cases:** Works for positive and negative numbers (two’s complement preserves LSB parity).
**Complexity:** O(1) time, O(1) space.

---

## 2) `findUniqueWithXor(int[] arr)` — XOR all to find unique element

**Purpose:** When every element appears twice except one, XORing all yields the unique element.

**Input:** `arr = {2, 3, 2, 4, 4}`

**Operation:** XOR in sequence:

```
xor = 0
xor ^= 2 -> 00000010 (2)
xor ^= 3 -> 00000010 ^ 00000011 = 00000001 (1)
xor ^= 2 -> 00000001 ^ 00000010 = 00000011 (3)
xor ^= 4 -> 00000011 ^ 00000100 = 00000111 (7)
xor ^= 4 -> 00000111 ^ 00000100 = 00000011 (3)
result = 3
```

**ASCII trace:**

```
0 ^ 2 = 2
2 ^ 3 = 1
1 ^ 2 = 3
3 ^ 4 = 7
7 ^ 4 = 3  -> unique = 3
```

**Why this works:** XOR cancels pairs (`x ^ x = 0`), and `0 ^ y = y`. Order independent.

**Edge cases:** If there are elements that appear odd times other than 1, this method fails.
**Complexity:** O(n) time, O(1) space.

---

## 3) `highestBitMask(int x)` — Mask of most significant set bit

**Purpose:** Return a mask with only the highest (leftmost) set bit preserved (e.g., for 13 -> 8).

**Input:** `x = 37` (example requested)

* `37` decimal → binary `0010 0101` (8-bit view). Highest set bit is the bit for value `32` (2^5).

**Algorithm used:** propagate the highest bit to all lower bits, then isolate it:

```
x |= x >> 1;
x |= x >> 2;
x |= x >> 4;
x |= x >> 8; ... (depending on word size)
return (x + 1) >>> 1;
```

**Step-by-step binary trace (start with 8-bit):**

Start:

```
x =  00100101  (37)
```

1. `x |= x >> 1`

```
x >> 1 = 00010010
x |=    00100101
        00010010
result:  00110111
```

2. `x |= x >> 2`

```
x >> 2 = 00001101
x |=    00110111
        00001101
result:  00111111
```

3. `x |= x >> 4`

```
x >> 4 = 00000011
x |=    00111111
        00000011
result:  00111111 (unchanged)
```

(For 8-bit we are done; in 32-bit code we did further shifts up to 16 bits etc — those won't change it further.)

Now `x = 00111111` (binary), which is `63`.

Compute `(x + 1) >>> 1`:

```
x + 1 = 01000000 (64)
(x + 1) >>> 1 = 00100000 (32)  => highest bit mask
```

**ASCII steps:**

```
initial  : 0010 0101 (37)
after ops: 0011 1111 (63)
x+1      : 0100 0000 (64)
(x+1)>>>1: 0010 0000 (32) => mask
```

**Result:** `32` (`0010 0000`) — correct highest-bit mask.

**Why this works:** Propagating sets all bits below the MSB to 1. Adding 1 produces a carry that leaves only a single 1 above the original MSB; shifting right isolates the original MSB as a single-bit mask.

**Edge cases:**

* `x = 0` → return 0.
* For `int` 32-bit, the code uses shifts up to 16 to cover full word.

**Complexity:** O(1) time (fixed small number of bit ops), O(1) space.

---

## 4) `setIthBit(int n, int i)` — Set i-th bit to 1 (0-based)

**Purpose:** Return `n` with the bit at index `i` set to 1.

**Input:** `n = 5 (00000101)`, `i = 2`.

**Operation:** `n | (1 << i)`

**Trace:**

```
(1 << 2) = 00000100 (4)
n =        00000101 (5)
n | mask = 00000101 (5)  // already set
```

**Result:** 5 (unchanged because bit 2 was already 1).

**If n=1 (00000001) and i=2:**

```
1 << 2 = 00000100
1 | 00000100 = 00000101 = 5
```

**Why it works:** OR with mask turns target bit to 1 without affecting other bits.

**Complexity:** O(1).

---

## 5) `clearIthBit(int n, int i)` — Clear (reset) i-th bit to 0

**Purpose:** Return `n` with the bit at index i set to 0.

**Input:** `n = 5 (00000101)`, `i = 0`.

**Operation:** `n & ~(1 << i)`

**Trace:**

```
(1<<0) = 00000001
~(1<<0)= 11111110
n =      00000101
n & ~ =  00000100 = 4
```

**Result:** 4 (`00000100`), LSB cleared.

**Why it works:** `~(1<<i)` is mask with zeros at i and ones elsewhere. ANDing clears the target bit.

**Complexity:** O(1).

---

## 6) `toggleIthBit(int n, int i)` — Flip the i-th bit

**Purpose:** Flip the bit: 0→1, 1→0.

**Input:** `n = 8 (00001000)`, `i = 3`

**Operation:** `n ^ (1 << i)`

**Trace:**

```
1<<3 = 00001000
n    = 00001000
n ^ mask = 00000000 => 0
```

**If input was `n=0`**:

```
0 ^ 00001000 = 00001000 => 8
```

**Why it works:** XOR with 1 flips the bit, XOR with 0 keeps it same.

**Complexity:** O(1).

---

## 7) `rightmostSetBitMask(int n)` — mask with only lowest set bit (n & -n)

**Purpose:** Return a mask with only the rightmost (least significant) set bit, `0` if `n=0`.

**Input:** `n = 12 (00001100)`

**Operation:** `n & (-n)`

**Binary trace (8-bit):**

```
n      = 00001100 (12)
~n     = 11110011
-n     = ~n + 1 = 11110011 + 1 = 11110100 (two's complement)
n & -n = 00001100 & 11110100 = 00000100 (4)
```

**ASCII:**

```
00001100 (n)
&11110100 (-n)
=00000100 => mask = 4
```

**Why it works:** Two’s complement construction isolates the lowest set bit.

**Edge cases:** `n=0` → result 0. For negative numbers, behavior still isolates LSB because two’s complement math is consistent.

**Complexity:** O(1).

---

## 8) `negativeViaTwosComplement(int n)` — compute -n as `~n + 1`

**Purpose:** Show two’s complement negative calculation.

**Input:** `n=5`

**Trace (8-bit):**

```
n      = 00000101
~n     = 11111010
~n + 1 = 11111011  => -5 in 8-bit two's complement 
```

**Check:** In Java 32-bit, `(~n) + 1` equals `-n`.

**Why it works:** Two’s complement representation: invert bits and add 1.

**Caveat:** Displaying negative numbers in n-bit requires understanding of two’s complement: `11111011` interpreted as signed is `-5`.

**Complexity:** O(1).

---

## 9) `countSetBits(int n)` — Brian Kernighan’s algorithm

**Purpose:** Count number of `1` bits efficiently by repeatedly clearing lowest set bit.

**Input:** `n = 29` → binary `00011101` (bits = 4)

**Algorithm:** while `n != 0`: `n = n & (n - 1)`, increment count.

**Trace:**

```
n = 00011101 (29) count=0
n & (n-1) -> 00011100 (28) count=1
n & (n-1) -> 00011000 (24) count=2
n & (n-1) -> 00010000 (16) count=3
n & (n-1) -> 00000000 (0)  count=4
stop -> count=4
```

**ASCII progression:**

```
29: 00011101
28: 00011100
24: 00011000
16: 00010000
0 : 00000000 -> done
```

**Complexity:** O(k) where k = number of set bits. In worst-case for 32-bit it's O(32) → O(1) practically; in bit-length terms O(log n).

---

## 10) `xorFrom0ToN(int n)` — XOR(0..n)

**Purpose:** Compute XOR of all integers from 0 to n in O(1) using pattern mod 4.

**Pattern:** n % 4 => result

* 0 → n
* 1 → 1
* 2 → n + 1
* 3 → 0

**Example:** `n=7` (7 % 4 = 3) → result = 0.

**Brief reason:** XOR pattern repeats every 4 numbers due to cancellations.

**Complexity:** O(1).

---

## 11) `xorRangeAB(int a, int b)` — XOR of [a..b]

**Purpose:** XOR(0..b) ^ XOR(0..a-1) gives XOR(a..b).

**Example:** `a=3, b=9`

```
xor(0..9)  ^ xor(0..2)  => result
```

Compute via `xorFrom0ToN`.

**Complexity:** O(1).

---

## 12) `flipAndInvertImage(int[][] A)` — flip horizontally and invert

**Purpose:** For each row, reverse the row and invert bits.

**Input sample:**

```
A = [
 [1,1,0],
 [1,0,1],
 [0,0,0]
]
```

**Operation:** For each row, swap left/right and invert (`1 ^ value`), doing both in place.

**Trace row-by-row:**

Row0 `[1,1,0]`

* l=0 r=2: left=1, right=0 -> A[0]=1^0=1, A[2]=1^1=0 => after step: [1,1,0] (same)
* l++ r-- => l=1 r=1: l==r -> invert center: 1 -> 0? Wait code in BitwiseUtils did `while (l <= r)` and swapped with invert; for center, it will set `A[mid] = 1 ^ A[mid]` twice? Let's clarify the code's behavior: it assigns `A[l] = 1 ^ right; A[r] = 1 ^ left;` When l==r, left==right==original mid => both assignments overwrite same location, but both will set appropriate inverted value. For center `v`, both will set `1 ^ v` ultimately correct.

Final matrix after all rows processed:

```
[
 [1,0,0] flipped+inverted ???  // Let's compute carefully below with correct method.
]
```

Let's perform carefully for each row:

Row0 `[1,1,0]`

* l=0 r=2: left=1, right=0

  * A[0] = 1 ^ right = 1 ^ 0 = 1
  * A[2] = 1 ^ left  = 1 ^ 1 = 0
    => row becomes [1,1,0]
* l=1 r=1: left=1, right=1

  * A[1] = 1 ^ right = 0
  * A[1] = 1 ^ left = 0 (same) => center becomes 0
    Final row0: `[1,0,0]`

Row1 `[1,0,1]`

* l=0 r=2: left=1 right=1

  * A[0] = 1 ^ 1 = 0
  * A[2] = 1 ^ 1 = 0
* l=1 r=1: center 0 -> A[1] = 1 ^ 0 = 1
  Final row1: `[0,1,0]`

Row2 `[0,0,0]`

* l=0 r=2: left=0 right=0

  * A[0] = 1 ^ 0 = 1
  * A[2] = 1 ^ 0 = 1 => row becomes [1,0,1]
* center 0 -> 1 ^ 0 = 1 -> center becomes 1
  Final row2: `[1,1,1]`

**Final matrix:**

```
[1,0,0]
[0,1,0]
[1,1,1]
```

**ASCII before/after row0:**

```
[1 1 0] -> flip -> [0 1 1] -> invert -> [1 0 0]
```

But our method combined flip+invert in one pass.

**Complexity:** O(m*n) time, O(1) extra space (in place).

---

## 13) `isPowerOfTwo(int n)` — test power of 2

**Purpose:** Return true if `n` is power of two.

**Input:** `n = 16` → `10000`

**Test:** `n > 0 && (n & (n-1)) == 0`

**Trace:**

```
16 = 00010000
15 = 00001111
16 & 15 = 00000000 => 0 -> true
```

**Why:** power of two has exactly one bit set, clearing it yields 0.

**Edge:** `n=0` -> false. Negative numbers -> false.

**Complexity:** O(1).

---

## 14) `fastPow(long a, long b)` — binary exponentiation

**Purpose:** Compute `a^b` in O(log b) multiplications by using binary bits of exponent.

**Input:** `a=2, b=10`

**Trace:**

```
res=1, base=2, b=10(1010)
b & 1? no -> base=4, b=5
b & 1? yes -> res=1*4? Wait step-by-step proper:

Initial: res=1, base=2, b=10
b=10 (1010)
b&1==0 -> skip multiply
base=4, b=5

b=5 (0101)
b&1==1 -> res=res*4=4
base=16, b=2

b=2 (0010)
b&1==0 -> skip
base=256, b=1

b=1
b&1==1 -> res=4*256=1024
b=0 -> done

Result = 1024
```

**Complexity:** O(log b) time.

---

## 15) `digitsInBase(long n, int b)` — digits count in base b

**Purpose:** Return number of digits of n in base b: `floor(log_b(n)) + 1`

**Input:** `n=255`, `b=16` (hex)

**Trace:**

```
255 base 16 = FF (two hex digits) => digits = 2
Math approach: log_16(255) = log(255)/log(16) ≈ 1.99 => floor 1 +1 = 2
```

**Edge:** n<=0 -> return 0 or handle separately.

**Complexity:** O(1) using logs; O(log_b n) if computed by repeated division.

---

## 16) `nthMagicNumber(int n)` — magic numbers (powers of 5 sum)

**Purpose:** Many variations exist; this one uses binary digits of n to pick powers of 5: accumulate `5^1, 5^2, ...` when corresponding bit in n is 1.

**Input:** `n = 6` → binary `110` (bits LSB to MSB: 0,1,1)

**Trace:**

```
power=5, ans=0
n=6 -> (n&1)=0 -> ans += 0
power *=5 -> 25 ; n>>=1 -> n=3
n=3 -> (n&1)=1 -> ans += 25  => ans=25
power *=5 -> 125 ; n>>=1 -> n=1
n=1 -> (n&1)=1 -> ans += 125 => ans=150
n=0 -> done
return 150
```

**Interpretation:** bits correspond to selecting 5, 25, 125, ... Note different problems vary (some shift indexing).

**Complexity:** O(log n) time (#bits).

---

## 17) `indexOfRightmostSetBit(int n)` — index of rightmost set bit (0-based)

**Purpose:** Return index (position) of LSB that is set.

**Input:** `n = 40` -> binary `00101000` → rightmost set bit at index 3 (2^3 = 8).

**Operation:** compute mask `n & -n = 00001000`, then trailing zeros = index.

**Trace:**

```
40 = 00101000
40 & -40 = 00001000 (8)
Integer.numberOfTrailingZeros(8) = 3 -> index 3
```

**Complexity:** O(1) using built-in.

**Edge:** n=0 -> return -1.

---

## 18) `findSingleInPairs(int[] arr)` — alias of XOR unique (same as #2)

**Purpose:** same as `findUniqueWithXor`.

---

## Additional conceptual notes (relevant to methods above)

### - `n & (n - 1)` clears lowest set bit

Example `n = 12 (1100)` -> `n & (n-1) = 1000 (8)`.

### - `n & -n` isolates lowest set bit

Example `n = 12 (1100)` -> mask = `0100 (4)`.

### - Two’s complement negative

`-n == (~n) + 1` always holds for signed integers in two’s complement.

---

# ASCII summary of common bit tricks

**Clear lowest set bit**

```
n = 11011000
n-1= 11010111
n&(n-1)=11010000  // lowest 1 cleared
```

**Isolate lowest set bit**

```
n      = 11011000
-n     = 00101000 (two's complement)
n & -n = 00001000  // only lowest one remains
```

**Propagate highest bit to lower bits (then isolate)**

```
x    = 0010 0101
x|=x>>1 -> 0011 0111
x|=x>>2 -> 0011 1111
x|=x>>4 -> 0011 1111
(x+1) -> 0100 0000
>>1    -> 0010 0000  // highest-mask
```

---

# Final checklist & pitfalls to remember

* Bit indexing: I used **0-based** in the code. E.g., `i=0` is LSB.
* Shift overflow: shifting left by >= word-size is undefined or wraps — avoid.
* Signed shifts: `>>` preserves sign; `>>>` zero-fills. For non-negative numbers, both behave the same.
* When showing examples, I used small widths (8 bits) for readability — real `int` are 32-bit; negative numbers have sign extension.
* Many bitwise tricks rely on two’s-complement representation (Java uses it).

---

