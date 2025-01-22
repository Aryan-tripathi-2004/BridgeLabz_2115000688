import java.util.*;

public class HeightInInches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Height(in cm): ");
        double centimeter = sc.nextInt();

        double inches = centimeter / 2.54;
        double feet = inches / 12;

        System.out.println("Your Height in cm is "+centimeter+" while in feet "+feet+" is  and inches is "+inches);

    }
}
