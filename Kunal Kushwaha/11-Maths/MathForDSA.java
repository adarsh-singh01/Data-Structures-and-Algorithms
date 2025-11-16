import java.util.*;

/**
 * MathForDSA.java
 *
 * A single-file collection of math utilities commonly used in DSA.
 * Runnable main() demonstrates example usages and prints results.
 *
 * Methods included (static helpers):
 *  - sieve(N)
 *  - integerSqrt(n)
 *  - sqrtWithPrecision(n, decimals) [incremental]
 *  - newtonSqrt(n)
 *  - factorize(n) (uses trial division; uses primes when appropriate)
 *  - modPow(a,e,mod)
 *  - modInverse(a, p) (p prime, using Fermat)
 *  - waterJugBFS(A,B,C,D) : BFS search for (A,B,C) jugs to measure D
 *  - gcd(a,b), lcm(a,b)
 *
 * Designed for clarity and demonstration. Use as a starting point for deeper study.
 */
public class MathForDSA {

    // ------------------------ SIEVE OF ERATOSTHENES ------------------------
    public static List<Integer> sieve(int N) {
        if (N < 2) return Collections.emptyList();
        boolean[] isComposite = new boolean[N + 1];
        for (int p = 2; p * p <= N; p++) {
            if (!isComposite[p]) {
                for (int mult = p * p; mult <= N; mult += p) isComposite[mult] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) if (!isComposite[i]) primes.add(i);
        return primes;
    }

    // ------------------------ INTEGER SQUARE ROOT (BINARY SEARCH) ------------------------
    public static long integerSqrt(long n) {
        if (n < 2) return n;
        long lo = 1, hi = n / 2, ans = 1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid <= n / mid) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }

