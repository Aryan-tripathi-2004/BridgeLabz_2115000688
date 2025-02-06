import java.util.*;

class School{
    private String schoolName;
    private ArrayList<Student> students;

    public School(String schoolName){
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void displayStudents(){
        for(Student student : students){
            student.displayStudent();
        }
    }
}
class Student{
    private String studentName;
    private String studentId;
    private ArrayList<Course> courses;

    public Student(String studentName,String studentId){
        this.studentName = studentName;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    public void enrolledInCourse(Course course){
        courses.add(course);
        course.EnrolledStudent(this);
    }

    public void displayStudent(){
        System.out.println(studentName);
        System.out.println(studentId);
        System.out.println();
    }

    public void CoursesEnrolledIn(){
        for(Course course : courses){
            course.displayCourse();
        }
    }

}
class Course{
    private String courseName;
    private String courseId;
    private ArrayList<Student> students;

    public Course(String courseName, String courseId){
        this.courseName = courseName;
        this.courseId = courseId;
        this.students = new ArrayList<>();
    }

    public void EnrolledStudent(Student student){
        students.add(student);
    }

    public void displayCourse(){
        System.out.println("Course Name: " +courseName);
        System.out.println("Course ID: " +courseId);
        System.out.println();
    }

    public void displayEnrolledStudents(){
        for(Student student : students){
            student.displayStudent();
        }
    }
}
class SchoolAndStudents{
    public static void main(String args[]){
        School school = new School("ABC Public School");

        Student student1 = new Student("Aryan","1234");
        Student student2 = new Student("Krishna","5678");

        school.addStudent(student1);
        school.addStudent(student2);

        Course course1 = new Course("Maths","M101");
        Course course2 = new Course("Science","S101");

        student1.enrolledInCourse(course1);
        student1.enrolledInCourse(course2);
        student2.enrolledInCourse(course1);

        System.out.println("Students in school: ");
        school.displayStudents();
        System.out.println("Student1 enrolled in : ");
        student1.CoursesEnrolledIn();
        System.out.println("Student2 enrolled in: ");
        student2.CoursesEnrolledIn();

        System.out.println("Students Enrolled in Course1: ");
        course1.displayEnrolledStudents();
        System.out.println("Students Enrolled in Course2: ");
        course2.displayEnrolledStudents();

    }
}