package pkg.other;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		System.out.println(DateUtil.dateToStr(new Date()));
		System.out.println(DateUtil.dateToStr(new Date(), "yyyy"));

		System.out.println(DateUtil.daysBetween(new Date(), new Date(2020, 6, 3)));
		System.out.println(DateUtil.daysBetween("2021-12-31", "2021-05-22"));

		System.out.println(DateUtil.lastDay(2000, 2));
	}

}
