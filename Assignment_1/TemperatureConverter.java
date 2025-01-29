import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        double temperature = getInput("Enter temperature: ");
        char scale = getScale("Enter scale (C for Celsius or F for Fahrenheit): ");
        
        if (scale == 'C' || scale == 'c') {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.println(temperature + "°C = " + fahrenheit + "°F");
        } else if (scale == 'F' || scale == 'f') {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.println(temperature + "°F = " + celsius + "°C");
        } else {
            System.out.println("Invalid scale entered!");
        }
    }

    static double getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextDouble();
    }

    static char getScale(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.next().charAt(0);
    }

    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
