import java.util.*;

class LeapYear{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        if(year>=1582){
            if(year%4==0 && year%100!=0 || year%400==0){
                System.out.println("This year is a leap year");
            }else{
                System.out.println("This year is not a leap year");
            }
        }else{
            System.out.println("Can't check leap year for years which is before 1582.");
        }
    }
}