#include <iostream>
using namespace std;

// Function to print a triangle of alternating 1s and 0s
// Each row starts with 1 if it's an odd row, 0 if it's even
// Then it alternates: 1 0 1 0 ... or 0 1 0 1 ...
void pt11(int n) {
    for (int i = 1; i <= n; i++) {
        // Determine the starting number for the current row:
        // - If the row number 'i' is odd → start with 1
        // - If the row number 'i' is even → start with 0
        int k = i % 2;

        // Print 'i' numbers in this row
        for (int j = 1; j <= i; j++) {
            cout << k << " ";  // Print current value of k (either 1 or 0)

            // Flip the value of k for the next number in the row
            // - If k was 1 → becomes 0
            // - If k was 0 → becomes 1
            k = 1 - k;
        }

        // After printing one full row, move to the next line
        cout << endl;
    }
}

int main() {
    pt11(5);  // Try with 5 rows
    return 0;
}

/*
### OUTPUT:

1
0 1
1 0 1
0 1 0 1
1 0 1 0 1

### HOW IT WORKS:

Row 1 (i = 1 → odd):
- Starts with 1
- Prints: 1

Row 2 (i = 2 → even):
- Starts with 0
- Prints: 0 1

Row 3 (i = 3 → odd):
- Starts with 1
- Prints: 1 0 1

Row 4 (i = 4 → even):
- Starts with 0
- Prints: 0 1 0 1

Row 5 (i = 5 → odd):
- Starts with 1
- Prints: 1 0 1 0 1

Each time, the variable `k` starts with the correct value based on the row number,
and then flips using `k = 1 - k` after each print.

This is a simple and elegant way to alternate between 1 and 0.
*/
