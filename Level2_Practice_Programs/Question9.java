import java.util.*;

public class Question9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First side(in meter): ");
        int side1 = sc.nextInt();
        System.out.print("Enter Second side(in meter): ");
        int side2 = sc.nextInt();
        System.out.print("Enter Third side(in meter): ");
        int side3 = sc.nextInt();

        double rounds = Math.ceil((double)5000 / (side1+side2+side3));

        System.out.println("The total number of rounds the athlete will run is "+rounds+" to complete 5 km");
    }
}
