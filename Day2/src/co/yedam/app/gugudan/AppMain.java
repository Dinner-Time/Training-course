package co.yedam.app.gugudan;
/*
작성일자 : 2021-05-27
구구단 프로그램
*/
public class AppMain {

	public static void main(String[] args) {
		GugudanApp gugudan = new GugudanApp();
		
		System.out.println("입력받은 단만 출력");
		gugudan.printDan();
		System.out.println("입력받은 범위의 단만 출력");
		gugudan.printRange();
		System.out.println("구구단 모두 출력");
		gugudan.printAll();
		System.out.println("구구단 모두를 역으로 출력");
		gugudan.printAllReverse();
		

	}

}
