package text;

public class Text {
	public Text() {}
	public int seqno;
	public String title;
	public String writer;
	public String content;
	public String text_date;
	public int getSeqno() {
		return this.seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return this.writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getText_date() {
		return this.text_date;
	}
	public void setText_date(String text_date) {
		this.text_date = text_date;
	}
}
