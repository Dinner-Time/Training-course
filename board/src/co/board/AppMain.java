package co.board;

import java.util.Scanner;

import co.board.access.login.Login;
import co.board.model.Member;
import co.board.view.BoardApp;

public class AppMain {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int selectNo = 0;
		do {
			try {
				System.out.print("1.로그인 | 0.종료\n>");
				selectNo = scanner.nextInt(); scanner.nextLine();
				switch(selectNo) {
				case 1: new Login().loginSuccess();
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(selectNo!=0);
		
	}
}
