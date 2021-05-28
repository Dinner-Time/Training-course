package sec02.exam07;

public class FloatDoubleExample {

	public static void main(String[] args) {
		/*
		  소수점이 있는 숫자 리터럴은 10진수 실수로 인식
		  		  정밀도
		  float : 7자리 4byte
		  double : 15자리 8byte (기본)
		  (가수)e(지수)  = (가수) * 10^(지수) -> 실수 리터럴 표현방식
		  		=> 가수는 실수, 지수는 정수
		 */
		
		// float var1 = 3.14; // Type mismatch: cannot convert from double to float
		float var1_1 = 3.14f;
		double var1_2 = 3.14;
		
		double var2 = 2.25;
		double var2_1 = 225e-2; // = 225 * 10^-2
		

	}

}
