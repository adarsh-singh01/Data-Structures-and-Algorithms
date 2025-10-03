import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Take input from user till user does not press X or x

        while(true){
            //take the operator as input
            System.out.print("Enter the operator (+, -, *, /) or 'X' to exit: ");
            char operator = sc.next().charAt(0);
            if(operator == 'X' || operator == 'x'){
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            } else if(operator == '+' || operator == '-' || operator == '*' || operator == '/'){
                //take the operands as input
                System.out.print("Enter two numbers: ");
                double num1 = sc.nextDouble();
                double num2 = sc.nextDouble();
                double result = 0;

                switch(operator){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if(num2 != 0){
                            result = num1 / num2;
                        } else {
                            System.out.println("Error: Division by zero is not allowed.");
                            continue; //skip the rest of the loop and start from the beginning
                        }
                        break;
                    default:
                        System.out.println("Invalid operator");
                        continue; //skip the rest of the loop and start from the beginning
                }
                System.out.println("The result is: " + result);
            } else {
                System.out.println("Invalid operator. Please try again.");
            }
        }

        sc.close();
    }
    
}
