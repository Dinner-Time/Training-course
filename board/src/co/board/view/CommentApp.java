package co.board.view;

import java.util.Scanner;

import co.board.access.cdao.CDAOExcecutor;
import co.board.model.Board;

public class CommentApp {
	public static void start(int id, String u_nick) {
		Scanner scanner = new Scanner(System.in);
		int selectNo = 0;
		do {
			System.out.println("\n1.댓글 보기 | 2.댓글 등록 | 3.댓글 수정 | 4.댓글 삭제 | 0.나가기");
			try {
				selectNo = scanner.nextInt(); scanner.nextLine();
				switch(selectNo) {
				case 1: CDAOExcecutor.getComment(id); break;
				case 2: CDAOExcecutor.insertComment(id, u_nick); break;
				case 3: CDAOExcecutor.updateComment(u_nick); break;
				case 4: CDAOExcecutor.deleteComment(u_nick); break;
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}while(selectNo != 0);
	}
}
