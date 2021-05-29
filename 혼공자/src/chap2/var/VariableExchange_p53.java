package chap2.var;

/*
 작성자: 박태훈
 작성일자: 2021-05-29
 변수값 교환
 */

public class VariableExchange_p53 {

	public static void main(String[] args) {

		int x, y; // 변수 x, y 선언
		x = 10; // x에 10을 저장 (x = 10)
		y = 20; // y에 20을 (x = 10, y = 20)
		System.out.println("x: " + x + ", y: " + y);

		int temp; // 변수 temp를 선언
		temp = x; // temp에 x를 저장 (x=10, y=20, temp=x(=10))

		x = y; // x에 y를 저장 (x=y(=20), y=20 , temp=10)
		y = temp; // y에 temp를 저장 (x=20, y=temp(=10), temp=10)

		System.out.println("x: " + x + ", y: " + y);

	}

}
