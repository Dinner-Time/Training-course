package my.itis.boi.book;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rent {
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private String name, title;
	String date = simpleDateFormat.format(new Date());
	
	public Rent() {
		super();
	}

	public Rent(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}

	public Rent(String name, String title, String date) {
		super();
		this.name = name;
		this.title = title;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Rent [name=" + name + ", title=" + title + ", date=" + date + "]";
	}

}
