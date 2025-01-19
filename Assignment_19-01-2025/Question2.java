import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter Second number: ");
        int num2 = sc.nextInt();

        sc.close();

        System.out.println("sum of numbers are: "+(num1+num2));
    }
}
