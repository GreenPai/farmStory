package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.CartDAO;
import kr.co.pamStory.dto.CartDTO;

public enum CartService {
	INSTANCE;
	private CartDAO dao = CartDAO.getInstance();
	
	public void registerCart(CartDTO dto) {
		dao.insertCart(dto);
		
	}

	public List<CartDTO> findCartByUid(String uid) {
		return dao.SelectCartByUid(uid);
	}

	public int countProduct(List<CartDTO> cartDTOS) {
		
		int cnt = 0;
		for(CartDTO dto : cartDTOS) {
			cnt += dto.getCartProdCount();
		}
		
		return cnt;
	}

	public int calculateDeliveryFee(List<CartDTO> cartDTOS) {

		int fee = 0;
		int total = 0;
		
		for(CartDTO dto : cartDTOS) {
			fee += dto.getProdDeliveryFee();
			total += dto.getTotal();
		}
		
		// 3만원 이상 무료배송
		if(total >= 30000) {
			fee = 0;
		}
		
		return fee;
	}

	public int calculateDiscount(List<CartDTO> cartDTOS) {
		
		int discount = 0;
		
		for(CartDTO dto : cartDTOS) {
			discount += (dto.getProdPrice() - dto.getProdDiscountPrice())*dto.getCartProdCount() ;
		}
		
		return discount;
	}

	public int calculatePoint(List<CartDTO> cartDTOS) {
		int point = 0;
		
		for(CartDTO dto : cartDTOS) {
			point += dto.getProdPoint();
		}
		
		return point;
	}

	public int calculatePrice(List<CartDTO> cartDTOS) {
		int price = 0;
		
		for(CartDTO dto : cartDTOS) {
			price += dto.getTotal();
		}
		
		return price;
	}

	public void deleteCart(String cartNo) {
		dao.deleteCart(cartNo);
		
	}

	public void deleteCartByUid(String uid) {
		dao.deleteCartByUid(uid);
	}
	
	
}
