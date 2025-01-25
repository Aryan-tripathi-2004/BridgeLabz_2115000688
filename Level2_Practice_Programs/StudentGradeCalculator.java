import java.util.Scanner;

class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1));

            System.out.print("Physics marks: ");
            marks[i][0] = sc.nextDouble();
            while (marks[i][0] < 0) {
                System.out.print("Marks must be positive. Enter again: ");
                marks[i][0] = sc.nextDouble();
            }

            System.out.print("Chemistry marks: ");
            marks[i][1] = sc.nextDouble();
            while (marks[i][1] < 0) {
                System.out.print("Marks must be positive. Enter again: ");
                marks[i][1] = sc.nextDouble();
            }

            System.out.print("Maths marks: ");
            marks[i][2] = sc.nextDouble();
            while (marks[i][2] < 0) {
                System.out.print("Marks must be positive. Enter again: ");
                marks[i][2] = sc.nextDouble();
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
