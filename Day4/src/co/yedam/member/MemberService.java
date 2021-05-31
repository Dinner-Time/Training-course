package co.yedam.member;

public class MemberService {

	Member[] members = new Member[10];
	int cnt = 0;

	// 회원가입
	void insert(String id, String pw, String name, int age) {
		members[cnt] = new Member(name, id, pw, age);
		cnt++;
	}

	// 전체 회원리스트 출력
	void printList() {
		for (int i = 0; i < cnt; i++) {
			System.out.println("id:" + members[i].id + " password:" + members[i].password + " name:" + members[i].name
					+ " age:" + members[i].age);
		}
	}

	// 회원 정보
	void printMember(int i) {
		System.out.println("id:" + members[i - 1].id + " name:" + members[i - 1].name + " age:" + members[i - 1].age);
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
