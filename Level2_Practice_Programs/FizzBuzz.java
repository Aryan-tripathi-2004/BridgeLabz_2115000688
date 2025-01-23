import java.util.*;

class FizzBuzz{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your number: ");
        int num = sc.nextInt();

        if(num>0){
            if(num%3==0 && num%5==0) System.out.println("FizzBuzz");
            else if(num%3==0) System.out.println("Fizz");
            else if(num%5==0) System.out.println("Buzz");
            else{
                for(int i=0;i<=num;i++){
                    System.out.print(num+" ");
                }
            }
        }
    }
}