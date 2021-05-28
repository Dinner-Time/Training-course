package sec02.exam05;

public class StringExample {

	public static void main(String[] args) {
		/*
		  문자열은 유니코드로 저장되지 않는다
		  따라서 문자열은 String타입을 사용한다. (기본 타입이 아닌 클래스 타입 -> sec06참조)
		 */
		
		// char name1 = "Tae hun"; //Type mismatch: cannot convert from String to char
							
		String name2 = "Tae hun";
		
		// String name3 = 'Tae hun'; //Invalid character constant
								     //''은 char타입에서만 사용
	}

}
