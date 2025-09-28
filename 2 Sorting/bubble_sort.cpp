/*
Bubble SORTING:

check every two nums by iterating if smaller is after bigger then it swaps and go in this way to last and again start from beginning till sorting is done



*/

#include <iostream>
using namespace std;

// Function to sort the array using bubble sort algorithm
void bubble_sort(int arr[], int n) {
    // Loop through the array from the end to the beginning
    for(int i = n-1; i >= 0; i--) {
        int didSwap=0;
        // Loop through the array from the current index to the end
        for(int j = 0; j <= i-1; j++) {
            // If the current element is greater than the next element
            if(arr[j] > arr[j+1]) {
                // Swap the current element with the next element
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                didSwap=1;
            }
            // If no two elements were swapped by inner loop, then the array is already sorted
            if(didSwap==0){
                break;
            }
        }
    }
}

// Function to read and print elements from the array
int main() {
    int n;
    cin>>n;
    int arr[n];
    for (int i=0;i<n;i++) cin>>arr[i];
    
    // Call the bubble_sort function
    bubble_sort(arr, n);
    
    // Print the sorted array
    for(int i=0;i<n;i++) cout<<arr[i]<<" ";
    
    return 0;
}

// The time complexity of the selection sort algorithm is O(n^2)...best is O(n)
