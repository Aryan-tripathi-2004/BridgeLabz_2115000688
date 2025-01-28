import java.util.Scanner;

public class YoungestAndTallest {

    public int findYoungest(int[] ages) {
        int youngest = ages[0];
        for (int age : ages) {
            if (age < youngest) {
                youngest = age;
            }
        }
        return youngest;
    }

    public double findTallest(double[] heights) {
        double tallest = heights[0];
        for (double height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        YoungestAndTallest yat = new YoungestAndTallest();

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter the height of " + names[i] + " in meters: ");
            heights[i] = sc.nextDouble();
        }

        int youngestAge = yat.findYoungest(ages);
        double tallestHeight = yat.findTallest(heights);

        System.out.println("The youngest friend is " + names[0] + " with age " + youngestAge);
        System.out.println("The tallest friend is " + names[1] + " with height " + tallestHeight);

        sc.close();
    }
}
