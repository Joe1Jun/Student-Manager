package ie.atu.sw;

import static java.lang.System.out;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

	
	private StudentManager sm = new StudentManager();
	private Scanner s;
	private boolean keepRunning = true;
	
	
	public Menu() {
		
		s = new Scanner (System.in);
	}
	
	public void start() {
		
		while(true) {
			
			showOptions();
			
			int choice = Integer.parseInt(s.next());
			
			switch(choice) {
			
			case 1 -> add();
			case 2 -> delete ();
			case 3 -> findById();
			case 4 -> findStudentsbyFirstname();
			case 5 -> getTotal();
			case 6 -> keepRunning = false;
		   default -> out.println("Invalid selection");
			}
			
			
		}
		
		
		
		
	}
	
	private void add() {
		
		out.println("[INFO] add a Student");
		
		
		out.println("Enter Student ID >");
		String sid = s.next();
		out.println("Enter Student Firstname >");
		String fname = s.next();
		out.println("Enter Student surname >");
		String sname = s.next();
		
		Student temp = new Student(sid, fname, sname, LocalDate.now(), new Address ("Galway"), Course.SOFT_DEV);
		
		sm.add(temp);
		
	}
	
	private void delete() {
		
		out.println("[INFO] delete a Student");
		out.println("Enter Student ID >");
		String sid = s.next();
		
		if(sm.delete(sid)) {
			
			out.println("[INFO] Student : " + sid + "deleted");
		}else {
			
			out.println("[INFO] Cannot find Student");
		}
	}
	
	private void findStudentsbyFirstname() {
		
		out.println("[INFO] Find a student by firstname");
		out.println("Enter Student Firstname >");
		String fname = s.next();
		
		Student [] results = sm.getStudentsByFirstName(fname);
		
		
		for (Student student : results) {
			
			out.println(student);
		}
	}
	
	private void findById () {
		
		out.println("[INFO] Find a student by ID");
		out.println("Enter Student ID >");
		String sid = s.next();
		Student student = sm.getStudentById(sid);
		
		if(student != null) {
			
			out.println(student);
		}else {
			
			out.println("[INFO] Cannot find Student");
		}
		
		}
	
	private void getTotal() {
		
		out.println(" Total Number of Students : " + sm.size());
	}

	private void showOptions() {

		out.println("******************************");
		out.println("*****   Student Manager 1.0 ******");
		out.println("(1) Add a Student");
		out.println("(2) Delete a Student");
		out.println("(3) Find Student by ID");
		out.println("(4) Find Student bt firstname");
		out.println("(5) Get Total Student Number");
		out.println("(6) Quit");
		out.println("Select an option [1-6] >");
	}

}
