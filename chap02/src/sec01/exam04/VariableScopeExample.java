package sec01.exam04;

public class VariableScopeExample {

	public static void main(String[] args) {
		/*
		 			## 변수의 사용범위 ##
		 			
		  변수는 블록({})내의 어디에서든 선언할 수 있으나 선언한 이후부터
		  자신이 속한 블록 내에서만 사용할 수 있다.
		 */
		
		int v1 = 10; //v1 선언 (method 블록)
		
		if (v1>5) {
			int v2;	//v2 선언 (if 블록)
			v2 = v1 - 10;
		} //v2 범위 끝
		
		// System.out.println("v1: "+v1+", v2: "+v2); //v2 cannot be resolved to a variable

	} //v1 범위 끝

}
