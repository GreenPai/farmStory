package kr.co.pamStory.dto;

/*
 * 고객이 장바구니에 담은 데이터를 전달해주기 위한 DTO
 * 전체 상품수, 상품금액, 할인금액, 포인트 사용, 전체주문금액 등 
 * */
public class CreditDTO {

	private int totalCnt;
	private int prodDeliveryFee;
	private int Price;
	private int discountPrice;
	private int finalPrice;
	private int point;
	private int userPoint;
	private int tot;
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getProdDeliveryFee() {
		return prodDeliveryFee;
	}
	public void setProdDeliveryFee(int prodDeliveryFee) {
		this.prodDeliveryFee = prodDeliveryFee;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	
	@Override
	public String toString() {
		return "CreditDTO [totalCnt=" + totalCnt + ", prodDeliveryFee=" + prodDeliveryFee + ", Price=" + Price
				+ ", discountPrice=" + discountPrice + ", finalPrice=" + finalPrice + ", point=" + point
				+ ", userPoint=" + userPoint + ", tot=" + tot + "]";
	}
	
	
	
	
}
