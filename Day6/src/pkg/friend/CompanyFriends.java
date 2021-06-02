package pkg.friend;

public class CompanyFriends extends Friends {

	String position;

	public CompanyFriends() {
		super();
	}

	public CompanyFriends(String sort, String name, String tel) {
		super(sort, name, tel);
	}

	public CompanyFriends(String sort, String name, String tel, String position) {
		super(sort, name, tel);
		this.position = position;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("직책: " + position);
		System.out.println();
	}

}
