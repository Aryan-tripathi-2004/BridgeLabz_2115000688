class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayRole() {
        System.out.println("This is a person in the school.");
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a teacher who teaches " + subject + ".");
    }
}

class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a student in grade " + grade + ".");
    }
}

class Staff extends Person {
    private String position;

    public Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a school staff member working as a " + position + ".");
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Person teacher = new Teacher("Mr. Smith", 40, "Mathematics");
        Person student = new Student("Alice", 15, 10);
        Person staff = new Staff("Mrs. Johnson", 35, "Librarian");

        teacher.displayRole(); 
        student.displayRole(); 
        staff.displayRole();   
    }
}
