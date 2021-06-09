package bookstore;

import java.sql.*;

public class Books {
	private String isbn;
	private String title;
	private String writer;
	private int price;
	private int quantity;

	public Books() {
		super();
	}

	public Books(String isbn, String title, String writer, int price, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "[isbn=" + isbn + ", 제목=" + title + ", 작가=" + writer + ", 가격=" + price + ", 수량="
				+ quantity + "]";
	}
	
	
	
}
