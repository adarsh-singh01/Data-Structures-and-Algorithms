public class ReverseNum {
    static int sum=0;
    static void rev(int n){
        if(n==0) return;
        
        int rem=n%10;
       
        sum=sum*10+rem;
        rev(n/10);
        //we dont need to do any return here as main thing which is sum is outside this func and this func is only doing computation
    }

    public static void main(String[] args) {
        rev(98765);
        System.out.println(sum);
    }
}


/*
 Start:
n = 98765
sum = 0

┌───────────────────────────────────────────────┐
│ CALL rev(98765)                               │
└───────────────────────────────────────────────┘
    rem = 98765 % 10 = 5
    sum = 0*10 + 5 = 5

    ┌───────────────────────────────────────────┐
    │ CALL rev(9876)                            │
    └───────────────────────────────────────────┘
        rem = 9876 % 10 = 6
        sum = 5*10 + 6 = 56

        ┌───────────────────────────────────────┐
        │ CALL rev(987)                         │
        └───────────────────────────────────────┘
            rem = 987 % 10 = 7
            sum = 56*10 + 7 = 567

            ┌───────────────────────────────────┐
            │ CALL rev(98)                      │
            └───────────────────────────────────┘
                rem = 98 % 10 = 8
                sum = 567*10 + 8 = 5678

                ┌──────────────────────────────┐
                │ CALL rev(9)                  │
                └──────────────────────────────┘
                    rem = 9 % 10 = 9
                    sum = 5678*10 + 9 = 56789

                    ┌──────────────────────────┐
                    │ CALL rev(0)              │
                    └──────────────────────────┘
                        n == 0 → return

Now recursion unwinds…
No more computation (sum is global)

RETURN chain:
rev(0) → rev(9) → rev(98) → rev(987) → rev(9876) → rev(98765)

Final sum = 56789

 */