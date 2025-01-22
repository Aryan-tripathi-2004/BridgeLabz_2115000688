import java.util.*;

public class Question12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight(in KG): ");
        int weight = sc.nextInt();

        double pound = weight * 2.2;
        System.out.println("The weight of the person in pound is "+pound+" and in kg is "+weight);
    }
}
