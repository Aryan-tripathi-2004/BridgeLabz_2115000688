class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display(){
        System.out.println("Employee ID: "+id);
        System.out.println("Employee Name: "+name);
        System.out.println("Employee Salary: "+salary);
    }
}
public class EmployeeData{
    public static void main(String[] args) {
        Employee E1 = new Employee(1,"Harsh",0);
        Employee E2 = new Employee(2,"krishna",10000);
        Employee E3 = new Employee(3,"shubham",20000);

        System.out.println("===========Employee Details===========");
        E1.display();
        System.out.println("======================================");
        E2.display();
        System.out.println("======================================");
        E3.display();
    }
}