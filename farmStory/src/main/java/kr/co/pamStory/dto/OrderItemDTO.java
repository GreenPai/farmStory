package kr.co.pamStory.dto;

public class OrderItemDTO {

	private int itemNo;
	private int orderNo;
	private int prodNo;
	private int itemPrice;
	private int itemDiscount;
	private int itemCount;
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemDiscount() {
		return itemDiscount;
	}
	public void setItemDiscount(int itemDiscount) {
		this.itemDiscount = itemDiscount;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	@Override
	public String toString() {
		return "OrderItemDTO [itemNo=" + itemNo + ", orderNo=" + orderNo + ", prodNo=" + prodNo + ", itemPrice="
				+ itemPrice + ", itemDiscount=" + itemDiscount + ", itemCount=" + itemCount + "]";
	}
	
	
	
	

}