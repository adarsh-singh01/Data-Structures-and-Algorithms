public class ProductOfDigits {
    static int product(int n){
        if(n/10==0) return n;
        int rem=n%10;
        return rem*product(n/10);
    }
    public static void main(String[] args) {
        int a=product(1424);
        System.out.println(a);
    }
}
