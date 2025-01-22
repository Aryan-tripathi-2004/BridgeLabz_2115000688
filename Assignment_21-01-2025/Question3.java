import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        double a = sc.nextDouble();
        System.out.print("Enter Second Number: ");
        double b = sc.nextDouble();
        System.out.print("Enter Third number: ");
        double c = sc.nextDouble();

        double result1 = a + b *c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println("The results of Int Operations are "+result1+ "," +result2+ "," +result3+ " and " + result4 );
    }
}
