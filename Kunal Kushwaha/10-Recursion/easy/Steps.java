public class Steps {

    // Wrapper function that starts counting from 0 steps
    static int noOfSteps(int n) {
        return helper(n, 0);
    }

    // Recursive helper to count steps to reduce n to 0
    private static int helper(int n, int steps) {

        // Base case: when n reaches 0, return number of steps taken
        if (n == 0) return steps;

        // If n is even → divide by 2
        if(n % 2 == 0) {
            return helper(n / 2, steps + 1);
        }

        // If n is odd → subtract 1
        return helper(n - 1, steps + 1);
    }

    public static void main(String[] args) {
        int a = noOfSteps(14);
        System.out.println(a);
    }
}


/*
Start:
n = 14
steps = 0

CALL helper(14, 0)
────────────────────────────────────────────
n = 14 (even)
→ divide by 2
→ helper(14/2 = 7, steps=1)

    CALL helper(7, 1)
    ─────────────────────────────────────────
    n = 7 (odd)
    → subtract 1
    → helper(6, 2)

        CALL helper(6, 2)
        ─────────────────────────────────────
        n = 6 (even)
        → divide by 2
        → helper(3, 3)

            CALL helper(3, 3)
            ─────────────────────────────────
            n = 3 (odd)
            → subtract 1
            → helper(2, 4)

                CALL helper(2, 4)
                ─────────────────────────────
                n = 2 (even)
                → divide by 2
                → helper(1, 5)

                    CALL helper(1, 5)
                    ───────────────────────
                    n = 1 (odd)
                    → subtract 1
                    → helper(0, 6)

                        CALL helper(0, 6)
                        ───────────────────
                        n == 0 → return 6

 */