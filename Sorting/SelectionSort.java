import java.util.Scanner;

public class SelectionSort{
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int numberOfStudents = input.nextInt();
        int []studentExamScore = new int[numberOfStudents];

        for(int i = 0;i < studentExamScore.length;i++){
            studentExamScore[i] = input.nextInt();
        }

        System.out.println("Before Sorting: ");
        displayStudentMarks(studentExamScore);

        SortStudentExamScore(studentExamScore);

        System.out.println("After Sorting: ");
        displayStudentMarks(studentExamScore);
    }

    public static void SortStudentExamScore(int []studentExamScore){
        for(int i = 0;i < studentExamScore.length - 1;i++){
            int minIndex = i;
            for(int j = i + 1;j < studentExamScore.length;j++){
                if(studentExamScore[j] < studentExamScore[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = studentExamScore[i];
                studentExamScore[i] = studentExamScore[minIndex];
                studentExamScore[minIndex] = temp;
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