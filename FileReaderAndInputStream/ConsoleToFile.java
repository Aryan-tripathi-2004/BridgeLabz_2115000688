import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter("output.txt");

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line + "\n");
            }

            System.out.println("Data saved to output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
