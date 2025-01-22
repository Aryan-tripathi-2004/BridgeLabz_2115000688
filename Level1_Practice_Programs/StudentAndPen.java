public class StudentAndPen {
    public static void main(String[] args) {
        int totalPens = 14, students = 3;
        int penStudentsGet = totalPens/students;
        int remainingPens = totalPens%students;

        System.out.println("The Pen Per Student is "+penStudentsGet+" and the remaining pen not distributed is "+remainingPens);
    }
}
