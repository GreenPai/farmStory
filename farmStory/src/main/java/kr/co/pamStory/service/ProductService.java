package kr.co.pamStory.service;

import kr.co.pamStory.dao.ProductDAO;
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

}
