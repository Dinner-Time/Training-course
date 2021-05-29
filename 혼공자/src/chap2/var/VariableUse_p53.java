package chap2.var;

/*
작성자: 박태훈
작성일자: 2021-05-29
변수의 사용
*/
public class VariableUse_p53 {

	public static void main(String[] args) {
		
		int hour = 3;
		int minute = 5;
		
		System.out.println(hour + "시 " + minute + "분"); 
		
		int totalMinute = (hour * 60) + 5;
		System.out.println("총  " + totalMinute + "분");

	}

}
