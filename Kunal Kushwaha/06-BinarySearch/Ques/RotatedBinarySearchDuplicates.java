
// Search in Rotated Sorted Array II (with duplicates)
public class RotatedBinarySearchDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6};
        int target = 5;
        System.out.println(search(arr, target));  // Output: index of 5 (could be any valid one)
    }

    static int search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);

        // If no pivot found, array is not rotated — do normal binary search
        if (pivot == -1) {
            return binarySearch(nums, target, 0 , nums.length - 1);
        }

        // If pivot is the target
        if (nums[pivot] == target) {
            return pivot;
        }

        // If target is in the left sorted portion
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // Else target is in the right sorted portion
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;  // Target found
            }
        }
        return -1;  // Target not found
    }

    // Supports arrays with duplicate values
    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: mid is pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2: mid - 1 is pivot
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Case 3: if elements at start, mid, and end are equal — skip duplicates
            /*
             ELABORATION:
             When start, mid, and end are equal, we cannot determine which side is sorted.
                Therefore, we increment start and decrement end to skip these duplicates.
                However, before skipping, we check if start or end is the pivot.
                If so, we return the pivot.
             */
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // Check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Check if end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }

            // Case 4: Left side is sorted → pivot in right
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            }

            // Case 5: Right side is sorted → pivot in left
            else {
                end = mid - 1;
            }
        }

        return -1;  // No pivot (array not rotated)
    }
}
