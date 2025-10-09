

// This class solves the Leetcode problem:
// Find how many numbers in the array have an even number of digits.
public class EvenDigits {

    public static void main(String[] args) {
        // Declare and initialize an array of integers.
        // This array is the input to the problem.
        // Why int[]? -> Because we are storing multiple integers in a single variable.
        int[] nums = {12, 345, 2, 6, 7896};

        // Uncomment to run the function that counts numbers with even number of digits
        // System.out.println(findNumbers(nums));

        // Testing the digits2 method with a negative number
        System.out.println(digits2(-345678)); // Expected output: 6
    }

    /**
     * This method counts how many numbers in the given array have an even number of digits.
     * @param nums Array of integers (int[]) to be checked.
     * @return The count of numbers with an even number of digits.
     */
    static int findNumbers(int[] nums) {
        int count = 0;

        // Enhanced for loop: iterate through each number in the array
        for (int num : nums) {
            // Check if the number has an even number of digits
            if (even(num)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Helper method to check whether a number has an even number of digits.
     * @param num Integer number to check.
     * @return true if the number has even digits, false otherwise.
     */
    static boolean even(int num) {
        // Call digits() method to count number of digits in the number
        int numberOfDigits = digits(num);

        // Return true if the number of digits is even (divisible by 2)
        return numberOfDigits % 2 == 0;
    }

    /**
     * Alternative way to count digits using logarithmic method.
     * Faster and more efficient than counting via division.
     * @param num The number whose digits we want to count.
     * @return Number of digits in the given number.
     */
    static int digits2(int num) {
        // Convert negative numbers to positive (log10 undefined for negatives)
        if (num < 0) {
            num = num * -1;
        }

        // Special case: log10(0) is undefined, so we need to handle 0 separately
        if (num == 0) {
            return 1;
        }

        // log10(num) gives number of digits - 1
        // e.g. log10(100) = 2.0 → (int)2.0 + 1 = 3
        return (int)(Math.log10(num)) + 1;
    }

    /**
     * Classic way to count the number of digits in a number using division.
     * @param num The number whose digits we want to count.
     * @return Number of digits in the number.
     */
    static int digits(int num) {
        // Handle negative numbers by converting them to positive
        if (num < 0) {
            num = num * -1;
        }

        // Special case: if number is 0, it has 1 digit
        if (num == 0) {
            return 1;
        }

        int count = 0;

        // Divide the number by 10 in each iteration, increase count until number becomes 0
        while (num > 0) {
            count++;
            num = num / 10; // or num /= 10;
        }

        return count;
    }

    //Leetcode solution
    /*
     
        public int findNumbers(int[] nums) {
        int ret = 0;

        for (int num : nums) {
            if ((int)Math.log10(num) % 2 == 1) {
                ret++;
            }
        }

        return ret;
    }

     */

}
