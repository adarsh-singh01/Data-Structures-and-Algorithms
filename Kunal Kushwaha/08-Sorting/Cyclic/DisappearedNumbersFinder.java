import java.util.ArrayList;
import java.util.List;

class DisappearedNumbersFinder {
        public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(arr);
        System.out.println("Disappeared numbers: " + disappearedNumbers); // Expected: [5, 6]
        }

        static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else{
                i++;
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int index = 0; index < nums.length; index++) {
            if (nums[index] != index+1) {
                ans.add(index+1);
            }
        }

        return ans;
    }

    static void swap(int[] nums, int first, int second) {
        int temp =nums[first];
        nums[first]= nums[second];
        nums[second]=temp;
    }

}

/*
===================== FLOW OF EXECUTION =====================

Initial array: {4, 3, 2, 7, 8, 2, 3, 1}

Step 1: i = 0
    nums[i] = 4
    correct = 4 - 1 = 3
    nums[i] (4) != nums[correct] (7) ✅
    → swap(nums[0], nums[3])
    Array after swap: {7, 3, 2, 4, 8, 2, 3, 1}

Step 2: i = 0
    nums[i] = 7
    correct = 7 - 1 = 6
    nums[i] (7) != nums[correct] (3) ✅
    → swap(nums[0], nums[6])
    Array after swap: {3, 3, 2, 4, 8, 2, 7, 1}

Step 3: i = 0
    nums[i] = 3
    correct = 3 - 1 = 2
    nums[i] (3) != nums[correct] (2) ✅
    → swap(nums[0], nums[2])
    Array after swap: {2, 3, 3, 4, 8, 2, 7, 1}

Step 4: i = 0
    nums[i] = 2
    correct = 2 - 1 = 1
    nums[i] (2) != nums[correct] (3) ✅
    → swap(nums[0], nums[1])
    Array after swap: {3, 2, 3, 4, 8, 2, 7, 1}

Step 5: i = 0
    nums[i] = 3
    correct = 3 - 1 = 2
    nums[i] (3) == nums[correct] (3) ✅ (duplicate)
    → increment i → i = 1

Step 6: i = 1
    nums[i] = 2
    correct = 2 - 1 = 1
    nums[i] == nums[correct] ✅
    → increment i → i = 2

Step 7: i = 2
    nums[i] = 3
    correct = 3 - 1 = 2
    nums[i] == nums[correct] ✅
    → increment i → i = 3

Step 8: i = 3
    nums[i] = 4
    correct = 4 - 1 = 3
    nums[i] == nums[correct] ✅
    → increment i → i = 4

Step 9: i = 4
    nums[i] = 8
    correct = 8 - 1 = 7
    nums[i] (8) != nums[correct] (1) ✅
    → swap(nums[4], nums[7])
    Array after swap: {3, 2, 3, 4, 1, 2, 7, 8}

Step 10: i = 4
    nums[i] = 1
    correct = 1 - 1 = 0
    nums[i] (1) != nums[correct] (3) ✅
    → swap(nums[4], nums[0])
    Array after swap: {1, 2, 3, 4, 3, 2, 7, 8}

Step 11: i = 4
    nums[i] = 3
    correct = 3 - 1 = 2
    nums[i] (3) == nums[correct] (3) ✅
    → increment i → i = 5

Step 12: i = 5
    nums[i] = 2
    correct = 2 - 1 = 1
    nums[i] (2) == nums[correct] (2) ✅
    → increment i → i = 6

Step 13: i = 6
    nums[i] = 7
    correct = 7 - 1 = 6
    nums[i] == nums[correct] ✅
    → increment i → i = 7

Step 14: i = 7
    nums[i] = 8
    correct = 8 - 1 = 7
    nums[i] == nums[correct] ✅
    → increment i → i = 8

Now i = 8 which equals nums.length → loop ends.

===================== ARRAY AFTER CYCLIC PLACEMENT =====================
Final array: {1, 2, 3, 4, 3, 2, 7, 8}

===================== FINDING DISAPPEARED NUMBERS =====================
index = 0 → nums[0] = 1 → OK  
index = 1 → nums[1] = 2 → OK  
index = 2 → nums[2] = 3 → OK  
index = 3 → nums[3] = 4 → OK  
index = 4 → nums[4] = 3 ❌ → missing number = 5  
index = 5 → nums[5] = 2 ❌ → missing number = 6  
index = 6 → nums[6] = 7 → OK  
index = 7 → nums[7] = 8 → OK  

===================== FINAL RESULT =====================
Disappeared numbers: [5, 6]
=========================================================
*/
