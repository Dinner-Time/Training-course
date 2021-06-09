package my.member.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import my.member.model.Friends;

public class ScannerUtil {
	static Scanner scanner = new Scanner(System.in);
	
	// 프롬프트 출력 (readInt 오버로딩)
	public static int readInt(String prompt) { 
		int i = 0;
		while (true) {
			try {
				scanner = new Scanner(System.in);
				System.out.print(prompt + ">");
				i = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("다시 입력하세요.");
			}
		}
		return i;
	}
	
	// 입력받은 값을 문자열
	public static String readStr() { 
		String s = scanner.next();
		return s;
	}
	// 프롬프트 출력 (readStr 오버로딩)
	public static String readStr(String prompt) { 
		System.out.print(prompt + ">");
		return readStr();
	}
	
	// 입력받은 값을 날짜로 
	public static String readDate() { 
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		do {
			try {
				result = scanner.next();
				df.parse(result.trim()); // 날짜 범위를 벗어나는 정보를 자동으로 파악
				break;
			} catch(Exception e) {
				System.out.println("날짜 형식이 아닙니다.(yyyy-MM-dd)");
			}
		} while(true);
		return result;
	}
	// 프롬프트 출력 (readDate 오버로딩)
	public static String readDate(String prompt) { 
		System.out.print(prompt + ">");
		return readDate();
	}
	
	// 입력받은 값을 split하여 Friend객체를 생성해서 담는다? (예외처리)
	public static Friends readFriend() { 
		Friends friends = new Friends();
		System.out.print("구분:");
		String sort = scanner.next();
		System.out.print("이름:");
		String name = scanner.next();
		System.out.print("전화번호:");
		String tel = scanner.next();
		friends = new Friends(sort, name, tel);
		return friends;
	}
	// 프롬프트 출력 (readFriend 오버로딩)
	public static Friends readFriend(String prompt) { 
		System.out.print(prompt + ">");
		return readFriend();
	}

}
