import java.util.*;

public class Question11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        int principal = sc.nextInt();
        System.out.print("Enter Rate: ");
        int rate = sc.nextInt();
        System.out.print("Enter Time: ");
        int time  = sc.nextInt();

        int simpleInterest = principal * rate * time / 100;
        System.out.println("The Simple Interest is "+simpleInterest+" for Principal, "+principal+" Rate of Interest "+rate+" and Time "+time+" year");
    }
}
