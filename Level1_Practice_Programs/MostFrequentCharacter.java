import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        int[] frequency = new int[256];
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i)]++;
        }
        
        char mostFrequent = str.charAt(0);
        int maxCount = 0;
        
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > maxCount) {
                maxCount = frequency[i];
                mostFrequent = (char) i;
            }
        }
        
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
        
        sc.close();
    }
}
