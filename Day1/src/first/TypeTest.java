package first;

public class TypeTest {
	/*
	 * 데이터 형 연습  
	 * byte < short < int < long < float < double
	 * 		  char
	 * boolean
	 */
	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		long a = 2147483648L;
		float f = 0.123456789f;
		System.out.println(f);
		double d = 0.123456789;
		System.out.println(d);
		
		
		
		int b8 = 015 + 04;
		System.out.println(b8 + " " + Integer.toOctalString(b8));
		
		int b16 = 0xff; // f(15) * 16 + 15
		System.out.println(b16);
		
		int b2 = 0b1111;
		System.out.println(b2);
		
		
		char c1 = '가';
		System.out.println((int)c1); // 10진수
		System.out.println(Integer.toHexString(c1)); // 16진수
		
		char c2 = 44033;
		char c3 = 0xac03;
		char c4 = '\uac02';
		
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}

}
