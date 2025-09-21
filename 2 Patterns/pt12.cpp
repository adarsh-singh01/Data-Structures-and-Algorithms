#include <iostream>
using namespace std;

// Function to print a mirrored number pyramid with shrinking center dashes
void pt12(int n) {
    // Initial number of dashes (spaces) in the middle
    // It starts with 2*(n-1) dashes and decreases by 2 in each row
    int space = 2 * (n - 1);

    // Outer loop for rows
    for (int i = 1; i <= n; i++) {

        // Part 1: Print increasing numbers from 1 to i
        // Example: i = 3 → prints 1 2 3
        for (int k = 1; k <= i; k++) {
            cout << k;
        }

        // Part 2: Print the dashes in the middle
        // Starts with 2*(n-1) and decreases by 2 after each row
        for (int k = 1; k <= space; k++) {
            cout << "-";
        }

        // Part 3: Print decreasing numbers from i to 1
        // Example: i = 3 → prints 3 2 1
        for (int k = i; k >= 1; k--) {
            cout << k;
        }

        // Newline after each row
        cout << endl;

        // Reduce the middle space by 2 for the next row
        space = space - 2;
    }
}

int main() {
    pt12(5);
    return 0;
}

/*
### ✅ OUTPUT:

1--------1
12------21
123----321
1234--4321
1234554321

### 🔍 EXPLANATION OF PATTERN:

Each row prints:
- Increasing numbers: from 1 to i
- Dashes: 2*(n - i) dashes
- Decreasing numbers: from i to 1

Let's walk through it row by row for n = 5:

Row 1:
- Increasing: 1
- Dashes: 2*(5 - 1) = 8 → --------
- Decreasing: 1
→ 1--------1

Row 2:
- Increasing: 1 2
- Dashes: 6
- Decreasing: 2 1
→ 12------21

Row 3:
- Increasing: 1 2 3
- Dashes: 4
- Decreasing: 3 2 1
→ 123----321

Row 4:
- Increasing: 1 2 3 4
- Dashes: 2
- Decreasing: 4 3 2 1
→ 1234--4321

Row 5:
- Increasing: 1 2 3 4 5
- Dashes: 0
- Decreasing: 5 4 3 2 1
→ 1234554321

### 🧠 Summary:

- You create a mirrored structure with `1..i` and `i..1`
- Dashes decrease by 2 each row to gradually shrink the middle gap
- Pattern becomes more dense toward the center

*/
