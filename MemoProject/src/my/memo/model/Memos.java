package my.memo.model;
/*
 * 친구 1명의 내용을 저장하는 용도
 */
public class Memos {
	protected String date;
	protected String content;

	public Memos() {
		super();
	}

	public Memos(String date, String content) {
		super();
		this.date = date;
		this.content = content;
	}

	public void print() {
		System.out.printf("메모 정보: %s %s\n", date, content);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Friends [date=" + date + ", content=" + content + "]";
	}


}
