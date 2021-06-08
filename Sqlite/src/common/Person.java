package common;

public class Person {
	private int id, age;
	private String name, phone;
	
	
	public Person() {}
	
	public Person(int id, String name, int age, String phone) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.phone = phone;
	}
	
//	******************************************************************************* 
	// getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
