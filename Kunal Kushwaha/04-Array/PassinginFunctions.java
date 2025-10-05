// Importing Arrays class to use Arrays.toString() for printing array contents
import java.util.Arrays;

public class PassinginFunctions {
    public static void main(String[] args) {
        // Declare and initialize an integer array
        int[] nums = {3, 4, 5, 12};

        // Print the original array
        System.out.println(Arrays.toString(nums));  // Output: [3, 4, 5, 12]

        // Call the change() function and pass the array
        change(nums);

        // Print the array after the function call
        System.out.println(Arrays.toString(nums));  // Output: [99, 4, 5, 12]
    }

    /**
     * Modifies the first element of the array.
     * Since arrays are passed by reference (technically, by value of the reference),
     * changes here reflect in the original array.
     */
    static void change(int[] arr) {
        arr[0] = 99;  // Change the first element to 99
    }
}


/*
 
Key Concepts Explained
🔁 Arrays Are Mutable

Arrays in Java can be changed (mutated) after they are created.

Changing an element inside a method affects the original array because you're working on the same object in heap memory.

📤 How Are Arrays Passed to Functions?

Java passes everything by value — but when you pass an array (which is an object), you're passing the value of its reference.

That means:

The function gets a copy of the reference.

So both main() and change() point to the same array object in heap.

🧪 What Happens Behind the Scenes?

int[] nums = {3, 4, 5, 12};  // nums (reference) → heap array [3, 4, 5, 12]

change(nums);  // 'arr' receives the same reference

arr[0] = 99;  // This modifies the heap array → now [99, 4, 5, 12]

✅ Output of the Program
[3, 4, 5, 12]
[99, 4, 5, 12]



 */