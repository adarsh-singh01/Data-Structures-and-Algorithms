

public class StringExample {
    public static void main(String[] args) {
        // String message=greet();
        // System.out.println(message);

        String personalised=myGreet("Adarsh");
        System.out.println(personalised);

    }

    static String myGreet(String name){//THIS IS PARAMETERIZED FUNCTION BCOZ IT TAKES AN INPUT
        String message="Hey my brother "+name;
        return message;
    }

    static String greet(){
        String greeting="Good Morning Adarsh!";
        return greeting+"\n Have a nice day";
    }
}
