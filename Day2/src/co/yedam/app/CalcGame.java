package co.yedam.app;

import java.util.Scanner;

/*
  사칙연산, 진수변환, 문자값 검사 
 */
public class CalcGame {
	double a, b;
	
	void input() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("num1 : ");
		String s1 = scanner.next();
		System.out.print("num2 : ");
		String s2 = scanner.next();
		
		a = Double.parseDouble(s1);
		b = Double.parseDouble(s2);
		
	}
	// 두 수의 합
	double add() {
		return a+b;
	}
	// 두 수의 차
	double sub() {
		return a-b;
	}
	// 두 수의 몫
	int div_int() {
		return (int)(a/b);
	}
	// 두 수의 나누기
	double div_double() {
		return a/(double)b;
	}
	// 두 수의 나머지
	int reminder() {
		return (int)(a%b);
	}
	
	
	

}
