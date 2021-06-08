package bookstore.search;

import java.sql.SQLException;
import java.util.ArrayList;
import bookstore.Books;

public class SearchBooks implements SearchBooksDesign{

	@Override
	public ArrayList<Books> getAllBooks() {
		ArrayList<Books> allBooks = new ArrayList<Books>();
		String sql = "select * from booklist"; // sql 쿼리문
		try {
			Books.queryExecute = Books.connectUrl.prepareStatement(sql);
			Books.getSqlResult = Books.queryExecute.executeQuery(); // 쿼리문 실행
			//
			while (Books.getSqlResult.next()) {
				// Person 객체 생성 및 초기화
				Books books = new Books(
						Books.getSqlResult.getString("ISBN"), 
						Books.getSqlResult.getString("제목"),
						Books.getSqlResult.getString("작가"), 
						Books.getSqlResult.getInt("가격"), 
						Books.getSqlResult.getInt("수량"));
				// 배열에 person 객체 추가
				allBooks.add(books);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allBooks;
	}

	@Override
	public Books getByIsbn() {
		return null;
	}

	@Override
	public ArrayList<Books> getByTitle() {
		return null;
	}

	@Override
	public ArrayList<Books> getByWriter() {
		return null;
	}

	@Override
	public ArrayList<Books> getBetweenPrice() {
		return null;
	}

}
