package wrapper;

import java.util.ArrayList;
import java.util.Scanner;

public class WrapperTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(10));
		list.add(new Integer("10"));
		list.add(100);
		
		Integer a = 100;
		int b = a;
		
		System.out.println(list);
		System.out.println(b);
		
		scanner.close();
		
	}

}
