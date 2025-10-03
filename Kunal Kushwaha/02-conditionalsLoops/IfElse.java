public class IfElse {

    /*
     syntax of if-else
     if(condition){
        //code to be executed if condition is true
     } else {
        //code to be executed if condition is false
     }
     */

    public static void main(String[] args) {
        int age = 18;
        if (age > 18) {
            System.out.println("You are an adult");
        } 
        else if(age==18){
            System.out.println("You just became an adult");
        }
        else {
            System.out.println("You are a minor");
        }

        //ternary operator
        String result = (age >= 18) ? "You are an adult" : "You are a minor";//here age>=18 is condition and ? is if and : is else
        System.out.println(result);

        //&& and ||
        int num = 25;
        if (num > 0 && num < 100) {
            System.out.println("The number is between 0 and 100");
        } else {
            System.out.println("The number is not between 0 and 100");
        }
    
}
}
