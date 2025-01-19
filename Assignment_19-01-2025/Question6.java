import java.util.*;

public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        int p = sc.nextInt();
        System.out.print("Enter rate: ");
        int r = sc.nextInt();
        System.out.print("Enter time(in years): ");
        int t = sc.nextInt();

        int i = (p*r*t)/100;
        System.out.println("The Simple Interest is: "+ i);
    }
}
