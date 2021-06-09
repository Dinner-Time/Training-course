package my.memo.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import my.memo.model.Memos;

public class ScannerUtil {
	static Scanner scanner = new Scanner(System.in);

	// 프롬프트 내용을 입력받아 정수를 입력받고 리턴
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

	// 프롬프트 내용을 입력받아 문자열을 리턴
	public static String readStr(String prompt) {
		System.out.print(prompt + ">");
		String s = scanner.next();
		return s;
	}

	// 입력받은 값을 날짜로
//	public static String readDate(String date) {
//		String result = "";
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		do {
//			try {
//				result = date;
//				df.parse(result.trim()); 
//				break;
//			} catch (Exception e) {
//				System.out.println("날짜 형식이 아닙니다.(yyyy-MM-dd)");
//				return null;
//			}
//		} while (true);
//		return result;
//	}

	public static String readDate() {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		do {
			try {
				System.out.print("날짜(yyyy-MM-dd)>");
				result = scanner.next();
				df.parse(result.trim()); 
				break;
			} catch (Exception e) {
				System.out.println("날짜 형식이 아닙니다.(yyyy-MM-dd)");
			}
		} while (true);
		return result;
	}

	// 입력받은 값을 split하여 Friend객체를 생성해서 담는다? (예외처리)
	public static Memos readMemo() {
		Memos memos = new Memos();
		
		System.out.print("날짜:내용>");
		String fr = scanner.next();
		
		String[] arr = fr.split(":");
		memos = new Memos(arr[0], arr[1]);
		
		return memos;
	}

}
