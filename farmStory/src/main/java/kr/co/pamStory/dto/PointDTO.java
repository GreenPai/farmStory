package kr.co.pamStory.dto;

public class PointDTO {
	private int pointNo;
	private String uid;
	private int point;
	private String pointDesc;
	private String pointDate;
	public int getPointNo() {
		return pointNo;
	}
	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPointDesc() {
		return pointDesc;
	}
	public void setPointDesc(String pointDesc) {
		this.pointDesc = pointDesc;
	}
	public String getPointDate() {
		return pointDate;
	}
	public void setPointDate(String pointDate) {
		this.pointDate = pointDate;
	}
	@Override
	public String toString() {
		return "PointDTO [pointNo=" + pointNo + ", uid=" + uid + ", point=" + point + ", pointDesc=" + pointDesc
				+ ", pointDate=" + pointDate + "]";
	}
	
	
}
