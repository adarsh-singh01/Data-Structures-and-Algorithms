# Time & Space Complexity — extremely detailed, math-first, interview-ready notes

These notes cover **what** time/space complexity are, **formal notation** (Big-O, Ω, Θ, little-o), **why** we ignore lower-order terms and constants, **common growth orders**, how to **analyze loops and recursion**, **recurrence solving methods** (plug-and-chug, Master Theorem, Akra–Bazzi) with examples, and **linear recurrence solutions** (Fibonacci via characteristic equation) including non-homogeneous cases.

---

## 1 — What is *time complexity*?

**Informal:** Time complexity measures how the running time (number of basic operations) of an algorithm grows with input size (n).

**Why not “seconds”?** Execution time depends on machine speed, compiler, caching, I/O, etc. Complexity abstracts these out and describes *growth* as (n \to \infty). Two machines may differ by constant factors; asymptotic notation ignores constants and low-order terms to capture the algorithm’s scalability.

**Old computer vs new computer:** a new CPU might be (10\times) faster (constant factor). If algorithm A is (O(n)) and B is (O(n\log n)), for small (n) B may be faster on old hardware due to constants, but asymptotically the one with lower growth will dominate on large (n). Complexity focuses on behavior for large input sizes.

---

## 2 — Basic growth orders (common hierarchy)

Small → large (typical order of growth):

[
O(1) ;<; O(\log n);<; O(n);<; O(n \log n);<; O(n^2);<; O(n^3);<; O(2^n);<; O(n!)
]

Examples:

* (O(1)): array index, addition.
* (O(\log n)): binary search.
* (O(n)): single loop.
* (O(n\log n)): mergesort, heapsort.
* (O(n^2)): double nested loop (naive matrix multiply).
* (O(2^n)): naive subset enumeration, naive Fibonacci recursion.
* (O(n!)): permutations enumeration.

---

## 3 — Formal definitions (mathematical)

Let (f(n)) and (g(n)) be functions from positive integers to positive reals.

### Big-O (upper bound)

(f(n) = O(g(n))) means:
[
\exists c>0,; \exists n_0:; \forall n\ge n_0,; f(n) \le c\cdot g(n).
]
Interpretation: for sufficiently large (n), (f) grows no faster than a constant times (g).

### Big-Ω (lower bound)

(f(n) = \Omega(g(n))) means:
[
\exists c>0,; \exists n_0:; \forall n\ge n_0,; f(n) \ge c\cdot g(n).
]
Interpretation: asymptotically (f) grows at least as fast as (g) up to a constant.

### Big-Θ (tight bound)

(f(n) = \Theta(g(n))) iff both (f(n) = O(g(n))) and (f(n) = \Omega(g(n))).
Meaning: (f) and (g) grow at the same rate asymptotically (within constant factors).

### little-o (strictly smaller)

(f(n) = o(g(n))) means:
[
\lim_{n\to\infty} \frac{f(n)}{g(n)} = 0.
]
I.e., (f) grows strictly slower than (g); no constant (c>0) can make (f(n)\le c g(n)) for large (n).

---

## 4 — Why ignore constants and lower-order terms?

**Example:** (T(n) = 3n^2 + 5n + 100).

For large (n), the (n^2) term dominates. Formally,

[
\lim_{n\to\infty} \frac{3n^2 + 5n + 100}{n^2} = 3.
]

So (T(n) = \Theta(n^2)). We ignore constants and lower-order terms because asymptotic growth is determined by the highest polynomial term (or fastest-growing factor), and constant factors represent machine/implementation specifics.

**Practical rule:** Keep the dominant term only; express in simplest asymptotic form (Big-O, Θ, or Ω depending on context).

---

## 5 — Best, worst, and average case

* **Worst-case complexity:** upper bound on time for any input of size (n). Usually reported with Big-O.
* **Best-case complexity:** lower bound on time for some input of size (n). Reported with Ω.
* **Average-case complexity:** expected time over a distribution of inputs.

