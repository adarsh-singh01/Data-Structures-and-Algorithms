
public class Nto1 {

    static void numPrint(int n){
        if(n==0)return;
        System.out.println(n);
        numPrint(n-1);
    }
    public static void main(String[] args) {
        numPrint(100);
    }
}
