import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int a = sc.nextInt();
        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();
        System.out.print("Enter Third number: ");
        int c = sc.nextInt();

        int result1 = a + b *c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        System.out.println("The results of Int Operations are "+result1+ "," +result2+ "," +result3+ " and " + result4 );
    }
}
