

public class BinarySearch {

    public static void main(String[] args) {
        // Sorted array to perform binary search on
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};

        // Target element to search for
        int target = 22;

        // Call binary search and store the result (index of target)
        int ans = binarySearch(arr, target);

        // Print the result
        System.out.println(ans);  // Output: 10
    }

    // Binary Search function
    // Returns the index of the target element if found
    // Returns -1 if the target does not exist in the array
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Continue searching as long as the range is valid
        while (start <= end) {
            // Find the middle element safely to avoid integer overflow
            // Safer than (start + end) / 2
            int mid = start + (end - start) / 2;

            // If target is smaller than mid element, ignore right half
            if (target < arr[mid]) {
                end = mid - 1;
            }
            // If target is greater than mid element, ignore left half
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            // If target is equal to mid element, return the index
            else {
                return mid;
            }
        }

        // Target not found
        return -1;
    }
}
