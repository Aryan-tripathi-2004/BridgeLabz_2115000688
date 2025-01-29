import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.print("Enter third number: ");
        int c = sc.nextInt();
        System.out.println("Maximum: " + findMax(a, b, c));
        sc.close();
    }

    static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}

