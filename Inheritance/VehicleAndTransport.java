class Vehicle{
    private int maxSpeed;
    private String fuelType;

    public Vehicle(int maxSpeed, String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo(){
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}
class Car extends Vehicle{
    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    public void displayInfo(){
        System.out.println("Vehicle Type: Car");
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
        System.out.println();
    }
}
class Truck extends Vehicle{
    private int loadCapacity;

    public Truck(int maxSpeed, String fuelType, int loadCapacity){
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public void displayInfo(){
        System.out.println("Vehicle Type: Truck");
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
        System.out.println();
    }

}
class MotorCycle extends Vehicle{
    private String type;

    public MotorCycle(int maxSpeed, String fuelType, String type){
        super(maxSpeed, fuelType);
        this.type = type;
    }

    public void displayInfo(){
        System.out.println("Vehicle Type: MotorCycle");
        super.displayInfo();
        System.out.println("Type: " + type);
        System.out.println();
    }

}

public class VehicleAndTransport {
    public static void main(String args[]){

        Vehicle[] vehicles = {
            new Car(200, "Petrol", 5),
            new Truck(100, "Diesel", 1000),
            new MotorCycle(150, "Petrol", "Sports")
        };

        for(Vehicle vehicle: vehicles){
            vehicle.displayInfo();
        }

    }
}
