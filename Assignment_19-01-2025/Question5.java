import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius: ");
        int r = sc.nextInt();
        System.out.println("Enter height: ");
        int h = sc.nextInt();

        double volume = 3.14 * r * r * h;

        System.out.println("Volume is: "+ volume);
    }
}
