import java.util.*;

public class Question8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Base number: ");
        int b = sc.nextInt();
        System.out.print("Enter Exponent number: ");
        int e = sc.nextInt();

        double res = Math.pow(e, b);
        System.out.println("The result is: "+res);
    }
}
