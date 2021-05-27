package co.yedam.app.gugudan;
/*
작성일자 : 2021-05-27
구구단 프로그램
*/
import java.util.Scanner;

public class GugudanApp {
	int a, s, e;
	
	// 입력문
	Scanner scanner = new Scanner(System.in);
	
	// 입력받은 단만 출력
	void printDan() {
		System.out.print("출력할 단: ");
		a = scanner.nextInt();
		System.out.println(a+"단");
		for(int j = 1; j<=9; j++) {
			System.out.println(a+"*"+j+"="+a*j);
		}
		System.out.println(" ");
	}
		
	// 전체 출력
	void printAll() {
		for (int j = 1; j<=9; j++) {
			for(int i=1; i<=9; i++) {
				System.out.print(i+"*"+j+"="+i*j + "\t");
			}
			System.out.println(" ");
		}
		
	}
	
	// 범위 출력
	void printRange() {
		System.out.print("시작할 단: ");
		s = scanner.nextInt();
		System.out.print("마지막 단: ");
		e = scanner.nextInt();
		for (int j = 1; j<=9; j++) {
		// i가 s로 시작해서 e보다 작을 때 실행한 후 i에 1을 더한다.
			for(int i=s; i<=e; i++) {
				System.out.print(i+"*"+j+"="+i*j + "\t");
			}
			System.out.println(" ");
		}
	}
	
	// 전체 역 출력
		void printAllReverse() {
			for (int j=9; j>=1; j--) {
				
				for(int i=9; i>=1; i--) {
					System.out.print(i+"*"+j+"="+i*j+"\t");
				}
				System.out.println(" ");
			}
		}
}
