import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int low = 1, high = 100, guess;
        String feedback;
        
        System.out.println("Think of a number between 1 and 100.");
        
        while (true) {
            guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            feedback = sc.next();
            
            if (feedback.equals("correct")) {
                System.out.println("The computer guessed your number!");
                break;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            }
        }
        
        sc.close();
    }

    public static int generateGuess(int low, int high, Random random) {
        return low + random.nextInt(high - low + 1);
    }
}
