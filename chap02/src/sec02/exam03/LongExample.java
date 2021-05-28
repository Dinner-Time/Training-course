package sec02.exam03;

public class LongExample {

	public static void main(String[] args) {
		/*
		 컴파일러는 정수 리터럴 타입을 int를 기본으로 하기 때문에 
		 int타입의 허용범위를 벗어나는 long타입 정수는 뒤에 L을 붙여 long타입임을 알려야 한다.
		 */
		
		long var1 = 10000000000L; 
		long var2 = 100000000; // int 허용범위를 벗어나지 않는 정수는 long타입으로 선언했어도 L을 붙일 필요가 없다.
		//int var3 = 10000000000L; //Type mismatch: cannot convert from long to int
								   // int 허용범위를 벗어나는 수를 int로 선언하면 반드시 오류가 발생한다.
	}

}
