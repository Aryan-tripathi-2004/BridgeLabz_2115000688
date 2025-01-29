import java.util.Scanner;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        int number = getInput();
        int result = calculateFactorial(number);
        displayResult(result);
    }

    static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    static void displayResult(int result) {
        System.out.println("The factorial is: " + result);
    }
}
