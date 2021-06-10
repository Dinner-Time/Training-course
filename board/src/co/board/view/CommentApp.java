package co.board.view;

import java.util.Scanner;

import co.board.access.CDAOExcecutor;
import co.board.model.Board;

public class CommentApp {
	public static void start(int id) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(id);
		int selectNo = 0;
		do {
			System.out.println("\n1.댓글 보기 | 2.댓글 등록 | 3.댓글 수정 | 4.댓글 삭제 | 0.나가기");
			try {
				selectNo = scanner.nextInt();
				switch(selectNo) {
				case 1: CDAOExcecutor.getComments(id); break;
				case 2: CDAOExcecutor.insertComment(id); break;
				case 3: CDAOExcecutor.updateComment(); break;
				case 4: CDAOExcecutor.deleteComment(); break;
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}while(selectNo != 0);
	}
}
