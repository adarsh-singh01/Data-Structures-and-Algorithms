#include <iostream>
using namespace std;

void pt18(int n) {
    // Outer loop runs 'n' times for each row
    for (int i = 0; i < n; i++) {

        // Inner loop starts from character ('E' - i) to 'E'
        // So for each row, the starting character moves backward
        // Row 0: E
        // Row 1: D E
        // Row 2: C D E
        // Row 3: B C D E
        // Row 4: A B C D E
        for (char ch = 'E' - i; ch <= 'E'; ch++) {
            cout << ch << " "; // Print the character followed by a space
        }

        // Move to the next line after each row
        cout << endl;
    }
}

int main() {
    pt18(5);  // Call the function with n = 5
    return 0;
}

/*
OUTPUT IS:
E
D E
C D E
B C D E
A B C D E

🔍 Explanation:
- In each row, we are printing characters ending at 'E'
- The starting character shifts one step back each row
- This gives a staircase effect from E to A
*/
