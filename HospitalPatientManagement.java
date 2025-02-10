import java.lang.reflect.Array;
import java.util.*;

abstract class Patient{
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + "\nName: " + name + "\nAge: " + age;
    }
}

interface MedicalRecord{
    public void addRecord(String record);
    public void viewRecord();
}

class InPatient extends Patient implements MedicalRecord{
    private String roomNo;
    private double dailyCharge;
    private int daysAdmitted;
    private ArrayList<String> medicalHistory;

    public InPatient(String patientId, String name, int age, String roomNo, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.roomNo = roomNo;
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
        medicalHistory = new ArrayList<String>();
    }

    public String getRoomNo() { return roomNo; }
    public double getDailyCharge() { return dailyCharge; }

    @Override
    public double calculateBill() {
        return dailyCharge*daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecord() {
        System.out.println("Medical History: ");
        for(String record: medicalHistory) {
            System.out.println(record);
        }
    }

    public void getInPatientDetails() {
        getPatientDetails();
        System.out.println("Room No: " + roomNo);
        System.out.println("Daily Charge: " + dailyCharge);
    }
}

class OutPatient extends Patient implements MedicalRecord{
    private double consultationFee;
    private ArrayList<String> medicalHistory;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        medicalHistory = new ArrayList<String>();
    }

    public double getConsultationFee() { return consultationFee; }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecord() {
        System.out.println("Medical History: ");
        for(String record: medicalHistory) {
            System.out.println(record);
        }
    }

    public void getOutPatientDetails() {
        getPatientDetails();
        System.out.println("Consultation Fee: " + consultationFee);
    }
}
class HospitalManagement {
    public static void processPatient(Patient patient) {
        System.out.println("\nProcessing Patient: " + patient.getPatientDetails());
        System.out.println("Total Bill: $" + patient.calculateBill());

        if (patient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) patient;
            record.addRecord("Routine Checkup Done.");
            record.viewRecord();
        }
    }
}
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient inPatient = new InPatient("P001", "John", 25, "R101", 100, 5);
        Patient outPatient = new OutPatient("P002", "Smith", 30, 50);

        HospitalManagement.processPatient(inPatient);
        HospitalManagement.processPatient(outPatient);
    }
}
