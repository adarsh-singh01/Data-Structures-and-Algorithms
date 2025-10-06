import java.util.Arrays;

public class SearchInStrings {
    public static void main(String[] args) {
        String name = "Adarsh";
        char target = 's';

        // Call the search function and print result
        System.out.println(search(name, target));

        // Print the string as a character array
        System.out.println(Arrays.toString(name.toCharArray()));
    }

    // Search using enhanced for-loop (for-each) with char array
    static boolean search2(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        // Convert string to char array and loop through each character
        for (char ch : str.toCharArray()) {
            if (ch == target) {
                return true;
            }
        }
        return false;
    }

    // Search using regular for-loop with charAt()
    static boolean search(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        // Loop through the string by index
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
