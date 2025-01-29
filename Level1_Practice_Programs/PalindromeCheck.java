import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        boolean isPalindrome = true;
        int len = str.length();
        
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.println(isPalindrome ? "Palindrome" : "Not a Palindrome");
        
        sc.close();
    }
}
