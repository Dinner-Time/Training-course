package sec02.exam04;

public class CharExample {

	public static void main(String[] args) {
		/*
		 하나의 문자를 ''로 감싼 것을 문자 리터럴이라한다.
		 문자 리터럴은 유니코드(2byte 숫자 : 0 ~ 65535)로 변환되어 저장된다.
		 # 유니코드가 정수이므로 char타입 또한 정수 타입에 속한다.#
		 */
		
		char var1 = 'A'; // 유니코드 10진수 : 65, 16진수 : 0x0041
		System.out.println(var1); 
		char var1_1 = 65;
		System.out.println(var1_1); 
		char var1_2 = 0x0041;
		System.out.println(var1_2); 
		// char는 정수타입이기 때문에 정수를 저장하면 해당하는 유니코드 문자를 가져온다.
		
		int var2 = 'A'; // int에 문자 리터럴을 저장하면 그 문자에 해당하는 유니코드 숫자를 가져온다.
		System.out.println(var2);
		
	}

}
