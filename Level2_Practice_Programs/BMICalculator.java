import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];
        double[] bmis = new double[n];
        String[] statuses = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight (in kg) of person " + (i + 1) + ": ");
            weights[i] = sc.nextDouble();

            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] < 29.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        System.out.println("\nResults:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + heights[i] + "m, Weight = " + weights[i] + "kg, BMI = " + bmis[i] + ", Status = " + statuses[i]);
        }
    }
}
