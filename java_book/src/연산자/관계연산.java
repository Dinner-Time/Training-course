package 연산자;

public class 관계연산 {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 10;
		
		if(y++>10 && x++>10) { // 비교연산을 먼저하고 ++연산 실행(++이 앞에 있을 경우 ++먼저 실행)
			System.out.println("confirmed");
		} else {
			System.out.println("not confirmed");
		}
		
		System.out.println(x); // if조건식에서 && 비교 연산은 앞 조건이 false이면 뒷 조건을 계산하지 않는다.
		System.out.println(y);
		
//	*******************************************************************************************
		
		x = 10;
		y = 10;
		
		if(++y>10 || x++>10) { 
			System.out.println("confirmed");
		} else {
			System.out.println("not confirmed");
		}
		
		System.out.println(x); // if조건식에서 || 비교 연산은 앞 조건이 true이면 뒷 조건을 계산하지 않는다.
		System.out.println(y);
		
//	*******************************************************************************************
		
		// 쉬프트 연산 -> 나누기보다 속도가 더 빠르다.
		int f = 8;
		System.out.println(f >> 1);
		System.out.println(f << 1);
	}

}
