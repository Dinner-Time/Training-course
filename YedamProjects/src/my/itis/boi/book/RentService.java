package my.itis.boi.book;

import java.util.Scanner;

public class RentService implements Service{
	
	Rent[] rentBooks;
	int cnt;			
	int maxCnt = 10;	
	
	Scanner scanner = new Scanner(System.in);
	
	public RentService() {
		rentBooks = new Rent[maxCnt];
	}

	@Override
	public void input() {
		if(cnt > maxCnt) {
			System.out.println("더 이상 추가할 수 없습니다.");
			return;
		}
		System.out.printf("이름>");
		String name = scanner.next();
		System.out.print("책 제목>");
		String book = scanner.next();
		rentBooks[cnt++] = new Rent(name, book); 
		System.out.println("등록된 건수:" + cnt);
	}

	@Override
	public void update() {
		System.out.printf("수정할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.print("이름>");
		String name = scanner.next();
		rentBooks[idx].setName(name);
		System.out.print("책 제목>");
		String book = scanner.next();
		rentBooks[idx].setName(book);
		System.out.println("수정되었습니다.");
	}

	@Override
	public void delete() {
		System.out.printf("삭제할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		for(int i=idx; i<cnt-1; i++) {
			rentBooks[i] = rentBooks[i+1];
		}
		cnt--;
		System.out.println("삭제되었습니다.");
	}

	@Override
	public void selectAll() {
		System.out.println(String.format("%-20s %-20s %-20s", "이름", "책 제목", "날짜"));
		System.out.println("================================================================");
		for(int i=0; i<cnt; i++) {
			System.out.println(String.format("%-20s %-20s %-20s", rentBooks[i].getName(), rentBooks[i].getTitle(), rentBooks[i].getDate()));
		}
		System.out.println("================================================================");
	}

	@Override
	public void selectOne() {
		System.out.printf("조회할 번호>");
		int idx = scanner.nextInt();
		if(idx > cnt-1) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.println(String.format("이름:%s   책제목:%s   날짜:%s", rentBooks[idx].getName(), rentBooks[idx].getTitle(),rentBooks[idx].getDate()));
	}

}
