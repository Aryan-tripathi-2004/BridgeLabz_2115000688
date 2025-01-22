import java.util.*;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Height: ");
        int height = sc.nextInt();
        System.out.print("Enter Base: ");
        int base = sc.nextInt();

        double area = (height*base)/2;
        System.out.println("The Area of Triangle is "+area);
    }
}
