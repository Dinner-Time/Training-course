package co.board.access;

import java.util.Scanner;

import co.board.model.Board;

public class CDAOExcecutor {
	
	static Scanner scanner = new Scanner(System.in);
	static CommentDAO cdao = new CommentDAO();
	
	public static void getComments(int id) {
		for (Board b : cdao.getComments(id)) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.printf("%d.| 작성자: %s | 내용: %s\n",b.getB_id(), b.getB_writer(), b.getB_content());
		}
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	public static void insertComment(int id) {
		try {
			Board board = new Board();
			System.out.print("작성자>"); scanner.nextLine();
			String writer = scanner.nextLine();
			System.out.print("내용>"); 
			String content = scanner.nextLine();
			
			board.setB_title("none");
			board.setB_writer(writer);
			board.setB_content(content);
			board.setB_parent_id(id);
			
			cdao.insertPost(board);
			
			System.out.println("작성완료");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updateComment() {
		try {
			System.out.print("수정할 댓글 번호>");
			int id = scanner.nextInt();
			System.out.print("수정할 내용>"); scanner.nextLine();
			String content = scanner.nextLine();
			
			cdao.updatePost(id, content);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteComment() {
		try {
			System.out.print("삭제할 댓글 번호>");
			int id = scanner.nextInt();
			
			cdao.deletPost(id);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
