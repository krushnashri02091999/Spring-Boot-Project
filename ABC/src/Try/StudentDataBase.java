package Try;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentDataBase {

	// Functional Interface
	// here used Supplier Function
	public static Supplier<Student> StudentSupplier = () -> {
		Student student1 = new Student("Adam", 2, 3.6, "Male", Arrays.asList("Swimming", "Basketball", "Vollyball"));
		return student1;
	};

	// Total Number of 6 Student
	public static List<Student> getAllstudent() {

		// 2nd Grade Student
		Student student1 = new Student("Adam", 2, 3.6, "male", Arrays.asList("Swimming", "Basketball", "Vollyball"));
		Student student2 = new Student("Jenny", 2, 3.6, "female", Arrays.asList("Swimming", "Gymnastic", "soccer"));
		// 3rd Grade Student
		Student student3 = new Student("Emily", 3, 4.9, "female", Arrays.asList("Swimming", "Gymnastic", "aerobics"));
		Student student4 = new Student("Dave", 3, 3.9, "male", Arrays.asList("Swimming", "Gymnastic", "soccer"));
		// 4th Grade Student
		Student student5 = new Student("Sophia", 4, 3.5, "female", Arrays.asList("Swimming", "Dancing", "football"));
		Student student6 = new Student("James", 4, 3.9, "male", Arrays.asList("Swimming", "Gymnastic", "Baseball"));

		List<Student> student = Arrays.asList(student1, student2, student3, student4, student5, student6); // Another
																											// way to
																											// add
																											// Object
																											// into List

		return student;

		/*
		 * List<Student> l1=new ArrayList<Student>(); l1.add(student1);
		 * l1.add(student2); l1.add(student3); l1.add(student4); l1.add(student5);
		 * l1.add(student6);
		 */
	}
}
