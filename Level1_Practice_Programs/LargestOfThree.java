import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = sc.nextInt();
        System.out.print("Enter the third number: ");
        int number3 = sc.nextInt();

        String isFirstLargest = (number1 > number2 && number1 > number3) ? "Yes" : "No";
        String isSecondLargest = (number2 > number1 && number2 > number3) ? "Yes" : "No";
        String isThirdLargest = (number3 > number1 && number3 > number2) ? "Yes" : "No";

        System.out.println("Is the first number the largest? " + isFirstLargest);
        System.out.println("Is the second number the largest? " + isSecondLargest);
        System.out.println("Is the third number the largest? " + isThirdLargest);
    }
}
