import java.util.*;

class VoteEligibility{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[10];
        System.out.print("Enter Students Age: ");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<arr.length;i++){
            int studentAge = arr[i];
            if(studentAge<=0) System.out.println("Invaild Age");
            else if(studentAge<18) System.out.println("The Student with the age "+studentAge+" cannot vote.");
            else System.out.println("The Student with the age "+studentAge+" can vote.");
        }

        sc.close();
    }
}