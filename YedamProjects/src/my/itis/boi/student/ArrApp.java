package my.itis.boi.student;

import java.util.Scanner;

public class ArrApp {
	int[] arr;
	int studentNum;

	Scanner scanner = new Scanner(System.in);
	
	void init() {
		System.out.print("학생수> ");
		studentNum = scanner.nextInt();
		arr = new int[studentNum];
	}
	// 점수입력
	void input() {
		for (int i = 0; i<arr.length; i++) {
			System.out.printf("scores[%d]> ", i);
			arr[i] = scanner.nextInt();
		}
	}
	
	//점수 리스트
	void scoreArray() {
		for (int i = 0; i<arr.length; i++) {
			System.out.printf("scores[%d]> %d", i, arr[i]);
			System.out.println();
		}
	}
	
	void maxScore() {
		int max = arr[0];
		for (int i = 1; i<arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("최고점수: "+ max);
	}
	
	void avgScore() {
		int sum = 0;
		for (int i = 0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("평균점수: "+(double)sum/arr.length);
	}
	
	//분석 -> 최고점수, 평균점수
	void analyze() {
		maxScore();
		avgScore();
	}
	//종료
	void terminate() {
		System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
		ArrApp app = new ArrApp();
		int selectNo = 0;
		boolean run = true;
		
		while (run) {
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.print("선택> ");
			Scanner scanner = new Scanner(System.in);
			selectNo = scanner.nextInt();
			if (selectNo == 1) {
				app.init();
			} else if (selectNo == 2) {
				app.input();
			} else if (selectNo == 3) {
				app.scoreArray();
			} else if (selectNo == 4) {
				app.analyze();
			} else if (selectNo == 5) {
				app.terminate();
				run = false;
			} else {
				
			}
			scanner.close();
		}
	}
}
