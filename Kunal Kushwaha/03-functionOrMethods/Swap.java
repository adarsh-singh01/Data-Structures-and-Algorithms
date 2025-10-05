import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        // Swap using a temporary variable
        // int temp = a;
        // a = b;
        // b = temp;

        swap(a, b); // Call the swap method...it won't work as java is pass by value

        System.out.println("After swapping:");
        System.out.println("a = " + a); // Should print 6
        System.out.println("b = " + b); // Should print 5

        String name = "Adarsh";//it is stored in the heap memory...bcoz it is a object and also string is immutable
        changeName(name);
        System.out.println(name);


        int[] arr = {1, 2, 3, 4, 5};//array is also stored in the heap memory but it is mutable and we can change its values
        changeArray(arr);
        System.out.println("After changing array:");
        System.out.println(Arrays.toString(arr)); // Should print [99, 2, 3, 4, 5]

    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside swap method:");
        System.out.println("a = " + a); // Should print 6
        System.out.println("b = " + b); // Should print 5
    }

    static void changeName(String naaam) {
        naaam = "Niharika";//java is pass by value so it won't change the original name...a new object is created in the heap memory and naaam is pointing to "Niharika" but name is still pointing to the original "Adarsh"....here we not changing the original string but creating a new object and making naaam point to it
    }


    static void changeArray(int[] nums) {
        nums[0] = 99; // This will change the original array...here we are modifying the original array and not creating a new object
    }
}