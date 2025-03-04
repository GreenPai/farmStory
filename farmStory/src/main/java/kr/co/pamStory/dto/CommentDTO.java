package kr.co.pamStory.dto;

public class CommentDTO {
	private int cno;
	private int parent;
	private String content;
	private String writer;
	private String regip;
	private String wdate;
	
	//추가필드
	private String nick;
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	public void setParent(String parent) {
		if(parent != null) {
			this.parent=Integer.parseInt(parent);
		}
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", parent=" + parent + ", content=" + content + ", writer=" + writer
				+ ", regip=" + regip + ", wdate=" + wdate + "]";
	}
	
}