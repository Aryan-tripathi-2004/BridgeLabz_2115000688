import java.util.Scanner;

class FizzBuzz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number > 0) {
            String[] result = new String[number];

            for (int i = 0; i < number; i++) {
                if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                    result[i] = "FizzBuzz";
                } else if ((i + 1) % 3 == 0) {
                    result[i] = "Fizz";
                } else if ((i + 1) % 5 == 0) {
                    result[i] = "Buzz";
                } else {
                    result[i] = String.valueOf(i + 1);
                }
            }

            for (int i = 0; i < result.length; i++) {
                System.out.println("Position " + (i + 1) + " = " + result[i]);
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
