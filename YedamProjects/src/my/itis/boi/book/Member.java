package my.itis.boi.book;

public class Member {
	private String name, phone;

	public Member() {

	}

	public Member(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", phone=" + phone + "]";
	}

}
