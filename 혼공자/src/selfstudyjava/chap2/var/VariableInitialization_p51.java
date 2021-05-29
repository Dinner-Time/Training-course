package selfstudyjava.chap2.var;

/*
 작성자: 박태훈
 작성일자: 2021-05-29
 변수 선언과 저장
 */
public class VariableInitialization_p51 {

	public static void main(String[] args) {

		int value; // 변수 value를 선언

//		int result = value + 10; //The local variable value may not have been initialized
								 // 	-> value를 선언 했지만 값을 저장하지 않아서 오류 발생

		value = 10;

		System.out.println(value);

	}

}
