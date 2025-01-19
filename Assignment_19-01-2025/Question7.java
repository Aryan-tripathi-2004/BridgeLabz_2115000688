import java.util.*;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Length: ");
        int l = sc.nextInt();
        System.out.print("Enter Width: ");
        int w = sc.nextInt();

        int p = 2*(l+w);
        System.out.println("Perimeter is: "+p);
    }
}
