/*
SELECTION SORTING:

Select the minimum and swap.

swap happened btw i and minimum index

*/

#include <iostream>
using namespace std;

// Function to sort the array using selection sort algorithm
void selection_sort(int arr[], int n) {
    // Traverse through all array elements
    for(int i=0; i<=n-2; i++) {
        // Assume the current index as the minimum element
        int min_idx = i;
        
        // Compare the current index element with the minimum element found so far
        for(int j=i+1; j<=n-1; j++) {
            // If the current element is less than the minimum element found so far
            if(arr[j] < arr[min_idx]) {
                // Swap the current element with the minimum element found so far
                min_idx = j;
            }
        }
        
        // Swap the minimum element found so far with the current element
        //swap(arr[i], arr[min_idx]);
        int temp = arr[i]; // Store the value at index i
        arr[i] = arr[min_idx]; // Swap the value at index i with the value at index min_idx
        arr[min_idx] = temp; // Swap the value at index min_idx with the stored value
    }
}

// Function to read and print elements from the array
int main() {
    int n;
    cin>>n;
    int arr[n];
    for (int i=0;i<n;i++) cin>>arr[i];
    
    // Call the selection_sort function
    selection_sort(arr, n);
    
    // Print the sorted array
    for(int i=0;i<n;i++) cout<<arr[i]<<" ";
    
    return 0;
}


// The time complexity of the selection sort algorithm is O(n^2), where n is the number of elements in the array. This means that the time it takes to sort the array grows quadratically with the number of elements.