---

## 6 — Space complexity

* **Total space:** all memory used (input + auxiliary).
* **Auxiliary space:** extra space used by algorithm excluding input (commonly reported).

Examples:

* In-place sort: (O(1)) auxiliary space (e.g., quicksort partitioning with iterative recursion eliminated).
* Merge sort: (O(n)) auxiliary for merging unless implemented in-place.

**Recursive algorithms:** auxiliary space includes recursion stack depth. For recursion tree height (h), stack uses (O(h)) space.

---

## 7 — Analyzing loops & examples

### Single loop

```java
for (int i=0;i<n;i++) sum+=arr[i];
```

Time: (O(n)). Space: (O(1)) auxiliary.

### Nested independent loops (multiplicative)

```java
for (i=0; i<n; i++)
  for (j=0; j<m; j++)
    doConstantWork();
```

Time: (O(n\cdot m)). If (m=n): (O(n^2)).

### Nested dependent loops (triangular)

```java
for (i=0; i<n; i++)
  for (j=0; j<=i; j++)
    doConstantWork();
```

Time: (\sum_{i=0}^{n-1} (i+1) = \Theta(n^2)). (Specifically (n(n+1)/2))

### Example: nested k loops each to n

Time: (O(n^k)).

---

## 8 — Recursion & recurrence relations

Recurrences express cost of recursive algorithms. Two common forms:

### Linear/Tree recursion

Example Fibonacci (tree recursion):
[
T(n) = T(n-1) + T(n-2) + O(1)
]
This yields exponential time if solved naively.

### Divide & conquer (standard form)

[
T(n) = a,T!\left(\frac{n}{b}\right) + f(n),
]
where (a) = number of subproblems, each of size (n/b), and (f(n)) = cost of dividing/combining.

---

## 9 — How to solve recurrences (three main methods)

1. **Plug & chug (iteration / expansion):** expand recurrence into summation, useful for linear recurrences or to guess pattern.
2. **Master Theorem:** quick solution for recurrences of form (T(n)=aT(n/b)+f(n)).
3. **Akra–Bazzi theorem:** more general than Master for recurrences with unequal partition sizes or non-exact divides; handles (T(n)=\sum a_i T(b_i n + g_i(n)) + f(n)).

   * For complex recurrences, one may need characteristic polynomials (for linear constant-coefficient recurrences like Fibonacci).
4. **Characteristic equation:** for homogeneous linear recurrences with constant coefficients (e.g., Fibonacci).

---

## 10 — Master Theorem (detailed)

For recurrence (T(n) = aT(n/b) + f(n)) with (a\ge1,\ b>1) and (f(n)) positive, define
[
n^{\log_b a}
]
(“critical exponent”).

**Cases:**

* **Case 1 (leaf-dominated):** If (f(n) = O(n^{\log_b a - \varepsilon})) for some (\varepsilon>0), then
  [
  T(n) = \Theta(n^{\log_b a}).
  ]
  (The work is dominated by the leaves of recursion tree.)

* **Case 2 (balanced):** If (f(n) = \Theta(n^{\log_b a}\cdot \log^k n)) for some (k\ge 0), then
  [
  T(n) = \Theta(n^{\log_b a}\cdot \log^{k+1} n).
  ]

* **Case 3 (root-dominated):** If (f(n) = \Omega(n^{\log_b a + \varepsilon})) for some (\varepsilon>0) and if regularity condition holds (a technical condition: (a f(n/b) \le c f(n)) for some (c<1) and large (n)), then
  [
  T(n) = \Theta(f(n)).
  ]

**Examples:**

* Mergesort: (T(n)=2T(n/2)+\Theta(n)). Here (a=2,b=2) so (n^{\log_b a}=n). (f(n)=n=\Theta(n^{\log_b a})) case 2 gives (T(n)=\Theta(n\log n)).
* Binary tree traversal: (T(n)=2T(n/2)+O(1)). Here (f(n)=O(1)=O(n^{1-\varepsilon})) so case 1: (T(n)=\Theta(n)).
* Quick sort average: (T(n)=2T(n/2)+\Theta(n)) -> same as mergesort average.

