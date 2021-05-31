package my.itis.boi.member;

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
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", password=" + password + ", age=" + age + "]";
	}
	
}
