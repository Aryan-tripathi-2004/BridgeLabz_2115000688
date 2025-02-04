class Vehicle {
    private static double registrationFee = 5000.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
            System.out.println();
        }
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Aryan", "Car", "ABC123");
        Vehicle v2 = new Vehicle("Om", "Motorcycle", "XYZ789");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(6000.0);

        System.out.println("After updating registration fee:\n");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
