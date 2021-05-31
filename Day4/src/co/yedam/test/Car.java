package co.yedam.test;

/*
 자동차 정보
 
 */

// 1. 클래스 선언
public class Car {

	// 필드(상태값, 속성..)
	String company;
	String model;
	String color;
	int maxSpeed;
	int speed;

	// 생성자
	/*
	 * 객체 생성시 호출되어 필드 초기화를 하는 특수용도의 메서드 생성자 명은 클래서 명과 동일,
	 * return타입 없음
	 * 중복선언은 가능 (오버로딩)
	 * 단 매개변수의 타입이나 갯수가 달라야한다.
	 */
	Car() {
		this("현대자동차", "그렌져", "검정", 350, 0);
	}

	Car(String company, String model, String color) {
		this(company, model, color, 0, 0);
	}

	public Car(String model, int speed) {
		this("",model,"", 0, speed);
	}

//	public Car(String model, int speed) {
//		super();
//		this.model = model;
//		this.speed = speed;
//	}
	
	public Car(String company, String model, String color, int maxSpeed, int speed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		if (maxSpeed>0) {
			this.maxSpeed = maxSpeed;
		} else {
			this.maxSpeed = 100;
		}
		if (speed>0) {
			this.speed = speed;
		} else {
			this.speed = 0;
		}
	}
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", speed=" + speed + "]";
	}
	
}
