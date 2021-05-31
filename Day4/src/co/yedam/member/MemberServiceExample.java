package co.yedam.member;

public class MemberServiceExample {

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		memberService.insert("hong", "12345", "홍길동", 24);
		memberService.insert("jang", "44566", "장윤복", 25);
		memberService.insert("kang", "54321", "강성길", 26);

		memberService.printList();
		memberService.printMember(3);

		System.out.println(memberService.login("jang", "44566"));
		System.out.println(memberService.login("kang", "12345"));
		
		
		
	}
}
