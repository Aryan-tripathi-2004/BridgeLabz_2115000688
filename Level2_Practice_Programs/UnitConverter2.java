import java.util.Scanner;

public class UnitConverter2 {

    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        double miles = km * km2miles;
        return miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        double km = miles * miles2km;
        return km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        double feet = meters * meters2feet;
        return feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        double meters = feet * feet2meters;
        return meters;
    }

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        double feet = yards * yards2feet;
        return feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        double yards = feet * feet2yards;
        return yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        double inches = meters * meters2inches;
        return inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        double meters = inches * inches2meters;
        return meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        double cm = inches * inches2cm;
        return cm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unit Converter");

        System.out.print("Enter the distance in yards: ");
        double yards = sc.nextDouble();
        double feetFromYards = convertYardsToFeet(yards);
        System.out.println("Distance in feet: " + feetFromYards);

        System.out.print("Enter the distance in feet: ");
        double feet = sc.nextDouble();
        double yardsFromFeet = convertFeetToYards(feet);
        System.out.println("Distance in yards: " + yardsFromFeet);

        System.out.print("Enter the distance in meters: ");
        double meters = sc.nextDouble();
        double inches = convertMetersToInches(meters);
        System.out.println("Distance in inches: " + inches);

        System.out.print("Enter the distance in inches: ");
        double inchesInput = sc.nextDouble();
        double metersFromInches = convertInchesToMeters(inchesInput);
        System.out.println("Distance in meters: " + metersFromInches);

        System.out.print("Enter the distance in inches: ");
        double inchesForCm = sc.nextDouble();
        double cmFromInches = convertInchesToCentimeters(inchesForCm);
        System.out.println("Distance in centimeters: " + cmFromInches);

        sc.close();
    }
}
