public class SumOfDigits {

    static int sum(int n){
        if(n==0) return 0;
        //if(n/10==0) return n;//GIVES 0 FOR SINGLE DIGIT INPUT
        int rem=n%10;
        return rem+sum(n/10);
    }
    public static void main(String[] args) {
        int a=sum(1024);
        System.out.println(a);
    }
}
