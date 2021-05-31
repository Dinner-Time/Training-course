package my.itis.boi.numgame;

public class AppMain {

	public static void main(String[] args) {
		NumberGameApp number = new NumberGameApp();
		
		while (true) {
			number.start();
			if (!number.restart()) {
				break;
			}
		}
	}
}
