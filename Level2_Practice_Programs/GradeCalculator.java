import java.util.Scanner;

class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject = "";
                if (j == 0) subject = "Physics";
                if (j == 1) subject = "Chemistry";
                if (j == 2) subject = "Maths";

                System.out.print(subject + " marks: ");
                marks[i][j] = sc.nextDouble();

                while (marks[i][j] < 0) {
                    System.out.print("Marks must be positive. Enter again: ");
                    marks[i][j] = sc.nextDouble();
                }
            }

            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;

            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }

        System.out.println("\nResults:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ": Physics = " + marks[i][0] + ", Chemistry = " + marks[i][1] + ", Maths = " + marks[i][2] + ", Percentage = " + percentages[i] + "%, Grade = " + grades[i]);
        }
    }
}
