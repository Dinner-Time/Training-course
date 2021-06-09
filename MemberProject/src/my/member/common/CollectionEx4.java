package my.member.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import my.member.access.FriendDAO;

public class CollectionEx4 {
	public static void main(String[] args) {
		FriendDAO dao = new FriendDAO();
		
		Map<String, String> scores = dao.getNameTel();
		Set<Entry<String, String>> ent = scores.entrySet();
		Iterator<Entry<String, String>> eiter = ent.iterator();
		
		while(eiter.hasNext()) {
			Entry<String, String> e = eiter.next();
			System.out.println(e.getKey()+","+ e.getValue());
		}
	}
}
