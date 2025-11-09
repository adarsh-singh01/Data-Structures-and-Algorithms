
public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        int duplicate = findDuplicates(arr);
        System.out.println("Duplicate number: " + duplicate); // Expected: 2
    }

static int findDuplicates(int[] arr){
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                } else {
                    return arr[i]; // Duplicate found
                }
            } else {
                i++;
            }
        }
        return -1; // No duplicate found
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

/*
===================== FLOW OF EXECUTION =====================

Initial array: {1, 3, 4, 2, 2}

Step 1: i = 0
    arr[i] = 1
    i + 1 = 1
    arr[i] == i + 1 ✅
    → increment i → i = 1

Step 2: i = 1
    arr[i] = 3
    i + 1 = 2
    arr[i] != i + 1 ✅
    correct = arr[i] - 1 = 3 - 1 = 2
    arr[i] (3) != arr[correct] (4) ✅
    → swap(arr[1], arr[2])
    Array after swap: {1, 4, 3, 2, 2}

Step 3: i = 1
    arr[i] = 4
    i + 1 = 2
    arr[i] != i + 1 ✅
    correct = arr[i] - 1 = 4 - 1 = 3
    arr[i] (4) != arr[correct] (2) ✅
    → swap(arr[1], arr[3])
    Array after swap: {1, 2, 3, 4, 2}

Step 4: i = 1
    arr[i] = 2
    i + 1 = 2
    arr[i] == i + 1 ✅
    → increment i → i = 2

Step 5: i = 2
    arr[i] = 3
    i + 1 = 3
    arr[i] == i + 1 ✅
    → increment i → i = 3

Step 6: i = 3
    arr[i] = 4
    i + 1 = 4
    arr[i] == i + 1 ✅
    → increment i → i = 4

Step 7: i = 4
    arr[i] = 2
    i + 1 = 5
    arr[i] != i + 1 ✅
    correct = arr[i] - 1 = 2 - 1 = 1
    arr[i] (2) == arr[correct] (2) ❌ (duplicate found!)
    → return arr[i] = 2

===================== FINAL RESULT =====================
Duplicate number: 2
=========================================================
*/
