#include <iostream> // For input/output operations
using namespace std;

// Recursive function to check if a string is a palindrome
bool f(int i, string &s) {
    // Base case: if we have checked up to the middle, it's a palindrome
    if (i >= s.size() / 2) return true;

    // If characters at the i-th and its mirror index from the end are not equal, not a palindrome
    if (s[i] != s[s.size() - i - 1]) return false;

    // Recursive call to check next pair of characters
    return f(i + 1, s);
}

int main() {
    string s = "madam"; // Input string (hardcoded here)

    // Call the palindrome check function starting from index 0
    cout << f(0, s); // Will print 1 (true) if palindrome, 0 (false) otherwise

    return 0;
}
