import java.util.*;

public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Kilometers: ");
        int k = sc.nextInt();

        double m = k * 0.621371;
        System.out.println("Miles: "+ m);
    }
}
