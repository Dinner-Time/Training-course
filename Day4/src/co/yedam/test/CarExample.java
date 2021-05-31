package co.yedam.test;

public class CarExample {

	public static void main(String[] args) {
		// 2. 객체생성 (인스턴스)
		Car myCar = new Car();
		myCar.company = "Ford";
		myCar.color = "green";
		myCar.speed = 200;
		System.out.println("회사: " + myCar.company);
		System.out.println("속도: " + myCar.speed);

		Car newCar = new Car("기아", "SM6", "빨강");
		System.out.println(newCar);
		
		Car miniCar = new Car("코나", 100);
		System.out.println(miniCar);
	}

}
