package my.project.animal;

public class Superman extends Human implements Flyer {

	public Superman() {
		super();
	}
	
	@Override
	public void takeOff() {
		System.out.println("superman takeoff");
	}

	@Override
	public void fly() {
		System.out.println("superman fly");
	}

	@Override
	public void land() {
		System.out.println("superman land");
	}
}
