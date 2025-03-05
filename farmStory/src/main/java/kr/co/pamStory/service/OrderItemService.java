package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.OrderDAO;
import kr.co.pamStory.dao.OrderItemDAO;
import kr.co.pamStory.dto.CartDTO;
import kr.co.pamStory.dto.OrderDTO;
import kr.co.pamStory.dto.OrderItemDTO;

public enum OrderItemService {
	INSTANCE;

	// 다오 연결
	private OrderItemDAO dao = OrderItemDAO.getInstance();

	public void register(OrderItemDTO orderItemDTO) {
		dao.insertOrderItem(orderItemDTO);
	}

}
