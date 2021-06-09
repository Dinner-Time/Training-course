package 제어문;

import java.util.Scanner;

public class While테스트2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = 0;

		while (a != 0) {
			a = scanner.nextInt();
			System.out.println(a);
		}
		System.out.println("terminate");

//		*******************************************************************************************

		do {
			a = scanner.nextInt();
			System.out.println(a);
		} while (a != 0);
		System.out.println("terminate");
		
		scanner.close();
	}

}
