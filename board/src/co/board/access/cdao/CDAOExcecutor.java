package co.board.access.cdao;

import java.util.Scanner;

import co.board.model.Board;

public class CDAOExcecutor {
	
	static Scanner scanner = new Scanner(System.in);
	static CommentDAO cdao = new CommentDAO();
	
	public static void getComment(int id) {
		for (Board b : cdao.getComments(id)) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.printf("%d.| 작성자: %s | 내용: %s\n",b.getB_id(), b.getB_writer(), b.getB_content());
		}
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	public static void insertComment(int id, String u_nick) {
		try {
			Board board = new Board();
			
			System.out.print("내용>"); 
			String content = scanner.nextLine();
			board.setB_title("none");
			board.setB_writer(u_nick);
			board.setB_content(content);
			board.setB_parent_id(id);
			
			cdao.insertPost(board);
			
			System.out.println("작성완료");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updateComment(String u_nick) {
		try {
			System.out.print("수정할 댓글 번호>");
			int id = scanner.nextInt();
			System.out.print("수정할 내용>"); scanner.nextLine();
			String content = scanner.nextLine();
			
			cdao.updatePost(id, content, u_nick);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteComment(String u_nick) {
		try {
			System.out.print("삭제할 댓글 번호>");
			int id = scanner.nextInt();
			
			cdao.deletPost(id, u_nick);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
