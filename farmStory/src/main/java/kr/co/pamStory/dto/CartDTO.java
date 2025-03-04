package kr.co.pamStory.dto;

public class CartDTO {
	private int cartNo;
	private String uid;
	private int prodNo;
	private int cartProdCount;
	private String cartProdDate;
	
	// 추가필드
	private String cateName;
	private String sname;
	private String prodName;
	private int prodDiscount;
	private int prodPrice;
	private int prodDiscountPrice;
	private int prodDeliveryFee;
	private int prodPoint;
	
	private int total;
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getProdPoint() {
		return prodPoint;
	}
	public void setProdPoint(int prodPoint) {
		this.prodPoint = prodPoint;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdDiscount() {
		return prodDiscount;
	}
	public void setProdDiscount(int prodDiscount) {
		this.prodDiscount = prodDiscount;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getProdDiscountPrice() {
		return prodDiscountPrice;
	}
	public void setProdDiscountPrice(int prodDiscountPrice) {
		this.prodDiscountPrice = prodDiscountPrice;
	}
	public int getProdDeliveryFee() {
		return prodDeliveryFee;
	}
	public void setProdDeliveryFee(int prodDeliveryFee) {
		this.prodDeliveryFee = prodDeliveryFee;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public int getCartProdCount() {
		return cartProdCount;
	}
	public void setCartProdCount(int cartProdCount) {
		this.cartProdCount = cartProdCount;
	}
	public String getCartProdDate() {
		return cartProdDate;
	}
	public void setCartProdDate(String cartProdDate) {
		this.cartProdDate = cartProdDate;
	}
	
	@Override
	public String toString() {
		return "CartDTO [cartNo=" + cartNo + ", uid=" + uid + ", prodNo=" + prodNo + ", cartProdCount=" + cartProdCount
				+ ", cartProdDate=" + cartProdDate + ", cateName=" + cateName + ", sname=" + sname + ", prodName="
				+ prodName + ", prodDiscount=" + prodDiscount + ", prodPrice=" + prodPrice + ", prodDiscountPrice="
				+ prodDiscountPrice + ", prodDeliveryFee=" + prodDeliveryFee + "]";
	}
	
	
}
