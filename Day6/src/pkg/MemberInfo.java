package pkg;

public class MemberInfo {
	
	static MemberInfo memberInfo = new MemberInfo();
	static MemberInfo getInstance() {
		return memberInfo;
	}
	private MemberInfo() {}
	
	
	
	String[] names = new String[10];
	
	void print() {
		for (String name : names) {
			if (name == null) {
				break;
			}
			System.out.println(name);
		}
	}
	
}
