//copy pasted from MissingNumber.java and modified
public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int[] result = findMissingNumber(arr);
        System.out.println("The duplicate number is: " + result[0] + ", The missing number is: " + result[1]); // Expected: 2, 3
    }

    static int[] findMissingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i]-1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index+1) {
                return new int[]{arr[index], index+1}; // Return both the duplicate and missing number
            }
        }

        return new int[]{-1, -1}; // No duplicate or missing number found
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}