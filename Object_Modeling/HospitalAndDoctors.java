import java.util.ArrayList;

class Doctor {
    private String doctorName;
    private ArrayList<Patient> patients;

    public Doctor(String doctorName) {
        this.doctorName = doctorName;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); 
        }
        System.out.println("Dr. " + doctorName + " is consulting Patient: " + patient.getPatientName());
    }

    public void displayPatients() {
        System.out.println("Dr. " + doctorName + " has the following patients:");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getPatientName());
        }
    }

    public String getDoctorName() {
        return doctorName;
    }
}

class Patient {
    private String patientName;
    private ArrayList<Doctor> doctors;

    public Patient(String patientName) {
        this.patientName = patientName;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void displayDoctors() {
        System.out.println("Patient " + patientName + " is consulting the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(" - Dr. " + doctor.getDoctorName());
        }
    }

    public String getPatientName() {
        return patientName;
    }
}

class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayDoctors() {
        System.out.println("Doctors in " + hospitalName + ":");
        for (Doctor doctor : doctors) {
            System.out.println(" - Dr. " + doctor.getDoctorName());
        }
    }

    public void displayPatients() {
        System.out.println("Patients in " + hospitalName + ":");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getPatientName());
        }
    }
}

public class HospitalAndDoctors {
    public static void main(String[] args) {
        
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Smith");
        Doctor doctor2 = new Doctor("John");

        Patient patient1 = new Patient("Aryan");
        Patient patient2 = new Patient("Om");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        hospital.displayDoctors();
        hospital.displayPatients();
        doctor1.displayPatients();
        doctor2.displayPatients();
        patient1.displayDoctors();
        patient2.displayDoctors();
    }
}
