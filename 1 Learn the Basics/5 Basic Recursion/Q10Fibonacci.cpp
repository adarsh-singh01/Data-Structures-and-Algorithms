#include <iostream>
using namespace std;

// Recursive function to calculate the nth Fibonacci number
int f(int n) {
    // Base case: return n if n is 0 or 1 (F(0) = 0, F(1) = 1)
    if (n <= 1) return n;

    // Recursive case:
    // Compute the (n-1)th Fibonacci number
    int last = f(n - 1);

    // Compute the (n-2)th Fibonacci number
    int slast = f(n - 2);

    // Add both to get the nth Fibonacci number
    return last + slast;
}

int main() {
    cout << f(4);  // Output the 4th Fibonacci number
    return 0;
}


/*

f(4)
├── f(3)
│   ├── f(2)
│   │   ├── f(1) → 1
│   │   └── f(0) → 0
│   └── f(1) → 1
├── (f(2) is reused here)
└── f(2)
    ├── f(1) → 1
    └── f(0) → 0


f(0) = 0
f(1) = 1
f(2) = f(1) + f(0) = 1 + 0 = 1
f(3) = f(2) + f(1) = 1 + 1 = 2
f(4) = f(3) + f(2) = 2 + 1 = 3


Time Complexity = O(2^n)

Space Complexity
1. Call Stack (due to recursion)

At most, the call stack goes down to f(1), one path deep. Since only one path is active at any time, the maximum depth of the recursion tree is n.

Space due to call stack = O(n)

2. No extra space is used (no arrays, no memoization).


*/

