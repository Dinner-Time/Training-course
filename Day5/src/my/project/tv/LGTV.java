package my.project.tv;

public class LGTV implements RemoteControl{
	
	public LGTV() {
		super();
		System.out.println("LG TV");
	}

	@Override
	public void powerOn() {
		System.out.println("LG TV Power On");
	}

	@Override
	public void powerOff() {
		System.out.println("LG TV Power Off");
	}

	@Override
	public void volumeUp() {
		System.out.println("LG TV Volume Up");
	}

	@Override
	public void volumDown() {
		System.out.println("LG TV Volume Down");
	}
	
}
