import java.util.*;

class Company{
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName){
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName, String departmentId){
        departments.add(new Department(departmentName, departmentId));
    }

    public Department getDepartments(int index){
        return departments.get(index);
    }

    public void display(){
        System.out.println("Company Name: " + companyName);
        System.out.println();
        System.out.println("Departments: ");
        for(Department department : departments){
            department.display();
        }
    }

}

class Department{
    private String departmentName;
    private String departmentId;
    private ArrayList<Employee> employees;
 
    public Department(String departmentName, String departmentId){
        this.departmentName = departmentName;
        this.departmentId = departmentId;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName, String employeeId, String employeeSalary){
        employees.add(new Employee(employeeName, employeeId, employeeSalary));
    }

    public void display(){
        System.out.println("Department Name: " + departmentName);
        System.out.println("Department Id: " + departmentId);
        System.out.println();
        System.out.println("Employees: ");
        for(Employee employee : employees){
            employee.display();
        }
    }

}

class Employee{
    private String employeeName;
    private String employeeId;
    private String employeeSalary;

    public Employee(String employeeName, String employeeId, String employeeSalary){
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.employeeSalary = employeeSalary;
    }

    public void display(){
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Employee Salary: " + employeeSalary);
        System.out.println();
    }
}

class CompanyAndDepartments{
    public static void main(String[] args){
        Company company1 = new Company("Capgemini Company");
        Company company2 = new Company("Accenture Company");

        company1.addDepartment("HR", "HR001");
        company1.addDepartment("Finance", "FIN001");
        company2.addDepartment("IT", "IT001");
        company2.addDepartment("Sales", "S001");

        company1.getDepartments(0).addEmployee("John", "E001", "10000");
        company1.getDepartments(0).addEmployee("Doe", "E002", "20000");
        company1.getDepartments(1).addEmployee("Alice", "E003", "30000");
        company1.getDepartments(1).addEmployee("Bob", "E004", "40000");
        company2.getDepartments(0).addEmployee("Charlie", "E005", "50000");
        company2.getDepartments(0).addEmployee("David", "E006", "60000");
        company2.getDepartments(1).addEmployee("Eve", "E007", "70000");
        company2.getDepartments(1).addEmployee("Frank", "E008", "80000");

        company1.display();
        company2.display();
    }
}