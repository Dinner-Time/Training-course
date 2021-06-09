package 제어문;

public class While테스트 {

	public static void main(String[] args) {
		
		// 1~10까지의 합(for문)
		int sum = 0;
		for(int i=1; i<11; i++) {
			sum += i;
		}
		System.out.println(sum);
		
//	*******************************************************************************************
		
		// 1~10까지의 합(while문) -> 조건을 먼저 비교(실행문이 실행되지 않을 수도 있다)
		sum = 0;
		int i = 1;
		while (i<11) {
			sum +=i;
			i++;
		}
		System.out.println(sum);
		
//	*******************************************************************************************

		// 1~10까지의 합(do-while문) -> 실행문 먼저 실행, 그 다음 조건 확인
		sum = 0;
		i = 1;
		do {
			sum +=i;
			i++;
		}while(i<11);
		System.out.println(sum);
	}

}
