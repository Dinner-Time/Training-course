package my.stream.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import my.stream.Person;
import my.stream.PersonDAO;

public class IteratorExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hong","Park","Choi"); // ArrayList의 초기값 할당 방법
		Iterator<String> iter = list.iterator(); // 반복된 요소를 지정하고 사용하기 위해 반복자 선언
		while(iter.hasNext()) { // 반복할 요소가 있으면 true
			String val = iter.next(); // 해당 요소를 가져옴
			System.out.println(val.toUpperCase().length());
		}
		
		// stream 메서드 사용.
		Stream<String> stream = list.stream(); // stream 생성
		Consumer<String> ex = (t)-> System.out.println(t.toUpperCase()); // 이것이 람다식
		
		System.out.println("<stream>");
		stream.forEach((t)-> System.out.println(t.toUpperCase())); // forEach()는 매개변수로 매서드(기능)를 받는다.
		
		
		// sample 요소를 database에서 갖고 오자.
		System.out.println("<person list>");
		PersonDAO dao = new PersonDAO();
		PersonDAO.connect();
		ArrayList<Person> people = dao.getAllPerson();
		
		Stream<Person> sPeople = people.stream();
		
		long cnt = sPeople//
			.filter((person) -> person.getAge() > 20)
			.filter((person) -> person.getPhone().startsWith("1"))
			.count();
//			.forEach((person) -> System.out.println(person)); // 쩐다......
		
		System.out.println("최종 처리 건수: "+cnt);
		
	  PersonDAO dao1 = new PersonDAO();
      ArrayList<Person> persons = dao1.getAllPerson();
      
      Stream<Person> pStream = persons.stream();
      
      long cnt1 =pStream
      .filter((t) -> t.getAge()> 20) // 익명개체를 만들겠다 , 필터로 걸러준다
      .filter((t) -> t.getName().startsWith("송"))
      .count();
      
      System.out.println("최종처리건수 : "+ cnt1);
//	      .forEach((t) -> System.out.println(t.toString()));
            //return 값이 true인 요소만 통과.

		
	}
}	
