package co.yedam.app.score;
/*
작성일 : 2021-05-27
학교 성적 관리 프로그램
*/
import java.util.Scanner;

public class ScoreApp {
	int kor, eng, math, sum;
	float avg;
	char grade;
	
	Scanner scanner = new Scanner(System.in);

	// 성적 입력
	void input() {
		System.out.print("국어 성적 : ");
		kor = scanner.nextInt();
		System.out.print("영어 성적 : ");
		eng = scanner.nextInt();
		System.out.print("수학 성적 : ");
		math = scanner.nextInt();
		
		sum = kor + eng + math;
		avg = (float)sum/3;
	}
	
//	// 총점 계산
//	int getSum() {
//		return sum;
//	}
//	
//	// 평균 계산
//	float getAvg() {
//		return avg;
//	}
	
	// 등급 산정
	char getGrade() {
		switch((int)avg/10) {
		case 10:
		case 9:
		case 8: grade = '상';break;
		case 7:
		case 6: grade = '중';break;
		default : grade = '하';
		}
		
		return grade;
	}
	
	boolean isPass() {
		//avg >= 60 -> true
		//else -> false
		if (avg >= 60) {
			return true;
		} else {
			return false;
		}
		
	}
}
