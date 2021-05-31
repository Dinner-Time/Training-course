package co.yedam.exam;

public class ExamScore {
	String examNum;
	int kor, his, eng, avg;
	
	ExamScore(){
		this("", 0,0,0);
	}
	
	ExamScore(String examNum, int kor, int his, int eng){
		this.examNum = examNum;
		this.kor = kor;
		this.his = his;
		this.eng = eng;
		this.avg = (kor+his+eng)/3;
	}
	
	boolean isPass() {
		if (avg >= 60 && kor>=40&& his>=40&& eng>=40) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "ExamScore [examNum=" + examNum + ", kor=" + kor + ", his=" + his + ", eng=" + eng + ", avg=" + avg
				+ "]";
	}
}
