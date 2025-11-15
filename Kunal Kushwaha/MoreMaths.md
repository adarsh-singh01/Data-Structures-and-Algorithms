
---

# 1. Primes — finding primes up to 40 (and generally)

## Analogy

Think of numbers as people standing in a line. If a person is a “composite”, they have a “friend” (a factor) earlier in line who can mark them off. Sieve of Eratosthenes is like having the first unmarked person mark all of their multiples — after doing this for each new unmarked person, only primes remain unmarked.

## Definition

A **prime** is a natural number >1 whose only positive divisors are 1 and itself. Composite numbers have additional divisors.

## Why useful

Primes are central to hashing, cryptography, number theory, generating coprime checks, factorization tasks, and algorithmic optimizations that use divisibility.

## Methods

### A — Trial division (simple, good for single n)

To test whether `n` is prime check divisibility `d` for `2 <= d <= sqrt(n)`. If none divide `n`, `n` is prime.

Important check: use `d*d <= n` rather than `d <= sqrt(n)` to avoid computing sqrt repeatedly and to keep integer arithmetic.

**Complexity**: O(sqrt(n)) for single `n`.

### B — Sieve of Eratosthenes (all primes ≤ N)

Mark multiples of every prime starting from 2. Complexity O(N log log N) time, O(N) space.

**Why O(N log log N)?** Number of operations approximates N * (1/2 + 1/3 + 1/5 + ... ) ≈ N log log N (harmonic over primes).

## Java: primes up to 40 (and general sieve)

```java
// Sieve of Eratosthenes: list primes up to N (works fast for N up to 1e7 comfortably in Java)
public static List<Integer> sieve(int N) {
    boolean[] isComposite = new boolean[N+1];
    List<Integer> primes = new ArrayList<>();
    for (int p = 2; p*p <= N; p++) {
        if (!isComposite[p]) {
            for (int mult = p*p; mult <= N; mult += p) {
                isComposite[mult] = true;
            }
        }
    }
    for (int i = 2; i <= N; i++) if (!isComposite[i]) primes.add(i);
    return primes;
}

public static void main(String[] args) {
    List<Integer> primesUpTo40 = sieve(40);
    System.out.println(primesUpTo40); // [2,3,5,7,11,13,17,19,23,29,31,37]
}
```

## ASCII flow (sieve up to 10)

```
initial numbers: 2 3 4 5 6 7 8 9 10
p=2 -> mark multiples from 4: 4,6,8,10
remaining candidates: 2 3 _ 5 _ 7 _ 9 _
p=3 -> mark multiples from 9: 9
remaining: 2 3 5 7
done -> primes: 2,3,5,7
```

## Interview patterns

* Generate primes for factorization or totient computation.
* Use sieve to precompute primes for many queries.

---

# 2. Integer square root and sqrt to k decimals

## Analogy

Finding sqrt is like finding where two equal-length rods meet: you can look at the midpoint and check if its square is too big or too small and narrow the interval.

## Integer sqrt (binary search)

To find floor(sqrt(n)) for non-negative integer `n`:

* Search range `[0, n]` (or `[0, min(n, 46340..)]` to avoid overflow for 32-bit).
* mid = (lo + hi) / 2
* if `mid*mid <= n` → candidate, move lo = mid + 1
* else hi = mid - 1
* final answer is hi (largest mid with mid*mid <= n)

**Use `mid <= n / mid` or use `long` to avoid overflow when doing `mid*mid` for 32-bit ints.**

**Complexity:** O(log n) iterations; each iteration O(1) => O(log n).

### Java: integer sqrt via binary search

```java
public static long integerSqrt(long n) {
    if (n < 2) return n;
    long lo = 1, hi = n/2, ans = 1;
    while (lo <= hi) {
        long mid = lo + (hi - lo) / 2;
        if (mid <= n / mid) { // mid*mid <= n without overflow
            ans = mid;
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return ans;
}
```

## Sqrt to k decimal places (binary search using doubles or integer scaling)

* One approach: compute integer part `r`. Then binary search on fractional part in interval `[r, r+1)` by treating numbers as integers scaled by `10^k` (or iterate by multiplying step by 10 for each decimal place).
* Alternatively use Newton–Raphson for faster convergence.

### Simple decimal method (incremental)

```java
public static double sqrtWithPrecision(double n, int decimals) {
    long intPart = integerSqrt((long)n);
    double increment = 1.0;
    double ans = intPart;
    for (int d = 0; d < decimals; d++) {
        increment /= 10.0;
        while (ans * ans <= n) ans += increment;
        ans -= increment;
    }
    return ans;
}
```

