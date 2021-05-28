package co.yedam.app;

public class AppMain {

	public static void main(String[] args) {
		CalcGame game = new CalcGame();
		
//		game.input();
//		
//		System.out.println(game.add());
//		System.out.println(game.sub());
//		System.out.println(game.div_int());
//		System.out.println(game.div_double());
//		System.out.println(game.reminder());
		
		System.out.println(game.sum(100));
		System.out.println(game.sum(10));
	}

}
