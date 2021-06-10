package co.board.view;

import java.util.Scanner;

import co.board.access.BDAOExecutor;

public class BoardApp {
	static Scanner scanner = new Scanner(System.in);
	
	public static void start() {
		int selectNo = 0;
		do {
			System.out.println("\n1.게시글 모두보기 | 2.게시글 상세보기 | 3.게시글 등록 | 4.게시글 내용 수정 | 5.게시글 삭제 | 0.나가기");
			try {
				selectNo = scanner.nextInt();
				switch(selectNo) {
				case 1: BDAOExecutor.getAllPost(); break;
				case 2: BDAOExecutor.getPost(); break;
				case 3: BDAOExecutor.insertPost(); break;
				case 4: BDAOExecutor.updatePost(); break;
				case 5: BDAOExecutor.deletePost(); break;
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}while(selectNo != 0);
	}
}

