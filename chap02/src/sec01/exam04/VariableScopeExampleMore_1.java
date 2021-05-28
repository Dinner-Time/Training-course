package sec01.exam04;

public class VariableScopeExampleMore_1 {

	public static void main(String[] args) {
		/*
					## 변수의 사용범위 ##
			
		  변수는 블록({})내의 어디에서든 선언할 수 있으나 선언한 이후부터
		  자신이 속한 블록 내에서만 사용할 수 있다.
		 */
		
		// 선언과 저장을 다른 블록에서 한다면?
		
		int x,y; // x, y 선언
		
		x = 10; // x 저장 (method 블록)
		
		if(x==10) {
			y = 20; // y 저장 (if 블록)
			int z; // z 저장 (if 블록)
			System.out.println("y: "+y);
		} // if 블록에서 저장된 y의 값은 if 블록 안에서만 사용한다.
		  // if 블록에서 선언된 z는 method 블록에서 사용할 수 없다.
		
		// System.out.println("x: "+x+", y: "+y); // The local variable y may not have been initialized
		
		// z = 30; // z cannot be resolved to a variable
		
		
		
		/*
		 선언한 변수에 저장한 값 또한 저장한 블록 내에서만 활용할 수 있다.
		 보다 작은 범위의 블록에서 선언한 변수명은 보다 큰 범위의 블록에 영향을 주지 못한다.
		 */
	} 

}
