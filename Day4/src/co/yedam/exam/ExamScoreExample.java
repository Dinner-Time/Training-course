package co.yedam.exam;

import java.util.Scanner;

public class ExamScoreExample {
	
	Scanner scanner = new Scanner(System.in);
	
	int korScore() {
		System.out.print("국어 성적: ");
		return scanner.nextInt();
	}
	
	int hisScore() {
		System.out.print("국사 성적: ");
		return scanner.nextInt();
	}
	
	int engScore() {
		System.out.print("영어 성적: ");
		return scanner.nextInt();
	}

	public static void main(String[] args) {
		ExamScoreExample input = new ExamScoreExample();
		ExamScore exResult = new ExamScore("",input.korScore(),input.hisScore(),input.engScore());
		System.out.println("평균: "+exResult.avg);
		System.out.println(exResult.isPass() ? "합격" : "불합격");
	}

}
