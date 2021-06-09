package 쓰레드;

public class 동기화Test {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		
		user1.start();
		user2.start();
		
	}

}
