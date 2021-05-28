package my.itis.boi.star;
/*
작성일 : 2021-05-28
삼각형 그리기
*/
public class StarApp {
	
	// *,10 -> **********
	String pad(char s, int cnt) {
		String result = "";
		for(int i=1; i<=cnt; i++) {
			result += s;
		}
		return result;
	}
	
	// 삼각형 출력
	void draw(int cnt) {
		for (int i=1; i<=cnt; i++) {
			System.out.println(pad('*', i));
		}
	}
	
	// 역삼각형 출력
//	void drawInvert(int cnt) {
//		for (int i=cnt; i>=1; i--) {
//			System.out.println(pad('*', i));
//		}
//	}
	
	void drawInvert(int cnt) {
		for (int i=0; i<cnt; i++) {
			System.out.println(pad('*', cnt - i));
		}
	}
	
	// 이등변 삼각형 출력
	void drawEq(int cnt) {
		for (int i=1; i<=cnt; i++) {
			System.out.println(pad(' ', cnt - i)+
					pad('*', i*2 - 1));
		}
	}
	
	// 역 이등변 삼각형 출력
	void drawEqInvert(int cnt) {
		for (int i=0; i<cnt; i++) {
			System.out.println(pad(' ', i)+
					pad('*', (cnt - i)*2 - 1));
		}
	}
	
	// 이등변 삼각형 범위 출력
		void drawEq(int s, int cnt) {
			for (int i=s; i<=cnt; i++) {
				System.out.println(pad(' ', cnt - i)+
						pad('*', i*2 - 1));
			}
		}
	
	
}
