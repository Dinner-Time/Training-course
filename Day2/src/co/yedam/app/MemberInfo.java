package co.yedam.app;

import java.util.Scanner;

public class MemberInfo {
	
	String name, id, tel;
	double height, weight;
	
	double result;

	String bmi_classify = "";
	
	Scanner scanner = new Scanner(System.in);
	
	void input() {
		
		//코드작성
		System.out.println("[필수 정보 입력]");
		
		System.out.print("1. 이름: ");
		name = scanner.next();
		
		System.out.print("2. 주민번호: ");
		id = scanner.next();
		
		System.out.print("3. 전화번호: ");
		tel = scanner.next();

	}
	
	
	void print() {
		System.out.println("");
		System.out.println("[입력한 내용]");
		System.out.println(name);
		System.out.println(id);
		System.out.println(tel);
	}

	void heightWeightInput() {
		
		System.out.print("4. 키(m): ");
		height = scanner.nextDouble();
		
		System.out.print("5. 몸무게(kg): ");
		weight = scanner.nextDouble();
		
	}
	
	String bmi() {
		
		result  = weight/(height*height);
		
		if(result < 18.5) {
			bmi_classify = "저체중";
		} else if (result < 23) {
			bmi_classify = "정상";
		} else if (result < 25) {
			bmi_classify = "과체중";
		} else {
			bmi_classify = "비만";
		}
		
		return bmi_classify;
	}
	
}
