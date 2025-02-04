class Student {
    private static String universityName = "ABC University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.rollNumber = ++totalStudents;
        this.name = name;
        this.grade = grade;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
        }
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println();
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", "A");
        Student s2 = new Student("Bob", "B");

        s1.displayStudentDetails();
        s2.displayStudentDetails();

        Student.displayTotalStudents();

        s2.updateGrade("A");

        System.out.println("After grade update:\n");
        s2.displayStudentDetails();
    }
}
