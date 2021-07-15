package exam4;

public class Exam4 {

	public static void main(String[] args) {

		String[] arr = { "010102-2", "991012-1", "960304-1", "881012-2", "040403-1" };

		int m = 0;
		int f = 0;
		int tenth =0 , twentieth =0, thirtieth =0, fortieth=0;

		for (String a : arr) {
			if (a.substring(a.length() - 1).equals("1")) {
				m++;
			} else if (a.substring(a.length() - 1).equals("2")) {
				f++;
			}
		}
		
		for (String a : arr) {
			int x = Integer.parseInt(a.substring(0,2));
			int y = 21-x;
			if (y<0) {
				y = 21+(100-x);
			}
			if (10 <= y && y < 20) {
				tenth++;
			} else if (y <30) {
				twentieth++;
			} else if (y<40) {
				thirtieth++;
			} else {
				fortieth++;
			}
		}
		
		System.out.println("남 "+m +" 여 "+f);
		System.out.println("10대 "+tenth+"명");
		System.out.println("20대 "+twentieth+"명");
		System.out.println("30대 "+thirtieth+"명");
		System.out.println("40대 "+fortieth+"명");
		
	}

}
