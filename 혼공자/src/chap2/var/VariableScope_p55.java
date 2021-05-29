package chap2.var;

/*
작성자: 박태훈
작성일자: 2021-05-29
변수의 사용 범위
*/
public class VariableScope_p55 {
	/*
	 한 블록이 끝나면 해당 블록에서 저장되고 선언된 변수들은 사라진다.
	 */
	public static void main(String[] args) { //main

		int v1 = 10; //main 메서드 블록 안에서 선언한 변수
		
		if (v1>5) { //if
			int v2;	//if 블록 안에서 선언한 변수
			v2 = v1 - 10;
			System.out.println(v2);
		} //if
		
//		System.out.println("v1: "+v1+", v2: "+v2); // v2 cannot be resolved to a variable
					

	} //main

}
