package 클래스;

public class Robot {
	
	// 오버로딩 : 같은 이름의 생성자 또는 메소드를 만드는 것(매개변수의 갯수나 타입이 달라야한다.)

	// 필드
	private int arm, leg; // private -> 클래스 내부에서만 접근
	private String name;
	
	// 생성자
	public Robot() {
	} // 기본 생성자 -> 생성하지 않아도 컴파일러가 자동 생성

	public Robot(int arm, int leg) {
		this.arm = arm; // this -> 자기 자신 객체를 참조하는 참조변수
		this.leg = leg;
	}
	
	public Robot(int arm, int leg, String name) {
		this.arm = arm;
		this.leg = leg;
		this.name = name;
	}

	// setter -> 필드 값 변경
	public void setArm(int arm) {
		this.arm = arm;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	// getter -> 필드 값 조회
	public int getArm() {
		return arm;
	}

	public int getLeg() {
		return leg;
	}
	
	public String getName(String name) {
		return name;
	}

	@Override
	public String toString() {
		return "Robot [arm=" + arm + ", leg=" + leg + ", name=" + name + "]";
	}

	// 일반 메서드
	void print() { // default -> 같은 패키지에서만 접근가능
		System.out.printf("arm:%d leg:%d name:%s", arm, leg, name);
	}

	@Override
	public boolean equals(Object obj) {
		return ((Robot)obj).arm == this.arm && ((Robot)obj).leg == this.leg;
	}
	
	

}
