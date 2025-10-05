
import java.util.Scanner;

public class FuncSumOfTwo {
    public static void main(String[] args) {
       sum();
       //sum();
    //    sum(); we can call it as many times as we want

         int result = sum2(4,5);
         System.out.println("The sum is: " + result+" using sum2");
    
         int result2 = sum3();
         System.out.println("The sum from sum3 is: " + result2);
    }

    //BELOW CODE RETURNS SOMETHING SO WE USE INT...its also is example of parameterized function
    static int sum2(int a, int b){
        return a+b;
    }
    //OR
    static int sum3(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = in.nextInt();
        System.out.print("Enter second number: ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        System.out.println("Sum: " + sum);
        //in.close(); we should not close here bcoz it will close the scanner and we wont be able to use it again in main method if we call sum3 again
        return sum;//it means the function is Khatam Tata Bye Bye...and return the value of sum to the place where it was called from(main method)
        //System.out.println("Hello"); unreachable statement
        //this line will never be executed bcoz return statement is above it
    }


    //BELOW CODE DOES NOT RETURN ANYTHING SO WE USE VOID
    static void sum(){//we use static bcoz we dont want to return anything and we want to call it directly without creating an object of the class
        Scanner in = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = in.nextInt();
        System.out.print("Enter second number: ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        System.out.println("Sum: " + sum);
        //in.close();
    }
}
