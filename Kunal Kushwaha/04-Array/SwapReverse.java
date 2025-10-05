// Importing Arrays utility class to use Arrays.toString() for printing the array
import java.util.Arrays;

public class SwapReverse {
    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] arr = {1, 3, 23, 9, 18, 56};

        // Uncomment the below line if you just want to swap two specific elements
        // swap(arr, 0, 4);  // Swaps elements at index 0 and index 4

        // Call the reverse method to reverse the entire array
        reverse(arr);

        // Print the modified array after reversing
        System.out.println(Arrays.toString(arr));  // Converts array to string for readable output
    }

    /**
     * Reverses the given array in-place using two-pointer approach.
     * It swaps the first and last elements, then moves inward.
     */
    static void reverse(int[] arr) {
        int start = 0;                    // Start pointer at beginning of array
        int end = arr.length - 1;         // End pointer at last index

        // Continue swapping until pointers meet or cross
        while (start < end) {
            swap(arr, start, end);       // Swap elements at start and end
            start++;                     // Move start forward
            end--;                       // Move end backward
        }
    }

    /**
     * Swaps two elements in an array given their indexes.
     */
    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];          // Store the value at index1
        arr[index1] = arr[index2];       // Assign value at index2 to index1
        arr[index2] = temp;              // Assign stored value to index2
    }
}
