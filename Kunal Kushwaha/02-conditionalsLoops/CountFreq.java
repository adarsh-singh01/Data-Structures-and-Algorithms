public class CountFreq {

    public static void main(String[] args) {
        int n=13556745;
        int count =0;

        int digitToFind = 5; // Digit whose frequency we want to find

        while(n>0){
            int digit = n % 10; // Extract the last digit
            if(digit == digitToFind){
                count++;
            }
            n = n / 10; // Remove the last digit
        }

        System.out.println("The frequency of digit " + digitToFind + " is: " + count);
    }
    
}
