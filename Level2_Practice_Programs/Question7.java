import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter Second Number: ");
        int num2 = sc.nextInt();

        int temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("The swapped numbers are "+num1+" and "+num2);
    }
}
