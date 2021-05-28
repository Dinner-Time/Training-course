package sec01.exam03;

public class VariableExchangeExample {

	public static void main(String[] args) {
		/* 
		 두 변수(x,y)의 값을 교환하는 방법
		 새로운 변수(temp)를 만들어 하나의 변수(x)를 저장하고,
		 그 변수(x)에 다른 하나의 변수(y)를 저장하고,
		 그 변수(y)에 (x)를 저장한 (temp)를 저장한다.
		 */
		
		int x,y; // 변수 x,y를 선언
		x = 10; // x에 10을 저장 (x = 10)
		y = 20; // y에 20을 저장 (x = 10, y = 20)
		System.out.println("x: " + x + ", y: " + y);
		
		int temp; // 변수 temp를 선언
		temp = x; // 변수 temp에 x를 저장 (x=10, y=20, temp(=x)=10)

		x = y; // 변수 x에 변수 y를 저장 (x(=y)=20, y=20 , temp=10)
		y = temp; // 변수 y에 temp(x를 저장한 변수)를 저장 (x=20, y(=temp)=10, temp=10)
		
		System.out.println("x: " + x + ", y: " + y);

	}

}
