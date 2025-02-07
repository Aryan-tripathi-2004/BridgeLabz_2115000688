class Course {
    protected String courseName;
    protected int duration; 

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); 
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded Lectures: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; 

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded); 
        this.fee = fee;
        this.discount = discount;
    }

    public double getFinalPrice() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price After Discount: $" + getFinalPrice());
    }
}

public class Education {
    public static void main(String[] args) {
        Course course = new Course("Java Programming", 6);
        course.displayDetails();
        System.out.println();

        OnlineCourse onlineCourse = new OnlineCourse("Python for Data Science", 8, "Udemy", true);
        onlineCourse.displayDetails();
        System.out.println();

        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Full Stack Web Development", 12, "Coursera", true, 500, 20);
        paidCourse.displayDetails();
    }
}
