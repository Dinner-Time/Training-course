package selfstudyjava.chap2.var;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		System.out.print("입력>");
		int a = scanner.nextInt();
		
		for (int i = 0; i<a; i++) {
			System.out.print((i+1)+"번째 수입력>");
			arr.add(scanner.nextInt());
		}
		int x = arr.get(0);
		for (int i = 0; i < arr.size(); i++) {
			if (x < arr.get(i)){
				x = arr.get(i);
			}
		}
		int x1 = arr.get(0);
		for (int i = 0; i < arr.size(); i++) {
			if (x1 > arr.get(i)){
				x1 = arr.get(i);
			}
		}
		System.out.println(x);
		System.out.println(x1);
		
		
		scanner.close();
		
		
	}

}
