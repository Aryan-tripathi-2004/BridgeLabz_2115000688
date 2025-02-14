import java.util.Scanner;

public class QuickSort{
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int numberOfProduct = input.nextInt();
        int []productPrices = new int[numberOfProduct];

        for(int i = 0;i < productPrices.length;i++){
            productPrices[i] = input.nextInt();
        }

        System.out.println("Before Sorting: ");
        displayStudentMarks(productPrices);

        sortProductPrices(productPrices, 0, productPrices.length - 1);

        System.out.println("After Sorting: ");
        displayStudentMarks(productPrices);
    }

    public static void sortProductPrices(int []productPrices, int low, int high){
        if(low >= high){
            return;
        }

        int pivot = getPivotIndex(productPrices, low, high);

        sortProductPrices(productPrices, low, pivot - 1);
        sortProductPrices(productPrices, pivot + 1, high);

    }

    public static int getPivotIndex(int []productPrices, int low, int high){
        int index = -1;
        int pivot = high;

        for(int i = 0;i < productPrices.length;i++){
            if(productPrices[i] < productPrices[pivot]){
                index++;
                swap(productPrices, index, i);
            }
        }

        index++;
        swap(productPrices, index, pivot);
        return index;
    }

    public static void swap(int []productPrices, int i, int j){
        int temp = productPrices[i];
        productPrices[i] = productPrices[j];
        productPrices[j] = temp;
    }

    public static void displayStudentMarks(int []nums){
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}