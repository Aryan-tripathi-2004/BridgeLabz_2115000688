import java.io.*;

class ReadingEfficiency{
    private static void readFileUsingFileReader(String filePath) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            while (br.readLine() != null); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileUsingInputStreamReader(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void compare(String filePath){
        System.out.println("Reading file using FileReader...");
        long start = System.currentTimeMillis();
        readFileUsingFileReader(filePath);
        long end = System.currentTimeMillis();
        System.out.println("FileReader Time: " + (end - start) + "ms\n");

        System.out.println("Reading file using InputStreamReader...");
        start = System.currentTimeMillis();
        readFileUsingInputStreamReader(filePath);
        end = System.currentTimeMillis();
        System.out.println("InputStreamReader Time: " + (end - start) + "ms");
    }
    public static void main(String[] args) {
        compare("LargeFile_1MB.txt");
        compare("LargeFile_100MB.txt");
        compare("LargeFile_500MB.txt");
    }
}
