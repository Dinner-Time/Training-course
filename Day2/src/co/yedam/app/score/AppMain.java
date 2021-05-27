package co.yedam.app.score;
/*
작성일 : 2021-05-27
학교 성적 관리 프로그램
*/
public class AppMain {

	public static void main(String[] args) {
		ScoreApp score = new ScoreApp();
		
		score.input();
		
		System.out.println("\n"+
				"총점 : " + score.sum + "\n" +
				"평균 : " + score.avg + "\n" +
				"평점 : " + score.getGrade() + "\n\n" +
				"과락 여부 : " + (score.isPass() ? "합격" : "불합"));
	}
}
