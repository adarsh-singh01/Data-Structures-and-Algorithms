public class Concept {
    //DIFFERNCE BETWEEN --N AND N--
    // static void fun1(int n){
    //     if(n==0) return;
    //     System.out.println(n);
    //     fun1(n--);//INFINITE LOOP BECAUSE N WILL ALWAYS BE SAME AS PREVIOUS CALL
    // }
    static void fun2(int n){
        if(n==0) return;
        
        System.out.println(n);
        fun2(--n);//DECREMENTS N BEFORE PASSING TO NEXT CALL
    }
    public static void main(String[] args) {
        //fun1(5);
        System.out.println("----");
        fun2(5);
    }
}
