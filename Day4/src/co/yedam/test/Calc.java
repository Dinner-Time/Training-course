package co.yedam.test;

//클래스 : 필드, 메소드(, 생성자)
public class Calc {
	// on   1. 리턴x, 매개변수x
	void turnOn() {
		System.out.println("계산기 on");
	}
	// 2. 리턴x, 매개변수o
	void sum(int a, int b) { 
		System.out.println("int method");
		System.out.println("합: "+(a+b));
	}
	void sum(double a, double b) { 
		System.out.println("double method");
		System.out.println("합: "+(a+b));
	}
	// 3. 리턴o, 매개변수o
	int sum2(int a, int b){ 
		return a+b;
	}
	// 4. 리턴o, 가변인수o
	int sum3(int ...arr) { 
		int result = 0;
		for (int i = 0; i<arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
	
}
