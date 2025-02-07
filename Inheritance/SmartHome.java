class Device{
    private String deviceId;
    private String status;

    public Device(String deviceId, String status){
        this.deviceId = deviceId;
        this.status = status;
    }

    public void display(){
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
class Thermostat extends Device{
    private String tempertaureSetting;

    public Thermostat(String deviceId, String status, String tempertaureSetting){
        super(deviceId, status);
        this.tempertaureSetting = tempertaureSetting;
    }

    public void display(){
        super.display();
        System.out.println("Temperature Setting: " + tempertaureSetting);
    }

}

class SmartHome{
    public static void main(String args[]){
        Device thermostat = new Thermostat("T001", "ON", "25");
        thermostat.display();
    }
}