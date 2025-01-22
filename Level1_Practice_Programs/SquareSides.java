import java.util.*;

public class SquareSides {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Perimeter: ");
        int perimeter = sc.nextInt();

        double side = perimeter/4;
        System.out.println("The length of the side is "+side+" whose perimeter is "+perimeter);
    }
}
