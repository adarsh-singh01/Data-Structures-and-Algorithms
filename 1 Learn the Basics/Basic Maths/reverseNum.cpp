#include <iostream> // Include the input-output stream library

using namespace std; // Use the standard namespace to avoid prefixing with std::

int main() {
    int n; // Declare an integer variable to store the user input

    cout << "Enter the number: "; // Prompt the user to enter a number
    cin >> n; // Take input from the user and store it in variable 'n'

    int revNumber = 0; // Initialize a variable to store the reversed number

    // Loop to extract digits from the original number and build the reversed number
    while(n > 0){
        int ld = n % 10; // Get the last digit of the number using modulus operator
        revNumber = (revNumber * 10) + ld; // Append the last digit to the reversed number
        n = n / 10; // Remove the last digit from the original number
    }

    // Print the reversed number
    cout << "Reverse of the number is: " << revNumber;

    return 0; // Exit the program
}

/*
OUTPUT EXAMPLES:

Enter the number: 12345
Reverse of the number is: 54321

Enter the number: 00123
Reverse of the number is: 321

Explanation:
- Leading zeroes are not preserved in integer input.
- For example, 00123 is stored as 123, so the reverse becomes 321.
- Also, if the input is 3200, the last zeros are dropped when reversed,
  because integer type cannot store leading or trailing zeros.
*/
