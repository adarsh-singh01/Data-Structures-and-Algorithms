public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';

        char ans = nextGreatestLetter(letters, target);
        System.out.println(ans); // Output: 'c'
    }

    // Function to find the smallest letter greater than the target
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            // Use safe mid formula to prevent overflow
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1; // Move right if target is greater than or equal to letters[mid]
            }
        }

        // At this point, start is at the smallest letter > target
        // If start == letters.length, it means target >= all elements, so wrap around to the first element
        return letters[start % letters.length];

        /*
        we can also write the above line like this:
        if (start < letters.length) {
            return letters[start];
        }
        return letters[0];
         */
    }
}
