public class ReverseNumOptimized {
    static int rev2(int n){
        int digits=(int)Math.log10(n)+1;
        return helper(n,digits);
    }

    private static int helper(int n, int digits) {
        if(n%10==n){
            return n;
        }
        int rem=n%10;
        return rem*(int)Math.pow(10,digits-1)+helper(n/10,digits-1);
    }

    public static void main(String[] args) {
        System.out.println(rev2(1234));
    }
}


/*
rev2(1234)
    digits = floor(log10(1234)) + 1
           = 3 + 1
           = 4

CALL helper(1234, 4)
───────────────────────────────────────────────
helper(1234, 4):
    n % 10 = 4
    n % 10 != n → continue
    rem = 4
    contributes: 4 * 10^(4-1) = 4 * 1000 = 4000

    ┌───────────────────────────────────────────┐
    │ CALL helper(123, 3)                       │
    └───────────────────────────────────────────┘
    helper(123, 3):
        n % 10 = 3
        rem = 3
        contributes: 3 * 10^(3-1) = 3 * 100 = 300

        ┌───────────────────────────────────────┐
        │ CALL helper(12, 2)                    │
        └───────────────────────────────────────┘
        helper(12, 2):
            rem = 2
            contributes: 2 * 10^(2-1) = 2 * 10 = 20

            ┌───────────────────────────────────┐
            │ CALL helper(1, 1)                 │
            └───────────────────────────────────┘
            helper(1, 1):
                n % 10 == n (1 == 1)
                BASE CASE → return 1

Now we unwind:

helper(1,1) returns 1

helper(12,2):
    return 20 + 1 = 21

helper(123,3):
    return 300 + 21 = 321

helper(1234,4):
    return 4000 + 321 = 4321
Final result: 4321
 */
