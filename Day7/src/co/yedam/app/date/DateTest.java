package co.yedam.app.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		
		Date date = new Date();
		Calendar now = Calendar.getInstance();
		System.out.println(System.currentTimeMillis());

		int year = now.get(Calendar.YEAR);	
		int month = now.get(Calendar.MONTH)+1;
		int day1 = now.get(Calendar.DAY_OF_YEAR);
		int day2 = now.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day1);
		System.out.println(day2);
		
		System.out.println(now);
		
		// 살아온 날 계산
		Calendar birth = Calendar.getInstance();
		birth.set(1996, 2, 8);
		long dur = now.getTimeInMillis() - birth.getTimeInMillis();
		System.out.println(dur/1000/60/60/24);
		
		// 기념일 계산
		Calendar event = Calendar.getInstance();
		event.set(2022, 0, 1);
		long dur1 = now.getTimeInMillis() - event.getTimeInMillis();
		System.out.println(dur1/1000/60/60/24);
		
		// Date to String
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd E");
		System.out.println(df.format(now.getTime()));
		
		
		LocalDate currentDate = LocalDate.now();
		System.out.printf("%d/%d/%d", currentDate.getYear(), currentDate.getMonthValue(),currentDate.getDayOfMonth());
		System.out.println();
		System.out.println(currentDate.plusDays(100));
		
	}
}
