package exam5;

import java.util.Scanner;

public class BookServiceInsert implements BookService{

	public BookServiceInsert() {}
	
	Scanner scanner = new Scanner(System.in);
	@Override
	public void execute(BookList book) {
		System.out.print("ISBN>");
		String isbn = scanner.next();
		scanner.nextLine(); // next()메소드를 입력할 때 남은 Enter키를 초기화
		System.out.print("NAME>");
		String name = scanner.nextLine();
		System.out.print("CONTENT>");
		String content = scanner.nextLine();
		
		for (Book i : book.books) {
			if(i.getIsbn().equals(isbn)) {
				System.out.println("이미 등록된 ISBN입니다.");
				return;
			}
		}
		book.insert(new Book(isbn, name, content)); // Book의 생성자를 통해 만든 익명객체를 BookList의 insert메소드를 통해 추가한다.
		
	}

}
