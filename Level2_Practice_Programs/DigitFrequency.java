import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int tempNumber = number;

        int[] digits = new int[10];
        int[] frequency = new int[10];

        int index = 0;
        while (tempNumber > 0) {
            digits[index] = tempNumber % 10;
            tempNumber = tempNumber / 10;
            index++;
        }

        for (int i = 0; i < index; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("Frequency of digits in " + number + ":");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }
    }
}
