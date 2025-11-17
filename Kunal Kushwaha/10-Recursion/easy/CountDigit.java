public class CountDigit {
    public static void main(String[] args) {
        int n = 102040560;
        int a = count(n);     // Count number of zero digits
        System.out.println(a);
    }

    // Wrapper method that starts count at 0
    static int count(int n){
        return helper(n, 0);
    }

    // Recursive function to count zeroes in n....its a special pattern ,how to return same value to above calls
    private static int helper(int n, int c){
        // Base case: when number becomes 0, return count
        if(n == 0) return c;

        int rem = n % 10;    // extract last digit

        // If digit is zero, increment count and continue
        if(rem == 0){
            return helper(n / 10, c + 1);
        }

        // Otherwise, continue without incrementing
        return helper(n / 10, c);
    }
}

/*
Start:
n = 102040560
c = 0

CALL helper(102040560, 0)
──────────────────────────────────────────────────
n = 102040560
rem = 0 → increment
→ helper(102040560/10 = 10204056, c=1)

    CALL helper(10204056, 1)
    ────────────────────────────────────────────────
    n = 10204056
    rem = 6 → no increment
    → helper(1020405, 1)

        CALL helper(1020405, 1)
        ────────────────────────────────────────────
        n = 1020405
        rem = 5 → no increment
        → helper(102040, 1)

            CALL helper(102040, 1)
            ────────────────────────────────────────
            n = 102040
            rem = 0 → increment
            → helper(10204, 2)

                CALL helper(10204, 2)
                ────────────────────────────────────
                n = 10204
                rem = 4 → no increment
                → helper(1020, 2)

                    CALL helper(1020, 2)
                    ─────────────────────────────────
                    n = 1020
                    rem = 0 → increment
                    → helper(102, 3)

                        CALL helper(102, 3)
                        ─────────────────────────────
                        n = 102
                        rem = 2 → no increment
                        → helper(10, 3)

                            CALL helper(10, 3)
                            ─────────────────────────
                            n = 10
                            rem = 0 → increment
                            → helper(1, 4)

                                CALL helper(1, 4)
                                ─────────────────────
                                n = 1
                                rem = 1 → no increment
                                → helper(0, 4)

                                    CALL helper(0, 4)
                                    ─────────────────
                                    n == 0 → return 4

 */