package my.itis.boi.baseball;

public class AppMain {

	public static void main(String[] args) {
		BaseballApp game = new BaseballApp();
		while (true) {
			game.start();
			if (!game.restart()) {
				break;
			}
		}
	}
}
