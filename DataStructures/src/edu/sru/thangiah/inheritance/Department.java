package edu.sru.thangiah.inheritance;

/**
 * <p>Title: Department.java </p>
 *
 * <p>Description: </p>
 * 
 * Example of aggregation (has-a relationship)
 * - The fundamental idea behind aggregation is asking whether
 * the child class can exist independently of the parent class
 * - In this type of inheritance the class constructor instantiates other child classes
 * - A department has faculty, staff, and students.
 *
 * @author Sam R. Thangiah
 *
 * @version 1.0
 */

class Student {
	Student(){
		System.out.println("Student");
	}
}
class Staff{
	Staff(){
		System.out.println("Staff");
	}
}
class Faculty{
	Faculty(){
		System.out.println("Faculty");
	}
	
}
public class Department {
	
	Student student;
	Staff staff;
	Faculty faculty;
	
	Department()
	{
		student = new Student();
		staff = new Staff();
		faculty = new Faculty();
	}
	
	public static void main(String[] args) {
	
		Department cpsc = new Department();
		Staff staff1 = new Staff();
	}
}
