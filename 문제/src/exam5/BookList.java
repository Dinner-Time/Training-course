package exam5;

import java.util.ArrayList;
import java.util.List;

public class BookList extends BookAccess{
	
	List<Book> books; // Book객체 타입을 담는 List 타입의 books 객체 선언
	
	//생성자 -> books를 Book타입 객체들을 담는 ArrayList로 생성한다
	public BookList() {
		books = new ArrayList<Book>(); 
	}

	@Override
	public void insert(Book book) { // books를 Book타입 객체들을 담기에 매개변수를 Book타입으로 받는다
		books.add(book); // books에 매겨변수를 추가
	}

	@Override
	public List<Book> findName(String name) { // List<Book>가 리턴 타입 
		List<Book> names = new ArrayList<Book>(); // 따라서 List<Book>타입의 객체 먼저 생성
		for (Book b : books) {
			if(b.getName().contains(name)) {
				names.add(b); // 조건에 맞는 객체를 추가한다
			}
		}
		return names; 
	}

	
}