---

## 11 — Akra–Bazzi theorem (deep dive + worked example)

Master covers equal partition sizes (n/b). Akra–Bazzi handles recurrences like:
[
T(x) = \sum_{i=1}^k a_i T(b_i x + g_i(x)) + f(x),
\quad \text{for } x \ge x_0,
]
with constants (a_i>0), (0<b_i<1), and (g_i(x)) “small” (sublinear perturbations). Function (f(x)) is positive and reasonably regular.

**Step 1 — find (p):**
Solve for (p) (real) the equation
[
\sum_{i=1}^k a_i b_i^p = 1.
]
This (p) generalizes (\log_b a) from Master theorem.

**Step 2 — three cases (similar spirit):**

Let
[
I(x) = \int_{1}^{x} \frac{f(u)}{u^{p+1}},du.
]

* If (I(x)) converges to a constant (i.e., (f(u) = O(u^{p-\varepsilon}))), then
  [
  T(x) = \Theta(x^p).
  ]

* If (I(x) \to \infty) and grows like (\log^{k} x) etc., then
  [
  T(x) = \Theta\big(x^p (1 + I(x))\big).
  ]

* If (f(x)) grows faster than (x^p) (i.e., (f(x) = \Omega(x^{p+\varepsilon}))), and regularity conditions hold, then
  [
  T(x) = \Theta(f(x)).
  ]

**Key:** Akra–Bazzi gives precise asymptotic by integrating (f(u)/u^{p+1}).

---

### Akra–Bazzi worked example

Solve:
[
T(n) = T(n/2) + T(n/3) + n.
]

**Step 1:** find (p) such that
[
(1)\cdot\left(\tfrac12\right)^p + (1)\cdot\left(\tfrac13\right)^p = 1.
]
Numerical solution gives (p \approx 0.7878849) (see note below).

**Step 2:** Compare (f(n)=n) with (n^p). Here (n = n^1) and (1>p), so (f(n)) grows faster than (n^p).

Thus this is the root-dominated case and (regularity holds), so
[
T(n) = \Theta(n).
]

**Interpretation:** even though there are two subcalls, the linear cost (n) at the root dominates; the total runtime is (\Theta(n)).

**Why not (n\log n)?** Because when (p<1) the sum of subproblems is “sparse” enough that the extra root work (n) dominates the smaller polynomial growth of descendants.

---

### Notes on finding (p)

Solve (\sum a_i b_i^p = 1). For the example:
[
(1/2)^p + (1/3)^p = 1.
]
You can solve numerically (binary search or Newton). For many simple recurrences, (p) is rational or equals (\log_b a) (Master case).

---

## 12 — Solving recurrences by iteration (plug & chug)

Example: (T(n) = T(n-1) + n), (T(1)=1).

Unfold:
[
T(n)=T(n-1)+n = (T(n-2) + (n-1)) + n = \dots = T(1) + \sum_{k=2}^{n} k = 1 + \frac{n(n+1)}{2} - 1 = \Theta(n^2).
]

So iterative expansion often reduces recurrence to a summation you can evaluate.

---

## 13 — Linear constant-coefficient recurrences (Fibonacci style)

Recurrences of the form:
[
a_n = c_1 a_{n-1} + c_2 a_{n-2} + \dots + c_k a_{n-k}
]
are homogeneous linear recurrences with constant coefficients. Solve with **characteristic polynomial**.

### Fibonacci example

[
F_n = F_{n-1} + F_{n-2},\quad F_0=0,; F_1=1.
]

Characteristic equation: (r^2 = r + 1), i.e. (r^2 - r - 1 = 0).

