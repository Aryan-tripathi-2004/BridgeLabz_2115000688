import java.util.Scanner;

public class NumberChecker {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            if (isPositive(numbers[i])) {
                System.out.print(numbers[i] + " is positive and ");
                if (isEven(numbers[i])) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else {
                System.out.println(numbers[i] + " is negative.");
            }
        }

        int result = compare(numbers[0], numbers[4]);
        if (result == 1) {
            System.out.println("The first element is greater than the last element.");
        } else if (result == 0) {
            System.out.println("The first element is equal to the last element.");
        } else {
            System.out.println("The first element is less than the last element.");
        }

        sc.close();
    }
}
