abstract class CourseType {
    private final String evaluationMethod;
    
    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }
    
    public abstract void evaluate();
    
    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}

// Specific course types
class ExamCourse extends CourseType {
    private final int numberOfExams;
    
    public ExamCourse(int numberOfExams) {
        super("Exam-Based");
        this.numberOfExams = numberOfExams;
    }
    
    @Override
    public void evaluate() {
        System.out.println("Evaluating through " + numberOfExams + " exams");
    }
}

class AssignmentCourse extends CourseType {
    private final int numberOfAssignments;
    
    public AssignmentCourse(int numberOfAssignments) {
        super("Assignment-Based");
        this.numberOfAssignments = numberOfAssignments;
    }
    
    @Override
    public void evaluate() {
        System.out.println("Evaluating through " + numberOfAssignments + " assignments");
    }
}

class ResearchCourse extends CourseType {
    private final String researchTopic;
    
    public ResearchCourse(String researchTopic) {
        super("Research-Based");
        this.researchTopic = researchTopic;
    }
    
    @Override
    public void evaluate() {
        System.out.println("Evaluating research project on: " + researchTopic);
    }
}

// Generic course class
class Course<T extends CourseType> {
    private final String courseCode;
    private final String courseName;
    private final T courseType;
    
    public Course(String courseCode, String courseName, T courseType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseType = courseType;
    }
    
    public void evaluateCourse() {
        System.out.println("Evaluating " + courseName + " (" + courseCode + ")");
        courseType.evaluate();
    }
    
    public String getCourseDetails() {
        return String.format("Course: %s (%s) - %s", 
            courseName, courseCode, courseType.getEvaluationMethod());
    }
}

// Department class to manage courses
class Department {
    private final String name;
    private final List<Course<? extends CourseType>> courses;
    
    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    
    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }
    
    public void evaluateAllCourses() {
        System.out.println("Evaluating all courses in " + name + " department:");
        for (Course<? extends CourseType> course : courses) {
            course.evaluateCourse();
            System.out.println("---");
        }
    }
    
    public void listAllCourses() {
        System.out.println(name + " Department Courses:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course.getCourseDetails());
        }
    }
}

// Main class to demonstrate usage
public class UniversitySystem {
    public static void main(String[] args) {
        // Create department
        Department computerScience = new Department("Computer Science");
        
        // Create different types of courses
        Course<ExamCourse> programmingCourse = new Course<>(
            "CS101", 
            "Introduction to Programming", 
            new ExamCourse(3)
        );
        
        Course<AssignmentCourse> webDevCourse = new Course<>(
            "CS202", 
            "Web Development", 
            new AssignmentCourse(5)
        );
        
        Course<ResearchCourse> thesisCourse = new Course<>(
            "CS400", 
            "Final Year Project", 
            new ResearchCourse("Machine Learning Applications")
        );
        
        // Add courses to department
        computerScience.addCourse(programmingCourse);
        computerScience.addCourse(webDevCourse);
        computerScience.addCourse(thesisCourse);
        
        // List all courses
        computerScience.listAllCourses();
        System.out.println();
        
        // Evaluate all courses
        computerScience.evaluateAllCourses();
    }
}