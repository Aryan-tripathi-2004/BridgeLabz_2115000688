import java.util.Scanner;

public class ConcateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of String array: ");
        int length = sc.nextInt();

        String arr[] = new String[length];
        for(int i=0;i<length;i++){
            arr[i] = sc.next();
        }

        StringBuffer sb = new StringBuffer();
        for(String s : arr){
            sb.append(s);
        }

        System.out.println(sb.toString());

    }
}
