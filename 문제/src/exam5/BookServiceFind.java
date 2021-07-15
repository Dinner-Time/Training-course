package exam5;

import java.util.List;
import java.util.Scanner;

public class BookServiceFind implements BookService{

	public BookServiceFind() {}
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void execute(BookList books) {
		System.out.print("검색할 이름>");
		String content = scanner.next();
		
		List<Book> list = books.findName(content); // BookList의 findName메소드는 리턴타입이 List<Book>이다.
		
		// 이름만 출력하는 메소드입니다.
//		for(Book l : list) {
//			System.out.println(l.getName());
//		}
		
		for(Book l : list) {
			System.out.println(l);
		}
		
		
	}

}
