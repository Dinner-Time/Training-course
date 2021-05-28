package my.itis.boi.score2;

public class AppMain {

	public static void main(String[] args) {
		ScoreArr2App score = new ScoreArr2App();

//		score.printScore();

		for (int i = 0; i < score.arr.length; i++) {
			System.out.printf("%d번 학생: %d점(%d과목)\n",
					i + 1, score.stdTotal(i), score.getSbjCnt(i));
		}
	}
	
}
