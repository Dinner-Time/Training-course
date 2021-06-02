package pkg.friend;

public class AppMain {

	public static void main(String[] args) {
//
//		Friends f = new CompanyFriends("회사", "태훈", "010-9640-0615", "과장");
//		f.print();
//		f = new SchoolFriends("학교", "태훈", "010-9640-0615","06-02");
//		f.print();
//
//		FriendAccess manager = new FriendManager();
//		manager.selectAll();
//		
//		manager = new FriendList();
//		manager.selectAll();

		FriendManager manager = new FriendManager();

		for (Friends fr : manager.friend) {
			if (fr instanceof CompanyFriends) {
				fr.print();
			}
		}

	}

}
