package Try;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class A{
	static Predicate<Student> p1=(student) -> student.getGradeLevel()>=3;	
	static Predicate<Student> p2 =student->student.getGender()=="female";
	
	public static List<String> nameList(){
			List<String> namelist = StudentDataBase.getAllstudent().stream()
					.map(Student::getName).collect(Collectors.toList());  // we can pass any function in map like (Uppercase,Lowercase)
		
			return namelist;
	}
	public static List<List<String>> listactivity(){
		 List<List<String>> collect = StudentDataBase.getAllstudent().stream().map(Student::getActivities).collect(Collectors.toList());
	List<Student> collect2 = StudentDataBase.getAllstudent().stream().filter(p1).collect(Collectors.toList());
	
	System.out.println("Using Gradelevel");
	collect2.forEach(System.out::println);
	List<Student> collect3 = StudentDataBase.getAllstudent().stream().filter(p2).collect(Collectors.toList());
	
	System.out.println("Using Gender");
	collect3.forEach(System.out::println);
	return collect;
}
public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1,2,3,4,2,5,4);
	
	
	Set<Integer> set=new HashSet<>();
	List<Integer> collect = list.stream().filter(i->!set.add(i)).collect(Collectors.toList());
System.out.println(collect);
 
 System.out.println("List of Student");
	nameList().forEach(System.out::println);
	listactivity().forEach(System.out::println);
}

}
