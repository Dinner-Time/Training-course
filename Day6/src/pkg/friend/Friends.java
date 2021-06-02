package pkg.friend;

public class Friends {
	protected String sort;
	protected String name;
	protected String tel;
	
	

	public Friends() {
		super();
	}

	public Friends(String sort, String name, String tel) {
		super();
		this.sort = sort;
		this.name = name;
		this.tel = tel;
	}

	public void print() {
		System.out.printf("친구 정보: %s %s %s\n", sort, name, tel);
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Friends [sort=" + sort + ", name=" + name + ", tel=" + tel + "]";
	}

}
