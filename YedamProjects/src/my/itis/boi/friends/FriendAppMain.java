package my.itis.boi.friends;

public class FriendAppMain {

	public static void main(String[] args) {
		FriendList list = new FriendList();
		
		//등록 테스트
		Friends f = new CompanyFriends("회사", "강영진", "1111-2222", "과장");
		list.insert(f);
		f = new SchoolFriends("학교", "진영훈", "2345-6789", "06-08");
		list.insert(f);
		
		//검색
		System.out.println(list.selectOne("강영진"));
		
		//수정 테스트
		f = new SchoolFriends("학교", "진영훈", "7890-1111");
		list.update(f);
		
		//삭제 
		list.delete("강영진");
		
		//전체조회
		list.selectAll();
	}

}
