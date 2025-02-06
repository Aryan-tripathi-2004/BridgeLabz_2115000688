import java.util.*; 

class University{
    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> faculties;

    public University(String universityName){
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String departmentId, String departmentName){
        departments.add(new Department(departmentId, departmentName));
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public void display(){
        System.out.println("This the Data Of "+ universityName);
        System.out.println();
        System.out.println("List of departmehts in the university: ");
        for(Department department : departments){
            department.display();
        }
        System.out.println();
        System.out.println("List of Faculty members in the university: ");
        for(Faculty faculty : faculties){
            faculty.display();
        }
        System.out.println();
    }

    public void deleteUniversity(){
        departments.clear();
        faculties.clear();
    }
}
class Department{
    private String departmentId;
    private String departmentName;

    public Department(String departmentId, String departmentName){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public void display(){
        System.out.println("Department Id: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println();
    }

}
class Faculty{
    private String facultyName;
    
    public Faculty(String facultyName){
        this.facultyName = facultyName;
    }

    public void display(){
        System.out.println("Faculty Name: " + facultyName);
    }
}
class UniversityWithFaculties{
    public static void main(String[] args) {
        University university = new University("G.L.A University, Mathura");

        university.addDepartment("001", "Computer Science");
        university.addDepartment("002", "Management");

        Faculty faculty1 = new Faculty("Arun");
        Faculty faculty2 = new Faculty("Aryan");
        Faculty faculty3 = new Faculty("Krishna");
        Faculty faculty4 = new Faculty("Vibhor");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addFaculty(faculty3);
        university.addFaculty(faculty4);

        System.out.println("Data of University Before deletion: ");
        System.out.println();
        university.display();
        university.deleteUniversity();
        System.out.println("Data of University after deleteion: ");
        System.out.println();
        university.display();

        System.out.println("Faculty data after university deleteion: ");
        faculty1.display();
        faculty2.display();
        faculty3.display();
        faculty4.display();

    }
}