import java.util.Arrays;

public class Cyclic {

    public static void main(String[] args) {
        // Input array containing numbers from 1 to n in random order
        int arr[] = {3, 5, 2, 1, 4};

        // Call cyclic sort function
        cyclicSort(arr);

        // Print the sorted array
        System.out.println(Arrays.toString(arr)); // Expected: [1, 2, 3, 4, 5]
    }

    /**
     * Cyclic sort algorithm:
     * Works efficiently for arrays containing numbers from 1 to n without duplicates.
     * It places each number at its correct index (value - 1).
     */
    static void cyclicSort(int[] arr) {
        int i = 0;

        // Continue until all elements are in the correct position
        while (i < arr.length) {
            int correct = arr[i] - 1; // Index where arr[i] should be placed

            // If current element is not at its correct position, swap it
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } 
            // Else move to the next element
            else {
                i++;
            }
        }
    }

    /**
     * Helper method to swap two elements in the array
     */
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

/*
===================== FLOW OF EXECUTION =====================

Initial array: {3, 5, 2, 1, 4}

Step 1: i = 0
    correct = arr[0] - 1 = 2
    arr[0] (3) != arr[2] (2), swap → {2, 5, 3, 1, 4}

Step 2: i = 0
    correct = arr[0] - 1 = 1
    arr[0] (2) != arr[1] (5), swap → {5, 2, 3, 1, 4}

Step 3: i = 0
    correct = arr[0] - 1 = 4
    arr[0] (5) != arr[4] (4), swap → {4, 2, 3, 1, 5}

Step 4: i = 0
    correct = arr[0] - 1 = 3
    arr[0] (4) != arr[3] (1), swap → {1, 2, 3, 4, 5}

Step 5: i = 0
    correct = arr[0] - 1 = 0
    arr[0] == arr[0], so increment i → 1

Continue checking:
    i=1 → correct=1 → OK
    i=2 → correct=2 → OK
    i=3 → correct=3 → OK
    i=4 → correct=4 → OK

Loop ends when i = arr.length

===================== FINAL RESULT =====================
Sorted array: {1, 2, 3, 4, 5}
=========================================================




===================== OTHER EXAMPLE'S FLOW OF EXECUTION =====================

Example array: {2, 1, 4, 3, 5}

Step 1: i = 0
    correct = arr[0] - 1 = 2 - 1 = 1
    arr[0] (2) != arr[1] (1), so swap arr[0] and arr[1]
    Array after swap: {1, 2, 4, 3, 5}

Step 2: i = 0
    correct = arr[0] - 1 = 1 - 1 = 0
    arr[0] (1) == arr[0] (1), so increment i → i = 1

Step 3: i = 1
    correct = arr[1] - 1 = 2 - 1 = 1
    arr[1] (2) == arr[1] (2), so increment i → i = 2

Step 4: i = 2
    correct = arr[2] - 1 = 4 - 1 = 3
    arr[2] (4) != arr[3] (3), so swap arr[2] and arr[3]
    Array after swap: {1, 2, 3, 4, 5}

Step 5: i = 2
    correct = arr[2] - 1 = 3 - 1 = 2
    arr[2] (3) == arr[2] (3), so increment i → i = 3

Step 6: i = 3
    correct = arr[3] - 1 = 4 - 1 = 3
    arr[3] (4) == arr[3] (4), so increment i → i = 4

Step 7: i = 4
    correct = arr[4] - 1 = 5 - 1 = 4
    arr[4] (5) == arr[4] (5), so increment i → i = 5

Now i = 5 which equals arr.length, so the loop ends.

===================== FINAL RESULT =====================
Sorted array: {1, 2, 3, 4, 5}
=========================================================

*/

