package my.member.common;

import java.util.HashSet;
import java.util.Set;

import my.member.access.FriendAccess;
import my.member.access.FriendDAO;
import my.member.model.Friends;

public class CollectionEx2 {
	public static void main(String[] args) {
		Set<Friends> set = new HashSet<>();
		
		FriendAccess dao =  new FriendDAO();
		
		for(Friends f : dao.selectAll()) {
			set.add(f);
			System.out.println(f);
		}
		System.out.println("<set>");
		for(Friends f : set) {
			System.out.println(f);
		}
	}
}
