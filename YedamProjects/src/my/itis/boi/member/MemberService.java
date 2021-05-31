package my.itis.boi.member;

import java.util.Scanner;

public class MemberService {

	Scanner scanner = new Scanner(System.in);
	Member[] members = new Member[10];
	int cnt = 0;

	// 회원가입
	void insert(String id, String pw, String name, int age) {
		members[cnt] = new Member(name, id, pw, age);
		cnt++;
	}

	void insert() {
		System.out.print("name>");
		String name = scanner.next();
		System.out.print("id>");
		String id = scanner.next();
		System.out.print("password>");
		String pw = scanner.next();
		System.out.print("age>");
		int age = scanner.nextInt();
		members[cnt] = new Member(name, id, pw, age);
		cnt++;
	}

	// 전체 회원리스트 출력
	void printList() {
		for (int i = 0; i < cnt; i++) {
			System.out.println("id:" + members[i].id + " name:" + members[i].name + " age:" + members[i].age);
		}
	}

	// 회원 정보
	void printMember(int i) {
		System.out.println(i +"id:" + members[i].id + " name:" + members[i].name + " age:" + members[i].age);
	}

	// 회원 번호로 조회
	void printMemberNo() {
		System.out.print("번호: ");
		int memberNo = scanner.nextInt();
		for (int i = 0; i < cnt; i++) {
			if (i == memberNo) {
				printMember(i);
			}
		}
	}

	// 회원 id로 조회
	void printMemberID() {
		System.out.print("id: ");
		String memberID = scanner.next();
		for (int i = 0; i < cnt; i++) {
			if (members[i].id.equals(memberID)) {
				printMember(i);
			}
		}
	}

	// 로그인
	boolean login(String id, String pw) {
		for (int i = 0; i < cnt; i++) {
			if (id.equals(members[i].id) && pw.equals(members[i].password)) {
				return true;
			}
		}
		return false;
	}

	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}

}
