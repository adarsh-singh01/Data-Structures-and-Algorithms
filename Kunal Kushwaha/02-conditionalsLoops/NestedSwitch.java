import java.util.Scanner;

public class NestedSwitch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your year (1-3): ");
        int year = in.nextInt();//this line of code is similar to cin>>year of c++;
        in.nextLine(); // consume newline

        System.out.print("Enter course name: ");
        String course = in.nextLine();

        switch (year) {
            case 1:
                System.out.println("You are in First Year.");
                switch (course) {
                    case "Math" -> System.out.println("You have selected Basic Mathematics.");
                    case "English" -> System.out.println("You have selected English Communication.");
                    default -> System.out.println("Course not available for First Year.");
                }
                break;

            case 2:
                System.out.println("You are in Second Year.");
                switch (course) {
                    case "DSA" -> System.out.println("You have selected Data Structures.");
                    case "DBMS" -> System.out.println("You have selected Database Management.");
                    default -> System.out.println("Course not available for Second Year.");
                }
                break;

            case 3:
                System.out.println("You are in Third Year.");
                switch (course) {
                    case "AI" -> System.out.println("You have selected Artificial Intelligence.");
                    case "ML" -> System.out.println("You have selected Machine Learning.");
                    default -> System.out.println("Course not available for Third Year.");
                }
                break;

            default:
                System.out.println("Invalid year entered.");
        }

        in.close(); // Close the scanner to prevent resource leaks
    }
}




/*

Enter your year (1-3): 2
Enter course name: DSA 
You are in Second Year.
You have selected Data Structures.


*/