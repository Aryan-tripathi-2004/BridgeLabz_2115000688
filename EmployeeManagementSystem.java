import java.util.*;

abstract class Employee{
    private String employeeID;
    private String name;
    private int baseSalary;

    public Employee(String employeeID, String name, int baseSalary){
        this.employeeID = employeeID;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract int calculateSalary();

    public String getEmployeeID(){
        return employeeID;
    }
    public String getName(){
        return name;
    }
    public int getBaseSalary(){
        return baseSalary;
    }
    
    public void displayDetails(){
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Salary: " + calculateSalary());
    }
}
interface Department{
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}
class FullTimeEmployee extends Employee implements Department{
    private String departmentName;
    private int bonus;

    public FullTimeEmployee(String employeeID, String name, int baseSalary, int bonus){
        super(employeeID, name, baseSalary);
        this.bonus = bonus;
    }

    public void assignDepartment(String departmentName){
        this.departmentName = departmentName;
    }
    public String getDepartmentDetails(){
        return departmentName;
    }   

    public int calculateSalary(){
        return getBaseSalary() + bonus;
    }
}
class PartTimeEmployee extends Employee implements Department{
    private String departmentName;
    private int hoursWorked;
    private int hourlyRate;

    public PartTimeEmployee(String employeeID, String name, int baseSalary, int hoursWorked, int hourlyRate){
        super(employeeID, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public void assignDepartment(String departmentName){
        this.departmentName = departmentName;
    }
    public String getDepartmentDetails(){
        return departmentName;
    }

    public int calculateSalary(){
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}
public class EmployeeManagementSystem{
    public static void main(String args[]){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        
        FullTimeEmployee employee1 = new FullTimeEmployee("FT001", "John", 50000, 10000);
        employee1.assignDepartment("HR");
        employees.add(employee1);

        PartTimeEmployee employee2 = new PartTimeEmployee("PT001", "Jane", 20000, 40, 100);
        employee2.assignDepartment("IT");
        employees.add(employee2);

        for(Employee employee : employees){
            employee.displayDetails();
            if(employee instanceof Department){
                System.out.println("Department: " + ((Department)employee).getDepartmentDetails());
            }
            System.out.println("-------------------------------------------------");
        }


    }
}