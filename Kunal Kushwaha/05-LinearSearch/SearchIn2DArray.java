

// Importing the Arrays utility class to use its method 'toString' for printing arrays in a readable format.
import java.util.Arrays;

public class SearchIn2DArray {

    public static void main(String[] args) {
        // Declaration and initialization of a 2D array (also known as a jagged array because rows can have different lengths)
        // 'int[][]' is used to define a 2-dimensional array of integers
        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {18, 12}
        };

        int target = 56; // The value we want to search in the array

        // Calling the 'search' method, which returns an int array (int[]) representing the position {row, column} of the target
        int[] ans = search(arr, target); 

        // Printing the result using Arrays.toString to display the int[] in readable form
        System.out.println(Arrays.toString(ans)); // Output format: [row, column]

        // Printing the maximum element in the 2D array
        System.out.println(max(arr));

        // Displaying the minimum possible integer value in Java, used as an initial value for max search
        System.out.println(Integer.MIN_VALUE);
    }

    // Method to search for a target value in a 2D array
    // Input: 2D array of integers and a target integer
    // Output: An array of two integers (int[]) representing the row and column of the target if found, else [-1, -1]
    static int[] search(int[][] arr, int target) {
        // Outer loop iterates through each row
        for (int row = 0; row < arr.length; row++) {
            // Inner loop iterates through each column in the current row
            for (int col = 0; col < arr[row].length; col++) {
                // If the target is found, return its position as a new int array
                // Why 'new int[] {row, col}'? Because we need to return both values together, and an array is a simple way to group them
                return new int[]{row, col};
            }
        }
        // If not found, return [-1, -1] to indicate the target was not found
        return new int[]{-1, -1};
    }

    // Method to find the maximum value in a 2D array
    // Input: 2D array of integers
    // Output: The largest integer value found in the array
    static int max(int[][] arr) {
        // Initialize max to the smallest possible integer value
        int max = Integer.MIN_VALUE;

        // Enhanced for loop to iterate through each row in the 2D array
        for (int[] ints : arr) {
            // Nested enhanced for loop to iterate through each element in the current row
            for (int element : ints) {
                // Update max if the current element is greater than the current max
                if (element > max) {
                    max = element;
                }
            }
        }

        // Return the maximum value found
        return max;
    }
}

