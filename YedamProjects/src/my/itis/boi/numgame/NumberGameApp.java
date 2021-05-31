package my.itis.boi.numgame;

import java.util.Scanner;

public class NumberGameApp {
	Scanner scanner = new Scanner(System.in);
	// 난수 생성
	int rndNum;

	void init() {
		rndNum = (int) (Math.random() * 45) + 1;
//		System.out.println(rndNum); // 주석처리 필수
	}

	// 사용자 숫자 입력
	int userInput;

	void input() {
		System.out.print("숫자를 입력하세요: ");
		userInput = scanner.nextInt();
	}

	// 남은 기회
	int chances = 6;

	boolean gameOver() {
		boolean isLose = false;
		if (chances == 0) {
			isLose = true;
		}
		return isLose;
	}

	// up&down 판단
	boolean isUpDown() {
		boolean isWin;
		if (rndNum == userInput) {
			isWin = true;
		} else {
			isWin = false;
			if (rndNum < userInput) {
				System.out.println("Down");
			} else {
				System.out.println("Up");
			}
		}
		return isWin;
	}

	// 게임 진행
	void start() {
		init();
		while (true) {
			input();
			if (isUpDown()) {
				System.out.println("이겼습니다!!");
				break;
			} else {
				chances--;
				System.out.println("남은 기회: " + chances);
				if (gameOver()) {
					System.out.println("졌습니다...");
					break;
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
			return true;
		} else {
			return false;
		}
	}
}
