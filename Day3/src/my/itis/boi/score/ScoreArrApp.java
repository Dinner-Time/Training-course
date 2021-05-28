package my.itis.boi.score;
/*
  작성일 : 2021-05-28
  배열을 이용한 성적 계산
 */
public class ScoreArrApp {
	int a = 10;
	int arr[] = {90, 90, 50};
	
	void printArr() {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	int total() {
		int result = 0;
		for (int i=0; i<arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
	
	double avg() {
		double result;
		result = (double)total()/arr.length;
		return result;
	}
	
	void printH() {
		System.out.printf("%1$s\n"
				+ "국어:%2$d\t영어:%3$d\t수학:%4$d\n"
				,"홍길동성적",arr[0],arr[1],arr[2]);
	}
}
