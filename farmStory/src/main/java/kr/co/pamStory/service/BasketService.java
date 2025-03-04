package kr.co.pamStory.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dao.BasketDAO;
import kr.co.pamStory.dto.PageGroupDTO;
import kr.co.pamStory.dto.ProductDTO;

public enum BasketService {
	INSTANCE;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private BasketDAO dao = BasketDAO.getInstance();
	
	public List<ProductDTO> findAllProduct() {
		return dao.SelectAllProduct();
	}

	public List<ProductDTO> findProductByCateNo(String cateNo) {
		return dao.SelectProductByCateNo(cateNo);
	}

	public int getLastPageNum(int total) {
		// 제품 5개당 페이지 1
		if(total % 5 == 0) {
			return total/5;
		}else {
			return total/5+ 1;
		}
	
	}

	public int getCurrentPage(String pg) {
		
		if(pg != null) {
			return Integer.parseInt(pg);
		}else {
			return 1;
		}
		
	}

	public int getStartNum(int currentPage) {
		return (currentPage - 1 ) * 5;
	}

	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 5;
		return total - start;
	}

	public List<ProductDTO> getPageProducts(List<ProductDTO> list, int start) {
		
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		
		int total = list.size();
		int end = start+5;
		
		if(end > total) {
			end = start + (total % 5);
		}
		
		for(int i=start; i<end; i++) {
			products.add(list.get(i));
		}
		
		return products;
	}

	public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
		int currentPageGroup =(int)Math.ceil(currentPage/ 5.0);
		int pageGroupStart= (currentPageGroup - 1)* 5 + 1;
		int pageGroupEnd = currentPageGroup * 5;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
	}
	
	
	
}
