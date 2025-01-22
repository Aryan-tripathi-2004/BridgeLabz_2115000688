import java.util.*;

public class DistanceInYard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance(in feet): ");
        int distanceInFeet = sc.nextInt();

        double distanceInYard = distanceInFeet/3;
        double distanceInMiles = distanceInYard/1760;

        System.out.println("Your Distance in feet is "+distanceInFeet+" while in yard "+distanceInYard+" is  and Miles is "+distanceInMiles);

    }
}
