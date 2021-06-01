package 클래스;

public class Calculator {
	
	// 싱글톤
	private static Calculator instance = new Calculator();
	
	private Calculator() {}
	
	public static Calculator getInstance() {
		return instance;
	}
	
	public int add(int a, int b) {
		return a+b;
	}
	
	
}
