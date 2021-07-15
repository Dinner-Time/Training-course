package my.stream;

public class Employees {
	private String firstName;
	private String lastName;
	private String title;
	private int birthYear;

	public Employees(String firstName, String lastName, String title, int birthYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.birthYear = birthYear;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getbirthYear() {
		return birthYear;
	}

	public void setbirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "Employees [firstName=" + firstName + ", lastName=" + lastName + ", title=" + title + ", birthYear="
				+ birthYear + "]";
	}
}
