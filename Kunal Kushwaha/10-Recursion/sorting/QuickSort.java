import java.util.Arrays;

public class QuickSort {

    /*
     * QuickSort using Hoare-style partition with middle element as pivot.
     *
     * Idea:
     *  - Pick a pivot (here: middle element).
     *  - Reorder the array so that:
     *      all elements < pivot come before it,
     *      all elements > pivot come after it.
     *  - Then recursively sort left and right parts.
     *
     * Time complexity:
     *  - Best / Average: O(n log n)
     *  - Worst: O(n^2) (when partition is extremely unbalanced repeatedly)
     *
     * Space complexity:
     *  - O(log n) due to recursion stack (in-place partitioning).
     */

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr)); // Expect: [1, 2, 3, 4, 5]
    }

    // QuickSort on subarray nums[low..high] (inclusive)
    static void sort(int[] nums, int low, int high) {
        // Base case: segment has 0 or 1 element => already sorted
        if (low >= high) {
            return;
        }

        // s and e are scanning pointers from left and right
        int s = low;
        int e = high;

        // Middle index and pivot choice
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        // Partition: move s forward and e backward, swapping when needed
        while (s <= e) {

            // Move s right until nums[s] >= pivot
            // (elements < pivot will be on the left)
            while (nums[s] < pivot) {
                s++;
            }

            // Move e left until nums[e] <= pivot
            // (elements > pivot will be on the right)
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                // Swap elements that are on the wrong side of pivot
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;

                // Move both pointers
                s++;
                e--;
            }
        }

        // Now, 'e' is the end index of left partition,
        // and 's' is the start index of right partition.
        // Recursively sort the two partitions.
        sort(nums, low, e);
        sort(nums, s, high);
    }
}
