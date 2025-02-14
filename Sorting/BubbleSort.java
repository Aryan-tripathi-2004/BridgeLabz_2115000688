import java.util.Scanner;

public class BubbleSort{
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int numberOfStudents = input.nextInt();
        int []studentsMarks = new int[numberOfStudents];

        for(int i = 0;i < studentsMarks.length;i++){
            studentsMarks[i] = input.nextInt();
        }

        System.out.println("Before Sorting: ");
        displayStudentMarks(studentsMarks);

        SortStudentMarks(studentsMarks);

        System.out.println("After Sorting: ");
        displayStudentMarks(studentsMarks);
    }

    public static void SortStudentMarks(int []studentsMarks){
        for(int i = 1;i < studentsMarks.length;i++){
            for(int j = 0;j < studentsMarks.length - i;j++){
                if(studentsMarks[j] > studentsMarks[j + 1]){
                    int temp = studentsMarks[j];
                    studentsMarks[j] = studentsMarks[j + 1];
                    studentsMarks[j + 1] = temp;
                }
            }
        }

    }

    public static void displayStudentMarks(int []nums){
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}