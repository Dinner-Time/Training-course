package 열거타입;

public class WeekTest {

	public static void main(String[] args) {
		
		String[] week = {"MON", "TUE", "WEN","TUR", "FRI", "SAT", "SUN"}; // 가독성이 떨어진다.
		String today = week[1];
		System.out.println(today);
		
//	*******************************************************************************************
		
		Week toDay = Week.MON;
		System.out.println(toDay);
		
	}

}
