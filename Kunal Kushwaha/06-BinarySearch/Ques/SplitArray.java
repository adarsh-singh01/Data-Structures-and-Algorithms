public class SplitArray {
    public static void main(String[] args) {
        SplitArray sa = new SplitArray();
        int[] nums = {7, 2, 5, 10, 8};  // The array to be split
        int m = 2;                      // Number of subarrays we want
        System.out.println(sa.splitArray(nums, m));
    }

    public int splitArray(int[] nums, int m) {
        /*
         * 🧠 Problem Intuition:
         * --------------------
         * We are given an array of non-negative integers `nums[]`
         * and an integer `m`. We want to split the array into exactly `m`
         * **continuous subarrays**, such that the **maximum sum** among these
         * subarrays is **as small as possible**.
         *
         * 💡 Goal: Minimize the largest subarray sum after splitting into m subarrays.
         *
         * 🔍 Key Insight:
         * - If we choose a "maximum subarray sum" (`maxSumLimit`), we can check:
         *     Can the array be split into ≤ m parts without any part exceeding this `maxSumLimit`?
         *
         * - We use **Binary Search** on the answer (i.e., the possible range of `maxSumLimit`)
         *   to find the **smallest** such limit that allows a valid split.
         *
         * ✅ Observations:
         * - The **minimum** possible value for the max subarray sum is the **max element** in `nums[]`.
         *     → Because any subarray must at least contain the largest number.
         * - The **maximum** possible value is the **sum** of all elements.
         *     → That happens when we don’t split the array at all.
         *
         * 📦 So we do binary search in the range [max(nums), sum(nums)].
         */

        int start = 0;
        int end = 0;

        // Initialize the binary search range:
        // start = max element, end = total sum of the array
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // max element
            end += nums[i];                   // total sum
        }

        /*
         * 🔁 Binary Search Loop:
         * ---------------------
         * We binary search for the **minimum possible maximum subarray sum** that allows splitting into m parts.
         */
        while (start < end) {
            int mid = start + (end - start) / 2;

            /*
             * Now, check: Can we split `nums[]` into `m` or fewer subarrays
             * where no subarray sum exceeds `mid`?
             *
             * Strategy:
             * - Iterate through nums[] and try to build subarrays.
             * - If adding current number exceeds `mid`, start a new subarray.
             * - Count how many subarrays (`pieces`) we end up with.
             */
            int sum = 0;
            int pieces = 1;  // At least one subarray exists

            for (int num : nums) {
                if (sum + num > mid) {
                    // Cannot add this number to current subarray without exceeding `mid`
                    // So, start a new subarray with current num
                    sum = num;
                    pieces++;
                } else {
                    // Safe to add this number to current subarray
                    sum += num;
                }
            }

            /*
             * After checking all elements:
             * - If we needed more than `m` pieces, then our guessed `mid` is too small.
             * - So we must increase it → search in [mid+1, end]
             *
             * - Otherwise, it’s a valid split with ≤ m subarrays.
             *   But maybe we can still minimize `mid` → search in [start, mid]
             */
            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        /*
         * 🏁 At the end of binary search, start == end
         * This is the **smallest possible max subarray sum** that allows us to split into `m` subarrays.
         */
        return end;
    }
}



/* 
public class SplitArray {
    public static void main(String[] args) {
        SplitArray sa = new SplitArray();
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(sa.splitArray(nums, m));
    }

    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop this will contain the max item of the array
            end += nums[i];
        }

        // binary search
        while (start < end) {
            // try for the middle as potential ans
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for(int num : nums) {
                if (sum + num > mid) {
                    // you cannot add this in this subarray, make new one
                    // say you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return end; // here start == end
    }
}

*/