    // Simple decimal precision using incremental refinement (not optimal but simple)
    public static double sqrtWithPrecision(double n, int decimals) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        long intPart = (long) integerSqrt((long) n);
        double ans = intPart;
        double increment = 1.0;
        for (int d = 0; d < decimals; d++) {
            increment /= 10.0;
            while (ans * ans <= n) ans += increment;
            ans -= increment;
        }
        return ans;
    }

    // ------------------------ NEWTON-RAPHSON FOR SQRT ------------------------
    public static double newtonSqrt(double S) {
        if (S == 0) return 0;
        double x = S;
        for (int i = 0; i < 100; i++) { // 100 iterations is safe for double precision
            double nx = 0.5 * (x + S / x);
            if (Math.abs(nx - x) < 1e-15) break;
            x = nx;
        }
        return x;
    }

    // Integer variant: stops when stable for integers
    public static long newtonIntegerSqrt(long n) {
        if (n < 2) return n;
        double x = n;
        while (true) {
            double nx = 0.5 * (x + n / x);
            if (Math.abs(nx - x) < 1e-9) break;
            x = nx;
        }
        long r = (long) x;
        // adjust to ensure floor(sqrt(n))
        while ((r + 1) * (r + 1) <= n) r++;
        while (r * r > n) r--;
        return r;
    }

    // ------------------------ FACTORIZATION (TRIAL DIVISION) ------------------------
    public static LinkedHashMap<Long, Integer> factorize(long n) {
        LinkedHashMap<Long, Integer> factors = new LinkedHashMap<>();
        if (n < 2) {
            if (n == 1) factors.put(1L, 1);
            return factors;
        }
        for (long p = 2; p * p <= n; p++) {
            while (n % p == 0) {
                factors.put(p, factors.getOrDefault(p, 0) + 1);
                n /= p;
            }
        }
        if (n > 1) factors.put(n, factors.getOrDefault(n, 0) + 1);
        return factors;
    }

    // If many factorizations are needed, generate primes once and iterate over primes instead.
    public static LinkedHashMap<Long, Integer> factorizeWithPrimes(long n, List<Integer> primes) {
        LinkedHashMap<Long, Integer> factors = new LinkedHashMap<>();
        if (n < 2) return factors;
        for (int p : primes) {
            if ((long)p * p > n) break;
            while (n % p == 0) {
                factors.put((long)p, factors.getOrDefault((long)p, 0) + 1);
                n /= p;
            }
        }
        if (n > 1) factors.put(n, factors.getOrDefault(n, 0) + 1);
        return factors;
    }

    // ------------------------ MODULAR EXPONENTIATION & INVERSE ------------------------
    public static long modPow(long a, long e, long mod) {
        long res = 1 % mod;
        long base = ((a % mod) + mod) % mod;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            e >>= 1;
        }
        return res;
    }

    // modular inverse using Fermat (mod must be prime and gcd(a,mod)=1)
    public static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    // ------------------------ GCD & LCM (Euclid) ------------------------
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a, b) * b);
    }

    // ------------------------ WATER JUG BFS (A,B,C jugs) ------------------------
    static class State {
        int a, b, c;
        State(int a, int b, int c) { this.a = a; this.b = b; this.c = c; }
        @Override public String toString() { return "(" + a + "," + b + "," + c + ")"; }
    }

    public static List<State> waterJugBFS(int A, int B, int C, int D) {
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];
        Queue<State> q = new ArrayDeque<>();
        Map<String, String> parent = new HashMap<>();
        State start = new State(0, 0, 0);
        String sKey = key(0,0,0);
        visited[0][0][0] = true;
        parent.put(sKey, null);
        q.add(start);
        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.a == D || cur.b == D || cur.c == D) {
                List<State> path = new ArrayList<>();
                String k = key(cur.a, cur.b, cur.c);
                while (k != null) {
                    String[] parts = k.split(",");
                    path.add(new State(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                    k = parent.get(k);
                }
                Collections.reverse(path);
                return path;
            }
            List<State> nexts = generateNextStates(cur, A, B, C);
            for (State ns : nexts) {
                if (!visited[ns.a][ns.b][ns.c]) {
                    visited[ns.a][ns.b][ns.c] = true;
                    String nk = key(ns.a, ns.b, ns.c);
                    parent.put(nk, key(cur.a, cur.b, cur.c));
                    q.add(ns);
                }
            }
        }
        return null; // impossible
    }

    private static String key(int a, int b, int c) { return a + "," + b + "," + c; }

    private static List<State> generateNextStates(State s, int A, int B, int C) {
        List<State> out = new ArrayList<>();
        // fill
        out.add(new State(A, s.b, s.c));
        out.add(new State(s.a, B, s.c));
        out.add(new State(s.a, s.b, C));
        // empty
        out.add(new State(0, s.b, s.c));
        out.add(new State(s.a, 0, s.c));
        out.add(new State(s.a, s.b, 0));
        // pour a->b
        int pour = Math.min(s.a, B - s.b);
        out.add(new State(s.a - pour, s.b + pour, s.c));
        // a->c
        pour = Math.min(s.a, C - s.c);
        out.add(new State(s.a - pour, s.b, s.c + pour));
        // b->a
        pour = Math.min(s.b, A - s.a);
        out.add(new State(s.a + pour, s.b - pour, s.c));
        // b->c
        pour = Math.min(s.b, C - s.c);
        out.add(new State(s.a, s.b - pour, s.c + pour));
        // c->a
        pour = Math.min(s.c, A - s.a);
        out.add(new State(s.a + pour, s.b, s.c - pour));
        // c->b
        pour = Math.min(s.c, B - s.b);
        out.add(new State(s.a, s.b + pour, s.c - pour));
        return out;
    }

    // ------------------------ UTILITIES & DEMOS ------------------------
    public static int digitsInBase(long n, int b) {
        if (n <= 0) return 0;
        return (int) (Math.floor(Math.log(n) / Math.log(b))) + 1;
    }

    // nth magic number (sum of powers of 5 chosen by bits of n)
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

    // ------------------------ MAIN (DEMONSTRATIONS) ------------------------
    public static void main(String[] args) {
        System.out.println("--- MathForDSA demo ---\n");

        // Sieve up to 40
        System.out.println("Primes up to 40: " + sieve(40));

        // integer sqrt
        long n = 37;
        System.out.println("integerSqrt(" + n + ") = " + integerSqrt(n));
        System.out.println("newtonIntegerSqrt(" + n + ") = " + newtonIntegerSqrt(n));
        System.out.println("newtonSqrt(" + n + ") = " + newtonSqrt(n));
        System.out.println("sqrtWithPrecision(" + n + ", 5) = " + sqrtWithPrecision(n, 5));

        // Factorization
        long x = 84;
        System.out.println("factorize(" + x + ") = " + factorize(x));
        // Factor using primes precomputed
        List<Integer> primes = sieve(100);
        System.out.println("factorizeWithPrimes(10007) = " + factorizeWithPrimes(10007L, primes));

        // Modular pow & inverse
        System.out.println("modPow(2,10,1_000_000_007) = " + modPow(2, 10, 1_000_000_007L));
        System.out.println("modInverse(3, 1_000_000_007) = " + modInverse(3, 1_000_000_007L));

        // gcd & lcm
        System.out.println("gcd(48,18) = " + gcd(48, 18));
        System.out.println("lcm(48,18) = " + lcm(48, 18));

        // Water jug: 3,5,8 target 4
        System.out.println("\nWater-jug BFS (3,5,8) target 4 demo:");
        List<State> path = waterJugBFS(3,5,8,4);
        if (path == null) System.out.println("No solution");
        else {
            for (int i = 0; i < path.size(); i++) System.out.println("step " + i + ": " + path.get(i));
        }

        // digits in base
        System.out.println("digitsInBase(255,16) = " + digitsInBase(255,16));

        // nth magic number
        System.out.println("nthMagicNumber(6) = " + nthMagicNumber(6));

        System.out.println("\n--- End demo ---");
    }
}
