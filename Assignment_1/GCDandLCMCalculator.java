import java.util.Scanner;

public class GCDandLCMCalculator {
    public static void main(String[] args) {
        int a = getInput("Enter the first number: ");
        int b = getInput("Enter the second number: ");
        
        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b, gcd);
        
        displayResults(gcd, lcm);
    }

    static int getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextInt();
    }

    static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }

    static void displayResults(int gcd, int lcm) {
        System.out.println("Greatest Common Divisor (GCD): " + gcd);
        System.out.println("Least Common Multiple (LCM): " + lcm);
    }
}
