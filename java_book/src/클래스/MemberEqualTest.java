package 클래스;

public class MemberEqualTest {

	public static void main(String[] args) {
		Member m1 = new Member("김성직", "gotthe", "1111", 20);
		Member m2 = new Member(new String("김성직"), "gotthe", "2222", 21);
		
		System.out.println(m1.equals(m2));
	}

}
