package co.yedam.app;

import java.util.Scanner;

/*
  �� ��ȯ �׽�Ʈ
 */
public class CastTest {

	public static void main(String[] args) throws Exception{
		
//		�ڵ� �� ��ȯ -> ������ �켱������ ���� ����� �޶��� �� �ִ�.
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
		
		//���� �� ��ȯ
		//a = b; //Type mismatch: cannot convert from long to int
		a = (int)b;
		
		//char(����) <-> int(�����ڵ�) 
		char c = 'A';
		System.out.println(c);
		int d = c;
		System.out.println(d);
		char e = 'Z';
		System.out.println(e);
		int f = e;
		System.out.println(f);
		
		//�Ǽ� -> ����
		double g = 3.74;
		int h = (int)g;
		System.out.println(h);
		
		//String������ �� ��ȯ -> Ÿ��.parseŸ��();
		int l = Integer.parseInt("10");
		System.out.println(l);
		
		//String������ �� ��ȯ -> String.valueOf(Ÿ��);
		String m = String.valueOf(100);
		System.out.println(m);
		
		Scanner scanner = new Scanner(System.in);
		String inputData;
		System.out.print("input: ");
		inputData = scanner.nextLine();
		System.out.println(inputData);
		
		}


}
