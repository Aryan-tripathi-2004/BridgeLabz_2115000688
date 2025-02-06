import java.util.ArrayList;

class Student {
    private String studentName;
    private String studentID;
    private ArrayList<Course> enrolledCourses;

    public Student(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentName(){
        return studentName;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this); 
        System.out.println(studentName + " enrolled in " + course.getCourseName());
    }

    public void displayEnrolledCourses() {
        System.out.println(studentName + " is enrolled in:");
        for (Course course : enrolledCourses) {
            System.out.println(" - " + course.getCourseName());
        }
    }
}


class Professor {
    private String professorName;
    private ArrayList<Course> assignedCourses;

    public Professor(String professorName, String professorID) {
        this.professorName = professorName;
        this.assignedCourses = new ArrayList<>();
    }

    public String getProfessorName(){
        return professorName;
    }

    public void assignProfessor(Course course) {
        assignedCourses.add(course);
        course.setProfessor(this); 
        System.out.println(professorName + " is assigned to teach " + course.getCourseName());
    }

    public void displayAssignedCourses() {
        System.out.println(professorName + " teaches:");
        for (Course course : assignedCourses) {
            System.out.println(" - " + course.getCourseName());
        }
    }
}

class Course {
    private String courseName;
    private String courseCode;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + " (" + courseCode + ")");
        System.out.println("Professor: " + (professor != null ? professor.getProfessorName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println(" - " + student.getStudentName());
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        
        Student student1 = new Student("Aryan", "S101");
        Student student2 = new Student("Om", "S102");

        
        Professor professor1 = new Professor("Dr. Kartik", "P201");
        Professor professor2 = new Professor("Dr. Ankush", "P202");

        
        Course course1 = new Course("Mathematics", "MATH101");
        Course course2 = new Course("Physics", "PHYS102");

        
        professor1.assignProfessor(course1);
        professor2.assignProfessor(course2);


        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);

        
        System.out.println("\n--- University System Overview ---");
        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();
        professor1.displayAssignedCourses();
        professor2.displayAssignedCourses();
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
