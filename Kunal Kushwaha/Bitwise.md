

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

