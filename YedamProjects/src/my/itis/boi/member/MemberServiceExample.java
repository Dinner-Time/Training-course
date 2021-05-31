package my.itis.boi.member;

import java.util.Scanner;

public class MemberServiceExample {

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		Scanner scanner = new Scanner(System.in);
		int selectNo = 0;
		boolean run = true;

		while (run) {
			System.out.println("1.등록 | 2.전체조회 | 3.번호로조회 | 4.로그인 | 5.id로조회 | 6.종료");
			System.out.print("입력> ");
			selectNo = scanner.nextInt();
			if (selectNo == 1) { // 등록
				memberService.insert();
			} else if (selectNo == 2) { // 전체조회
				memberService.printList();
			} else if (selectNo == 3) { // 번호로 조회
				memberService.printMemberNo();
			} else if (selectNo == 4) { // 로그인
				System.out.print("id>");
				String id = scanner.next();
				System.out.print("password>");
				String pw = scanner.next();
				System.out.println(memberService.login(id, pw) ? "로그인되었습니다." : "id또는 password를 확인해주세요.");
			} else if (selectNo == 5) { // id로 조회
				memberService.printMemberID();
			} else if (selectNo == 6) { // 종료
				run = false;
			}
		}

	}
}