This is O(10 * decimals * iterations) — okay for small decimals.

---

# 3. Newton–Raphson method for sqrt — derivation and why it works

## Analogy

Newton–Raphson is like sliding down a tangent line: to solve `f(x)=0` you approximate `f` by its tangent at a guess `x_i` and use where that tangent crosses the x-axis as the next guess.

## Derivation for sqrt(n)

We want `x = sqrt(S)` → equivalently solve `f(x) = x^2 - S = 0`.

Newton iteration for root of `f(x)`:

```
x_{k+1} = x_k - f(x_k)/f'(x_k)
```

Here `f'(x)=2x`. So:

```
x_{k+1} = x_k - (x_k^2 - S) / (2 x_k)
         = x_k - (x_k/2) + (S / (2 x_k))
         = (x_k + S / x_k) / 2
```

So iteration:

```
x_{k+1} = (x_k + S / x_k) / 2
```

This converges quadratically (error roughly squares each iteration) provided `x_0` is positive and not too pathological. Rapid convergence — few iterations to reach high precision.

## Why it works (intuitively)

* The tangent line of `f` at `x_k` typically intersects the x-axis much closer to actual root than `x_k`.
* For convex functions like `x^2 - S`, this produces monotonic approach and quadratic convergence.

## Complexity / convergence

* Newton converges **quadratically**: errors decrease roughly as `e_{k+1} ≈ C * e_k^2`. So if you want `p` digits of precision, iterations ≈ O(log p) (rapid).
* In practice, for double precision you need only a handful (4–10) iterations.
* For integer sqrt to `d` decimal places: cost per iteration involves division; iteration count small → overall very fast.

## Java: Newton–Raphson sqrt (double)

```java
public static double newtonSqrt(double S) {
    if (S == 0) return 0;
    double x = S; // initial guess
    for (int i = 0; i < 50; i++) { // 50 is safe for double precision
        double nx = 0.5 * (x + S / x);
        if (Math.abs(nx - x) < 1e-15) break;
        x = nx;
    }
    return x;
}
```

For integer sqrt you can use Newton in integers (using divisions) until `x*x <= n` and `x+1` squared > n.

## ASCII of iterations for S = 10

```
x0 = 10
x1 = (10 + 10/10)/2 = 5.5
x2 = (5.5 + 10/5.5)/2 ≈ 3.659...
x3 ≈ 3.196...
x4 ≈ 3.1623... final
```

---

# 4. Factorization of a number (listing prime factors)

## Analogy

Factorization is like breaking a compound into prime "atoms". Start removing smallest prime atoms repeatedly until remnant is 1.

## Methods

### A — Trial division by primes up to sqrt(n)

* Get primes up to sqrt(n) (using sieve).
* For each prime `p` <= sqrt(n), while `n % p == 0`, record `p` and divide `n /= p`.
* If after loop `n > 1` then `n` is prime (remaining factor).

**Complexity:** O(π(sqrt(n))) divisions, roughly O(sqrt(n) / log sqrt(n)). Using primes reduces constants.

### B — Pollard's Rho (for large n) — advanced (not covered in depth here).

## Java: trial factorization (using primes from sieve)

```java
public static Map<Long,Integer> factorize(long n) {
    Map<Long,Integer> factors = new LinkedHashMap<>();
    for (long p = 2; p * p <= n; p++) {
        while (n % p == 0) {
            factors.put(p, factors.getOrDefault(p,0) + 1);
            n /= p;
        }
    }
    if (n > 1) factors.put(n, factors.getOrDefault(n,0) + 1);
    return factors;
}
```

(For speed, iterate `p` over primes rather than all integers.)

## Example: 84 → prime factors 2^2 * 3^1 * 7^1

---

# 5. Modulo arithmetic & Fermat’s Little Theorem

## Analogy

Modulo arithmetic is like using a clock with `m` hours: adding or multiplying wraps around modulo `m`.

## Basic properties (for modulus `M`):

* `(a + b) % M = ((a % M) + (b % M)) % M`
* `(a * b) % M = ((a % M) * (b % M)) % M`
* Modular subtraction and division: subtraction works via addition of additive inverse; division needs modular inverse.

## Fermat’s Little Theorem

If `p` is prime and `a` is not divisible by `p` (i.e., gcd(a,p)=1), then:

```
a^(p-1) ≡ 1 (mod p)
```

Equivalently:

```
a^(p-2) ≡ a^{-1} (mod p)
```

So modular inverse of `a` modulo prime `p` is `a^(p-2) mod p`.

**Proof sketch:** group theory or combinatorial argument; many standard proofs.

