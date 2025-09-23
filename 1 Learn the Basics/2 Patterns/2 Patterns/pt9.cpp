#include <iostream>
using namespace std;

// Function to print the top half of the diamond (regular pyramid)
void pt8(int n){
    for (int i = 1; i <= n; i++) {
        // Print left spaces (decreasing with each row)
        for (int j = 1; j <= n - i; j++) {
            cout << "-";
        }

        // Print stars (odd count: 1, 3, 5, ... → 2*i - 1)
        for (int j = 0; j < i * 2 - 1; j++) {
            cout << "*";
        }

        // Print right spaces (same as left for symmetry)
        for (int j = 1; j <= n - i; j++) {
            cout << "-";
        }

        // Move to next line after each row
        cout << endl;
    }
}

// Function to print the bottom half of the diamond (inverted pyramid)
void pt9(int n){
    for (int i = 1; i <= n; i++) {
        // Print left spaces (increasing with each row)
        for (int j = 0; j < i - 1; j++) {
            cout << "-";
        }

        // Print stars (odd count: 2*(n-i)+1 → 9, 7, 5, ... 1)
        for (int j = 0; j < 2 * (n - i) + 1; j++) {
            cout << "*";
        }

        // Print right spaces (same as left for symmetry)
        for (int j = 0; j < i - 1; j++) {
            cout << "-";
        }

        // Move to next line after each row
        cout << endl;
    }
}

int main() {
    pt8(5);  // Print top half of the diamond
    pt9(5);  // Print bottom half of the diamond
    return 0;
}

/*
Expected output:

----*----
---***---
--*****--
-*******-
*********
*********
-*******-
--*****--
---***---
----*----

Explanation:
- The top half is printed by pt8() from 1 star to 9 stars (in steps of 2), centered with dashes.
- The bottom half is printed by pt9() from 9 stars back to 1, again centered.
- The middle row (*********) is printed twice: once by pt8() and once by pt9().
*/
