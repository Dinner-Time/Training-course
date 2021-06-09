package my.bookstore.prac;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bookstore.Books;
import bookstore.ConnectBookList;

public class SearchTools implements SearchToolsDesign {

	PreparedStatement execution;
	ResultSet result;

	// 전체 도서 조회
	@Override
	public ArrayList<Books> getAllBooks() {
		ArrayList<Books> allBooks = new ArrayList<Books>();
		String sql = "select * from booklist"; // sql 쿼리문
		try {
			execution = ConnectBookList.getDbUrl().prepareStatement(sql);
			result = execution.executeQuery();
			//
			while (result.next()) {
				// Person 객체 생성 및 초기화
				Books books = new Books(result.getString("ISBN"), result.getString("제목"), result.getString("작가"),
						result.getInt("가격"), result.getInt("수량"));
				// 배열에 person 객체 추가
				allBooks.add(books);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allBooks;
	}

	// ISBN으로 도서 조회
	@Override
	public Books getByIsbn(String isbn) {
		for (Books b : getAllBooks()) {
			if (b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		return null;
	}

	// 제목으로 도서 조회
	@Override
	public ArrayList<Books> getByTitle(String title) {
		ArrayList<Books> books = new ArrayList<Books>();
		for (Books b : getAllBooks()) {
			if (b.getTitle().contains(title)) {
				books.add(b);
			}
		}
		return books;
	}

	// 작가이름으로 도서 조회
	@Override
	public ArrayList<Books> getByWriter(String writer) {
		ArrayList<Books> books = new ArrayList<Books>();
		for (Books b : getAllBooks()) {
			if (b.getWriter().contains(writer)) {
				books.add(b);
			}
		}
		return books;
	}

	// 가격 범위로 도서조회
	@Override
	public ArrayList<Books> getBetweenPrice(int minPrice, int maxPrice) {
		ArrayList<Books> books = new ArrayList<Books>();
		for (Books b : getAllBooks()) {
			if (b.getPrice() >= minPrice && b.getPrice() <= maxPrice) {
				books.add(b);
			}
		}
		return books;
	}

}
