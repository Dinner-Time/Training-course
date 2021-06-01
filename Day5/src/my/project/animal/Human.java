package my.project.animal;

public class Human extends Animal {

	public Human() {
		super();
	}

	public void think() {
		System.out.println("human think");
	}

	@Override
	public void eat() {
		System.out.println("human eat");
	}
}
