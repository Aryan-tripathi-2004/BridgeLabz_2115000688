
class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity; 

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging with " + batteryCapacity + " kWh capacity.");
    }
}


class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity; 

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling with " + fuelCapacity + " liters of petrol.");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250, 75);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        ev.displayInfo();
        ev.charge();

        pv.displayInfo();
        pv.refuel();
    }
}