Roots:
[
r = \frac{1 \pm \sqrt{5}}{2} = \phi \text{ and } \psi.
]
General solution:
[
F_n = A\phi^n + B\psi^n.
]
Use initial conditions to find (A,B):
[
F_0 = 0 = A + B, \quad F_1 = 1 = A\phi + B\psi.
]
Solve:
[
A = \frac{1}{\sqrt{5}},\quad B = -\frac{1}{\sqrt{5}}.
]
Thus **Binet’s formula**:
[
\boxed{F_n = \frac{\phi^n - \psi^n}{\sqrt{5}}}
]
where (\phi=\frac{1+\sqrt5}{2}), (\psi=\frac{1-\sqrt5}{2}).

For large (n), (\psi^n \to 0), so (F_n \approx \phi^n/\sqrt{5}) (exponential growth).

**Complexity:** naive recursive Fibonacci has exponential time; memoized or linear DP is (O(n)).

---

## 14 — Non-homogeneous linear recurrences

Form: (a_n = c_1 a_{n-1} + \dots + c_k a_{n-k} + g(n)), where (g(n)) is non-zero.

Solution:

1. Solve the homogeneous recurrence (find general solution).
2. Find a **particular solution** (a_n^{(p)}) for the non-homogeneous part (method of undetermined coefficients or generating functions).
3. General solution = homogeneous + particular.
4. Use initial conditions to determine constants.

**Example:** (a_n = 2a_{n-1} + 1).

* Homogeneous solution: (a_n^{(h)} = C \cdot 2^n).
* Guess particular solution: constant? Let (a_n^{(p)} = A). Then (A = 2A + 1) → no finite (A). Try linear (A n + B): substitute and solve. This process gives closed form.

---

## 15 — Tricks & practical guidelines

* **Recursion space (auxiliary):** for divide & conquer with depth (d), stack space is (O(d)). If each call is (n/b), depth ~ (\log_b n).
* **“Only calls that are interlinked will be on the stack at the same time.”** True: in a tree recursion, the stack depth equals the maximum root-to-leaf path length; sibling calls are not simultaneously on the stack (except for their own children).
* **Space complexity of recursion = height of recursion tree** (or max depth).
* **When recurrence has subproblems with overlapping substructure**, use memoization to convert exponential recursion to polynomial time.

---

## 16 — Example catalogue (recurrences → solution)

1. (T(n)=T(n-1)+O(1)) → (T(n)=\Theta(n)).
2. (T(n)=aT(n/b)+\Theta(n^d)) → use Master:

   * if (d < \log_b a) → (T(n)=\Theta(n^{\log_b a})).
   * if (d = \log_b a) → (T(n)=\Theta(n^{\log_b a}\log n)).
   * if (d > \log_b a) → (T(n)=\Theta(n^d)) (if regularity holds).
3. (T(n)=T(n/2)+T(n/3)+n) → Akra–Bazzi → (T(n)=\Theta(n)).
4. Fibonacci recursion (T(n)=T(n-1)+T(n-2)) → exponential; closed form via characteristic equation.

---

## 17 — Why Master vs Akra–Bazzi?

* Master theorem is quick and easy for equal partitions (and constant factors).
* Akra–Bazzi handles unequal partitions and small perturbations (g_i(n)) and provides a more precise integral form.
* Use Akra–Bazzi when you have recurrences like (T(n)=T(\alpha n)+T(\beta n)+f(n)) with (\alpha+\beta<1) or unequal.

---

## 18 — A short tutorial: solving recurrence with Master (step-by-step)

Example: (T(n)=2T(n/2)+n).

1. Identify (a=2, b=2). Compute (n^{\log_b a} = n^{\log_2 2} = n).
2. Compare (f(n)=n) to (n^{\log_b a}): they are equal ⇒ case 2 with (k=0).
3. So (T(n)=\Theta(n\log n)).

Example: (T(n)=3T(n/4)+n).

