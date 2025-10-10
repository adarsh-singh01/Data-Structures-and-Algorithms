public class FirstAndLast {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 7, 8, 8, 10};
        int target = 7;

        int[] ans = searchRange(arr, target); // Get first and last positions
        System.out.println("First and Last Position: [" + ans[0] + ", " + ans[1] + "]"); // Output: [1, 3]
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1}; // Default if target not found
        ans[0] = search(nums, target, true);  // Find first occurrence
        if (ans[0] != -1) {// If first occurrence is found, search for last but if first occurrence is not found then there is no point in searching for last occurrence because if first occurrence is not found it means target is not present in the array
            ans[1] = search(nums, target, false);  // Find last occurrence
        }
        return ans;
    }

    public static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid; // Found target
                if (findStartIndex) {
                    end = mid - 1; // Keep searching left
                } else {
                    start = mid + 1; // Keep searching right
                }
            }
        }

        return ans;
    }
}

/*
How this works:

1. The main function calls `searchRange()` with a sorted array and a target.
2. `searchRange()` calls `search()` twice:
   - First to find the **first** index of the target.
   - Second to find the **last** index.
3. The `search()` function uses binary search.
   - If `findStartIndex` is true, it keeps going left after finding the target.
   - If false, it keeps going right.
4. It returns [-1, -1] if the target is not found.
5. This approach ensures O(log n) time using binary search twice.
*/