## Modular exponentiation (fast pow mod)

Use binary exponentiation with mod at each multiply to avoid overflow.

### Java: modular exponentiation

```java
public static long modPow(long a, long e, long mod) {
    long res = 1 % mod;
    long base = a % mod;
    while (e > 0) {
        if ((e & 1) == 1) res = (res * base) % mod;
        base = (base * base) % mod;
        e >>= 1;
    }
    return res;
}
```

**Example using Fermat**: modular inverse:

```java
public static long modInverse(long a, long p) { // p prime
    return modPow(a, p-2, p);
}
```

**Complexity:** `modPow` O(log e) multiplications.

---

# 6. Water jug problem (3L, 5L, 8L → obtain 4L) — math and code

## Problem statement

You have jugs of capacities `A`, `B`, `C` (here 3,5,8 liters) and unlimited water. You can fill, empty, or pour from one jug to another until source is empty or destination full. Goal: measure exactly `D` liters in any jug (4L).

## Math (Bézout / solvability)

The Diophantine solvability condition: `D` is measurable iff `D % gcd(A,B,C) == 0` and `D <= max(A,B,C)` (for single jug target). For three jugs general condition uses gcd of capacities.

Compute `g = gcd(A, gcd(B, C))`. If `D % g != 0` impossible.

For 3/5/8:

* gcd(3,5,8) = 1 → any integer liter ≤ 8 possible; 4 is possible.

## Constructive approach

Two approaches:

* BFS over states `(x,y,z)` amounts in jugs (capacity constraints).
* For minimal steps and explicit moves BFS is simplest.

### State graph

* Node: (a,b,c)
* Edges: fill(i), empty(i), pour(i→j) for i != j
* Start: (0,0,0)
* Goal: any state with a==D or b==D or c==D

Number of states bounded by `(A+1)*(B+1)*(C+1)` → small for small jugs.

## Java: BFS solver (returns sequence of states or moves)

```java
static class State {
    int a,b,c;
    State(int a,int b,int c){this.a=a;this.b=b;this.c=c;}
}
public static List<State> waterJugBFS(int A,int B,int C,int D) {
    int[] cap = {A,B,C};
    State start = new State(0,0,0);
    int maxA=A, maxB=B, maxC=C;
    boolean[][][] visited = new boolean[A+1][B+1][C+1];
    Map<String,String> parent = new HashMap<>();
    Map<String,String> action = new HashMap<>();
    Queue<State> q = new LinkedList<>();
    q.add(start);
    visited[0][0][0] = true;
    String startKey = "0,0,0";
    parent.put(startKey, null);
    while (!q.isEmpty()) {
        State s = q.poll();
        if (s.a == D || s.b == D || s.c == D) {
            // reconstruct path
            List<State> path = new ArrayList<>();
            String key = s.a + "," + s.b + "," + s.c;
            while (key != null) {
                String[] parts = key.split(",");
                path.add(new State(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2])));
                key = parent.get(key);
            }
            Collections.reverse(path);
            return path;
        }
        // generate operations: fill, empty, pour
        List<State> nexts = new ArrayList<>();
        // fill each
        nexts.add(new State(A, s.b, s.c));
        nexts.add(new State(s.a, B, s.c));
        nexts.add(new State(s.a, s.b, C));
        // empty each
        nexts.add(new State(0, s.b, s.c));
        nexts.add(new State(s.a, 0, s.c));
        nexts.add(new State(s.a, s.b, 0));
        // pour a->b
        int pour = Math.min(s.a, B - s.b);
        nexts.add(new State(s.a - pour, s.b + pour, s.c));
        // pour a->c
        pour = Math.min(s.a, C - s.c);
        nexts.add(new State(s.a - pour, s.b, s.c + pour));
        // pour b->a
        pour = Math.min(s.b, A - s.a);
        nexts.add(new State(s.a + pour, s.b - pour, s.c));
        // b->c
        pour = Math.min(s.b, C - s.c);
        nexts.add(new State(s.a, s.b - pour, s.c + pour));
        // c->a
        pour = Math.min(s.c, A - s.a);
        nexts.add(new State(s.a + pour, s.b, s.c - pour));
        // c->b
        pour = Math.min(s.c, B - s.b);
        nexts.add(new State(s.a, s.b + pour, s.c - pour));

        for (State ns : nexts) {
            if (!visited[ns.a][ns.b][ns.c]) {
                visited[ns.a][ns.b][ns.c] = true;
                String nkey = ns.a + "," + ns.b + "," + ns.c;
                parent.put(nkey, s.a + "," + s.b + "," + s.c);
                q.add(ns);
            }
        }
    }
    return null; // no solution
}
```

