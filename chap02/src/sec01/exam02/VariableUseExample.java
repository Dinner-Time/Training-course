package sec01.exam02;

public class VariableUseExample {

	public static void main(String[] args) {
		
		int hour = 3;
		int minute = 5;
		
		System.out.println(hour + "시 " + minute + "분"); //+로 변수와 문자열을 연결
		
		int totalMinute = (hour * 60) + 5;
		System.out.println("총 " + totalMinute + "분");

	}

}
