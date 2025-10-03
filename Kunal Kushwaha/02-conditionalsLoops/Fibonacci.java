// Program to display the Fibonacci sequence up to n terms and then Also ask which term to display

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        /*

        //it displays the Fibonacci sequence up to n terms
        
        int n = 10; // Number of terms in the Fibonacci sequence to display
        int a = 0, b = 1; // Initialize the first two terms of the sequence

        System.out.println("Fibonacci Series up to " + n + " terms:");

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " "); // Print the current term

            // Calculate the next term by summing the previous two terms
            int nextTerm = a + b;
            a = b; // Update 'a' to the next term
            b = nextTerm; // Update 'b' to the new next term
        }

        System.out.println(); // Print a newline for better output formatting

        */

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter nth term to display in the Fibonacci sequence: ");
        int termToDisplay = sc.nextInt();
        int p=0, q=1;
        int count=2;//here count is 2 because we already have first two terms
        int termValue=0;

        while(count<=termToDisplay){
            termValue = p + q;
            p = q;
            q = termValue;
            count++;
        }
        System.out.println("The " + termToDisplay + "th term of the Fibonacci sequence is: " + termValue);
        sc.close();
    }

    
    
}
