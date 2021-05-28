package co.yedam.app.baseball;
/*
 작성자 : 박태훈
 작성일 : 2021-05-27
 
 임의의 수 3개
 사용자 입력
 스트라이크, 볼 카운트
 3스트라이크 게임종료
 */
import java.util.Scanner;

public class BaseBallApp {
	int s,b; // 스트라이크, 볼 변수
	int c1,c2,c3; // 생성된 세 자리 난수
	int u1,u2,u3; // 입력된 세 자리 수
	int r = 6; // 남은 기회
	String inputValue = ""; // 입력된 문자열 
	
	Scanner scanner = new Scanner(System.in); // input을 위한 Scanner 사용
	
	void makeRnd() {
		/*
		 세 자리 난수를 생성하는 메서드.
		 어느 하나 중복된 값이 없어야한다.
		 */
		c1 = (int)(Math.random()*10); // 첫번째 난수 생성
		c2 = (int)(Math.random()*10); // 두번째 난수 생성
		while (c1 == c2) { // 첫번째 수와 두번째 수의 중복 체크 
			c2 = (int)(Math.random()*10); // 중복이면 다시 생성
		}
		c3 = (int)(Math.random()*10); // 세번째 난수 생성
		while ((c1 == c3) || (c2 == c3)) { // 세번쨰 난수와 다른 두 난수 중복 체크
			c3 = (int)(Math.random()*10); // 중복이면 다시 생성
		}
		System.out.println(c1+""+c2+""+c3); // 주석 처리 필요
	}

	void userInput() {
		/*
		 사용자의 수를 입력받는 메서드
		 문자열로 세 자리 수를 입력받은 후 문자열 자르기를 한다.
		 세 자리가 아닐 경우 다시 입력한다.
		 중복 값이 없어야 한다. 
		 * 수가 아닌 문자가 입력 될 시의 문제는 해결 못함
		 */
		while (inputValue.length() !=3) { // 3자리 수가 아닌 동안
			System.out.print("세 자리 수를 입력하세요: ");
			inputValue = scanner.next(); 
			if (inputValue.length() < 3) { // 3자리 수보다 작은 수를 입력하면 문자열 자르기에서 오류가 나기때문에 continue해준다.
				continue;
			}
			u1 = Integer.parseInt(inputValue.substring(0, 1)); //
			u2 = Integer.parseInt(inputValue.substring(1, 2)); // 
			u3 = Integer.parseInt(inputValue.substring(2, 3)); // 문자열 자르기
			while ((u1 == u2) || (u1 == u3) || (u2==u3)) { // 중복 값 조건
				System.out.println("중복되지 않은 값을 입력하세요: ");
				inputValue = ""; // 입력 값 초기화
				break; // 해당 while문 탈출 -> 하지 않으면 무한루프 발생(?)
			}
		}
	}
	
	void sbCount() {
		/*
		  스트라이크, 볼을 확인하는 메서드
		 */
		if (u1 == c1){
			s++;
		} else if((u1 == c2) || (u1 == c3)) {
			b++;
		} 
		
		if (u2 == c2){
			s++;
		} else if((u2 == c1) || (u2 == c3)) {
			b++;
		}
		
		if (u3 == c3){
			s++;
		} else if((u3 == c2) || (u3 == c1)) {
			b++;
		}
	}
	
	void isGameOver() {
		/*
		  게임 종료 판별 메서드
		  s == 3 이고 r == 0일때 게임은 종료된다. -> start 메서드
		 */
		if (s != 3) { // s가 3이 아닐 때
			r--; // 남은 기회(r)이 하나 차감
			System.out.println("남은 기회: "+r+"");
			if (r == 0) { // 남은 기회(r)가 0일때 -> 패배
				System.out.println("졌습니다...");
				s = 0; // s를 0으로 만들어 게임을 종료시킨다.
			} else { // 남은 기회(r)가 0이 아닐때 -> s, b을 출력한다.
				System.out.print(s+"s "+b+"b"+"\n");
			}
		} else { // s가 3일때 -> 승리
			System.out.println("맞췄습니다!!");
			r = 0; // r을 0으로 만들어 게임을 종료한다.
		}
	}
	
	void start() {
		/*
		  모든 게임의 과정
		 */
		makeRnd(); // 난수 생성
		while(s<3 && r>0) { // 게임종료 조건
			s = b = 0; // s, b를 초기화
			inputValue = ""; // 입력 값 초기화 -> 하지 않으면 userInput이 다시 발생하지 않는다.
			userInput(); // userInputCheck 메서드 안에 userInput 메서드로 사용자 추측 수 입력
			System.out.println(u1+""+u2+""+u3); // 조건을 만족한 사용자 추측 수 출력
			sbCount(); // s, b 판별
			isGameOver(); // 게임종료 판별
		}		
	}
}
