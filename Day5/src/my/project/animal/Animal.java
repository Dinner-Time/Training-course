package my.project.animal;

public abstract class Animal {
	Animal() {
	}

	public void run() {
		System.out.println("run");
	}

	public abstract void eat();

	public void sleep() {
		System.out.println("sleep");
	}

}
