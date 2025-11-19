import java.util.Arrays;

public class TriangleAndSomeSortt {
    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 5};

        // Print a triangle pattern using recursion
        triangle(4, 0);

        // Perform selection sort using recursion
        selection(arr, arr.length, 0, 0);

        // Print sorted array
        System.out.println(Arrays.toString(arr));
    }

    // Prints a triangle (normal order) using recursion
    // r = remaining rows, c = current column
    static void triangle(int r, int c) {
        // Base case: no rows left
        if (r == 0) {
            return;
        }

        // Still printing stars in this row
        if (c < r) {
            System.out.print("* ");
            triangle(r, c + 1);   // Move to next column
        } else {
            // End of row → move to next line
            System.out.println();
            triangle(r - 1, 0);   // Start next row
        }
    }

    // Prints triangle in reverse order (uses post-recursion printing)
    static void triangle2(int r, int c) {
        if (r == 0) {
            return;
        }

        if (c < r) {
            triangle2(r, c + 1);   // Go deeper first
            System.out.print("* "); // Print after recursion unwinds
        } else {
            triangle2(r - 1, 0);
            System.out.println();
        }
    }

    // Recursive Selection Sort
    // r = unsorted portion size, c = index scanning for max, max = index of current max
    static void selection(int[] arr, int r, int c, int max) {

        // Base case: array fully sorted
        if (r == 0) {
            return;
        }

        // Scan through unsorted portion to find maximum element
        if (c < r) {
            if (arr[c] > arr[max]) {
                selection(arr, r, c + 1, c);  // Found new max
            } else {
                selection(arr, r, c + 1, max);
            }
        } else {
            // Swap the found max element with last element of unsorted portion
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;

            // Recursively sort remaining portion
            selection(arr, r - 1, 0, 0);
        }
    }

    // Recursive Bubble Sort
    static void bubble(int[] arr, int r, int c) {

        // Base case: no rows left → sorted
        if (r == 0) {
            return;
        }

        // Compare adjacent elements in current pass
        if (c < r - 1) {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubble(arr, r, c + 1); // Move to next column
        } else {
            // After one full pass → reduce unsorted region
            bubble(arr, r - 1, 0);
        }
    }
}
