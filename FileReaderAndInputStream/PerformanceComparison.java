import java.io.*;
import java.util.StringTokenizer;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer();
        compareFileReaderAndInputStreamReader("output.txt"); 
    }

    public static void compareStringBuilderAndStringBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1_000_000 + " ms");
    }

    public static void compareFileReaderAndInputStreamReader(String filePath) {
        try {
            long start = System.nanoTime();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br1 = new BufferedReader(fileReader);
            int wordCount = 0;
            String line;
            while ((line = br1.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
            br1.close();
            fileReader.close();
            long end = System.nanoTime();
            System.out.println("FileReader - Word Count: " + wordCount + ", Time: " + (end - start) / 1_000_000 + " ms");

            start = System.nanoTime();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
            BufferedReader br2 = new BufferedReader(inputStreamReader);
            wordCount = 0;
            while ((line = br2.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
            br2.close();
            inputStreamReader.close();
            end = System.nanoTime();
            System.out.println("InputStreamReader - Word Count: " + wordCount + ", Time: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
