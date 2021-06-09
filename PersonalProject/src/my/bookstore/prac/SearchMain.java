package my.bookstore.prac;

import java.util.Scanner;
import bookstore.Books;

public class SearchMain extends SearchTools{
	
	static Scanner scanner;

	public static void seachBook() {
		SearchMain start = new SearchMain();
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
}
