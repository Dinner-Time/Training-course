package 클래스;

public class EqualTest {

	public static void main(String[] args) {
		Robot r1 = new Robot(2, 4);
		Robot r2 = new Robot(2, 4);

		String a = "hello";
		String b = "hello";

		System.out.println(a == b);
		System.out.println(r1 == r2);

		System.out.println(a.equals(b));
		System.out.println(r1.equals(r2));
		
		System.out.println(r1);

	}

}
