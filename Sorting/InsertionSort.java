import java.util.Scanner;

public class InsertionSort{
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int numberOfEmployee = input.nextInt();
        int []employeeID = new int[numberOfEmployee];

        for(int i = 0;i < employeeID.length;i++){
            employeeID[i] = input.nextInt();
        }

        System.out.println("Before Sorting: ");
        displayStudentMarks(employeeID);

        SortStudentMarks(employeeID);

        System.out.println("After Sorting: ");
        displayStudentMarks(employeeID);
    }

    public static void SortStudentMarks(int []employeeID){
        for(int i = 1;i < employeeID.length;i++){
            int j = i;
            while(j > 0 && employeeID[j] < employeeID[j - 1]){
                int temp = employeeID[j];
                employeeID[j] = employeeID[j - 1];
                employeeID[j - 1] = temp;
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