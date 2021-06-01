package my.project.animal;

public class AppMain {

	public static void main(String[] args) {
		Superman superman = new Superman();
		Human human = new Human();
		Bird bird = new Bird();
		human.think();
		superman.eat();
		superman.fly();
		superman.land();
		superman.run();
		superman.sleep();
		bird.run();
		bird.eat();
	}

}
