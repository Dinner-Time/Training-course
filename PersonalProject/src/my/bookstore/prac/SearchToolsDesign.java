package my.bookstore.prac;

import java.util.ArrayList;
import bookstore.Books;

public interface SearchToolsDesign {
	// 전체 도서 조회
	ArrayList<Books> getAllBooks();
	// ISBN 조회
	Books getByIsbn(String isbn);
	// 제목 조회
	ArrayList<Books> getByTitle(String title);
	// 작가 조회
	ArrayList<Books> getByWriter(String writer);
	// 가격 조회
	ArrayList<Books> getBetweenPrice(int minPrice, int maxPrice);
}
