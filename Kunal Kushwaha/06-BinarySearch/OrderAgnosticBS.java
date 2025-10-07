

public class OrderAgnosticBS {

    public static void main(String[] args) {
        // Example 1: Ascending sorted array
        // int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};

        // Example 2: Descending sorted array
        int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};

        int target = 22;

        // Perform order-agnostic binary search
        int ans = orderAgnosticBS(arr, target);

        // Print the index of the target element if found, otherwise -1
        System.out.println(ans);
    }

    // Function to perform binary search on both ascending and descending sorted arrays
    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Determine the sort order of the array
        // If start < end, array is ascending; otherwise, descending
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // Calculate mid in a safe way to avoid integer overflow
            int mid = start + (end - start) / 2;

            // Check if the target is found
            if (arr[mid] == target) {
                return mid;
            }

            // Handle ascending order
            if (isAsc) {
                if (target < arr[mid]) {
                    // Target lies in the left half
                    end = mid - 1;
                } else {
                    // Target lies in the right half
                    start = mid + 1;
                }
            }

            // Handle descending order
            else {
                if (target > arr[mid]) {
                    // Target lies in the left half (higher values)
                    end = mid - 1;
                } else {
                    // Target lies in the right half (lower values)
                    start = mid + 1;
                }
            }
        }

        // Target not found in array
        return -1;
    }
}
