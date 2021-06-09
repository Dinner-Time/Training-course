package bookstore.search;

import java.util.ArrayList;
import bookstore.Books;

public interface BooksUtilDesign {
	// 전체 리스트 조회
	ArrayList<Books> getAllBooks();
	// ISBN으로 도서 조회
	Books getByIsbn(String isbn);
	// 제목으로 도서 조회
	ArrayList<Books> getByTitle(String title);
	// 작가로 책 검색
	ArrayList<Books> getByWriter(String writer);
	// 가격 범위로 책 검색
	ArrayList<Books> getBetweenPrice(int startPrice, int lastPrice);
	// 도서 추가 (ISBN이 같을 시 추가불가 안내)
	void bookAdd(Books book);
	// 도서 수정 (ISBN으로 도서 검색 
	//			-> 변경할 항목 선택
	//			-> 변경할 내용 입력 -> 완료)
	void bookUpdate(Books book);
	// 도서 삭제 (ISBN으로 도서 검색 -> 삭제)
	void bookDelete(String ISBN);
}
