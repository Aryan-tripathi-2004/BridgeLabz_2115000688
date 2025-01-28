import java.util.Random;

public class EmployeeBonus {

    public static double[][] generateEmployeeData(int numEmployees) {
        Random rand = new Random();
        double[][] employeeData = new double[numEmployees][2]; // 0th column for salary, 1st column for years of service

        for (int i = 0; i < numEmployees; i++) {
            // Generate random salary between 10000 and 99999
            employeeData[i][0] = 10000 + rand.nextInt(90000); 
            // Generate random years of service between 1 and 15
            employeeData[i][1] = 1 + rand.nextInt(15);
        }
        return employeeData;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][3]; // 0th column for old salary, 1st column for new salary, 2nd column for bonus

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonus = 0;

            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05; // 5% bonus
            } else {
                bonus = oldSalary * 0.02; // 2% bonus
            }

            double newSalary = oldSalary + bonus;

            updatedData[i][0] = oldSalary;
            updatedData[i][1] = newSalary;
            updatedData[i][2] = bonus;
        }
        return updatedData;
    }

    public static void calculateAndDisplayTotals(double[][] updatedData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        for (int i = 0; i < updatedData.length; i++) {
            totalOldSalary += updatedData[i][0];
            totalNewSalary += updatedData[i][1];
            totalBonus += updatedData[i][2];
        }

        System.out.println("Employee Bonus Details");
        System.out.println("--------------------------------------------------------");
        System.out.println("Old Salary   New Salary   Bonus");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < updatedData.length; i++) {
            System.out.printf("%10.2f   %10.2f   %10.2f\n", updatedData[i][0], updatedData[i][1], updatedData[i][2]);
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
    }

    public static void main(String[] args) {
        int numEmployees = 10;
        double[][] employeeData = generateEmployeeData(numEmployees);
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);
        calculateAndDisplayTotals(updatedData);
    }
}
