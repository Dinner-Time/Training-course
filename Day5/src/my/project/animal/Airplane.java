package my.project.animal;

public class Airplane implements Flyer{

	@Override
	public void takeOff() {
		System.out.println("Airplane takeoff");
	}

	@Override
	public void fly() {
		System.out.println("Airplane fly");
	}

	@Override
	public void land() {
		System.out.println("Airplane land");
	}

}
