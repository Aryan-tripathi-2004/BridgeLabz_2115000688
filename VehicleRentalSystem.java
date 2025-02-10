import java.util.*;

abstract class Vehicle{
    private String vehicleNumber;
    private String type;
    private String rentalRate;

    public Vehicle(String vehicleNumber, String type, String rentalRate){
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber(){ return vehicleNumber;}
    public String getType(){ return type;}
    public String getRentalRate(){ return rentalRate;}

    public void display(){
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: " + rentalRate);
    }

    abstract double calculateRentalCost(int days);
}

interface Insurable{
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable{
    public Car(String vehicleNumber, String type, String rentalRate){
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days){
        return days * Double.parseDouble(getRentalRate());
    }

    @Override
    public double calculateInsurance(){
        return 0.03 * Double.parseDouble(getRentalRate());
    }

    @Override
    public String getInsuranceDetails(){
        return "Car Insurance: 3%";
    }
}
class Bike extends Vehicle implements Insurable{
    public Bike(String vehicleNumber, String type, String rentalRate){
        super(vehicleNumber, type, rentalRate);
    }
    @Override
    public double calculateRentalCost(int days){
        return days * Double.parseDouble(getRentalRate());
    }

    @Override
    public double calculateInsurance(){
        return 0.02 * Double.parseDouble(getRentalRate());
    }

    @Override
    public String getInsuranceDetails(){
        return "Bike Insurance: 2%";
    }
}
class Truck extends Vehicle implements Insurable{
    public Truck(String vehicleNumber, String type, String rentalRate){
        super(vehicleNumber, type, rentalRate);
    }
    @Override
    public double calculateRentalCost(int days){
        return days * Double.parseDouble(getRentalRate());
    }

    @Override
    public double calculateInsurance(){
        return 0.05 * Double.parseDouble(getRentalRate());
    }

    @Override
    public String getInsuranceDetails(){
        return "Truck Insurance: 5%";
    }
}

class VehicleRentalSystem{
    public static void main(String args[]){
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        Vehicle car = new Car("KA01 1234", "Car", "1000");
        Vehicle bike = new Bike("KA02 1234", "Bike", "500");
        Vehicle truck = new Truck("KA03 1234", "Truck", "2000");

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);

        for(Vehicle vehicle: vehicles){
            vehicle.display();
            System.out.println("Rental Cost: " + vehicle.calculateRentalCost(5));
            if(vehicle instanceof Insurable){
                Insurable insurable = (Insurable) vehicle;
                System.out.println("Insurance Cost: " + insurable.calculateInsurance());
                System.out.println(insurable.getInsuranceDetails());
            }
            System.out.println("-------------------------------------------------");
        }

    }
}