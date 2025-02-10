import java.util.Random;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: $" + ratePerKm;
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Garage";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Station";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9; 
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Auto Stand";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 2; 
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class RideHailingService {
    public static void processRide(Vehicle vehicle, double distance) {
        System.out.println("\nProcessing Ride for: " + vehicle.getVehicleDetails());
        System.out.println("Estimated Fare: $" + vehicle.calculateFare(distance));

        if (vehicle instanceof GPS) {
            GPS gpsVehicle = (GPS) vehicle;
            gpsVehicle.updateLocation("On Route");
            System.out.println("Updated Location: " + gpsVehicle.getCurrentLocation());
        }
    }
}

public class RideHailing {
    public static void main(String[] args) {
        Vehicle car = new Car("C001", "John Doe", 5.0);
        Vehicle bike = new Bike("B002", "Jane Smith", 3.0);
        Vehicle auto = new Auto("A003", "Robert Brown", 4.0);

        RideHailingService.processRide(car, 10);
        RideHailingService.processRide(bike, 8);
        RideHailingService.processRide(auto, 12);
    }
}
