class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            System.out.println("Salary updated to: $" + salary);
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    private String team;

    public Manager(int employeeID, String department, double salary, String team) {
        super(employeeID, department, salary);
        this.team = team;
    }

    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Team: " + team);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "HR", 50000);
        emp1.setSalary(55000);
        emp1.displayEmployeeDetails();

        System.out.println();

        Manager mgr1 = new Manager(201, "IT", 70000, "Software Team");
        mgr1.displayManagerDetails();
        mgr1.setSalary(75000);
        mgr1.displayEmployeeDetails();
    }
}
