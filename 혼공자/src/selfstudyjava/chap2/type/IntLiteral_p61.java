package selfstudyjava.chap2.type;

/*
 작성자: 박태훈
 작성일자: 2021-05-30
 정수 리터럴
 */
public class IntLiteral_p61 {

	public static void main(String[] args) {
		int var1 = 0b1011; // 2진수 -> 0b로 시작
		int var2 = 0206; // 8진수 -> 0으로 시작
		int var3 = 0xfa3; // 16진수 -> 0x로 시작

		System.out.println("2진수: " + var1);
		System.out.println("8진수: " + var2);
		System.out.println("16진수: " + var3);
	}

}
