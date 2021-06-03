package my.itis.boi.friends;

import java.util.ArrayList;
import java.util.List;

public class FriendList implements FriendAccess {

	List<Friends> friends;

	public FriendList() {
		friends = new ArrayList<Friends>();
	}

	@Override
	public void insert(Friends friend) {
		friends.add(friend);
	}

	@Override
	public void update(Friends friend) {
		for (Friends f : friends) {
			if (f.getName().equals(friend.getName()) && f.getSort().equals(friend.getSort())) {
				friends.set(friends.indexOf(f), friend);
			}
		}
	}

	@Override
	public void delete(String name) {
		for (Friends f : friends) {
			if (f.getName().equals(name)) {
				friends.remove(f);
			}
		}
	}

	@Override
	public void selectAll() {
		for (Friends f : friends) {
			System.out.println(f);
		}
	}

	@Override
	public Friends selectOne(String name) {
		for (Friends f : friends) {
			if (f.getName().equals(name)) { // contains -> 포함
				return f;
			}
		}
		return null;
	}

}
