package my.itis.boi.numgame;

import java.util.Scanner;

public class NumberGameApp {
	Scanner scanner = new Scanner(System.in);
	// 난수 생성
	int rndNum;
	void init() {
		rndNum = (int) (Math.random() * 10) + 1;
	}
	// 사용자 숫자 입력
	int userInput;
	void input() {
		System.out.print("Input a number: ");
		userInput = scanner.nextInt();
	}

	// up&down 판단
	//
	boolean gameOver() {
		boolean isUpDown;
		if (rndNum == userInput) {
			isUpDown = true;
		} else {
			isUpDown = false;
			if (rndNum > userInput) {
				System.out.println("Down");
			} else {
				System.out.println("Up");
			}
		}
		return isUpDown;
	}
	
	void start() {
		init();
		while(true) {
			input();
			gameOver();
			if (gameOver()) {
				break;
			}
		}
	}
}
