package my.member.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import my.member.model.Friends;


public class CollectionEx {

	public static void main(String[] args) {
		List<String> list = null;
		
		list = new ArrayList<String>();
		list.add("Hong");
		list.add("Hong");
		list.add("Park");
		list.add("Choi");
		
		list.remove(0);
		
		for(String s : list) {
			System.out.println(s);
		}
		
		Set<String> set = new HashSet<String>();
		set.add("Hong");
		set.add("Hong");
		set.add("Park");
		set.add("Choi");
		
		System.out.println("<set>");
		for(String f : set) {
			System.out.println(f);
		}
		
	}

}
