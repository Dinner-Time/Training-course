package selfstudyjava.chap2.type;

/*
 작성자: 박태훈
 작성일자: 2021-05-30
 byte타입, long타입
 */
public class ByteLong_p61 {

	public static void main(String[] args) {
		byte var1 = -128;
//		byte var2 = 128; // Type mismatch: cannot convert from int to byte
						 // -> byte 타입의 범위를 넘어서서 오류 발생

//		long var3 = 3000000000; // The literal 3000000000 of type int is out of range
								// 		-> 자바는 정수의 기본 타입을 int로 정해져있기 떄문에
								// 		int타입의 범위를 벗어나는 정수는 long 타입임을 알려줘야한다.
		long var4 = 3000000000L;

		System.out.println(var1 + " " + var4);
	}

}
