package kr.co.pamStory.dto;

public class ImageDTO {
	private int ino;
	private int prodNo;
	private String oName;
	private String sName;
	private String rdate;
	
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	@Override
	public String toString() {
		return "ImageDTO [ino=" + ino + ", prodNo=" + prodNo + ", oName=" + oName + ", sName=" + sName + ", rdate="
				+ rdate + "]";
	}
	
	
	
	
}
