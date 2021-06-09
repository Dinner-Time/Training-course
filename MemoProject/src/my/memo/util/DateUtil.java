package my.memo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static String format = "yyyy-MM-dd E";

	// Date to String
	public static String dateToStr(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date.getTime());
	}

	// Overloading
	public static String dateToStr(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date.getTime());
	}

	// 두 날짜 사이의 일 수 계산
	public static long daysBetween(Date d1, Date d2) {
		long result = d1.getTime() - d2.getTime();
		result = result / 1000 / 60 / 60 / 24;
		return Math.abs(result);
	}

	public static long daysBetween(String s1, String s2) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		long result = 0;
		try {
			Date d1 = df.parse(s1);
			Date d2 = df.parse(s2);
			result = d1.getTime() - d2.getTime();
			result = result / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Math.abs(result);
	}

	// 해당 월의 마지막 날짜
	public static int lastDay(int year, int month) {
		int result = 0;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		result = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return result;
	}

}
