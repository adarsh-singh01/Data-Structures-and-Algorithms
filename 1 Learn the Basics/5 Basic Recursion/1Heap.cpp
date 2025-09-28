#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "How many numbers in the array? ";
    cin >> n;

    int arr[n];  // Declaring an array of size n

    cout << "Enter " << n << " numbers:\n";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];  // Input elements into array
    }

    // Precompute frequency of numbers using hash array
    // Assumes numbers are in the range 0 to 12
    int hash[13] = {0};  // Initialize all counts to 0

    for (int i = 0; i < n; i++) {
        hash[arr[i]] += 1;  // Count occurrences
    }

    int q;
    cout << "How many queries? ";
    cin >> q;

    // Answering queries
    cout << "Enter numbers to get their frequency (0 to 12):\n";
    while (q--) {
        int number;
        cin >> number;

        // Output frequency of the queried number
        cout << hash[number] << endl;
    }

    return 0;
}


/*

for int...array can be of 10^6 inside main and 10^7 globally

for bool..array can be of 10^7 inside main and 10^8 globally
after that i will throw segFault

if u declare anything globally it need not get initiallized as they start with 0 and not garbage values

*/