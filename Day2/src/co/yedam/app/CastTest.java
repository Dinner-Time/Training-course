package co.yedam.app;

import java.util.Scanner;

/*
  형 변환 테스트
 */
public class CastTest {

	public static void main(String[] args) throws Exception{
		
//		자동 형 변환 -> 연산자 우선순위에 따라 결과가 달라질 수 있다.
		int a = 10;
		long b = a;
		double i = 5 + 10.5;
		System.out.println(i);
		System.out.println("hi"+5*10);
		String j = "hi" + 5;
		
		System.out.println(5/2);
		double k = 5/2;
		System.out.println(k);
		
		System.out.println(5/(double)2);
		
		//강제 형 변환
		//a = b; //Type mismatch: cannot convert from long to int
		a = (int)b;
		
		//char(문자) <-> int(유니코드) 
		char c = 'A';
		System.out.println(c);
		int d = c;
		System.out.println(d);
		char e = 'Z';
		System.out.println(e);
		int f = e;
		System.out.println(f);
		
		//실수 -> 정수
		double g = 3.74;
		int h = (int)g;
		System.out.println(h);
		
		//String에서의 형 변환 -> 타입.parse타입();
		int l = Integer.parseInt("10");
		System.out.println(l);
		
		//String으로의 형 변환 -> String.valueOf(타입);
		String m = String.valueOf(100);
		System.out.println(m);
		
		Scanner scanner = new Scanner(System.in);
		String inputData;
		System.out.print("input: ");
		inputData = scanner.nextLine();
		System.out.println(inputData);
		
		}


}
