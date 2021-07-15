package exam5;

import java.util.Scanner;

public class BookApp2 {
	public static void main(String[] args) {
		BookList list = new BookList();
		list.insert(new Book("1","자바","자바를 배우자"));
		list.insert(new Book("2","JSP","JSP 기초"));
		list.insert(new Book("3","JSP응용","JSP 심화학습"));
		list.insert(new Book("4","자바웹","JSP 응용"));
		BookService[] service = {null,
				new BookServiceInsert(),
				new BookServiceFind(),
//				new BookServiceFindIsbn()
				};
		int menu =0;
		do {
		System.out.println("1.등록   2.내용조회   3.Isbn검색   0.종료");
		System.out.println("입력>");
		Scanner scanner = new Scanner(System.in);
		menu = scanner.nextInt();
//		if(menu ==1) {
//			BookServiceInsert service = new BookServiceInsert();
//			service.execute(list);
//		}else if (menu == 2) {
//			BookServiceFind service = new BookServiceFind();
//			service.execute(list); //나중에 조건들이 확장될 경우 if문 대신에
//		}else if (menu == 2) {
//		BookServiceFindIsbn service = new BookServiceFindIsbn();
//		service.execute(list);
		service[menu].execute(list); //==>확장성을 고려한 문장
		}while(menu !=0);
	}

}
