#include <iostream>
using namespace std;

int sumFunctional(int i) {
    if (i < 1) return 0;        // base case
    return i + sumFunctional(i - 1);  // add current and return
}

int main() {
    int n;
    cout << "Enter n: ";
    cin >> n;

    int result = sumFunctional(n);
    cout << "Sum is: " << result << endl;

    return 0;
}

/*
Functional recursion uses the return value of the function to compute the result.

So, instead of passing sum around, each function call returns a value and adds it to the total.

sumFunctional(3)
= 3 + sumFunctional(2)
           ↓
         sumFunctional(2)
         = 2 + sumFunctional(1)
                     ↓
                   sumFunctional(1)
                   = 1 + sumFunctional(0)
                                 ↓
                               sumFunctional(0)
                               = 0  (base case)



sumFunctional(0) = 0
→ sumFunctional(1) = 1 + 0 = 1
→ sumFunctional(2) = 2 + 1 = 3
→ sumFunctional(3) = 3 + 3 = 6


*/
