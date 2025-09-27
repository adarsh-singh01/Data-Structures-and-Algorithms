#include <iostream>
using namespace std;

void sumParameterized(int i, int sum) {
    if (i < 1) {
        // Base case: when i reaches 0, print the final sum
        cout << "Sum is: " << sum << endl;
        return;
    }

    sumParameterized(i - 1, sum + i); // pass updated sum
}

int main() {
    int n;
    cout << "Enter a number: ";
    cin >> n;

    sumParameterized(n, 0); // start from n, with sum = 0
    return 0;
}


/*

🔷 What is Parameterized Recursion?

Parameterized recursion is when you pass additional variables (parameters) to the recursive function to carry or build up a result during the recursion process.

✅ Key Idea:

Instead of calculating the result after the recursive call returns, you carry the result as a parameter and keep updating it.


How it works:

You pass the current total sum at each step.

When you hit the base case (i < 1), you just print the final sum.

*/