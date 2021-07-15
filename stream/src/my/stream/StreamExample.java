package my.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StreamExample {
	public static void main(String[] args) {
		
		List<Person> list = null;
		PersonDAO dao = new PersonDAO();
		PersonDAO.connect();
		list = dao.getAllPerson();
		
		List<Integer> test = new ArrayList<>(); 
		
		OptionalDouble avg = 
				list.stream()
				.filter(person -> person.getAge()%2==0)
//				.filter(person -> person.getAge()%2==1)
				.mapToInt(age ->  age.getAge())
//				.forEach(age -> test.add(age));
				.average();
				
//		System.out.println(test);
		if(avg.isPresent()) {
			System.out.println(avg.getAsDouble());
		} else {
			System.out.println("none");
		}
		
	}
}
