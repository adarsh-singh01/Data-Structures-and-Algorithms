
public class OnetoN {
   static void numPrint(int n){
        if(n==0)return;
        
        numPrint(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        numPrint(100);
    }
}