1. (a=3,b=4). (n^{\log_b a} = n^{\log_4 3} \approx n^{0.792}).
2. (f(n)=n = n^{1}) with (1 > 0.792), so case 3 ⇒ (T(n)=\Theta(n)) (root dominated).

---

## 19 — Little-o and limits method for comparing growth

If (\lim_{n\to\infty} f(n)/g(n) = 0), then (f(n) = o(g(n))).
If the limit is a nonzero constant (c), then (f(n) = \Theta(g(n))).
If the limit is (\infty), then (f(n)) grows faster and (g(n) = o(f(n))).

Use limit comparisons to classify polynomial/exponential/logarithmic growth:

* (\log n = o(n^\varepsilon)) for any (\varepsilon>0).
* Polynomial (n^c = o(2^{n})) for any constant (c).

---

## 20 — Practical examples and quick reference

* **Nested for loops:** ( \text{for } i=1..n ; \text{for } j=1..n \Rightarrow O(n^2)).
* **Dependent nested loop:** ( \text{for } i=1..n ; \text{for } j=1..i \Rightarrow \sum_{i=1}^n i = \Theta(n^2)).
* **Divide & conquer height:** For (T(n)=aT(n/b)+\dots), recursion depth ≈ (\log_b n).
* **Space for recursion:** recursion stack uses (O()depth()) frames; each frame uses local memory.

---

## 21 — Solving Fibonacci recurrence (detailed derivation)

Given (F_n = F_{n-1} + F_{n-2}) with (F_0=0,F_1=1).

1. Assume solution (F_n = r^n). Substitute:
   [
   r^n = r^{n-1} + r^{n-2} \Rightarrow r^2 = r + 1.
   ]
2. Solve roots:
   [
   r = \frac{1\pm\sqrt{5}}{2} = \phi,\psi.
   ]
3. General solution (F_n = A\phi^n + B\psi^n).
4. Use initial conditions:
   [
   F_0 = 0 = A + B,\quad F_1 = 1 = A\phi + B\psi.
   ]
   Solve: (A=1/\sqrt{5}, B=-1/\sqrt{5}).
5. Binet formula:
   [
   F_n = \frac{\phi^n - \psi^n}{\sqrt{5}}.
   ]

Asymptotically (F_n \sim \phi^n/\sqrt5).

---

## 22 — Non-homogeneous recurrence quick example

Solve (a_n = 2a_{n-1} + 1) with (a_0 = c).

1. Solve homogeneous part: (a_n^{(h)} = C\cdot 2^n).
2. Guess particular solution: try constant (A). Substitute:
   (A = 2A + 1 \Rightarrow A = -1). So particular solution (a_n^{(p)} = -1).
3. General solution: (a_n = C\cdot 2^n - 1).
4. Use initial condition to solve (C).

---

## 23 — Final practical checklist for complexity analysis

1. **Count basic ops** in loops and recurrences; express as function (T(n)).
2. **Drop constants** and lower-order terms; give Big-O or Θ.
3. **Recurrences**: try iteration first; if form fits, use Master; if partitions unequal, use Akra–Bazzi; if linear constant coefficients, use characteristic polynomial.
4. **Space:** count auxiliary allocations + recursion stack.
5. **Edge cases:** small (n) or pathological input patterns can change best/average/worst cases.
6. **Use limits** to compare functions when unsure: (\lim_{n\to\infty} f(n)/g(n)).

---

## 24 — Short summary (one-page mental map)

* Notation: (O) upper bound, (\Omega) lower bound, (\Theta) tight, (o) strict small.
* Ignore constants and lower terms for asymptotic behavior.
* Master theorem solves (T(n)=aT(n/b)+f(n)).
* Akra–Bazzi solves more general recurrences: find (p) with (\sum a_i b_i^p=1) and integrate (f(u)/u^{p+1}).
* Linear recurrences solved via characteristic equations (Fibonacci → Binet).
* Recursion stack space = height of recursion tree.
* Use memoization when recursive subproblems repeat.

---

