import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in celcius: ");
        int fahrenheit   = sc.nextInt();
        
        double celsiusResult  = (fahrenheit - 32) * ((double)5/9);

        System.out.println("The "+fahrenheit+ " celsius is "+celsiusResult+" fahrenheit");

    }
}
