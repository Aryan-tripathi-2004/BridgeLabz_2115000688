import java.io.*;
import java.util.*;


class WordOcurrence{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word to find its Occurenece in the file: ");
        String str = sc.nextLine();
        int count = 0;

        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> map = new HashMap();

        try(BufferedReader br = new BufferedReader(new FileReader("Sample.txt"))){
            String line;
            while((line = br.readLine())!=null){
                String arr[] = line.split("\\s+");
                
                for(String s : arr){
                    if(s.equals(str)) count++;
                }
            }

            System.out.println(count);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}