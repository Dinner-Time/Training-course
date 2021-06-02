package pkg.other;

import pkg.*;
//import pkg.Car;
//import pkg.Count;
//import pkg.DateUtil;
//import pkg.ProjectInfo;

public class AppMain {
	public static void main(String[] args) {
//		System.out.println(DateUtil.curDate());
//		System.out.println(ProjectInfo.NAME);
//
//		Count count1 = new Count();
//		Count.cnt++;
//
//		count1.setCnt2(count1.getCnt2() + 1);
//		
		Car car = new Car();
		car.setModel("현대");
		car.setSpeed(100);
		System.out.println(car.getModel() + " " + car.getSpeed());

		Car car2 = new Car("ford", 70);
		System.out.println(car2.getModel() + " " + car2.getSpeed());

		Car car3 = new Car("기아");
		System.out.println(car3.getModel() + " " + car3.getSpeed());

		Car car4 = new Car(120);
		System.out.println(car4.getModel() + " " + car4.getSpeed());

	}

}
