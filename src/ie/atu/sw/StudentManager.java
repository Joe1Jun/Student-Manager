package ie.atu.sw;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class StudentManager {

	private static final int INITIAL_CAPACITY = 1;
	private Student[] student = null;

	public StudentManager() {

		student = new Student[INITIAL_CAPACITY];
		init();
	}

	public void add(Student s) {

		for (int i = 0; i < student.length; i++) {

			if (student[i] == null) {
				student[i] = s;
				return;
			}
		}
		
		int index = getExpandedIndex();
        student[index] = s;
	}
	
	private int getExpandedIndex() {
		
		Student [] temp = new Student [student.length *2];
		
		for (int i = 0; i < student.length; i++) {
			temp[i] = student[i];
		}
		
		int index = student.length;
		student = temp;
		return 0;
	}

	public boolean delete(String sid) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].sid().equals(sid)) {
				student[i] = null;
				return true;
			}
		}

		return false;
	}

	public Student getStudentById(String sid) {

		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].sid().equals(sid)) {

				return student[i];
			}
		}

		return null;
	}

	public Student[] getStudentsByFirstName(String firstname) {
		int matches = 0;
		// count the number of matches and create an array of the right size
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].firstname().equals(firstname)) {

				matches++;
			}
		}

		// copy all the matches into a new array

		Student[] temp = new Student[matches];
		int index = 0;

		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].firstname().equals(firstname)) {

				temp[index] = student [i];
				index++;
			}
		}

		return temp;

	}

	public int size() {
		int total = 0;
		for (int i = 0; i < student.length; i++) {
			if (student != null)
				total++;
		}
		return total;
	}
	
	private void init () {
		
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		
		String [] fnames = {"Joe" , "Jane" , "Anne", "Pat"};
		String [] snames = {"Smith", "Murohy", "Burke", "O'Brien"};
		
		Course [] courses = Course.values();
		int max = 100000;
		long start = System.currentTimeMillis();
		
		for (int i = 0 ; i < max ; i++) {
			
			Student rs = new Student ("G00" + i, fnames[rand.nextInt(0, fnames.length)] , 
					snames[rand.nextInt(0, snames.length)], 
					LocalDate.now(), 
					new Address("Galway"), 
					courses[rand.nextInt(0 , courses.length)]);
			
			this.add(rs);
		}
		System.out.println("Time " + (System.currentTimeMillis() - start));
		
		
	}

}
