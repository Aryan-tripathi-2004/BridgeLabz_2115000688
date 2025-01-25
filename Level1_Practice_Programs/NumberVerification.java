import java.util.*;

class NumberVerification{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[5];
        System.out.print("Enter 5 Numbers: ");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<arr.length;i++){
            int number = arr[i];
            if(number>0){
                if(number%2==0) System.out.println("Even");
                else System.out.println("Odd");
            }
            else if(number<0) System.out.println("Negative");
            else System.out.println("Zero");
        }

        if(arr[0]==arr[arr.length-1]) System.out.println("First and last number of array are equal");
        else if(arr[0]>arr[arr.length-1]) System.out.println("First number is greater than last number");
        else System.out.println("Second number is greater than first number");
    }
}