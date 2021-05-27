package co.yedam.app.baseball;
/*
 작성일 : 2021-05-27
 
 임의의 수 3개
 사용자 입력
 스트라이크, 볼 카운트
 3스트라이크 게임종료
 
 */
public class BaseBallApp {
	int s,b;
	int c1,c2,c3;
	int u1,u2,u3;
	
	void makeRnd() {
		// 난수 발생
	}
	
	void userInput() {
		
	}
	
	void sbCount() {
		
	}
	
	void start() {
		makeRnd();
		while(s<3) {
			s = b = 0;
			userInput();
			sbCount();	
		}
	}
}
