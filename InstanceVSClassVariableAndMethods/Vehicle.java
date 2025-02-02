class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 1000;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John Doe", "Car");
        Vehicle v2 = new Vehicle("Alice Smith", "Bike");

        System.out.println("Before Updating Registration Fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(1200);

        System.out.println("\nAfter Updating Registration Fee:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
