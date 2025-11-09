
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {4,3,2,0,1,6};
        int missingNumber = findMissingNumber(arr);
        System.out.println("The missing number is: " + missingNumber); // Expected: 2
    }

    static int findMissingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
        }

        return arr.length;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

/*
===================== FLOW OF EXECUTION =====================

Initial array: {4, 3, 2, 0, 1, 6}

Step 1: i = 0
    arr[i] = 4
    correct = arr[i] = 4
    arr[i] < arr.length (6) ✅
    arr[i] (4) != arr[correct] (1) ✅
    → swap arr[0] and arr[4]
    Array after swap: {1, 3, 2, 0, 4, 6}

Step 2: i = 0
    arr[i] = 1
    correct = arr[i] = 1
    arr[i] (1) != arr[correct] (3) ✅
    → swap arr[0] and arr[1]
    Array after swap: {3, 1, 2, 0, 4, 6}

Step 3: i = 0
    arr[i] = 3
    correct = arr[i] = 3
    arr[i] (3) != arr[correct] (0) ✅
    → swap arr[0] and arr[3]
    Array after swap: {0, 1, 2, 3, 4, 6}

Step 4: i = 0
    arr[i] = 0
    correct = 0
    arr[i] == arr[correct] ✅
    → increment i → i = 1

Step 5: i = 1
    arr[i] = 1
    correct = 1
    arr[i] == arr[correct] ✅
    → increment i → i = 2

Step 6: i = 2
    arr[i] = 2
    correct = 2
    arr[i] == arr[correct] ✅
    → increment i → i = 3

Step 7: i = 3
    arr[i] = 3
    correct = 3
    arr[i] == arr[correct] ✅
    → increment i → i = 4

Step 8: i = 4
    arr[i] = 4
    correct = 4
    arr[i] == arr[correct] ✅
    → increment i → i = 5

Step 9: i = 5
    arr[i] = 6
    correct = 6
    arr[i] (6) >= arr.length (6) ❌
    → can't swap, increment i → i = 6

Now i = 6 which equals arr.length, so the loop ends.

===================== ARRAY AFTER CYCLIC PLACEMENT =====================
Final array: {0, 1, 2, 3, 4, 6}

===================== FINDING THE MISSING NUMBER =====================
for index = 0 → arr[0] == 0 ✅
for index = 1 → arr[1] == 1 ✅
for index = 2 → arr[2] == 2 ✅
for index = 3 → arr[3] == 3 ✅
for index = 4 → arr[4] == 4 ✅
for index = 5 → arr[5] == 6 ❌ → mismatch found

Missing number = 5

===================== FINAL RESULT =====================
The missing number is: 5
=========================================================
*/
