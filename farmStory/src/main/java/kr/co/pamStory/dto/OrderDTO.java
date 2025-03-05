package kr.co.pamStory.dto;

public class OrderDTO {

	// order
	private int orderNo;
	private String uid;
	private int orderTotalPrice;
	private String orderAddr;
	private int orderStatus;
	private String orderDate;
	private String orderReceiver;
	private String orderSender;
	private String orderContent;
	private String orderHp;
	private String receiverHp;
	private String payment;
	
	// 추가 필드 
	private int itemNo;
	private int prodNo;
	private int itemPrice;
	private int itemDiscount;
	private int itemCount;
	private String sname;
	private String prodName;
	private int prodPrice;
	private int prodDeliveryFee;
	
	
	public int getProdDeliveryFee() {
		return prodDeliveryFee;
	}
	public void setProdDeliveryFee(int prodDeliveryFee) {
		this.prodDeliveryFee = prodDeliveryFee;
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
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
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
	public int getOrderNo() {
		return orderNo;
	}
	public String getReceiverHp() {
		return receiverHp;
	}
	public void setReceiverHp(String receiverHp) {
		this.receiverHp = receiverHp;
	}
	public String getOrderReceiver() {
		return orderReceiver;
	}
	public void setOrderReceiver(String orderReceiver) {
		this.orderReceiver = orderReceiver;
	}
	public String getOrderSender() {
		return orderSender;
	}
	public void setOrderSender(String orderSender) {
		this.orderSender = orderSender;
	}
	public String getOrderContent() {
		return orderContent;
	}
	public void setOrderContent(String orderContent) {
		this.orderContent = orderContent;
	}
	public String getOrderHp() {
		return orderHp;
	}
	public void setOrderHp(String orderHp) {
		this.orderHp = orderHp;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(int orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	public String getOrderAddr() {
		return orderAddr;
	}
	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "OrderDTO [orderNo=" + orderNo + ", uid=" + uid + ", orderTotalPrice=" + orderTotalPrice + ", orderAddr="
				+ orderAddr + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", orderReceiver="
				+ orderReceiver + ", orderSender=" + orderSender + ", orderContent=" + orderContent + ", orderHp="
				+ orderHp + ", receiverHp=" + receiverHp + ", payment=" + payment + ", itemNo=" + itemNo + ", prodNo="
				+ prodNo + ", itemPrice=" + itemPrice + ", itemDiscount=" + itemDiscount + ", itemCount=" + itemCount
				+ ", sname=" + sname + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodDeliveryFee="
				+ prodDeliveryFee + "]";
	}
	
	

}