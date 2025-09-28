/*

INSERTION SORT:
it iterates over the array and checks if things are in correct order or not.

*/

#include <iostream>

using namespace std;

void insertion_sort(int arr[], int n) {
    // Loop from the start of the array to the second-to-last element
    for (int i = 0; i < n - 1; i++) {
        // Initialize j to the current index
        int j = i;
        // Loop from the current index to the second-to-last element
        while (j > 0 && arr[j - 1] > arr[j]) {
            // Swap the current element with the one that is out of order
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            // Decrement j to try swapping the next element
            j--;
            cout<<"runs";
        }
    }
}

int main() {
    int n;
    cin>>n;
    int arr[n];
    for (int i=0;i<n;i++) cin>>arr[i];
    
    // Call the insertion_sort function
    insertion_sort(arr, n);
    
    // Print the sorted array
    for(int i=0;i<n;i++) cout<<arr[i]<<" ";
    
    return 0;
}

/*
WORST CASE TIME COMPLEXITY: O(n^2)
BEST CASE TIME COMPLEXITY: O(n)
*/
