import java.util.*;

public class NumberOfHandShakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        long totalHandShake = (numberOfStudents*(numberOfStudents-1))/2;
        System.out.println("Number of possible handshakes: "+totalHandShake);

    }
}
