package my.itis.boi.friends;

public class SchoolFriends extends Friends {

	String birth;

	public SchoolFriends() {
		super();
	}

	public SchoolFriends(String sort, String name, String tel) {
		super(sort, name, tel);
	}

	public SchoolFriends(String sort, String name, String tel, String birth) {
		super(sort, name, tel);
		this.birth = birth;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("생일: "+birth);
		System.out.println();
	}

}
