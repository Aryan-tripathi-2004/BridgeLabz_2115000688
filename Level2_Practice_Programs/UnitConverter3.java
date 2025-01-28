import java.util.Scanner;

public class UnitConverter3 {

    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        double kilograms = pounds * pounds2kilograms;
        return kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        double pounds = kilograms * kilograms2pounds;
        return pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        double liters = gallons * gallons2liters;
        return liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        double gallons = liters * liters2gallons;
        return gallons;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unit Converter");

        System.out.print("Enter temperature in Fahrenheit: ");
        double farhenheit = sc.nextDouble();
        double celsiusFromFahrenheit = convertFarhenheitToCelsius(farhenheit);
        System.out.println("Temperature in Celsius: " + celsiusFromFahrenheit);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();
        double farhenheitFromCelsius = convertCelsiusToFarhenheit(celsius);
        System.out.println("Temperature in Fahrenheit: " + farhenheitFromCelsius);

        System.out.print("Enter weight in pounds: ");
        double pounds = sc.nextDouble();
        double kilogramsFromPounds = convertPoundsToKilograms(pounds);
        System.out.println("Weight in kilograms: " + kilogramsFromPounds);

        System.out.print("Enter weight in kilograms: ");
        double kilograms = sc.nextDouble();
        double poundsFromKilograms = convertKilogramsToPounds(kilograms);
        System.out.println("Weight in pounds: " + poundsFromKilograms);

        System.out.print("Enter volume in gallons: ");
        double gallons = sc.nextDouble();
        double litersFromGallons = convertGallonsToLiters(gallons);
        System.out.println("Volume in liters: " + litersFromGallons);

        System.out.print("Enter volume in liters: ");
        double liters = sc.nextDouble();
        double gallonsFromLiters = convertLitersToGallons(liters);
        System.out.println("Volume in gallons: " + gallonsFromLiters);

        sc.close();
    }
}
