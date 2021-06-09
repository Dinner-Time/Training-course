package 열거타입;

import java.util.Scanner;

public class SelectTest {
	static Scanner scanner = new Scanner(System.in);
	static SELECT selectSwitch(int num) {
		switch(num) {
		case 1: return SELECT.등록;
		case 2: return SELECT.수정;
		case 3: return SELECT.삭제;
		case 0: return SELECT.종료;
		}
		return null;
	}
	
	static void select1() {
		
		int selectNo = 0;
		do {
			System.out.println("1.등록 2.수정 3.삭제 0.종료");
			selectNo = scanner.nextInt();
			switch(selectNo) {
			case 1: System.out.println("등록"); break;
			case 2: System.out.println("수정"); break;
			case 3: System.out.println("삭제"); break;
			case 0: System.out.println("종료"); break;
			}
		}while(selectNo != 0);
	}
	
	static void select2() {
		SELECT select = null;
		do {
			System.out.println("1.등록 2.수정 3.삭제 0.종료");
			select = selectSwitch(scanner.nextInt());
			switch(select) {
			case 등록: System.out.println("등록"); break;
			case 수정: System.out.println("수정"); break;
			case 삭제: System.out.println("삭제"); break;
			case 종료: System.out.println("종료"); break;
			}
		}while(select != SELECT.종료);
	}
	
	static void select3() {
		SELECT select = null;
		int selectNo;
		do {
			SELECT.print();
			System.out.println("\n입력>");
			selectNo = scanner.nextInt();
			select = SELECT.getSELECT(selectNo);
			System.out.println(select);
		}while(select != SELECT.종료);
		
	}
	
	public static void main(String[] args) {
		select3();
	}
	
}
