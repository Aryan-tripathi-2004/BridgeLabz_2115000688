import java.util.*;

public class FeeWithDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter fee: ");
        int fee = sc.nextInt(); 
        System.out.print("Enter fee discount: ");
        int discountPercent = sc.nextInt();
        double discount = ((double)fee*discountPercent)/100;
        double feeRequired = fee - discount;

        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+feeRequired);

    }
}
