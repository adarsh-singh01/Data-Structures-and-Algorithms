

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};  // Rotated sorted array with distinct elements
        int target = 1;
        System.out.println(search(arr, target));
    }

    // Main search function that handles rotated arrays
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // If no pivot is found, array is not rotated — do normal binary search
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // If pivot itself is the target
        if (nums[pivot] == target) {
            return pivot;
        }

        // If target is greater than or equal to first element, it's in left half
        /*
         ELABORATION (with visualization):
         Consider the array: [4, 5, 6, 7, 0, 1, 2]
         - If target is 1, it is greater than 4 (the first element).
         - This means the target must be in the left half of the array (before the pivot).
         - We can safely perform a binary search in the range [0, pivot - 1].
         */
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // Else, it's in right half
        /*
            ELABORATION (with visualization):
            Consider the array: [4, 5, 6, 7, 0, 1, 2]
            - If target is 1, it is less than 4 (the first element).
            - This means the target must be in the right half of the array (after the pivot).
            - We can safely perform a binary search in the range [pivot + 1, end].
         */
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    // Standard binary search
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Finds the pivot index in a rotated sorted array with distinct elements
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: pivot is mid
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2: pivot is mid - 1
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Case 3: pivot is in left half
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                // Case 4: pivot is in right half
                end = mid - 1;
            }
        }

        return -1; // No pivot found (array is not rotated)
    }
}
