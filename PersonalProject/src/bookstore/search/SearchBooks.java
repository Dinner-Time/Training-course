package bookstore.search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import bookstore.Books;

public class SearchBooks implements BooksUtilDesign {
	static Scanner scanner;

	public static void seachBook() {
		SearchBooks start = new SearchBooks();
		int selectNo = 1;
		do {
			scanner = new Scanner(System.in);
			System.out.println("1.전체조회 2.ISBN으로조회 3.제목으로조회 4.작가로조회 5.가격범위로조회 0.종료");
			System.out.print(">");
			try {
				selectNo = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("다시 입력하세요");
			}
			switch (selectNo) {
			
			// 책 전체를 출력합니다.
			case 1:
				for (Books b : start.getAllBooks()) {
					System.out.println(b);
				}
				break;
				
			// ISBN으로 책을 조회합니다.
			case 2:
				System.out.print("ISBN>");
				String isbn = scanner.next();
				System.out.println(start.getByIsbn(isbn));
				break;
				
			// 제목으로 책을 조회합니다.
			case 3:
				System.out.print("제목에 포함된 글자>");
				scanner.nextLine();
				String title = scanner.nextLine();
				for (Books b : start.getByTitle(title)) {
					System.out.println(b);
				}
				break;
				
			// 작가로 책을 조회합니다.
			case 4:
				System.out.print("작가>");
				scanner.nextLine();
				String writer = scanner.nextLine();
				for (Books b : start.getByWriter(writer)) {
					System.out.println(b);
				}
				break;
				
			// 가격 범위로 책을 조회합니다.
			case 5:
				System.out.print("최소가격>");
				int minPrice = scanner.nextInt();
				System.out.print("최고가격>");
				int maxPrice = scanner.nextInt();
				for (Books b : start.getBetweenPrice(minPrice, maxPrice)) {
					System.out.println(b);
				}
				break;
			}
		} while (selectNo != 0);
	}
	// 전체 도서 조회
	@Override
	public ArrayList<Books> getAllBooks() {
		ArrayList<Books> allBooks = new ArrayList<Books>();
		String sql = "select * from booklist"; // sql 쿼리문
		try {
			ResultSet result = Books.getSqlSelect(sql);
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
	public ArrayList<Books> getBetweenPrice(int startPrice, int lastPrice) {
		ArrayList<Books> books = new ArrayList<Books>();
		for (Books b : getAllBooks()) {
			if (b.getPrice() >= startPrice && b.getPrice() <= lastPrice) {
				books.add(b);
			}
		}
		return books;
	}
	
}
