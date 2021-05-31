package selfstudyjava.chap2.type;

/*
 작성자: 박태훈
 작성일자: 2021-05-30
 char 타입 -> 유니코드(0~65535)로 저장되는 정수 타입이다.
 문자 리터럴 -> 한 문자를 ' '로 감싼다.
 */
public class CharType_p63 {
	public static void main(String[] args) {
		char var1 = 'A'; // 문자로 저장
		char var2 = 65; // 저장된 정수에 해당하는 유니코드 문자를 가져온다.
		char var3 = 0x0041; //
		char var4 = '\u0041'; // 16진수 유니코드를 가져온다.
		System.out.println(var1 + " " + var2 + " " + var3 + " " + var4);

		int var5 = '가'; // 문자 리터럴을 int 타입에 저장하면 그 문자에 해당하는 유니코드 숫자를 가져온다.
		System.out.println(var5);
	}
}
