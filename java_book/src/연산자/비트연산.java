package 연산자;

public class 비트연산 {

	public static void main(String[] args) {
		// xor연산(^:서로 다르면 1) -> 암호화 복호화에 주로 사용
		int a = 04474;
		int key = 01111;
		System.out.println(a);

		int x = a ^ key;
		System.out.println(x);

		int y = x ^ key;
		System.out.println(y);
		
		
		// and연산(&:둘 다 1일때 1) -> 마스크(특정 비트값만 확인)
		a = 0b10101111;
		x = 0b00000001;
		System.out.println(a & x);
		
		
		// or연산(|:둘 중 하나가 1일때 1)
	}

}
