package 클래스;

public class StringEqual {

	public static void main(String[] args) {
		String s1 = "hello"; // 상수를 따로 저장하는 영역에 할당
		String s2 = "hello"; //  -> 같은 문자열 재사용
		
		String s3 = new String("hello"); // 힙 영역 할당
		String s4 = new String("hello"); //  -> 새로운 String객체 생성
		
		System.out.println(s1==s2); // true
		System.out.println(s3==s4); // false
		System.out.println(s1==s3); // false
		System.out.println(s2.equals(s4)); // true
		
		StringBuffer sb = new StringBuffer("Hello World");
		sb.insert(5, "!!");
		System.out.println(sb);
		sb.replace(0, 5, "hi");
		System.out.println(sb.toString().equals("hi!! World"));
	}

}
