package co.board.view;

import java.util.Scanner;

import co.board.access.bdao.BDAOExecutor;
import co.board.model.Member;

public class BoardApp {
	static Scanner scanner = new Scanner(System.in);
	
	public static void start(Member user) {
		int selectNo = 0;
		do {
			System.out.println("\n1.게시글 모두보기 | 2.게시글 상세보기 | 3.게시글 등록 | 4.게시글 내용 수정 | 5.게시글 삭제 | 0.나가기");
			try {
				selectNo = scanner.nextInt(); scanner.nextLine();
				switch(selectNo) {
				case 1: BDAOExecutor.getAllPost(); break;
				case 2: BDAOExecutor.getPost(user.getU_nick()); break;
				case 3: BDAOExecutor.insertPost(user.getU_nick()); break;
				case 4: BDAOExecutor.updatePost(user.getU_nick()); break;
				case 5: BDAOExecutor.deletePost(user.getU_nick()); break;
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}while(selectNo != 0);
	}
}

