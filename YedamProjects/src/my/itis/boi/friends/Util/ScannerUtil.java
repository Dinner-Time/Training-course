package my.itis.boi.friends.Util;

import java.util.Scanner;

import my.itis.boi.friends.Friends;

public class ScannerUtil {
	static Scanner scanner  = new Scanner(System.in);
	
	public static int readInt() { // 입력받은 값을 정수로 자동변환
		int i = scanner.nextInt();
		return i;
	}
	public static String readStr() { // 입력받은 값을 문자열
		String s = scanner.next();
		return s;
	}
	public static String readDate() { // 입력받은 값을 날짜로 (예외처리 필수)
		
	}
	public static Friends readFriend() { // 입력받은 값을 split하여 Friend객체를 생성해서 담는다?
		String fr = scanner.next(); 
		String[] arr = fr.split(" ");
		Friends friends = new Friends(arr[0], arr[1], arr[2]);
		return friends;
	}

}
