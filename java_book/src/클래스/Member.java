package 클래스;

public class Member {
	String name, id, password;
	int age;

	Member() {

	}

	Member(String name, String id, String password, int age) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		Member member = (Member)obj;
		return member.name.equals(this.name) && member.id.equals(this.id);
	}
}
