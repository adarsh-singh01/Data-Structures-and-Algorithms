public class ReverseNum {
    public static void main(String[] args) {
        int n = 12345;
        int reversed = 0;

        while (n > 0) {
            int digit = n % 10; // Extract the last digit
            reversed = reversed * 10 + digit; // Append it to the reversed number...what it done is in simple terms is it shifts the previous digits to left and adds the new digit at unit place
            n = n / 10; // Remove the last digit
        }

        System.out.println("The reversed number is: " + reversed);
    }
}

/*
VISUAL REPRESENTATION OF REVERSING A NUMBER:

Initial number: 12345
Goal: Build reversed = 54321

Loop Steps:
-------------------------------------------------------
|   n     | digit = n % 10 | reversed (after step)    |
-------------------------------------------------------
| 12345   |        5        |   0 * 10 + 5   =   5     |
| 1234    |        4        |   5 * 10 + 4   =   54    |
| 123     |        3        |   54 * 10 + 3  =   543   |
| 12      |        2        |   543 * 10 + 2 =   5432  |
| 1       |        1        |   5432 * 10 + 1 = 54321  |
-------------------------------------------------------

Explanation:
1. Take the last digit using n % 10.
2. Shift digits in 'reversed' left by multiplying it by 10.
3. Add the digit to the end of 'reversed'.
4. Remove last digit from 'n' using n / 10.

Once n becomes 0, the loop ends.

Final Output: reversed = 54321
*/

