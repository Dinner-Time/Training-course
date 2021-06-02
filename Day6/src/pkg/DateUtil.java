package pkg;

public class DateUtil {
	
	static String date = "20210602";
	public static String curDate() { // 정적 메소드는 인스턴스를 사용할 수 없다.
		return date;
	}
}
