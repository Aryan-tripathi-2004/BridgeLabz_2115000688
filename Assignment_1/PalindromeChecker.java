import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        String str = getInput();
        if (isPalindrome(str)) {
            displayResult(true);
        } else {
            displayResult(false);
        }
    }

    static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.next();
    }

    static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static void displayResult(boolean result) {
        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}

