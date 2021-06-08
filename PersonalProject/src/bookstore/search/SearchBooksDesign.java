package bookstore.search;

import java.util.ArrayList;
import bookstore.Books;

public interface SearchBooksDesign {
	// 전체 리스트 조회
	ArrayList<Books> getAllBooks();
	// isbn으로 책 검색
	Books getByIsbn();
	// 제목으로 책 검색
	ArrayList<Books> getByTitle();
	// 작가로 책 검색
	ArrayList<Books> getByWriter();
	// 가격 범위로 책 검색
	ArrayList<Books> getBetweenPrice();
}
