package exam5;

import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BookList list = new BookList();
		list.insert(new Book("1","자바","자바를 배우자"));
		list.insert(new Book("2","JSP","JSP 기초"));
		list.insert(new Book("3","JSP응용","JSP 심화학습"));
		list.insert(new Book("4","자바웹","JSP 응용"));
		int menu =0;
		do {
		System.out.println("1.등록   2.이름조회  0.종료");
		System.out.print("입력>");
		menu = scanner.nextInt();
		if(menu ==1) {
			BookServiceInsert bookServiceInsert = new BookServiceInsert();
			bookServiceInsert.execute(list);
		}else if (menu == 2) {
			BookServiceFind bookServiceFind = new BookServiceFind();
			bookServiceFind.execute(list);
//	**************************************
	// 전체조회
		}else if (menu == 65535) {
			for (Book k : list.books) {
				System.out.println(k);
			}
//	**************************************
		}
		}while(menu !=0);
		scanner.close();
	}

}
