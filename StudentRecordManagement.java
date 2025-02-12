import java.util.*;

class Student{
    int rollNo;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollNo, String name, int age, String grade){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentRecord{
    private Student head;

    public void addStudentAtBeginning(int rollNo,String name,int age,String grade){
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;

        System.out.println("Student added successfully at beginning");
    }

    public void addStudentAtEnd(int roolNo, String name, int age, String grade){
        Student newStudent = new Student(roolNo, name, age, grade);

        if(head==null){
            newStudent.next = head;
            head = newStudent;
        }else{
            Student temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newStudent;
            newStudent.next = null;
        }
        System.out.println("Student added successfully at end");
    }

    public void AddAtSpecificPosition(int position,int rollNo, String name, int age, String grade){
        Student newStudent = new Student(rollNo, name, age, grade);
        Student temp = head;

        if(position<1){
            System.out.println("Invalid Position");
        }

        if(position==1){
            newStudent.next = head;
            head = newStudent;
            System.out.println("Student added successfully at position "+position);
            return;
        }

        int count = 1;
        while(count<position-1 && temp!=null){
            temp = temp.next;
            count++;
        }

        if(temp==null){
            System.out.println("Position not found");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
        System.out.println("Student added successfully at position "+position);
    }

    public void deleteByRollNumber(int rollNo){
        if(head==null){
            System.out.println("No student record found");
            return;
        }
        if(head.rollNo==rollNo){
            head = head.next;
            System.out.println("Student deleted successfully");
            return;
        }

        Student temp = head;
        while(temp.next!=null && temp.next.rollNo!=rollNo){
            temp = temp.next;
        }

        if(temp.next==null){
            System.out.println("Student with Roll number "+rollNo+" not found");
        }else{
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully");
        }
    }

    public void searchByRollNumber(int rollNo){
        if(head==null){
            System.out.println("No student record found");
            return;
        }

        Student temp = head;
        while(temp!=null){
            if(temp.rollNo==rollNo){
                System.out.println("Student Found: Roll Number: " + temp.rollNo + 
                ", Name: " + temp.name +
                ", Age: " + temp.age + 
                ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }   
        if(temp==null){
            System.out.println("Student not found");
        }
    }

    public void displayStudentDetails(){
        System.out.println("Student Details: ");
        
        if(head==null){
            System.out.println("No student record found");
            return;
        }

        Student temp = head;
        while(temp!=null){
            System.out.println("Roll Number: " + temp.rollNo + 
            ", Name: " + temp.name +
            ", Age: " + temp.age + 
            ", Grade: " + temp.grade);
            System.out.println();
            temp = temp.next;
        }
        System.out.println("--------------------------------------------");
    }

    public void updateStudentDetails(int rollNo, String name, int age, String grade){
        if(head==null){
            System.out.println("No student record found");
            return;
        }

        Student temp = head;
        while(temp!=null){
            if(temp.rollNo==rollNo){
                temp.name = name;
                temp.age = age;
                temp.grade = grade;
                System.out.println("Student details updated successfully");
                return;
            }
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("Student not found");
        }
    }
}    

class StudentRecordManagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecord studentRecord = new StudentRecord();

        while(true){
            System.out.println();
            System.out.println("1. Add Student at beginning");
            System.out.println("2. Add Student at end");
            System.out.println("3. Add Student at specific position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Display Student Details");
            System.out.println("7. Update Student Details");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter Roll Number: ");
                    int rollNo = sc.nextInt();
                    System.out.println("Enter Name: ");
                    String name = sc.next();
                    System.out.println("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.println("Enter Grade: ");
                    String grade = sc.next();
                    studentRecord.addStudentAtBeginning(rollNo, name, age, grade);
                    break;
                case 2:
                    System.out.println("Enter Roll Number: ");
                    int rollNo1 = sc.nextInt();
                    System.out.println("Enter Name: ");
                    String name1 = sc.next();
                    System.out.println("Enter Age: ");
                    int age1 = sc.nextInt();
                    System.out.println("Enter Grade: ");
                    String grade1 = sc.next();
                    studentRecord.addStudentAtEnd(rollNo1, name1, age1, grade1);
                    break;
                case 3:
                    System.out.println("Enter Position: ");
                    int position = sc.nextInt();
                    System.out.println("Enter Roll Number: ");
                    int rollNo2 = sc.nextInt();
                    System.out.println("Enter Name: ");
                    String name2 = sc.next();
                    System.out.println("Enter Age: ");
                    int age2 = sc.nextInt();
                    System.out.println("Enter Grade: ");
                    String grade2 = sc.next();
                    studentRecord.AddAtSpecificPosition(position, rollNo2, name2, age2, grade2);
                    break;
                case 4:
                    System.out.println("Enter Roll Number: ");
                    int rollNo3 = sc.nextInt();
                    studentRecord.deleteByRollNumber(rollNo3);
                    break;
                case 5:
                    System.out.println("Enter Roll Number: ");
                    int rollNo4 = sc.nextInt();
                    studentRecord.searchByRollNumber(rollNo4);
                    break;
                case 6:
                    studentRecord.displayStudentDetails();
                    break;
                case 7:
                    System.out.println("Enter Roll Number: ");
                    int rollNo5 = sc.nextInt();
                    System.out.println("Enter Name: ");
                    String name3 = sc.next();
                    System.out.println("Enter Age: ");
                    int age3 = sc.nextInt();
                    System.out.println("Enter Grade: ");
                    String grade3 = sc.next();
                    studentRecord.updateStudentDetails(rollNo5, name3, age3, grade3);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}