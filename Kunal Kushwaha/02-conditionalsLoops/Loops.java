import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {

        // --------- for loop demonstration ----------

        // Declare an integer variable 'n' which will later store user input
        int n;

        // Create a Scanner object named 'sc' to read input from the console (System.in)
        Scanner sc = new Scanner(System.in);

        // Prompt the user by printing a message to the console
        System.out.print("Enter a number: ");

        // Read an integer input from the user and store it in variable 'n'
        n = sc.nextInt();

        // Start of a 'for' loop that will run from i = 1 up to and including n
        for (int i = 1; i <= n; i++) {
            // For each iteration, print the current value of i followed by " Hello World"
            // Example output: "1 Hello World", "2 Hello World", etc.
            System.out.println(i + " Hello World");
        }

        // Close the Scanner object to free system resources and prevent memory leaks
        sc.close();

        // --------- for-each loop demonstration ----------

        // Declare and initialize an array of integers named 'arr' with 5 elements
        int[] arr = {10, 20, 30, 40, 50};

        // Use a for-each loop to iterate over each element in the array 'arr'
        // In each iteration, the current element is stored in the variable 'num'
        for (int num : arr) {
            // Print the current value of 'num' to the console
            // This will output each element of the array on a new line
            System.out.println(num);
        }

        // --------- while loop demonstration ----------

        // It is used when we don't know the number of iterations in advance,
        // whereas for loop is used when we know the number of iterations in advance

        int count = 1; // Initialize a counter variable 'count' to 1
        while (count <= 10) { // Continue looping as long as 'count' is less than or equal to 10
            // Print the current value of 'count' to the console
            System.out.print(count + " ");
            count++; // Increment the counter variable 'count' by 1 in each iteration
        }

        System.out.println(); // Print a newline for better output formatting

        // --------- do-while loop demonstration ----------

        // It is similar to while loop but it executes the block of code at least once
        // even if the condition is false

        int number = 1; // Initialize a variable 'number' to 1
        do {
            // Print the current value of 'number' to the console
            System.out.print(number + " ");
            number++; // Increment the variable 'number' by 1 in each iteration
        } while (number <= 10); // Continue looping as long as 'number' is less than or equal to 10

    }

}
