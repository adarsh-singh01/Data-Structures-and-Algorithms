#include <iostream>
using namespace std;

// Function to print an increasing + decreasing star pattern
// For example, if n = 4, it prints:
// *
// * *
// * * *
// * * * *
// * * *
// * *
// *
void pt10(int n) {
    // Outer loop runs from 1 to 2n - 1
    // Why 2n - 1?
    // Because the pattern first increases from 1 to n (n rows)
    // Then decreases from n-1 back to 1 (n-1 rows)
    // Total rows = n (up) + n-1 (down) = 2n - 1
    for (int i = 1; i <= 2 * n - 1; i++) {

        int stars = i;  // Default: stars = current row number

        // If we've passed the middle (i > n), we need to reverse
        // For example, if n = 4:
        // i = 5 ➝ stars = 2*4 - 5 = 3
        // i = 6 ➝ stars = 2*4 - 6 = 2
        // i = 7 ➝ stars = 2*4 - 7 = 1
        if (i > n) {
            stars = 2 * n - i;
        }

        // Inner loop: print that many stars
        for (int j = 1; j <= stars; j++) {
            cout << "* ";
        }

        // Newline after each row
        cout << endl;
    }
}

int main() {
    pt10(4);  // Try with a small number to understand the pattern
    return 0;
}

/*
Explanation of OUTPUT for n = 4:

Row i = 1 ➝ stars = 1 ➝ * 
Row i = 2 ➝ stars = 2 ➝ * * 
Row i = 3 ➝ stars = 3 ➝ * * * 
Row i = 4 ➝ stars = 4 ➝ * * * * 
Row i = 5 ➝ stars = 3 ➝ * * *       (2*4 - 5 = 3)
Row i = 6 ➝ stars = 2 ➝ * *         (2*4 - 6 = 2)
Row i = 7 ➝ stars = 1 ➝ *           (2*4 - 7 = 1)

So final pattern:

* 
* * 
* * * 
* * * * 
* * * 
* * 
* 

✅ Total rows: 2n - 1 = 7
✅ Looks like a hill or a symmetric mountain made of stars
*/
