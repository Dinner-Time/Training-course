package my.project.animal;

public class Bird extends Animal implements Flyer{

	public Bird() {
		super();
	}

	@Override
	public void run() {
		System.out.println("Bird Run");
	}

	@Override
	public void eat() {
		System.out.println("Bird Eat");
	}
	@Override
	public void takeOff() {
		System.out.println("bird takeoff");
	}
	@Override
	public void fly() {
		System.out.println("bird fly");
	}
	@Override
	public void land() {
		System.out.println("bird land");
	}
	
	public void layEggs() {
		System.out.println("bird layEggs");
	}

}
