import java.util.Scanner;

public class MergeSort{
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int numberOfBooks = input.nextInt();
        int []bookPrices = new int[numberOfBooks];

        for(int i = 0;i < bookPrices.length;i++){
            bookPrices[i] = input.nextInt();
        }

        System.out.println("Before Sorting: ");
        displayStudentMarks(bookPrices);

        int [] sortedBookPrice = SortBookPrices(bookPrices, 0, bookPrices.length - 1);

        System.out.println("After Sorting: ");
        displayStudentMarks(sortedBookPrice);
    }

    public static int getMiddle(int []nums, int low, int high){
        int midIndex = low + (high - low) / 2;
        return midIndex;
    }

    public static int [] SortBookPrices(int []nums, int low, int high){
        if(low == high){
            int []arr = new int[1];
            arr[0] = nums[low];
            return arr;
        }

        int midIndex = getMiddle(nums, low, high);

        int []left = SortBookPrices(nums, low, midIndex);
        int []right = SortBookPrices(nums, midIndex + 1, high);
        return mergeList(left, right);
    }


    public static int [] mergeList(int []left, int []right){
        int length = left.length + right.length;
        int [] sortedArray = new int[length];

        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] <= right[rightIndex]){
                sortedArray[index] = left[leftIndex];
                leftIndex++;
            }
            else{
                sortedArray[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }

        while(leftIndex < left.length){
            sortedArray[index] = left[leftIndex];
            leftIndex++;
            index++;
        }

        while(rightIndex < right.length){
            sortedArray[index] = right[rightIndex];
            rightIndex++;
            index++;
        }
        return sortedArray;
    }



    public static void displayStudentMarks(int []nums){
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}