import java.util.Scanner;

public class CountingSort{
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int numberOfStudents = input.nextInt();
        int []studentsAge = new int[numberOfStudents];

        for(int i = 0;i < studentsAge.length;i++){
            studentsAge[i] = input.nextInt();
        }

        System.out.println("Before Sorting: ");
        displayStudentMarks(studentsAge);

        studentsAge = SortStudentAge(studentsAge);

        System.out.println("After Sorting: ");
        displayStudentMarks(studentsAge);
    }

    public static int [] SortStudentAge(int []studentsAge){
        int max = -1;
        for(int i = 0;i < studentsAge.length;i++){
            max = Math.max(max, studentsAge[i]);
        }
        
        int []frequency = new int[max + 1];
        
        for(int i = 0;i < studentsAge.length;i++){
            frequency[studentsAge[i]]++;
        }

        for(int i = 1;i < frequency.length;i++){
            frequency[i] = frequency[i - 1] + frequency[i];
        }

        int[] sortedStudentAge = new int[studentsAge.length];
        for(int i = studentsAge.length - 1;i >= 0;i--){
            int position = frequency[studentsAge[i]] - 1;
            sortedStudentAge[position] = studentsAge[i];
            frequency[studentsAge[i]]--;
        }

        return sortedStudentAge;
    }

    public static void displayStudentMarks(int []nums){
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}