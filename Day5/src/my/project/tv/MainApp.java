package my.project.tv;

public class MainApp {

	public static void main(String[] args) {
//		SamsungTv tv = new SamsungTv();
//		LGTV tv = new LGTV();
		
		// 다형성 : 참조하는 대상의 메서드 호출
		// 		-> 코드는 같아도 참조하는 대상에 따라 결과 값이 달라진다.
		// 부모타입의 참조변수가 자식객체를 참조할 수 있다.
		
//		RemoteControl tv = new SamsungTv();
//		RemoteControl tv = (RemoteControl)BeanFactory.getBean("samsung"); 
		RemoteControl tv = (RemoteControl)BeanFactory.getBean(args[0]);
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumDown();
		
	}

}
