import java.util.Scanner;

public class Largest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 no. to compare one by one with a space : ");

        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        // Find the largest number among a, b, and c
        int largest = a; // Assume a is the largest initially

        if (b > largest) {
            largest = b; // Update largest if b is greater
        }
        if (c > largest) {
            largest = c; // Update largest if c is greater
        }

        // Print the largest number
        System.out.println("The largest number is: " + largest);

        //other way
        /*

        int largest = Math.max(a, Math.max(b, c));
        System.out.println("The largest number is: " + largest);

        */

        //another way
        /*

        int max = a;
        if(a>b && a>c){
            max = a;
        } else if(b>a && b>c){
            max = b;
        } else {
            max = c;
        }

        */

        sc.close();
    }
    
}
