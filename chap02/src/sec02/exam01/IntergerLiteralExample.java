package sec02.exam01;

public class IntergerLiteralExample {

	public static void main(String[] args) {
		/*
		 프로그래머에 의해 직접 입력된 값을 리터럴(literal)이라고 부른다.
		 */
		int var2 = 0b1010; // 2진수 리터럴 : 0b로 시작하고 0과 1로 구성된다.
		System.out.println(var2);
		int var8 = 0144; // 8진수 리터럴 : 0으로 시작하고 0 ~ 7로 구성된다.
		System.out.println(var8);
		int var10 = 1000; // 10진수 리터럴 : 0 ~ 9로 구성된다.
		System.out.println(var10);
		int var16 = 0x2710; // 16진수 리터럴 : 0x로 시작하고 0 ~ 9, A,B,C,D,E,F 로 구성된다.
		System.out.println(var16);
	}

}
