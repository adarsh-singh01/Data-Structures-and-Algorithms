//i think the tut didnt have a true backtracking code so wrote this with AI


#include <iostream>
#include <vector>
using namespace std;

// Backtracking function to generate all subsets from i to n
void backtrack(int i, int n, vector<int>& subset) {
    // Base case: if we've considered all numbers from 1 to n
    if (i > n) {
        cout << "{ ";
        for (int num : subset) {
            cout << num << " ";
        }
        cout << "}" << endl;  // print current subset
        return;
    }

    // 1. Include current number i in the subset
    subset.push_back(i);
    backtrack(i + 1, n, subset);  // Recurse for next number

    // 2. Backtrack: remove number i to explore other possibilities
    subset.pop_back();

    // 3. Exclude current number i from the subset and recurse
    backtrack(i + 1, n, subset);
}

int main() {
    int n;
    cout << "Enter n: ";
    cin >> n;

    vector<int> subset;  // to store current subset
    backtrack(1, n, subset);  // start from 1

    return 0;
}


/*


backtrack(i=1, subset=[])
├── Include 1 → subset=[1]
│   ├── Include 2 → subset=[1,2]
│   │   ├── Include 3 → subset=[1,2,3]
│   │   │   └── i=4 > 3 → Print {1 2 3}
│   │   └── Exclude 3 → subset=[1,2]
│   │       └── i=4 > 3 → Print {1 2}
│   └── Exclude 2 → subset=[1]
│       ├── Include 3 → subset=[1,3]
│       │   └── i=4 > 3 → Print {1 3}
│       └── Exclude 3 → subset=[1]
│           └── i=4 > 3 → Print {1}
└── Exclude 1 → subset=[]
    ├── Include 2 → subset=[2]
    │   ├── Include 3 → subset=[2,3]
    │   │   └── i=4 > 3 → Print {2 3}
    │   └── Exclude 3 → subset=[2]
    │       └── i=4 > 3 → Print {2}
    └── Exclude 2 → subset=[]
        ├── Include 3 → subset=[3]
        │   └── i=4 > 3 → Print {3}
        └── Exclude 3 → subset=[]
            └── i=4 > 3 → Print {}


*/


/*

What is Backtracking?

Backtracking is a general algorithmic technique used to explore all possible solutions to a problem, and backtrack (undo) steps when you realize a path doesn't lead to the desired result.

🧠 In simple terms:
“Try → If it works, continue → If not, undo and try another path.”

It's commonly used in:

Combinatorics (like permutations, combinations)

Puzzles (Sudoku, N-Queens)

Pathfinding (maze problems)

Constraint satisfaction problems (like backtracking in recursion)

📌 Backtracking vs Simple Recursion

Simple Recursion just goes down one path (like counting 1 to N).

Backtracking tries all possible options at every step and backtracks to try other ones.

*/