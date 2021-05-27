package co.yedam.app;
/*
 연산자 테스트
 논리 : and(&&), or(||), not(!)
 a++, a-- -> a+=1, a-+1
 (조건) ? (A) : (B) -> if (조건){
 						A
 					  }else{
 					  	B
 					  }
 */
public class OperatorTest {

	public static void main(String[] args) {
		//증감연산자
		
		int x =1;
		int y =1;
		
		int result1 = ++x +10;
		System.out.println(String.format("x=%d result=%d", x, result1));
		int result2 = y++ + 10;
		System.out.println(String.format("y=%d result=%d", y, result2));
		int result3 = ++x + y++;
		System.out.println(String.format("x=%d y=%d result=%d", x, y, result3));
		
		//논리연산
		x = 0;
		y = 0;
		
		System.out.println(x==0 && y==0);
		System.out.println(x>0 && y>0);
		System.out.println(! (x>0 && y>0));
		
		//삼항연산
		x = 3;
		System.out.println(x>0 && y>0 ? "둘 다 양수이다" : "둘 중 하나 이상은 양수가 아니다");
		System.out.println(x%2==0 ? "even" : "odd");
	}

}
