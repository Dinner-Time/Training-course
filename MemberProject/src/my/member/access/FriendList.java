package my.member.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import my.member.model.Friends;

public class FriendList implements FriendAccess {

	ArrayList<Friends> friends;

	public FriendList() {
		friends = new ArrayList<Friends>();
		open();
	}
	
	String path = "d:/temp/friend.txt";
	
	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while(true) {
				if(!scanner.hasNext()) break;
				String str = scanner.next();
				String[] arr = str.split(",");
				friends.add(new Friends(arr[0],arr[1],arr[2]));
			}
			scanner.close();
		} catch( Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for(Friends f: friends) {
				fw.write(String.format("%s,%s,%s\n", f.getSort(), f.getName(), f.getTel()));
			}
			fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Friends friend) {
		friends.add(friend);
		save();
	}

	@Override
	public void update(Friends friend) {
		for (Friends f : friends) {
			if (f.getName().equals(friend.getName())) {
				friends.set(friends.indexOf(f), friend);
				save();
			}
		}
	}

	@Override
	public void delete(String name) { // 동명이인 일경우?
		for (Friends f : friends) {
			if (f.getName().equals(name)) {
				friends.remove(f);
				save();
			}
		}
	}

	@Override
	public ArrayList<Friends> selectAll() {
		return friends;
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
	
	public Friends findTel(String tel) {
		for (Friends f : friends) {
			if (f.getTel().contains(tel)) { // contains -> 포함
				System.out.println(f);
			}
		}
		return null;
	}

}
