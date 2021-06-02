package pkg.friend;

public class FriendAppMain {

	public static void main(String[] args) {
		FriendList list = new FriendList();
		
		//등록 테스트
		Friends f = new CompanyFriends();
		list.insert(f);
		f = new SchoolFriends();
		list.insert(f);
		
		//검색
		
		//수정 테스트
		f = new SchoolFriends();
		list.update(f);
		
		//삭제 
		list.delete();
		
		//전체조회
	}

}
