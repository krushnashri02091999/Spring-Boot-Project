package Try;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingClass {
	public static List<Student> sortStudentByName(){
		List<Student> sortbyname = StudentDataBase.getAllstudent().stream()
				.sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
		return sortbyname;
	};
	
	public static List<Student> sortStudentByGPA(){
		List<Student> sortbygpa = StudentDataBase.getAllstudent().stream()
				.sorted(Comparator.comparing(Student::getGpa)).collect(Collectors.toList());
	return sortbygpa;
	};
	public static List<Student> sortStudentByGPAReverse(){
		List<Student> sortbygpa = StudentDataBase.getAllstudent().stream()
				.sorted(Comparator.comparing(Student::getGpa).reversed()).collect(Collectors.toList());
	return sortbygpa;
	};
	public static void main(String[] args) {
		System.out.println("Sorting of Student by Name");
		sortStudentByName().forEach(System.out::println);
		System.out.println("Sorting of Student by GPA");
		sortStudentByGPA().forEach(System.out::println);
		System.out.println("Sorting of Student by GPA in Reverse");
		sortStudentByGPAReverse().forEach(System.out::println);
	}
}
