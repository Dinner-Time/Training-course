package pkg.friend;

import java.util.ArrayList;
import java.util.List;

public class FriendList implements FriendAccess {

	List<Friends> friends;
	
	public FriendList() {
		friends = new ArrayList<Friends>();
	}

	@Override
	public void insert(Friends friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Friends selectOne(String name) {
		for (Friends f : friends) {
			if(f.getName().equals(name)) { //contains -> 포함
				return f;
			}
		}
		return null;
	}


}
