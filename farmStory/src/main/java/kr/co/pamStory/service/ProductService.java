package kr.co.pamStory.service;

import java.util.List;

import kr.co.pamStory.dao.ProductDAO;
import kr.co.pamStory.dto.PageGroupDTO;
import kr.co.pamStory.dto.ProductDTO;

public enum ProductService {
	
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();

	public int registerProduct(ProductDTO dto) {
		
		return dao.insertProduct(dto);
		
	}

	public ProductDTO findProductByProdNo(String prodNo) {
		
		return dao.selectProductByProdNo(prodNo);
	}

	public List<ProductDTO> findLatest3Products() {
		return dao.selectLatest3Products();
	}

	public List<ProductDTO> findAllProduct() {
		return dao.selectAllProducts();
	}

	public void deleteProduct(String prodNo) {
		dao.deleteProduct(prodNo);
		
	}

	public int getCountProduct() {
		
		return dao.selectCountProduct();
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

	public List<ProductDTO> findAllProduct(int start) {
		return dao.selectAllProducts(start);
	}

	// 제품 구매 시 총량 감소
	public void minusProduct(int prodNo, int cartProdCount) {
		dao.ModifProductStock(prodNo, cartProdCount);
		
	}

	public List<ProductDTO> findBest6Products() {
		
		return dao.selectBest6Products();
	}


}
