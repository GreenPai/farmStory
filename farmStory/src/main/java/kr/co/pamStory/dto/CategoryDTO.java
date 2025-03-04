package kr.co.pamStory.dto;

public class CategoryDTO {
	private int cateNo;
	private String cateName;
	
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	@Override
	public String toString() {
		return "CategoryDTO [cateNo=" + cateNo + ", cateName=" + cateName + "]";
	}
	
	
}
