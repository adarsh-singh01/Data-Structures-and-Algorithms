public class ColNotFixed {
    public static void main(String[] args) {
        // Declare a 2D array (array of arrays) with varying column sizes (jagged array)
        int[][] arr = {
                {1, 2, 3, 4},     // First row has 4 elements
                {5, 6},           // Second row has 2 elements
                {7, 8, 9}         // Third row has 3 elements
        };

        // -------------------------------
        // Traversing the 2D jagged(rectangular or not even) array
        // -------------------------------

        // Outer loop iterates over each row
        for (int row = 0; row < arr.length; row++) {
            // Inner loop iterates over each element in the current row
            // Note: arr[row].length gives number of columns in that specific row
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");  // Print element followed by a space
            }
            System.out.println();  // Move to next line after printing one row
        }
    }
}
