package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.OrderDAO;
import kr.co.pamStory.dto.OrderDTO;
import kr.co.pamStory.dto.PageGroupDTO;
import kr.co.pamStory.dto.ProductDTO;

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
	
	public int getCountOrder() {
		return dao.selectCountOrder();
	}

	public int getCountOrder(String uid) {
		return dao.selectCountOrder(uid);
	}
	
	public int getLastPageNum(int total) {
		int lastPageNum =0;
		
		if(total %6 ==0){
			lastPageNum = total/6;
		}else {
			lastPageNum= total/6+1;
		}
		return lastPageNum;
		
		
	}

	public int getCurrentPage(String pg) {
		int currentPage=1;
		if(pg !=null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}

	public int getStartNum(int currentPage) {
		return (currentPage -1) * 6;
	}

	//페이지 그룹 계산하기
	public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
		
		int currentPageGroup =(int)Math.ceil(currentPage/ 6.0);
		int pageGroupStart= (currentPageGroup - 1)* 6 + 1;
		int pageGroupEnd = currentPageGroup * 6;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
	}
	
	//페이지 시작번호구하기
	public int getPageStartNum(int total, int currentPage) {
		int start=(currentPage -1) * 6;
		return total - start;
	}

	public List<OrderDTO> findAllOrder(int start, String uid) {
		return dao.selectAllOrder(start, uid);
	}

	public List<OrderDTO> findAllOrder(int start) {
		return dao.selectAllOrder(start);
	}



}
