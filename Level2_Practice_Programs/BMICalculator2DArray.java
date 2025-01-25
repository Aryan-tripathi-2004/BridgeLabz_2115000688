import java.util.Scanner;

class BMICalculator2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
            personData[i][0] = sc.nextDouble();
            while (personData[i][0] <= 0) {
                System.out.print("Height must be positive. Enter again: ");
                personData[i][0] = sc.nextDouble();
            }

            System.out.print("Enter weight (in kg) of person " + (i + 1) + ": ");
            personData[i][1] = sc.nextDouble();
            while (personData[i][1] <= 0) {
                System.out.print("Weight must be positive. Enter again: ");
                personData[i][1] = sc.nextDouble();
            }

            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nResults:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + personData[i][0] + "m, Weight = " + personData[i][1] + "kg, BMI = " + personData[i][2] + ", Status = " + weightStatus[i]);
        }
    }
}
