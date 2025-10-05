import java.util.Scanner;

public class SwitchCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Input scanner for user input

        // Example 1: Switch on fruit name (currently commented out)
        // String fruit = in.next();
        //
        // switch (fruit) {
        //     case "Mango" -> System.out.println("King of fruits");
        //     case "Apple" -> System.out.println("A sweet red fruit");
        //     case "Orange" -> System.out.println("Round fruit");
        //     case "Grapes" -> System.out.println("Small fruit");
        //     default -> System.out.println("please enter a valid fruit");
        // }

        int day = in.nextInt(); // Input: day number (1 to 7)

        // Example 2: Print day name (commented out)
        // switch (day) {
        //     case 1 -> System.out.println("Monday");
        //     case 2 -> System.out.println("Tuesday");
        //     case 3 -> System.out.println("Wednesday");
        //     case 4 -> System.out.println("Thursday");
        //     case 5 -> System.out.println("Friday");
        //     case 6 -> System.out.println("Saturday");
        //     case 7 -> System.out.println("Sunday");
        // }

        // Example 3: Grouped case for weekday/weekend using traditional switch (commented out)
        // switch (day) {
        //     case 1:
        //     case 2:
        //     case 3:
        //     case 4:
        //     case 5:
        //         System.out.println("Weekday");
        //         break;
        //     case 6:
        //     case 7:
        //         System.out.println("Weekend");
        //         break;
        // }




// char grade = 'B';

// switch (grade) {
//     case 'A':
//     case 'B':
//     case 'C':
//         System.out.println("Passed");
//         break;
//     case 'D':
//     case 'F':
//         System.out.println("Failed");
//         break;
//     default:
//         System.out.println("Invalid grade");
// }




        // Example 4: Modern switch expression for weekday/weekend
        switch (day) {
            case 1, 2, 3, 4, 5 -> System.out.println("Weekday"); // Monday to Friday
            case 6, 7 -> System.out.println("Weekend");         // Saturday and Sunday
        }
        in.close(); // Close the scanner to prevent resource leaks
    }
}



/*
 
----------What happens internally:

if (num == 1) {
    System.out.println("One");
} else if (num == 2) {
    System.out.println("Two");
} else if (num == 3) {
    System.out.println("Three");
} else {
    System.out.println("Default");
}

Now, let's say num = 2.
The switch (num) evaluates to 2.

It jumps directly to case 2:.
It runs:
System.out.println("Two");
Then it continues executing the next lines sequentially:
System.out.println("Three");
System.out.println("Default");
It does NOT check if num == 3 or any other case again.



switch (num) evaluates to 2.

It jumps directly to case 2:.

It runs:

System.out.println("Two");

System.out.println("Three"); (it does NOT check if num == 3)

System.out.println("Default");




------------So why doesn't it check case 3: again?

Because:

switch is not like multiple if checks

It uses labels internally (like in assembly or bytecode)

Once it finds a matching case, it's just sequential execution from that point

Think of it like this:

A switch is a controlled jump to a labeled block of code — not a chain of condition checks.



When You Use break

By adding break, you're saying:

"After running this block, exit the switch."

So with break, you control exactly where the switch stops.

 */