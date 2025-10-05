// Import required classes
import java.util.ArrayList;
import java.util.Scanner;

public class MultiArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Create Scanner to take user input

        // Declare a multi-dimensional ArrayList (List of Lists)
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // -------------------------------
        // Step 1: Initialization
        // -------------------------------
        // We create 3 empty inner ArrayLists and add them to the outer list
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());  // Each inner list starts empty
        }

        // -------------------------------
        // Step 2: Adding Elements
        // -------------------------------
        // Nested loop to populate each inner list with 3 integers
        System.out.println("Enter 9 numbers (3 rows × 3 columns):");
        for (int i = 0; i < 3; i++) {              // Outer loop for rows
            for (int j = 0; j < 3; j++) {          // Inner loop for columns
                int val = in.nextInt();            // Read user input
                list.get(i).add(val);              // Add value to the ith row (inner list)
            }
        }

        // -------------------------------
        // Step 3: Output the Structure
        // -------------------------------
        // This prints the entire list of lists
        System.out.println("Multi-dimensional ArrayList:");
        System.out.println(list);
    }
}

/*
 
What is a Multi-Dimensional ArrayList?

It’s a dynamic structure — a list where each element is itself a list.

Java doesn’t have built-in multi-dimensional lists like Python or other languages, so we use:

ArrayList<ArrayList<Integer>>


This behaves like a 2D array, but:

Each row (inner list) can have a different number of columns.

You can dynamically add/remove rows or columns at runtime.


-------Memory Model (Behind the Scenes)
| Structure         | Description                             |
| ----------------- | --------------------------------------- |
| Outer `ArrayList` | Stores references to inner `ArrayList`s |
| Inner `ArrayList` | Stores actual integer values            |


So, it's not a grid/matrix in memory. It’s more like:

list → [
          [10, 20, 30],   // list.get(0)
          [40, 50, 60],   // list.get(1)
          [70, 80, 90]    // list.get(2)
       ]


       
Sample Input & Output
User Input:
10 20 30
40 50 60
70 80 90

Program Output:
Multi-dimensional ArrayList:
[[10, 20, 30], [40, 50, 60], [70, 80, 90]]





| Concept                         | Explanation                                    |
| ------------------------------- | ---------------------------------------------- |
| `ArrayList<ArrayList<Integer>>` | Declares a list of lists                       |
| `list.add(new ArrayList<>())`   | Initializes each row                           |
| `list.get(i).add(val)`          | Adds value to specific row (inner list)        |
| Dynamic size                    | You can grow or shrink rows/columns as needed  |
| Useful when                     | You don’t know row/column size at compile-time |


 */