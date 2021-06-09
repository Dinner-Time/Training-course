package my.memo.access;

import java.util.ArrayList;
import my.memo.model.Memos;

// 친구 관리 프로그램 개발 표준
public interface MemoAccess {
	// 등록
	void insert(Memos memo);

	// 수정
	void update(Memos memo);

	// 삭제
	void delete(String date);

	// 전체조회
	ArrayList<Memos> selectAll();

	// 날짜검색
	Memos findDate(String date);
	
	// 내용검색
	Memos findContent(String content);
}
