public class FindInMountain {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 6, 4, 2};
        int target = 6;

        int index = findInMountainArray(arr, target);
        System.out.println("Target found at index: " + index);
    }

    public static int findInMountainArray(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);

        // Try to find in the ascending part
        /*
You search first in the ascending (left) side (which is sorted ascending).

If found, you return immediately — this is the smallest index.

If not found on the left, you search the descending side.

If found there, return the index.

Else return -1.
         */
        int index = binarySearch(arr, target, 0, peak, true);
        if (index != -1) return index;//it will end the program if index is found in the ascending part (i.e first half)

        // Try to find in the descending part
        return binarySearch(arr, target, peak + 1, arr.length - 1, false);
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid; // descending
            } else {
                start = mid + 1; // ascending
            }
        }
        return start;
    }
    //THIS IS ACTUALLY ORDER AGNOSTIC BINARY SEARCH
    private static int binarySearch(int[] arr, int target, int start, int end, boolean ascending) {
        while (start <= end) {//unlike the previous one here we are using <= bcoz we are searching for a particular element
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) return mid;
            // Standard binary search for ascending sorted array
            if (ascending) {
                if (target < arr[mid]) end = mid - 1;
                else start = mid + 1;
            } 
            // Modified binary search for descending sorted array
            else {
                if (target > arr[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }
}

/**
 * This program solves the LeetCode problem "Find in Mountain Array" (1095) using a simplified approach
 * that works with a normal int[] array instead of the MountainArray interface used on LeetCode.
 * 
 * A "mountain array" is an array where:
 * - Elements strictly increase up to a single peak.
 * - Then strictly decrease after the peak.
 * 
 * Goal:
 * Given such an array and a target value, find the index of the target.
 * If the target does not exist, return -1.
 * 
 * This solution performs the following steps:
 * 
 * 1. Find the peak index using binary search:
 *    - Since the array first increases and then decreases, the peak is the highest element.
 *    - Using binary search, we compare mid with mid + 1:
 *        - If arr[mid] > arr[mid + 1], we are in the decreasing part, so the peak is at mid or to the left.
 *        - Else, we are in the increasing part, so the peak is to the right.
 *    - We repeat until start == end, which gives the peak index.
 * 
 * 2. Perform binary search in the ascending part of the array (from index 0 to peak):
 *    - Use standard binary search since values are sorted in ascending order.
 *    - If target is found, return its index.
 * 
 * 3. If the target wasn't found in the ascending part, perform binary search in the descending part (from peak+1 to end):
 *    - Use modified binary search where comparisons are reversed since the array is sorted in descending order.
 *    - If target is found, return its index.
 * 
 * 4. If target is not found in either part, return -1.
 * 
 * This approach ensures an efficient O(log n) time complexity using binary search three times:
 * - Once for finding the peak
 * - Once on the left of the peak
 * - Once on the right of the peak
 */

