package 배열;
/*
작성일 : 2021-05-27
학교 성적 관리 프로그램
*/

public class ScoreApp {
	String name;
	int kor, eng, math, sum;
	double avg;

	public ScoreApp(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

		this.sum = kor + eng + math;
		this.avg = (double) this.sum / 3;
	}

}
