import java.util.Scanner;

public class Temperature {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        float fahrenheit=input.nextFloat();
        float celsius=(fahrenheit-32)*5/9;
        System.out.println("celsius = "+celsius);
        input.close(); // closes scanner and System.in
    }
}
