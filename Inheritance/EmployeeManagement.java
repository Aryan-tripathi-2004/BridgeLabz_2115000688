class Employee{
    private String name;
    private String Id;
    private int salary;

    public Employee(String name, String Id, int salary){
        this.name = name;
        this.Id = Id;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Id: " + Id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee{
    private int teamSize;
    
    public Manager(String name, String Id, int salary, int teamSize){
        super(name, Id, salary);
        this.teamSize = teamSize;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
        System.out.println();
    }
}

class Developer extends Employee{
    private String technology;
    
    public Developer(String name, String Id, int salary, String technology){
        super(name, Id, salary);
        this.technology = technology;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Technology: " + technology);
        System.out.println();
    }
}

class Intern extends Employee{
    private int duration;
    
    public Intern(String name, String Id, int salary, int duration){
        super(name, Id, salary);
        this.duration = duration;
    }

    public void displayDetails(){
        super.displayDetails();
        System.out.println("Duration: " + duration);
        System.out.println();
    }
}

public class EmployeeManagement {
    public static void main(String[] args){
        Employee manager = new Manager("Aryan", "M101", 80000, 5);
        Employee developer = new Developer("Om", "D102", 60000, "Java");
        Employee intern = new Intern("Priyansu", "I103", 20000, 6);

        System.out.println("Manager Details:");
        manager.displayDetails();
        System.out.println();

        System.out.println("Developer Details:");
        developer.displayDetails();
        System.out.println();

        System.out.println("Intern Details:");
        intern.displayDetails();
    }
}
