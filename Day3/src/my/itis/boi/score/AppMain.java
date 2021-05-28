package my.itis.boi.score;
/*
작성일 : 2021-05-28
배열을 이용한 성적 계산
*/
public class AppMain {
	
	public static void main(String[] args) {
		
		ScoreArrApp score = new ScoreArrApp();
		
		score.printArr();
		
		System.out.printf(
				"총점: %6d \n"
				+ "평균: %6.2f \n"
				, score.total(), score.avg());
		
		score.printH();
		
	}
}
