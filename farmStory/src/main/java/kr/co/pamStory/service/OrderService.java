package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.OrderDAO;
import kr.co.pamStory.dto.OrderDTO;

public enum OrderService {
	INSTANCE;

	// 다오 연결
	private OrderDAO dao = OrderDAO.getInstance();

	public static List<OrderDTO> findLatest3Orders() {
		return null;
	

		
	}

	List<OrderDTO> findAllOrder() {
		
		return null;
	}



}
