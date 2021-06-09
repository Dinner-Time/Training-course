package my.bookstore.prac;

import bookstore.Books;

public interface OwnerUtilDesign {
	// 도서 추가 (ISBN이 같을 시 추가불가 안내)
	void bookAdd(Books book);
	// 도서 수정 (ISBN으로 도서 검색 
	//			-> 변경할 항목 선택
	//			-> 변경할 내용 입력 -> 완료)
	void bookUpdate(Books book);
	// 도서 삭제 (ISBN으로 도서 검색 -> 삭제)
	void bookDelete(String ISBN);
}
