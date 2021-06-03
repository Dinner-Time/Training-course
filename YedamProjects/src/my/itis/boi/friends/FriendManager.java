package my.itis.boi.friends;

public class FriendManager implements FriendAccess {
	Friends[] friend = new Friends[5];

	public FriendManager() {
		super();
		friend[0] = new CompanyFriends("회사", "song", "010-222-3333");
		friend[1] = new SchoolFriends("학교", "jang", "010-444-5555");
		friend[2] = new SchoolFriends("학교", "kang", "010-123-3333");
		friend[3] = new CompanyFriends("회사", "han", "010-222-3456");
		friend[4] = new CompanyFriends("회사", "yeo", "010-222-9875");
	}

	@Override
	public void insert(Friends friend) {
		
	}

	@Override
	public void update(Friends friend) {
		
	}

	@Override
	public void delete(String name) {
		
	}

	@Override
	public void selectAll() {
		
	}

	@Override
	public Friends selectOne(String name) {
		return null;
	}

}
