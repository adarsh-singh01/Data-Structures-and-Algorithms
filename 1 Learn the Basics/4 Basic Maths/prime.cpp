#include <iostream> // Required for input and output (cin and cout)

using namespace std;

int main() {
    int n; // Variable to store the input number

    cout << "Enter the number: "; // Ask user to input a number
    cin >> n; // Read the input number

    int count = 0; // Counter to count the number of divisors

    // Loop from 1 to sqrt(n)
    for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) { // If i is a divisor of n
            count++; // Count i as a divisor

            // Check if i and n/i are different to avoid double-counting perfect squares
            if ((n / i) != i) {
                count++; // Count the corresponding divisor (n / i)
            }
        }
    }

    // A prime number has exactly 2 divisors: 1 and itself....NOTE : 0 and 1 are not considered prime numbers
    if (count == 2) {
        cout << n << " is a prime number.";
    } else {
        cout << n << " is not a prime number.";
    }

    return 0; // Indicate successful program termination
}
