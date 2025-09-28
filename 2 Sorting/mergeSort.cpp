#include <iostream>
#include <vector>
using namespace std;

// Merge function to merge two sorted halves of arr[low..mid] and arr[mid+1..high]
void merge(vector<int>& arr, int low, int mid, int high) {
    // Temporary vector to store merged result
    vector<int> temp;

    int left = low;      // Pointer to the left half
    int right = mid + 1; // Pointer to the right half

    // Merge elements from both halves in sorted order
    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp.push_back(arr[left]);
            left++;
        } else {
            temp.push_back(arr[right]);
            right++;
        }
    }

    // If there are remaining elements in the left half
    while (left <= mid) {
        temp.push_back(arr[left]);
        left++;
    }

    // If there are remaining elements in the right half
    while (right <= high) {
        temp.push_back(arr[right]);
        right++;
    }

    // Copy merged elements back to original array
    for (int i = low; i <= high; i++) {
        arr[i] = temp[i - low]; // temp is 0-indexed; arr starts from 'low'
    }
}

// Recursive helper function for merge sort
void mS(vector<int>& arr, int low, int high) {
    if (low >= high) return; // Base case: single element is already sorted

    int mid = (low + high) / 2;

    // Sort left half
    mS(arr, low, mid);

    // Sort right half
    mS(arr, mid + 1, high);

    // Merge both sorted halves
    merge(arr, low, mid, high);
}

// Main merge sort function called from outside
void mergeSort(vector<int>& arr, int n) {
    mS(arr, 0, n - 1);
}

int main() {
    vector<int> arr = {5, 2, 9, 1, 5, 6};
    mergeSort(arr, arr.size());

    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}


/*


Merge Sort is O(n log n) time complexity.

It uses Divide and Conquer.

Space complexity is O(n) due to the temporary arrays.

It’s a stable sorting algorithm.



            [5, 2, 9, 1]
            /         \
         [5, 2]      [9, 1]
         /   \        /   \
       [5]  [2]     [9]  [1]

         ↓ merge     ↓ merge

       [2, 5]       [1, 9]

         ↓ merge

      [1, 2, 5, 9] ← Final sorted array


*/


/*


Initial Array:
[5, 2, 9, 1, 6, 3]

Dividing: [0, 5] -> [0, 2] and [3, 5]
Dividing: [0, 2] -> [0, 1] and [2, 2]
Dividing: [0, 1] -> [0, 0] and [1, 1]

Merging:
Left: [5]
Right: [2]
After Merge: [2, 5]

Merging:
Left: [2, 5]
Right: [9]
After Merge: [2, 5, 9]

Dividing: [3, 5] -> [3, 4] and [5, 5]
Dividing: [3, 4] -> [3, 3] and [4, 4]

Merging:
Left: [1]
Right: [6]
After Merge: [1, 6]

Merging:
Left: [1, 6]
Right: [3]
After Merge: [1, 3, 6]

Merging:
Left: [2, 5, 9]
Right: [1, 3, 6]
After Merge: [1, 2, 3, 5, 6, 9]

Sorted Array:
[1, 2, 3, 5, 6, 9]



*/
