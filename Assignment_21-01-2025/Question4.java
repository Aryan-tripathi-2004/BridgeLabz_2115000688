import java.util.*;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in celcius: ");
        int celsius  = sc.nextInt();
        
        double farenheitResult  = (celsius*((double)9/5))+32;

        System.out.println("The "+celsius+ " celsius is "+farenheitResult +" fahrenheit");

    }
}
