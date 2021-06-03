package co.yedam.app;

import java.util.Scanner;

public class TryTest1 {

	public static void main(String[] args) {
		

//		NullPointerException
		try {
			String s = null;
			System.out.println(s.charAt(0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
//		ArrayIndexOutOfBoundsException
		try {
			int[] arr = new int[5];
			System.out.println(arr[5]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int a = 0;
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.print("input ");
				a = scanner.nextInt();
				System.out.println();
				if (a<5) {
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Terminate.");
	}

}
