package pkg;

public class MemberInfoMain {
	public static void main(String[] args) {
		MemberInfo member1 = MemberInfo.getInstance();
		member1.names[0] = "hong";
		
		MemberInfo member2 = MemberInfo.getInstance();
		member2.names[0] = "park";
		
		MemberInfo member3 = MemberInfo.getInstance();
		member3.names[0] = "jang";
		
		member1.print();
		member2.print();
		member3.print();
		
	}
}
