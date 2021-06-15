package co.board.access;

import java.util.ArrayList;
import co.board.model.Board;

public interface BoardAccess {
	// 전체 리스트(내용 미 출력)
	ArrayList<Board> getAllPosts();
	// 상세보기(b_id로 단건 조회, 내용 출력)
	Board getPost(int id);
	// 등록(제목/작성자/내용)
	void insertPost(Board board);
	// 수정(작성자만)
	void updatePost(int id, String content, String u_nick);
	// 삭제(작성자와 admin만)
	void deletPost(int id, String u_nick);
}
