import java.util.Scanner;

public class BMIcalculator {

    public static double calculateBMI(double weight, double height) {
        height = height / 100; 
        return weight / (height * height);
    }

    public static String[] calculateBMIStatus(double[] bmiValues) {
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            if (bmiValues[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmiValues[i] >= 18.5 && bmiValues[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmiValues[i] >= 25 && bmiValues[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] personsData = new double[10][3]; 
        double[] bmiValues = new double[10];
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            personsData[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm): ");
            personsData[i][1] = sc.nextDouble();

            bmiValues[i] = calculateBMI(personsData[i][0], personsData[i][1]);
            personsData[i][2] = bmiValues[i];
        }

        status = calculateBMIStatus(bmiValues);

        System.out.println("\nResults:");

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ": Weight = " + personsData[i][0] + "kg, Height = " + personsData[i][1] + "cm, BMI = " + personsData[i][2] + ", Status = " + status[i]);
        }

        sc.close();
    }
}
