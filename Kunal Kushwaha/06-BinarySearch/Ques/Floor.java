public class Floor {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 17;

        int ans = floor(arr, target);
        System.out.println(ans); // Output: 16
    }

    // Function to find the floor of a target in a sorted array
    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // Use safe mid formula to prevent overflow
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // Target is found, it's its own floor
                return arr[mid];
            }
        }

        // At this point, start is at the smallest number > target
        // But if start == arr.length, target > all elements, so no floor
        if (end >= 0) {
            return arr[end];//it is end because end will be at the largest number < target
        }

        // No floor exists
        return -1;
    }
}

