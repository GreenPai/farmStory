package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.OrderDAO;
import kr.co.pamStory.dto.OrderDTO;

public enum OrderService {
	INSTANCE;

	// 다오 연결
	private final OrderDAO dao = OrderDAO.getInstance();

	public List<OrderDTO> findLatest3Orders() {
		return dao.selectLatest3Orders();
	
	}

	public int registerOrder(OrderDTO dto) {
		return dao.insertOrder(dto);
	}


}
