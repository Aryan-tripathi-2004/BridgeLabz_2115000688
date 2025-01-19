import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Temperature in Celsius: ");
        int celsius = sc.nextInt();
        double fahrenheit = (celsius*((double)9/5))+32;
        System.out.println("Temperature in fahrenheit is: "+fahrenheit);

    }
}
