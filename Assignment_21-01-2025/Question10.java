import java.util.*;

public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numberOfchocolates : ");
        int numberOfchocolates  = sc.nextInt();
        System.out.print("Enter numberOfChildren: ");
        int numberOfChildren = sc.nextInt();

        int chocolateGet = numberOfchocolates/numberOfChildren;
        int chocolateRem = numberOfchocolates%numberOfChildren;

        System.out.println("The number of chocolates each child gets is "+chocolateGet+" and the number of remaining chocolates are "+chocolateRem);

    }
}
