/*
QUICKSORT ALGORITHM:

QuickSort is a divide and conquer algorithm. It works by selecting a 'pivot' element from the array 
and partitioning the other elements into two sub-arrays, according to whether they are less than or 
greater than the pivot. The sub-arrays are then recursively sorted. 
*/

#include <iostream>
#include <vector>  // Required for using vector

using namespace std;

// Function to partition the array into elements less than and greater than the pivot
int partition(vector<int>& arr, int low, int high) {
    int pivot = arr[high];  // Choosing the last element as pivot
    int i = low - 1;        // Index for smaller element
    int j;                  // Index for traversing

    // Traverse from low to high - 1
    for (j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(arr[i], arr[j]);  // Swap elements to the left side of pivot
        }
    }

    // Place pivot in the correct position
    swap(arr[i + 1], arr[high]);

    return i + 1;  // Return pivot index
}

// Recursive quicksort function
void qs(vector<int>& arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);  // Partitioning index

        // Recursively sort elements before and after partition
        qs(arr, low, pi - 1);
        qs(arr, pi + 1, high);
    }
}

// Wrapper function to apply quicksort on a vector and return the sorted vector
vector<int> quickSort(vector<int> arr) {
    qs(arr, 0, arr.size() - 1);  // Sort entire array
    return arr;                  // Return sorted result
}


int main() {
    vector<int> arr = {10, 7, 8, 9, 1, 5};

    // Call quickSort
    vector<int> sorted = quickSort(arr);

    // Print the sorted array
    cout << "Sorted array: ";
    for (int num : sorted) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}

/*
Time Complexity Analysis:
Best	O(n log n)	
Average	O(n log n)	
Worst	O(n²)

Space Complexity:
Auxiliary	O(log n)	
Worst case	O(n)

*/

/*

QuickSort Visualization
=======================

Initial Array:
[10, 7, 8, 9, 1, 5]

Step 1: Choose pivot = 5
Partitioning: [10, 7, 8, 9, 1, 5]
After partition: [1, 5, 8, 9, 10, 7]
 → Left: [1]
 → Right: [8, 9, 10, 7]

Step 2: Choose pivot = 7
Partitioning: [8, 9, 10, 7]
After partition: [7, 9, 10, 8]
 → Left: []
 → Right: [9, 10, 8]

Step 3: Choose pivot = 8
Partitioning: [9, 10, 8]
After partition: [8, 10, 9]
 → Left: []
 → Right: [10, 9]

Step 4: Choose pivot = 9
Partitioning: [10, 9]
After partition: [9, 10]
 → Left: []
 → Right: []

Final Sorted Array:
[1, 5, 7, 8, 9, 10]


QuickSort Tree Structure
=========================

quickSort([10, 7, 8, 9, 1, 5])
├── Left: quickSort([1])
│   └── Base case (1 element)
└── Right: quickSort([8, 9, 10, 7])
    ├── Left: quickSort([])
    │   └── Base case (empty)
    └── Right: quickSort([9, 10, 8])
        ├── Left: quickSort([])
        │   └── Base case (empty)
        └── Right: quickSort([10, 9])
            ├── Left: quickSort([])
            └── Right: quickSort([])
                └── All base cases (sorted)

Final combination (merge phase conceptually):
[1] + [5] + [7] + [8] + [9] + [10] → [1, 5, 7, 8, 9, 10]

*/



