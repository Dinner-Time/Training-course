package my.itis.boi.baseball;

import java.util.Scanner;

public class BaseballApp {
	// 세자리 난수 생성
	int c1, c2, c3;

	void init() {
		c1 = (int) (Math.random() * 9) + 1;
		c2 = (int) (Math.random() * 9) + 1;
		c3 = (int) (Math.random() * 9) + 1;
		while (c1 == c2) {
			c2 = (int) (Math.random() * 9) + 1;
		}
		while (c1 == c3 || c2 == c3) {
			c3 = (int) (Math.random() * 9) + 1;
		}
//		System.out.println(c1 + "" + c2 + "" + c3);
	}

	// 사용자 세자리 수 입력
	Scanner scanner = new Scanner(System.in);
	String input;
	int u1, u2, u3;

	void userInput() {
		System.out.print("세 자리 수를 입력하세요: ");
		input = scanner.next();
		u1 = Integer.parseInt(input.substring(0, 1));
		u2 = Integer.parseInt(input.substring(1, 2));
		u3 = Integer.parseInt(input.substring(2, 3));
	}

	// s,b 판단
	int s, b;

	void strikeOrBall() {
		s = 0;
		b = 0;
		if (u1 == c1) {
			s++;
		} else if (u1 == c2 || u1 == c3) {
			b++;
		}
		if (u2 == c2) {
			s++;
		} else if (u2 == c1 || u2 == c3) {
			b++;
		}
		if (u3 == c3) {
			s++;
		} else if (u3 == c1 || u3 == c2) {
			b++;
		}
	}

	// 게임 종료 조건
	int chances = 6;

	// 게임 진행
	void start() {
		init();
		while (s != 3 && chances != 0) {
			userInput();
			strikeOrBall();
			chances--;
			if (s == 3) {
				System.out.println("승리!!");
			} else {
				if (chances == 0) {
					System.out.println("패배...");
				} else {
					System.out.println(s + "s " + b + "b" + " 남은기회: " + chances);
				}
			}
		}
	}

	// 재시작
	boolean restart() {
		System.out.print("한판 더?(y/n): ");
		char again = scanner.next().charAt(0);
		if (again == 'y' || again == 'Y') {
			chances = 6;
			s = 0;
			return true;
		} else {
			return false;
		}
	}
}
