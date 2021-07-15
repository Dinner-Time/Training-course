package my.stream;

import java.util.ArrayList;

public class EmpExample {
	public static void main(String[] args) {
		PersonDAO.connect();
		ArrayList<Employees> list = PersonDAO.nameTel();
		
		list.stream()
		.filter(b -> b.getbirthYear()>=1970)
		.forEach(emp -> System.out.println(emp.getFirstName()+" "+emp.getLastName()+":"+emp.getTitle()));
		
	}
}
