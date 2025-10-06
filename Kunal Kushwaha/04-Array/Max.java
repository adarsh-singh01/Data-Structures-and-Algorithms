public class Max {
    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] arr = {1, 3, 2, 9, 18};

        // Call maxRange() to find the maximum value between index 1 and 3 (inclusive)
        // Sub-array = [3, 2, 9] → max = 9
        System.out.println(maxRange(arr, 1, 3));
    }

    /**
     * Finds the maximum value in the subarray from index `start` to `end` (inclusive).
     * Includes validation for edge cases like null array or invalid range.
     *
     * @param arr   The input array
     * @param start The starting index of the range
     * @param end   The ending index of the range
     * @return      The maximum value in the specified range or -1 if invalid
     */
    static int maxRange(int[] arr, int start, int end) {
        // ✅ Edge Case 1: Check if array is null
        if (arr == null) {
            return -1;//returning -1 to indicate invalid input
        }

        // ✅ Edge Case 2: Check if range is invalid (start > end)
        if (start > end) {
            return -1;//returning -1 to indicate invalid input
        }

        // ✅ Edge Case 3: Check if indices are out of bounds
        if (start < 0 || end >= arr.length) {
            return -1;
        }

        // Initialize maxVal with the first element in the given range
        int maxVal = arr[start];

        // Traverse the range from start to end
        for (int i = start; i <= end; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];  // Update maxVal if current element is greater
            }
        }

        return maxVal;  // Return the maximum found in the range
    }

    /**
     * Finds the maximum value in the entire array.
     * Safe for empty arrays using edge-case handling.
     *
     * @param arr The input array
     * @return    The maximum value in the array or -1 if the array is empty
     */
    static int max(int[] arr) {
        // ✅ Edge Case: Handle empty array
        if (arr.length == 0) {
            return -1;
        }

        // Start by assuming the first element is the maximum
        int maxVal = arr[0];

        // Traverse the array starting from index 1
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];  // Update if a larger value is found
            }
        }

        return maxVal;  // Return the overall maximum
    }
}


/*
int[] arr = {1, 3, 2, 9, 18};
System.out.println(maxRange(arr, 1, 3));  // Output: 9
System.out.println(max(arr));            // Output: 18

 */