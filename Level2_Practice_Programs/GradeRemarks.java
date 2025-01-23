import java.util.*;

class GradeRemarks{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Your Physics Marks: ");
		int physicsMarks = sc.nextInt();
		System.out.print("Enter Your Chemistry Marks: ");
		int chemistryMarks = sc.nextInt();
		System.out.print("Enter Your Maths Marks: ");
		int mathsMarks = sc.nextInt();
		
		double averageMarks = physicsMarks+chemistryMarks+mathsMarks/3;
		double percentage = averageMarks*100;
		
		if(percentage>=80){
			System.out.printf("Your averageMarks is "+averageMarks+ " and your grade is A. %n Your remark : Level 4, above agency-normalized standards");
		}
		else if(80>percentage && percentage>=70){
			System.out.printf("Your averageMarks is "+averageMarks+ " and your grade is B. %n Your remark : Level 3, at agency-normalized standards");
		}
		else if(70>percentage && percentage>=60){
			System.out.printf("Your averageMarks is "+averageMarks+ " and your grade is C. %n Your remark : Level 2, below, but approaching agency-normalized standards");
		}
		else if(60>percentage && percentage>=50){
			System.out.printf("Your averageMarks is "+averageMarks+ " and your grade is D. %n Your remark : Level 1, Well below agency-normalized standards");
		}
		else if(50>percentage && percentage>=40){
			System.out.printf("Your averageMarks is "+averageMarks+ " and your grade is E. %n Your remark : Level 1, too below agency-normalized standards");
		}
		else{
			System.out.printf("Your averageMarks is "+averageMarks+ " and your grade is R. %n Your remark : Level 3, Remedial standards");
		}
	}
}