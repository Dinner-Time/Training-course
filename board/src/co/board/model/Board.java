package co.board.model;

public class Board {
	private int b_id;
	private String b_title, b_writer, b_content;
	private int b_parent_id;
	
	public Board() {}
	
	public Board(int b_id, String b_title, String b_writer, String b_content) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_content = b_content;
	}
	
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public int getB_id() {
		return b_id;
	}
	public String getB_title() {
		return b_title;
	}
	public String getB_writer() {
		return b_writer;
	}
	
	public int getB_parent_id() {
		return b_parent_id;
	}

	public void setB_parent_id(int b_parent_id) {
		this.b_parent_id = b_parent_id;
	}

	@Override
	public String toString() {
		return "Board [b_id=" + b_id + ", b_title=" + b_title + ", b_writer=" + b_writer + ", b_content=" + b_content
				+ "]";
	}
	
}
