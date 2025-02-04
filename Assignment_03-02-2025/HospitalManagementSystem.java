class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println();
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("Aryan", 30, "Flu", 101);
        Patient p2 = new Patient("om", 45, "Diabetes", 102);

        p1.displayPatientDetails();
        p2.displayPatientDetails();

        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
    }
}
