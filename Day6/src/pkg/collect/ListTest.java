package pkg.collect;

import java.util.*;

import pkg.*;
import pkg.friend.*;

public class ListTest {
	public static void main(String[] args) {
		
		LinkedList<Friends> list = new LinkedList<Friends>();
		list.add(new Friends("현대", "홍", "1111"));
		list.add(0,new CompanyFriends("삼성", "김", "1234"));
		list.add(new SchoolFriends("대륜", "박", "4567"));
	
		for (Friends fr : list) {
			System.out.println(fr.getName());
		}
		System.out.println("===========");
		
		
		list.remove(0);
		for (Friends fr : list) {
			System.out.println(fr.getName());
		}
		System.out.println("===========");
		
		Friends fr = list.get(0);
		System.out.println("첫번째 이름: "+fr.getName());
		fr = list.get(list.size()-1);
		System.out.println("마지막 이름: "+fr.getName());
		System.out.println("===========");
		
		list.set(1, new Friends("중학", "성", "4445"));
		for (Friends frs : list) {
			System.out.println(frs.getName());
		}
		
	}
}
