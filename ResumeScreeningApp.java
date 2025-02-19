import java.util.*;

// Abstract Class for Job Roles
abstract class JobRole {
    protected String candidateName;
    protected double experience; // in years

    public JobRole(String candidateName, double experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }

    public abstract boolean isQualified();

    public String getCandidateName() {
        return candidateName;
    }

    public double getExperience() {
        return experience;
    }
}

// Software Engineer Role
class SoftwareEngineer extends JobRole {
    private boolean knowsJava;

    public SoftwareEngineer(String candidateName, double experience, boolean knowsJava) {
        super(candidateName, experience);
        this.knowsJava = knowsJava;
    }

    @Override
    public boolean isQualified() {
        return experience >= 2 && knowsJava;
    }
}

// Data Scientist Role
class DataScientist extends JobRole {
    private boolean knowsML;

    public DataScientist(String candidateName, double experience, boolean knowsML) {
        super(candidateName, experience);
        this.knowsML = knowsML;
    }

    @Override
    public boolean isQualified() {
        return experience >= 3 && knowsML;
    }
}

// Product Manager Role
class ProductManager extends JobRole {
    private boolean hasMBA;

    public ProductManager(String candidateName, double experience, boolean hasMBA) {
        super(candidateName, experience);
        this.hasMBA = hasMBA;
    }

    @Override
    public boolean isQualified() {
        return experience >= 5 && hasMBA;
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private T candidate;

    public Resume(T candidate) {
        this.candidate = candidate;
    }

    public boolean evaluateCandidate() {
        return candidate.isQualified();
    }

    public void displayCandidateInfo() {
        System.out.println("Candidate: " + candidate.getCandidateName());
        System.out.println("Experience: " + candidate.getExperience() + " years");
        System.out.println("Qualified: " + (evaluateCandidate() ? "Yes" : "No"));
    }
}

// Resume Screening System
class ResumeScreeningSystem {
    // Generic method to process resumes
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        resume.displayCandidateInfo();
        System.out.println("--------------------------------");
    }

    // Wildcard method to process multiple resumes
    public static void processMultipleResumes(List<? extends JobRole> candidates) {
        for (JobRole candidate : candidates) {
            System.out.println("Screening: " + candidate.getCandidateName());
            System.out.println("Experience: " + candidate.getExperience() + " years");
            System.out.println("Qualified: " + (candidate.isQualified() ? "Yes" : "No"));
            System.out.println("--------------------------------");
        }
    }
}

// Main Class
public class ResumeScreeningApp {
    public static void main(String[] args) {
        // Creating candidates for different job roles
        SoftwareEngineer se1 = new SoftwareEngineer("Alice", 3, true);
        DataScientist ds1 = new DataScientist("Bob", 2, false);
        ProductManager pm1 = new ProductManager("Charlie", 6, true);

        // Creating Resume objects
        Resume<SoftwareEngineer> resumeSE = new Resume<>(se1);
        Resume<DataScientist> resumeDS = new Resume<>(ds1);
        Resume<ProductManager> resumePM = new Resume<>(pm1);

        // Process individual resumes
        System.out.println("Processing Individual Resumes:");
        ResumeScreeningSystem.processResume(resumeSE);
        ResumeScreeningSystem.processResume(resumeDS);
        ResumeScreeningSystem.processResume(resumePM);

        // Process multiple resumes
        List<JobRole> candidateList = Arrays.asList(se1, ds1, pm1);
        System.out.println("\nProcessing Multiple Resumes:");
        ResumeScreeningSystem.processMultipleResumes(candidateList);
    }
}
