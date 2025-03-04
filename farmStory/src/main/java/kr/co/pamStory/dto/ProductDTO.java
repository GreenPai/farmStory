package kr.co.pamStory.dto;

import java.util.List;

public class ProductDTO {
	
	private int prodNo;
	private int cateNo;
	private String prodName;
	private int  prodPrice;
	private int prodStock;
	private int prodSold;
	private int prodDiscount;
	private int prodPoint;
	private int prodDeliveryFee;
	private String prodContent;
	private String regDate;
	
	// 추가 필드
	private String cateName;
	private String imagesName;
	private int prodDiscountPrice;
	
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getProdDiscountPrice() {
		return prodDiscountPrice;
	}
	public void setProdDiscountPrice(int prodDiscountPrice) {
		this.prodDiscountPrice = prodDiscountPrice;
	}
	public String getImagesName() {
		return imagesName;
	}
	public void setImagesName(String imagesName) {
		this.imagesName = imagesName;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getProdStock() {
		return prodStock;
	}
	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}
	public int getProdSold() {
		return prodSold;
	}
	public void setProdSold(int prodSold) {
		this.prodSold = prodSold;
	}
	public int getProdDiscount() {
		return prodDiscount;
	}
	public void setProdDiscount(int prodDiscount) {
		this.prodDiscount = prodDiscount;
	}
	public int getProdPoint() {
		return prodPoint;
	}
	public void setProdPoint(int prodPoint) {
		this.prodPoint = prodPoint;
	}
	public int getProdDeliveryFee() {
		return prodDeliveryFee;
	}
	public void setProdDeliveryFee(int prodDeliveryFee) {
		this.prodDeliveryFee = prodDeliveryFee;
	}
	public String getProdContent() {
		return prodContent;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}
	@Override
	public String toString() {
		return "ProductDTO [prodNo=" + prodNo + ", cateNo=" + cateNo + ", prodName=" + prodName + ", prodPrice="
				+ prodPrice + ", prodStock=" + prodStock + ", prodSold=" + prodSold + ", prodDiscount=" + prodDiscount
				+ ", prodPoint=" + prodPoint + ", prodDeliveryFee=" + prodDeliveryFee + ", prodContent=" + prodContent
				+ ", regDate=" + regDate + ", cateName=" + cateName + ", imagesName=" + imagesName
				+ ", prodDiscountPrice=" + prodDiscountPrice + "]";
	}
	
	
	
	
	
	
	
	
}
	