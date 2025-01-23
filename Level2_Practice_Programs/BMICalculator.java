import java.util.*;

class BMICalculator{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Height(in cm): ");
        int height = sc.nextInt();
        System.out.print("Enter your Weight(in kg): ");
        int weight = sc.nextInt();

        double heightInMeter =  (double)height/100;
        double BMI = weight/(heightInMeter*heightInMeter);
        
        if(BMI<=18.4) System.out.println("UnderWeight");
        else if(BMI>=18.5 && BMI<=24.9) System.out.println("Normal");
        else if(BMI>=25.0 && BMI<=39.9) System.out.println("OverWeight");
        else System.out.println("Obese");
        
    }
}