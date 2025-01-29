import java.util.Scanner;

public class WordReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        
        System.out.print("Enter the word to replace: ");
        String wordToReplace = sc.nextLine();
        
        System.out.print("Enter the word to replace with: ");
        String replaceWith = sc.nextLine();
        
        String modifiedSentence = replaceWord(sentence, wordToReplace, replaceWith);
        
        System.out.println("Modified Sentence: " + modifiedSentence);
        
        sc.close();
    }

    public static String replaceWord(String sentence, String wordToReplace, String replaceWith) {
        return sentence.replace(wordToReplace, replaceWith);
    }
}
