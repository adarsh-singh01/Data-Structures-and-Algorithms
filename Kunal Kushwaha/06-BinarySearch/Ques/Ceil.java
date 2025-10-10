public class Ceil {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 17;

        int ans = ceil(arr, target);
        System.out.println(ans); // Output: 18
    }

    // Function to find the ceiling of a target in a sorted array
    static int ceil(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // Use safe mid formula to prevent overflow
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;//in ceil we find the smallest number >= target and at the end target>mid will happen ...so this code will do start=mid+1 and the condition of while loop which is start<=end will be violated...and that value of "start" will be the ceil
            } else {
                // Target is found, it's its own ceiling
                return arr[mid];
            }
        }

        // At this point, start is at the smallest number > target
        // But if start == arr.length, target > all elements, so no ceiling

        // This is the actual ceiling
        if (start < arr.length) {
            return arr[start];//the reason why it is start is written in the above comments...in short when while loop ends start=end+1;
        }

        // No ceiling exists
        return -1;
    }
}


/*
==============================
🧠 What is "Ceiling" in an Array?
==============================

Given a sorted array, the *ceiling* of a target is:
→ The smallest element in the array that is 
  greater than or equal to the target.

If target exists in the array → return that.
If not → return the next greater element.
If target > all elements → return -1 (no ceiling exists)

------------------------------
📘 Example:
int[] arr = {2, 3, 5, 9, 14, 16, 18};
int target = 17;

Step-by-step:
- start = 0, end = 6
- mid = (0+6)/2 = 3 → arr[3] = 9 → 17 > 9 → search right
- start = 4, end = 6
- mid = (4+6)/2 = 5 → arr[5] = 16 → 17 > 16 → search right
- start = 6, end = 6
- mid = (6+6)/2 = 6 → arr[6] = 18 → 17 < 18 → search left
- end = 5 → loop ends

Now, start = 6 → arr[6] = 18 is the ceiling ✅

Edge Case:
If target = 20 → start = 7 (beyond last index)
→ No ceiling exists → return -1 ❌

==============================
⌛ Time Complexity: O(log n)
==============================
*/
