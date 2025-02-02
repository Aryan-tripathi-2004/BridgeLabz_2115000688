class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Tech Academy";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 6, 500);
        Course c2 = new Course("Data Science", 12, 1200);

        System.out.println("Before Updating Institute Name:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        Course.updateInstituteName("Global Tech Institute");

        System.out.println("\nAfter Updating Institute Name:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}

