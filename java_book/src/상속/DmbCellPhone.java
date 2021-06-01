package 상속;

public class DmbCellPhone extends CellPhone {
	int channel;

	public DmbCellPhone() {
		super();
		System.out.println("DmbCellPhone 기본 생성자");
	}

	public DmbCellPhone(String model, String color, int channel) {
		super(model, color);
//		this.model = model;
//		this.color = color;
		this.channel = channel;
		System.out.println("DmbCellPhone 생성자");
	}

	void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB시작");
	}

	void turnOffDmb() {
		System.out.println("DMB 종료");
	}

	void changeChannel(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel + "번 변경");
	}

	@Override //->메소드 재정의 : 상속받은 메서드를 수정 사용
	void powerOn() {
//		super.powerOn();
		System.out.println("Dmb 전원 on");
	}
}
