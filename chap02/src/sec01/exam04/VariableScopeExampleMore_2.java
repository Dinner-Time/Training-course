package sec01.exam04;

public class VariableScopeExampleMore_2 {

	public static void main(String[] args) {
		/*
					## 변수의 사용범위 ##

		  변수는 블록({})내의 어디에서든 선언할 수 있으나 선언한 이후부터
		  자신이 속한 블록 내에서만 사용할 수 있다.
		 */
		
		// 범위가 작은 블록 안에서 선언한 변수명을 범위가 더 큰 블록에서
		// 또는 범위가 같은 다른 블록에서 다시 선언 할 수 있는가?
		
		int x = 10;
		
		if (x == 10) {
			int y = 20; // if 블록 내에서 변수명 y를 선언
			System.out.println("y: "+y);
		}
		
		int y = 30; // method 블록 내에서 변수명 y 재사용이 가능하다.
		System.out.println("y: "+y);
		
		
		if (x ==10){
			// int y = 50; // 해당 if 블록에서 선언한 y가 method블록에서 선언한 y의 범위 안에 있어서 사용이 불가능하다.
			System.out.println("y: "+y); // line 22를 주석처리 하면 오류가 사라진다.
		} 
		
		/*
		 변수의 사용범위 밖에서는 같은 변수명을 재사용하는 것이 가능하다.
		 */

	}

}
