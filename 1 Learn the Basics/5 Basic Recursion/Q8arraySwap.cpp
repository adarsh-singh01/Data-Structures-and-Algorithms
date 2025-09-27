#include <iostream>
using namespace std;

// Recursive function to reverse the array
void func(int i, int arr[], int n) {
    // Base case: if we've reached or passed the middle, stop recursion
    if (i >= n / 2) return;

    // Swap the i-th element with its mirror (n-i-1) from the end
    swap(arr[i], arr[n - i - 1]);

    // Recursive call to process the next pair
    func(i + 1, arr, n);
}

int main() {
    int n;
    cout << "enter size of array : ";
    cin >> n; // Read size of array

    int arr[n]; // Declare an array of size n (note: not standard C++, see previous note)

    // Input n elements into the array
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // Call the recursive function to reverse the array
    func(0, arr, n);

    // Output the reversed array
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}




/*


func(0, arr, 5)
  ↳ swap arr[0] with arr[4] → [5, 2, 3, 4, 1]
  ↳ func(1, arr, 5)
       ↳ swap arr[1] with arr[3] → [5, 4, 3, 2, 1]
       ↳ func(2, arr, 5)
            ↳ i = 2, n/2 = 2.5 → continue
            ↳ since i == n/2 (integer division), stop (base case)




func(0)
├── swap arr[0] and arr[4]
└── func(1)
    ├── swap arr[1] and arr[3]
    └── func(2)
        └── base case reached (i >= n/2) → return


*/