### Example: 3,5,8 target 4

Running BFS will find a sequence (one possible solution):

* Fill 8 → (0,0,8)
* Pour 8->5 → (0,5,3)
* Empty 5 -> (0,0,3)
* Pour 3->5 → (0,3,0)
  ... There are many sequences; BFS finds a shortest in move-count.

## Math-based constructive method (2-jug variant)

For two jugs, standard method uses repeated pour/fill based on Bezout coefficients; for three jugs BFS is simplest.

## Complexity

State space `(A+1)*(B+1)*(C+1)`. BFS time O(states) and returns shortest action sequence.

---

# 7. Euclid’s algorithm (GCD) and LCM relation

## Euclid’s algorithm (recursive)

```
gcd(a, 0) = a
gcd(a, b) = gcd(b, a % b)
```

**Complexity:** O(log min(a,b)) iterations (each step reduces numbers).

### Java:

```java
public static long gcd(long a, long b) {
    while (b != 0) {
        long t = a % b;
        a = b;
        b = t;
    }
    return Math.abs(a);
}
```

## LCM formula

```
lcm(a,b) = a / gcd(a,b) * b
```

Use `a / gcd(a,b)` first to avoid overflow when computing `a*b`.

### Java:

```java
public static long lcm(long a, long b) {
    if (a == 0 || b == 0) return 0;
    return Math.abs(a / gcd(a,b) * b);
}
```

---

# 8. Miscellaneous useful formulas & tips

### Number of digits in base `b`

Number of digits of positive integer `n` in base `b` is: `floor(log_b(n)) + 1`. Use `Math.log(n)/Math.log(b)` with rounding caveats.

### Check if power of two

`(n > 0) && (n & (n-1)) == 0`.

### Counting primes / sieve complexity

Sieve up to N: time O(N log log N), space O(N).

### Finding factors

Factors come in pairs `(d, n/d)`. Iterate `d` from `1` to `floor(sqrt(n))` and collect both when divisible.

---

# 9. Worked small examples and ASCII traces

## Example: trial division to test primality of 37

```
check d=2: 37%2 !=0
d=3: 37%3 !=0
d=4: 4*4=16 <=37 -> 37%4 !=0
...
stop when d*d > 37 (d=7 gives 49>37) -> prime
```

## Example: integerSqrt(n=37)

Binary search:

```
lo=1 hi=18 mid=9 -> 9*9=81>37 -> hi=8
mid=(1+8)/2=4 -> 16<=37 -> ans=4 lo=5
mid=6 -> 36<=37 -> ans=6 lo=7
mid=7 -> 49>37 -> hi=6
stop -> ans=6 (6*6<=37 <7*7)
```

## Newton on S=37

x0=37
x1=(37 + 37/37)/2 = (37 +1)/2 = 19
x2=(19 + 37/19)/2 ≈ (19 + 1.947)/2 ≈ 10.473...
... converge quickly to 6.0827...

---

# 10. Summary table (complexities & when to use)

| Task                      | Recommended method           | Time complexity              | Space               |
| ------------------------- | ---------------------------- | ---------------------------- | ------------------- |
| primality (single n)      | trial division up to sqrt(n) | O(sqrt(n))                   | O(1)                |
| primes ≤ N (many)         | sieve of Eratosthenes        | O(N log log N)               | O(N)                |
| integer sqrt              | binary search or Newton      | O(log n) / few iter          | O(1)                |
| sqrt to k decimals        | Newton or scaled binary      | few iterations (Newton fast) | O(1)                |
| factorization small n     | trial division (primes)      | ~O(sqrt(n)/log n)            | O(1) or primes list |
| modular pow               | binary exponentiation        | O(log exponent)              | O(1)                |
| modular inverse mod prime | Fermat + modPow              | O(log p)                     | O(1)                |
| water jug solution        | BFS on states                | O(ABC) states                | O(ABC)              |
| gcd                       | Euclid                       | O(log min(a,b))              | O(1)                |

---

# 11. Interview patterns & questions to practice

* Implement `isPrime(n)` both with trial division and simple Miller–Rabin for large `n`.
* Implement sieve and use it to factor many numbers quickly.
* Implement integer sqrt by binary search (watch overflow).
* Implement Newton–Raphson and explain quadratic convergence.
* Implement `modPow` and use Fermat to compute modular inverse.
* Solve water jug variants with BFS and detect impossibility via gcd.
* Implement Euclid gcd and LCM (avoid overflow).
* Given `n`, count set bits, count primes ≤ n, sum of divisors, number of divisors — use factorization.

---
