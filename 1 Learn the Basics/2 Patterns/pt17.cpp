#include <iostream>
using namespace std;

void pt17(int n) {

    // Loop for each row (1 to n)
    for (int i = 1; i <= n; i++) {

        // Print leading dashes to center the characters
        // Number of dashes = n - i
        for (int k = 1; k <= n - i; k++) {
            cout << "-";
        }

        // Character starts from 'A' for each row
        char ch = 'A';

        // Breakpoint is the middle index of total characters in the row
        // Total characters = 2*i - 1 → middle = (2*i + 1) / 2
        int breakpoint = (2 * i + 1) / 2;

        // Print characters (total 2*i - 1 per row)
        for (int k = 0; k < 2 * i - 1; k++) {
            cout << ch;

            // Until breakpoint, increment character (A → B → C...)
            // After breakpoint, start decrementing (C → B → A)
            if (k <= breakpoint) ch++;
            else ch--;
        }

        // Print trailing dashes (same as leading) for symmetry
        for (int k = 1; k <= n - i; k++) {
            cout << "-";
        }

        // Move to the next line
        cout << endl;
    }
}

int main() {
    pt17(5);  // Call the function with n = 5
    return 0;
}

/*
Output:

----A----
---ABA---
--ABCBA--
-ABCDCBA-
ABCDEDCBA

Pattern explanation:
- Pyramid of characters with center-aligned rows
- Each row starts from 'A', increases to a peak, then decreases symmetrically
- Dashes are used to center-align the pyramid visually
*/
