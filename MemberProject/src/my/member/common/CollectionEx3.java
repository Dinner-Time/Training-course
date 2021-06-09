package my.member.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import my.member.model.Friends;

public class CollectionEx3 {
	public static void main(String[] args) {
		Map<String, Friends> map = new HashMap<>();
		map.put("선생님", new Friends("1반", "인선","019"));
		map.put("반장", new Friends("1반", "태훈","017"));
		map.put("정상", new Friends("1반", "상수","018"));
		map.put("반장", new Friends("1반", "경훈","010"));
		
		System.out.println(map.get("선생님"));
		
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			Friends val = map.get(key);
			System.out.println("key:" + key + " value:" + val.toString());
		}
		
		//Friends : key, Interger : value
		Map<Friends, Integer> scores = new HashMap<>();
		scores.put(new Friends("1반", "김민수", "123"), 100);
		scores.put(new Friends("1반", "황정훈", "123"), 87);
		scores.put(new Friends("1반", "강인영", "123"), 95);
		scores.put(new Friends("1반", "최지민", "123"), 68);
		scores.put(new Friends("1반", "김민수", "123"), 88);
		
		Set<Entry<Friends, Integer>> ent = scores.entrySet();
		Iterator<Entry<Friends, Integer>> eiter = ent.iterator();
		
		while(eiter.hasNext()) {
			Entry<Friends, Integer> e = eiter.next();
			System.out.println(e.getKey()+","+ e.getValue());
		}
		
	}
}
