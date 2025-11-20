import java.util.Arrays;

/*
Merge Sort (top-down, recursive)

High-level steps:
1. Divide the array into two parts (left half, right half).
2. Recursively sort each half.
3. Merge the two sorted halves into a single sorted array.

Key points:
- At every "level" of recursion, all n elements are involved in merging.
- Depth of recursion tree is O(log n).
=> Time complexity: O(n log n)

Functional version:
- mergeSort(arr) returns a new sorted array.
- It does NOT sort the original array in-place.

In-place-like version:
- mergeSortInPlace(arr, start, end) uses the same arr, with index ranges.
- It still uses temporary array `mix` for merging, so auxiliary space is O(n),
  but it avoids creating new left/right subarrays via copyOfRange.
*/

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        // Functional style:
        // mergeSort(arr);             // This does nothing to 'arr' because we ignore the returned sorted array.
        // arr = mergeSort(arr);       // This would correctly reassign 'arr' to the sorted array.

        // “In-place” style (using index range [start, end)):
        mergeSortInPlace(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr)); // Expect: [1, 2, 3, 4, 5]
    }

    // Functional merge sort: returns a NEW sorted array.
    static int[] mergeSort(int[] arr) {
        // Base case: an array of length 1 is already sorted.
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        // Recursively sort the left half: arr[0..mid-1]
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));

        // Recursively sort the right half: arr[mid..end-1]
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        // Merge two sorted halves into one sorted array.
        return merge(left, right);
    }

    // Merge two sorted arrays 'first' and 'second' into a single sorted array.
    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0; // pointer in first
        int j = 0; // pointer in second
        int k = 0; // pointer in mix

        // While both arrays have elements, pick the smaller one.
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from 'first', if any.
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        // Copy remaining elements from 'second', if any.
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }

    // In-place style merge sort using the same array 'arr' and index range [start, end)
    static void mergeSortInPlace(int[] arr, int start, int end) {
        // Base case: segment of length 1 is already sorted.
        if (end - start == 1) {
            return;
        }

        int mid = (start + end) / 2;

        // Sort the left half: [start, mid)
        mergeSortInPlace(arr, start, mid);

        // Sort the right half: [mid, end)
        mergeSortInPlace(arr, mid, end);

        // Merge the two sorted halves back into arr[start..end-1]
        mergeInPlace(arr, start, mid, end);
    }

    // Merge two sorted subarrays of arr:
    // left:  [start, mid)
    // right: [mid, end)
    // into a temporary array 'mix', then copy back to arr[start..end-1].
    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start; // pointer in left half
        int j = mid;   // pointer in right half
        int k = 0;     // pointer in mix

        // Merge two sorted parts into mix[]
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left half
        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements from right half
        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged result back into the original array segment
        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }
}
