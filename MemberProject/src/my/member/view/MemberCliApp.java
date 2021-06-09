package my.member.view;

import my.member.access.FriendAccess;
import my.member.access.FriendDAO;
import my.member.model.Friends;
import my.member.util.ScannerUtil;

public class MemberCliApp {
	
	FriendAccess friendList = new FriendDAO();
	
	public void start() {
		int menunum;
		do {
			menuTitle();
			menunum = ScannerUtil.readInt("입력");
			switch (menunum) {
			case 1: insert(); break;
			case 2: update(); break;
			case 3: delete(); break;
			case 4: selectAll(); break;
			case 5: selectOne(); break;
			case 6: findTel(); break;
			}
		} while(menunum!=0);
	}
	
	public void selectOne() {
		System.out.println(friendList.selectOne(ScannerUtil.readStr("친구 이름")));;
	}

	public void delete() {
		friendList.delete(ScannerUtil.readStr("친구 이름"));
	}

	public void selectAll() {
		for (Friends f : friendList.selectAll()) {
			System.out.println(f);
		}
	}

	public void update() {
		Friends friend = friendList.selectOne(ScannerUtil.readStr("친구 이름"));
		friend.setTel(ScannerUtil.readStr("친구 전화번호"));
		friendList.update(friend);
	}

	public void insert() {
		friendList.insert(ScannerUtil.readFriend());
	}
	
	public void findTel() {
		System.out.println(friendList.findTel(ScannerUtil.readStr("친구 전화번호")));
	}

	//활동 선택
	public void menuTitle() {
		System.out.println("=====친구 관리======");
		System.out.print("1.추가 | ");
		System.out.print("2.전화번호 수정 | ");
		System.out.print("3.삭제 | ");
		System.out.print("4.전체 조회 | ");
		System.out.print("5.이름으로 조회 | ");
		System.out.print("6.전화번호로 조회 | ");
		System.out.print("0. 종료");
		System.out.println();
	}
	
}
