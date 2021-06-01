package my.project.tv;

public class SamsungTv implements RemoteControl{

	public SamsungTv() {
		super();
		System.out.println("SamsungTV");
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV Power On");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV Power Off");
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV Volume Up");
	}

	@Override
	public void volumDown() {
		System.out.println("SamsungTV Volume Down");
	}
	
}
