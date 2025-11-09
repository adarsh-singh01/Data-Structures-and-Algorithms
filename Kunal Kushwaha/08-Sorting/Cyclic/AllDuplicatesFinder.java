import java.util.ArrayList;
import java.util.List;

class AllDuplicatesFinder {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println("Duplicate numbers: " + duplicates); // Expected: [2, 3]
    }

    static List<Integer> findDuplicates(int[] nums) {
        int i = 0;

        // Step 1: Place each number at its correct index
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        // Step 2: Collect duplicates
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1 && !ans.contains(nums[index])) {
                ans.add(nums[index]);
            }
        }

        return ans;
    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
/*
===================== FLOW OF EXECUTION =====================

Initial array: {4, 3, 2, 7, 8, 2, 3, 1}

Step 1: i = 0
    arr[i] = 4
    correct = arr[i] - 1 = 4 - 1 = 3
    arr[i] (4) != arr[correct] (7) ✅
    → swap(arr[0], arr[3])
    Array after swap: {7, 3, 2, 4, 8, 2, 3, 1}

Step 2: i = 0
    arr[i] = 7
    correct = 7 - 1 = 6
    arr[i] (7) != arr[6] (3) ✅
    → swap(arr[0], arr[6])
    Array after swap: {3, 3, 2, 4, 8, 2, 7, 1}

Step 3: i = 0
    arr[i] = 3
    correct = 3 - 1 = 2
    arr[i] (3) != arr[2] (2) ✅
    → swap(arr[0], arr[2])
    Array after swap: {2, 3, 3, 4, 8, 2, 7, 1}

Step 4: i = 0
    arr[i] = 2
    correct = 2 - 1 = 1
    arr[i] (2) != arr[1] (3) ✅
    → swap(arr[0], arr[1])
    Array after swap: {3, 2, 3, 4, 8, 2, 7, 1}

Step 5: i = 0
    arr[i] = 3
    correct = 3 - 1 = 2
    arr[i] (3) == arr[2] (3) ❌
    → i++ → i = 1

Step 6: i = 1
    arr[i] = 2
    correct = 2 - 1 = 1
    arr[i] (2) == arr[1] (2) ✅
    → i++ → i = 2

Step 7: i = 2
    arr[i] = 3
    correct = 3 - 1 = 2
    arr[i] (3) == arr[2] (3) ✅
    → i++ → i = 3

Step 8: i = 3
    arr[i] = 4
    correct = 4 - 1 = 3
    arr[i] (4) == arr[3] (4) ✅
    → i++ → i = 4

Step 9: i = 4
    arr[i] = 8
    correct = 8 - 1 = 7
    arr[i] (8) != arr[7] (1) ✅
    → swap(arr[4], arr[7])
    Array after swap: {3, 2, 3, 4, 1, 2, 7, 8}

Step 10: i = 4
    arr[i] = 1
    correct = 1 - 1 = 0
    arr[i] (1) != arr[0] (3) ✅
    → swap(arr[4], arr[0])
    Array after swap: {1, 2, 3, 4, 3, 2, 7, 8}

Step 11: i = 4
    arr[i] = 3
    correct = 3 - 1 = 2
    arr[i] (3) == arr[2] (3) ❌
    → i++ → i = 5

Step 12: i = 5
    arr[i] = 2
    correct = 2 - 1 = 1
    arr[i] (2) == arr[1] (2) ❌
    → i++ → i = 6

Step 13: i = 6
    arr[i] = 7
    correct = 7 - 1 = 6
    arr[i] (7) == arr[6] (7) ✅
    → i++ → i = 7

Step 14: i = 7
    arr[i] = 8
    correct = 8 - 1 = 7
    arr[i] (8) == arr[7] (8) ✅
    → i++ → i = 8 → loop ends

Array after cyclic placement: {1, 2, 3, 4, 3, 2, 7, 8}

Step 15: Collect duplicates
    index = 0 → arr[0] = 1 → correct
    index = 1 → arr[1] = 2 → correct
    index = 2 → arr[2] = 3 → correct
    index = 3 → arr[3] = 4 → correct
    index = 4 → arr[4] = 3 → duplicate → ans.add(3)
    index = 5 → arr[5] = 2 → duplicate → ans.add(2)
    index = 6 → arr[6] = 7 → correct
    index = 7 → arr[7] = 8 → correct

===================== FINAL RESULT =====================
Duplicate numbers: [3, 2]   (order may vary)
IF we want sorted order: [2, 3]
then we can sort the ans list before returning.
=========================================================
*/
