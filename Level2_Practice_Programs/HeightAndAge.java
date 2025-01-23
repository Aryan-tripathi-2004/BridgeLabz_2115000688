import java.util.*;

class HeightAndAge{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter Amar's height: ");
        int heightAmar = sc.nextInt();

        System.out.print("Enter Akbar's age: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter Akbar's height: ");
        int heightAkbar = sc.nextInt();

        System.out.print("Enter Anthony's age: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter Anthony's height: ");
        int heightAnthony = sc.nextInt();

        int youngestAge = ageAmar;
        if (ageAkbar < youngestAge) {
            youngestAge = ageAkbar;
        }
        if (ageAnthony < youngestAge) {
            youngestAge = ageAnthony;
        }

        int tallestHeight = heightAmar;
        if (heightAkbar > tallestHeight) {
            tallestHeight = heightAkbar;
        }
        if (heightAnthony > tallestHeight) {
            tallestHeight = heightAnthony;
        }

        System.out.println("Youngest friend's age: " + youngestAge);
        System.out.println("Tallest friend's height: " + tallestHeight);
    }
}